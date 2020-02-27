package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ef;
import com.xiaomi.push.ek;
import com.xiaomi.push.eo;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class e implements eo {
    @Override // com.xiaomi.push.eo
    public void a(Context context, HashMap<String, String> hashMap) {
        Cif cif = new Cif();
        cif.b(ek.a(context).m258a());
        cif.d(ek.a(context).b());
        cif.c(hq.AwakeAppResponse.f490a);
        cif.a(com.xiaomi.push.service.aj.a());
        cif.f630a = hashMap;
        ay.a(context).a((ay) cif, hg.Notification, true, (ht) null, true);
        com.xiaomi.channel.commonutils.logger.b.m47a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eo
    public void b(Context context, HashMap<String, String> hashMap) {
        MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, ef.a(hashMap));
        com.xiaomi.channel.commonutils.logger.b.m47a("MoleInfo：\u3000send data in app layer");
    }

    @Override // com.xiaomi.push.eo
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m47a("MoleInfo：\u3000" + ef.b(hashMap));
        String str = hashMap.get("awake_info");
        if (String.valueOf(1007).equals(hashMap.get("event_type"))) {
            p.a(context, str);
        }
    }
}
