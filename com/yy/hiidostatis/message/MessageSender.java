package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes9.dex */
public interface MessageSender {

    /* loaded from: classes9.dex */
    public interface ResultListener {
        void onResult(int i, Message message, String str);
    }

    void asyncSend(Message message);

    void setResultListener(ResultListener resultListener);
}
