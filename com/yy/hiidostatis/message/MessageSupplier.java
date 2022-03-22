package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes7.dex */
public interface MessageSupplier {
    Message fetchMessage(int i);

    void removeMessage(String str);

    void restoreMessage(String str);
}
