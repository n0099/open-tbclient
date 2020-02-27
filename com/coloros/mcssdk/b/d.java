package com.coloros.mcssdk.b;

import android.content.Context;
import com.coloros.mcssdk.callback.MessageCallback;
import com.coloros.mcssdk.mode.Message;
import com.coloros.mcssdk.mode.SptDataMessage;
/* loaded from: classes8.dex */
public final class d implements c {
    @Override // com.coloros.mcssdk.b.c
    public final void a(Context context, Message message, MessageCallback messageCallback) {
        if (message == null) {
            return;
        }
        com.coloros.mcssdk.c.d.a("process--SptMessageProcessor--message:" + message);
        if (message.getType() == 4103) {
            SptDataMessage sptDataMessage = (SptDataMessage) message;
            if (messageCallback != null) {
                messageCallback.processMessage(context, sptDataMessage);
            }
        }
    }
}
