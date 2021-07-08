package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes6.dex */
public interface MessageSender {

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onResult(int i2, Message message, String str);
    }

    void asyncSend(Message message);

    void setResultListener(ResultListener resultListener);
}
