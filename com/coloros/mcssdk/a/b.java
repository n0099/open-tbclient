package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public final class b extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return ao(intent);
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c ao(Intent intent) {
        try {
            com.coloros.mcssdk.e.b bVar = new com.coloros.mcssdk.e.b();
            bVar.zs(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("command"))));
            bVar.zt(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("code"))));
            bVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            bVar.setAppKey(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appKey")));
            bVar.vo(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appSecret")));
            bVar.setAppPackage(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
