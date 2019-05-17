package com.sso.sso;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;

@Controller
public class OssTest {
    @Value("${endpoint}")
    private  String endpoint;
    @Value("${bucketName}")
    private  String bucketName;
    @Value("${picLocation}")
    private  String picLocation;
    @Value("${accessKeyId}")
    private  String accessKeyId;
    @Value("${accessKeySecret}")
    private  String accessKeySecret;
    @RequestMapping("/say")
    public void say() {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello OSS";
        System.out.println(bucketName);
        PutObjectResult u = ossClient.putObject(bucketName, "u", new ByteArrayInputStream(content.getBytes()));
        String eTag = u.getETag();
        System.out.println(eTag);
// 关闭OSSClient。
        ossClient.shutdown();
    }
}
