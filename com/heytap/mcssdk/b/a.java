package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.Message;
/* loaded from: classes6.dex */
public final class a implements c {
    @Override // com.heytap.mcssdk.b.c
    public final void a(Context context, Message message, MessageCallback messageCallback) {
        if (message != null && message.getType() == 4098) {
            AppMessage appMessage = (AppMessage) message;
            if (messageCallback != null) {
                messageCallback.processMessage(context, appMessage);
            }
        }
    }
}
