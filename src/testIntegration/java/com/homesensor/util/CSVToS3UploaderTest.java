package com.homesensor.util;

import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.util.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CSVToS3UploaderTest {

    private final static String TEST_BUCKET = "home-sensor-test-bucket";

    @Test
    public void shouldUploadCSVToS3() throws IOException {
        String key = "test-key";
        String csvString = "test,csv,string";
        CSVToS3Uploader CSVToS3Uploader = new CSVToS3Uploader();

        CSVToS3Uploader.upload(TEST_BUCKET, key, csvString);

        String s3ObjectContent = IOUtils
                .toString(AmazonS3ClientBuilder
                        .defaultClient()
                        .getObject(TEST_BUCKET, key)
                        .getObjectContent());

        assertThat(s3ObjectContent, is(csvString));
    }
}
