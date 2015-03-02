package com.example.novy.emailsender.sending_email;

import com.google.common.collect.ImmutableList;

import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Collection;

import test.matchers.StringEntityByContentMatcher;
import utils.builders.MessageDataBuilder;
import utils.builders.StringEntityBuilder;

import static org.junit.Assert.assertThat;
import static test.matchers.StringEntityByContentMatcher.*;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class StringEntityFactoryTest {

    @Test
    public void shouldProduceProperStringEntity() throws Exception {
        final String sender = "sender@gmail.com";
        final String password = "password";
        final Collection<String> recipients = ImmutableList.of("sender@gmail.com");
        final String subject = "subject";
        final String content = "content";

        final StringEntityFactory objectUnderTest = new StringEntityFactory();

        final MessageData messageData = MessageDataBuilder
                .newMessageData()
                .sender(sender)
                .password(password)
                .recipients(recipients)
                .subject(subject)
                .content(content)
                .build();

        final StringEntity expectedResult = StringEntityBuilder
                .newStringEntity()
                .sender(sender)
                .password(password)
                .recipients(recipients)
                .subject(subject)
                .content(content)
                .build();


        assertThat(objectUnderTest.fromMessageData(messageData), equalsByContent(expectedResult));
    }
}