package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes3.dex */
public final class b extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return aF(intent);
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c aF(Intent intent) {
        try {
            com.coloros.mcssdk.e.b bVar = new com.coloros.mcssdk.e.b();
            bVar.BR(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("command"))));
            bVar.q(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("code"))));
            bVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            bVar.setAppKey(com.coloros.mcssdk.c.a.a(intent.getStringExtra(WBConstants.SSO_APP_KEY)));
            bVar.Fn(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appSecret")));
            bVar.Fp(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
