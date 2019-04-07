package com.coloros.mcssdk.b;

import android.content.Context;
import com.coloros.mcssdk.callback.MessageCallback;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.Message;
/* loaded from: classes3.dex */
public final class a implements c {
    @Override // com.coloros.mcssdk.b.c
    public final void a(Context context, Message message, MessageCallback messageCallback) {
        if (message == null) {
            return;
        }
        com.coloros.mcssdk.c.d.a("process--AppMessageProcessor--message:" + message);
        if (message.getType() == 4098) {
            AppMessage appMessage = (AppMessage) message;
            if (messageCallback != null) {
                messageCallback.processMessage(context, appMessage);
            }
        }
    }
}
