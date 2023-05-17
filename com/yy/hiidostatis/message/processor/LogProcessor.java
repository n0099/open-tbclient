package com.yy.hiidostatis.message.processor;

import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes10.dex */
public class LogProcessor implements MessageProcessor {
    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        try {
            L.debug(message, "id:%s \n urlParams:%s \n content:%s \n", message.getMsgId(), message.getUrlParams(), new String(message.getContent(), IMAudioTransRequest.CHARSET));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return message;
    }
}
