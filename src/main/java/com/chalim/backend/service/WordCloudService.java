package com.chalim.backend.service;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class WordCloudService {
    public String generateWordCloudImage() {
        String imagePath = "";

        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            // Python 스크립트 파일 경로
            String scriptPath = "path/to/wordcloud_generator.py";

            // Python 스크립트 실행
            pyInterp.exec("exec(open('" + scriptPath + "').read())");

            // Python 함수 호출
            PyObject pyObject = pyInterp.get("generate_wordcloud");
            PyObject result = pyObject.__call__();

            // 이미지 파일의 경로를 반환
            imagePath = result.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return imagePath;
    }
}