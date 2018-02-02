package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
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
            dVar.xX(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("messageID"))));
            dVar.uS(com.coloros.mcssdk.c.a.a(intent.getStringExtra("taskID")));
            dVar.setAppPackage(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            dVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            dVar.setDescription(com.coloros.mcssdk.c.a.a(intent.getStringExtra("description")));
            dVar.uU(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appID")));
            dVar.uT(com.coloros.mcssdk.c.a.a(intent.getStringExtra("globalID")));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + dVar.toString());
            return dVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
