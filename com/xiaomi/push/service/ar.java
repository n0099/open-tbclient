package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ef;
import com.xiaomi.push.ek;
import com.xiaomi.push.eo;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class ar implements eo {
    @Override // com.xiaomi.push.eo
    public void a(Context context, HashMap<String, String> hashMap) {
        Cif cif = new Cif();
        cif.b(ek.a(context).m256a());
        cif.d(ek.a(context).b());
        cif.c(hq.AwakeAppResponse.f489a);
        cif.a(aj.a());
        cif.f629a = hashMap;
        byte[] a = iq.a(w.a(cif.c(), cif.b(), cif, hg.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m45a("MoleInfo : context is not correct in pushLayer " + cif.a());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m45a("MoleInfo : send data directly in pushLayer " + cif.a());
        ((XMPushService) context).a(context.getPackageName(), a, true);
    }

    @Override // com.xiaomi.push.eo
    public void b(Context context, HashMap<String, String> hashMap) {
        he a = he.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1L, ef.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.eo
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m45a("MoleInfo：\u3000" + ef.b(hashMap));
    }
}
