package com.epam.socialmediaapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class S3ServiceTests {

    @Mock
    private S3Client s3Client;

    @InjectMocks
    private S3Service s3Service;

    @Test
    void uploadFile_Success() throws IOException {

        Mockito.doNothing().when(s3Client).putObject(Mockito.any(PutObjectRequest.class), Mockito.any(RequestBody.class));


        InputStream inputStream = new ByteArrayInputStream("Test content".getBytes());
        s3Service.uploadFile("testfile.txt", inputStream);

        Mockito.verify(s3Client, Mockito.times(1)).putObject(ArgumentMatchers.any(PutObjectRequest.class), ArgumentMatchers.any(RequestBody.class));
    }

}
