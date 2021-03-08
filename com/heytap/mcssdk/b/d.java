package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.mode.SptDataMessage;
/* loaded from: classes5.dex */
public final class d implements c {
    @Override // com.heytap.mcssdk.b.c
    public final void a(Context context, Message message, MessageCallback messageCallback) {
        if (message != null && message.getType() == 4103) {
            SptDataMessage sptDataMessage = (SptDataMessage) message;
            if (messageCallback != null) {
                messageCallback.processMessage(context, sptDataMessage);
            }
        }
    }
}
