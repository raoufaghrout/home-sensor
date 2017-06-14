package com.homesensor.util;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class CSVToS3Uploader {

    public void upload(String bucket, String key, String csvString) {
        AmazonS3ClientBuilder.defaultClient().putObject(bucket, key, csvString);
    }
}
