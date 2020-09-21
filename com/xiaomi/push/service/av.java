package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.el;
import com.xiaomi.push.eq;
import com.xiaomi.push.eu;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class av implements eu {
    @Override // com.xiaomi.push.eu
    public void a(Context context, HashMap<String, String> hashMap) {
        il ilVar = new il();
        ilVar.b(eq.a(context).m269a());
        ilVar.d(eq.a(context).b());
        ilVar.c(hw.AwakeAppResponse.f476a);
        ilVar.a(an.a());
        ilVar.f617a = hashMap;
        byte[] a = iw.a(w.a(ilVar.c(), ilVar.b(), ilVar, hm.Notification));
        if (!(context instanceof XMPushService)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("MoleInfo : context is not correct in pushLayer " + ilVar.a());
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("MoleInfo : send data directly in pushLayer " + ilVar.a());
        ((XMPushService) context).a(context.getPackageName(), a, true);
    }

    @Override // com.xiaomi.push.eu
    public void b(Context context, HashMap<String, String> hashMap) {
        hk a = hk.a(context);
        if (a != null) {
            a.a("category_awake_app", "wake_up_app", 1L, el.a(hashMap));
        }
    }

    @Override // com.xiaomi.push.eu
    public void c(Context context, HashMap<String, String> hashMap) {
        com.xiaomi.channel.commonutils.logger.b.m54a("MoleInfo：\u3000" + el.b(hashMap));
    }
}
