import os
from wordcloud import WordCloud
import matplotlib.pyplot as plt
from konlpy.tag import Okt

def generate_wordcloud(text, save_path='static/wordcloud/wordcloud.png'):
    # 한글 형태소 분석기로 Konlpy의 Okt를 사용
    okt = Okt()
    tokens = okt.nouns(text)

    # 단어 빈도수 계산
    word_counts = {}
    for token in tokens:
        if len(token) > 1:  # 길이가 1인 단어는 제외
            word_counts[token] = word_counts.get(token, 0) + 1

    # WordCloud 생성
    wordcloud = WordCloud(
        font_path='static/Font/eastarjet.ttf',  # 한글 폰트 경로 지정
        background_color='white',
        width=800,
        height=400,
    ).generate_from_frequencies(word_counts)

    # 시각화 및 이미지 저장
    plt.figure(figsize=(10, 5))
    plt.imshow(wordcloud, interpolation='bilinear')
    plt.axis('off')

    plt.savefig(save_path)
    plt.close()  # 이미지 저장 후 플롯을 닫아 메모리를 해제합니다.

    return os.path.abspath(save_path)

if __name__ == "__main__":
    # 분석할 한글 텍스트 입력
    korean_text = """
    여러분 안녕하세요. 이번에는 한글 워드클라우드를 생성하는 예제 코드를 작성해보겠습니다.
    이 코드는 Konlpy 라이브러리의 Okt 형태소 분석기와 WordCloud 라이브러리를 사용하여
    주어진 한글 텍스트에서 단어 빈도수를 계산하고 시각화하는 간단한 예제입니다.
    """

    image_path = generate_wordcloud(korean_text)
    print(image_path)
