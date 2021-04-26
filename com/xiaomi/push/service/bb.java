package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class bb implements ee {
    @Override // com.xiaomi.push.ee
    public void a(Context context, HashMap<String, String> hashMap) {
        ie ieVar = new ie();
        ieVar.b(ea.a(context).m272a());
        ieVar.d(ea.a(context).b());
        ieVar.c(hp.AwakeAppResponse.f506a);
        ieVar.a(at.a());
        ieVar.f647a = hashMap;
        byte[] a2 = ip.a(y.a(ieVar.c(), ieVar.b(), ieVar, hf.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo : context is not correct in pushLayer " + ieVar.m453a());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo : send data directly in pushLayer " + ieVar.m453a());
        ((XMPushService) context).a(context.getPackageName(), a2, true);
    }

    @Override // com.xiaomi.push.ee
    public void b(Context context, HashMap<String, String> hashMap) {
        hd a2 = hd.a(context);
        if (a2 != null) {
            a2.a("category_awake_app", "wake_up_app", 1L, dv.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.ee
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m58a("MoleInfo：\u3000" + dv.b(hashMap));
    }
}
