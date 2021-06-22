package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.hx;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
/* loaded from: classes7.dex */
public class ad extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f41007a;

    public ad(Context context) {
        this.f41007a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo170a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.aq a2 = com.xiaomi.push.service.aq.a(this.f41007a);
        hx hxVar = new hx();
        hxVar.a(com.xiaomi.push.service.ar.a(a2, hl.MISC_CONFIG));
        hxVar.b(com.xiaomi.push.service.ar.a(a2, hl.PLUGIN_CONFIG));
        ie ieVar = new ie("-1", false);
        ieVar.c(hp.DailyCheckClientConfig.f506a);
        ieVar.a(ip.a(hxVar));
        an.a(this.f41007a).a((an) ieVar, hf.Notification, (hs) null);
    }
}
