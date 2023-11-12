package com.epam.socialmediaapp.controller;
import com.epam.socialmediaapp.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String key = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        s3Service.uploadFile(key, inputStream);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<InputStreamResource> getFile(@PathVariable String filename) {
        InputStream file = s3Service.getFile(filename);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Adjust the content type based on your file type
                .body(new InputStreamResource(file));
    }

    @GetMapping("/list")
    public List<String> listFiles() {
        return s3Service.listFiles();
    }

    @DeleteMapping("/{filename}")
    public void deleteFile(@PathVariable String filename) {
        s3Service.deleteFile(filename);
    }
}
