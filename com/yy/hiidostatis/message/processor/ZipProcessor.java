package com.yy.hiidostatis.message.processor;

import com.hiido.snappy.Snappy;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ZipProcessor implements MessageProcessor {
    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        if (message.isSingle()) {
            return message;
        }
        try {
            System.currentTimeMillis();
            byte[] compress = Snappy.compress(message.getContent());
            message.setContent(compress);
            message.setLength(compress.length);
            return message;
        } catch (IOException unused) {
            return null;
        }
    }
}
