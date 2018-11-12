package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
/* loaded from: classes3.dex */
public final class e extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4103 == i) {
            com.coloros.mcssdk.e.c ao = ao(intent);
            com.coloros.mcssdk.a.a(context, (com.coloros.mcssdk.e.d) ao, "push_transmit");
            return ao;
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c ao(Intent intent) {
        try {
            com.coloros.mcssdk.e.d dVar = new com.coloros.mcssdk.e.d();
            dVar.xt(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("messageID"))));
            dVar.yp(com.coloros.mcssdk.c.a.a(intent.getStringExtra(WebSocketAction.PARAM_KEY_TASKID)));
            dVar.yq(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            dVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            dVar.setDescription(com.coloros.mcssdk.c.a.a(intent.getStringExtra("description")));
            dVar.setAppID(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appID")));
            dVar.yr(com.coloros.mcssdk.c.a.a(intent.getStringExtra("globalID")));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + dVar.toString());
            return dVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
