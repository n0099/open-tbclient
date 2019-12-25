package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coloros.mcssdk.mode.Message;
/* loaded from: classes5.dex */
public final class b extends c {
    @Override // com.coloros.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return a(intent);
        }
        return null;
    }

    @Override // com.coloros.mcssdk.a.c
    public final Message a(Intent intent) {
        try {
            CommandMessage commandMessage = new CommandMessage();
            commandMessage.setCommand(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra("command"))));
            commandMessage.setResponseCode(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra("code"))));
            commandMessage.setContent(com.coloros.mcssdk.c.b.a(intent.getStringExtra("content")));
            commandMessage.setAppKey(com.coloros.mcssdk.c.b.a(intent.getStringExtra("appKey")));
            commandMessage.setAppSecret(com.coloros.mcssdk.c.b.a(intent.getStringExtra(CommandMessage.APP_SECRET)));
            commandMessage.setAppPackage(com.coloros.mcssdk.c.b.a(intent.getStringExtra("appPackage")));
            com.coloros.mcssdk.c.d.a("OnHandleIntent-message:" + commandMessage.toString());
            return commandMessage;
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
