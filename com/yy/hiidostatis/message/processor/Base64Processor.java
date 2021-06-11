package com.yy.hiidostatis.message.processor;

import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
import java.io.UnsupportedEncodingException;
/* loaded from: classes7.dex */
public class Base64Processor implements MessageProcessor {
    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        try {
            message.setContent(Base64Util.encode(message.getContent()).getBytes("UTF-8"));
            return message;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
