package com.matheusparro.desafio_java_pleno.config.aws;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSnsConfig {
    @Value("${aws.region}")
    private String region;
    private String accessKey;
    private String secretKey;

    @Value("${aws.sns.catalog.topic.arn}")
    private String catalogTopicArn;

    @Bean
    public AmazonSNS createSnsClient() {
        return AmazonSNSClient.builder()
                .withRegion(region)
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }

    @Bean(name = "snsCatalogTopic")
    public Topic snsCatalogTopicBuilder(){
        return new Topic().withTopicArn(catalogTopicArn);
    }

}
