package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.mode.Message;
import com.coloros.mcssdk.mode.SptDataMessage;
/* loaded from: classes8.dex */
public final class e extends c {
    @Override // com.coloros.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        if (4103 == i) {
            Message a = a(intent);
            PushManager.statisticMessage(context, (SptDataMessage) a, PushManager.EVENT_ID_PUSH_TRANSMIT);
            return a;
        }
        return null;
    }

    @Override // com.coloros.mcssdk.a.c
    public final Message a(Intent intent) {
        try {
            SptDataMessage sptDataMessage = new SptDataMessage();
            sptDataMessage.setMessageID(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra("messageID"))));
            sptDataMessage.setTaskID(com.coloros.mcssdk.c.b.a(intent.getStringExtra("taskID")));
            sptDataMessage.setAppPackage(com.coloros.mcssdk.c.b.a(intent.getStringExtra("appPackage")));
            sptDataMessage.setContent(com.coloros.mcssdk.c.b.a(intent.getStringExtra("content")));
            sptDataMessage.setDescription(com.coloros.mcssdk.c.b.a(intent.getStringExtra("description")));
            sptDataMessage.setAppID(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.APP_ID)));
            sptDataMessage.setGlobalID(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.GLOBAL_ID)));
            com.coloros.mcssdk.c.d.a("OnHandleIntent-message:" + sptDataMessage.toString());
            return sptDataMessage;
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
