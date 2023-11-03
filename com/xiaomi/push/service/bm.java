package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.dx;
import com.xiaomi.push.ec;
import com.xiaomi.push.eg;
import com.xiaomi.push.hf;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class bm implements eg {
    @Override // com.xiaomi.push.eg
    public void a(Context context, HashMap<String, String> hashMap) {
        ig igVar = new ig();
        igVar.b(ec.a(context).m456a());
        igVar.d(ec.a(context).b());
        igVar.c(hr.AwakeAppResponse.f508a);
        igVar.a(bd.a());
        igVar.f650a = hashMap;
        byte[] a = ir.a(ah.a(igVar.c(), igVar.b(), igVar, hh.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo : context is not correct in pushLayer " + igVar.m645a());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo : send data directly in pushLayer " + igVar.m645a());
        ((XMPushService) context).a(context.getPackageName(), a, true);
    }

    @Override // com.xiaomi.push.eg
    public void b(Context context, HashMap<String, String> hashMap) {
        hf a = hf.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1L, dx.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.eg
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m186a("MoleInfo：\u3000" + dx.b(hashMap));
    }
}
