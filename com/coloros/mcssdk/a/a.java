package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
/* loaded from: classes3.dex */
public final class a extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4098 == i) {
            com.coloros.mcssdk.e.c ao = ao(intent);
            com.coloros.mcssdk.a.a(context, (com.coloros.mcssdk.e.a) ao, "push_transmit");
            return ao;
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c ao(Intent intent) {
        try {
            com.coloros.mcssdk.e.a aVar = new com.coloros.mcssdk.e.a();
            aVar.xt(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("messageID"))));
            aVar.yp(com.coloros.mcssdk.c.a.a(intent.getStringExtra(WebSocketAction.PARAM_KEY_TASKID)));
            aVar.yq(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            aVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            aVar.xp(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("balanceTime"))));
            aVar.dj(Long.parseLong(com.coloros.mcssdk.c.a.a(intent.getStringExtra("startDate"))));
            aVar.dk(Long.parseLong(com.coloros.mcssdk.c.a.a(intent.getStringExtra("endDate"))));
            aVar.ym(com.coloros.mcssdk.c.a.a(intent.getStringExtra("timeRanges")));
            aVar.setTitle(com.coloros.mcssdk.c.a.a(intent.getStringExtra("title")));
            aVar.yn(com.coloros.mcssdk.c.a.a(intent.getStringExtra("rule")));
            aVar.xq(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("forcedDelivery"))));
            aVar.xr(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("distinctBycontent"))));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
