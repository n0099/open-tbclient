package com.heytap.mcssdk.b;

import android.content.Context;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
/* loaded from: classes8.dex */
public final class b implements c {
    @Override // com.heytap.mcssdk.b.c
    public final void a(Context context, Message message, MessageCallback messageCallback) {
        if (message != null && message.getType() == 4105) {
            CommandMessage commandMessage = (CommandMessage) message;
            if (messageCallback != null) {
                messageCallback.processMessage(context, commandMessage);
            }
        }
    }
}
