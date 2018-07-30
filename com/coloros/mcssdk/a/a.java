package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes3.dex */
public final class a extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4098 == i) {
            com.coloros.mcssdk.e.c ak = ak(intent);
            com.coloros.mcssdk.a.a(context, (com.coloros.mcssdk.e.a) ak, "push_transmit");
            return ak;
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c ak(Intent intent) {
        try {
            com.coloros.mcssdk.e.a aVar = new com.coloros.mcssdk.e.a();
            aVar.vU(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("messageID"))));
            aVar.wv(com.coloros.mcssdk.c.a.a(intent.getStringExtra("taskID")));
            aVar.ww(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            aVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            aVar.vP(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("balanceTime"))));
            aVar.de(Long.parseLong(com.coloros.mcssdk.c.a.a(intent.getStringExtra("startDate"))));
            aVar.df(Long.parseLong(com.coloros.mcssdk.c.a.a(intent.getStringExtra("endDate"))));
            aVar.ws(com.coloros.mcssdk.c.a.a(intent.getStringExtra("timeRanges")));
            aVar.setTitle(com.coloros.mcssdk.c.a.a(intent.getStringExtra("title")));
            aVar.wt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("rule")));
            aVar.vQ(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("forcedDelivery"))));
            aVar.vR(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("distinctBycontent"))));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
