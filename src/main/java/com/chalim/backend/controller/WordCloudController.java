package com.chalim.backend.controller;

import com.chalim.backend.apiPayLoad.ApiResponse;
import com.chalim.backend.dto.MenuInfoDto;
import com.chalim.backend.dto.TranslateResponse;
import com.chalim.backend.dto.WordcloudResponse;
import com.chalim.backend.service.WordCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCloudController {

    @Autowired
    private WordCloudService wordcloudService;

    @GetMapping("/wordcloud")
    public ResponseEntity<ApiResponse<WordcloudResponse>> generateWordCloudImage() {
        String imagePath = wordcloudService.generateWordCloudImage();
        WordcloudResponse wordcloudresponse = new WordcloudResponse(imagePath);
        ApiResponse<WordcloudResponse> response = ApiResponse.onSuccess(wordcloudresponse);
        return ResponseEntity.ok(response);
    }
}
