package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.coloros.mcssdk.PushManager;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.Message;
/* loaded from: classes3.dex */
public final class a extends c {
    @Override // com.coloros.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        if (4098 == i) {
            Message a = a(intent);
            PushManager.statisticMessage(context, (AppMessage) a, PushManager.EVENT_ID_PUSH_TRANSMIT);
            return a;
        }
        return null;
    }

    @Override // com.coloros.mcssdk.a.c
    public final Message a(Intent intent) {
        try {
            AppMessage appMessage = new AppMessage();
            appMessage.setMessageID(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra("messageID"))));
            appMessage.setTaskID(com.coloros.mcssdk.c.b.a(intent.getStringExtra("taskID")));
            appMessage.setAppPackage(com.coloros.mcssdk.c.b.a(intent.getStringExtra("appPackage")));
            appMessage.setContent(com.coloros.mcssdk.c.b.a(intent.getStringExtra("content")));
            appMessage.setBalanceTime(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.BALANCE_TIME))));
            appMessage.setStartDate(Long.parseLong(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.START_DATE))));
            appMessage.setEndDate(Long.parseLong(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.END_DATE))));
            appMessage.setTimeRanges(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.TIME_RANGES)));
            appMessage.setTitle(com.coloros.mcssdk.c.b.a(intent.getStringExtra("title")));
            appMessage.setRule(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.RULE)));
            appMessage.setForcedDelivery(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.FORCED_DELIVERY))));
            appMessage.setDistinctBycontent(Integer.parseInt(com.coloros.mcssdk.c.b.a(intent.getStringExtra(Message.DISTINCT_CONTENT))));
            com.coloros.mcssdk.c.d.a("OnHandleIntent-message:" + appMessage.toString());
            return appMessage;
        } catch (Exception e) {
            com.coloros.mcssdk.c.d.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
