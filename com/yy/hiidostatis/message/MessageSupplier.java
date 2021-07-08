package com.yy.hiidostatis.message;

import com.yy.hiidostatis.message.bean.Message;
/* loaded from: classes6.dex */
public interface MessageSupplier {
    Message fetchMessage(int i2);

    void removeMessage(String str);

    void restoreMessage(String str);
}
