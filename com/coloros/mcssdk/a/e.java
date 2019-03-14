package com.coloros.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.open.SocialConstants;
/* loaded from: classes3.dex */
public final class e extends c {
    @Override // com.coloros.mcssdk.a.d
    public final com.coloros.mcssdk.e.c a(Context context, int i, Intent intent) {
        if (4103 == i) {
            com.coloros.mcssdk.e.c aF = aF(intent);
            com.coloros.mcssdk.a.a(context, (com.coloros.mcssdk.e.d) aF, "push_transmit");
            return aF;
        }
        return null;
    }

    public final com.coloros.mcssdk.e.c aF(Intent intent) {
        try {
            com.coloros.mcssdk.e.d dVar = new com.coloros.mcssdk.e.d();
            dVar.BS(Integer.parseInt(com.coloros.mcssdk.c.a.a(intent.getStringExtra("messageID"))));
            dVar.Fo(com.coloros.mcssdk.c.a.a(intent.getStringExtra("taskID")));
            dVar.Fp(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appPackage")));
            dVar.setContent(com.coloros.mcssdk.c.a.a(intent.getStringExtra("content")));
            dVar.setDescription(com.coloros.mcssdk.c.a.a(intent.getStringExtra(SocialConstants.PARAM_COMMENT)));
            dVar.ei(com.coloros.mcssdk.c.a.a(intent.getStringExtra("appID")));
            dVar.Fq(com.coloros.mcssdk.c.a.a(intent.getStringExtra("globalID")));
            com.coloros.mcssdk.c.c.a("OnHandleIntent-message:" + dVar.toString());
            return dVar;
        } catch (Exception e) {
            com.coloros.mcssdk.c.c.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
