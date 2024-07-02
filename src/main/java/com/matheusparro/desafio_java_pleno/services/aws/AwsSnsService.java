package com.matheusparro.desafio_java_pleno.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {
    @Autowired
    AmazonSNS amazonSNS;

    @Autowired
    @Qualifier("snsCatalogTopic")
    private Topic catalogTopic;

    public void publish(MessageDTO message){
        this.amazonSNS.publish(this.catalogTopic.getTopicArn(), message.message());
    }
}
