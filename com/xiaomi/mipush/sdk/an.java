package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hy;
import com.xiaomi.push.iq;
/* loaded from: classes3.dex */
public class an extends ai.a {
    private Context a;

    public an(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo140a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.ag a = com.xiaomi.push.service.ag.a(this.a);
        hy hyVar = new hy();
        hyVar.a(com.xiaomi.push.service.ah.a(a, hm.MISC_CONFIG));
        hyVar.b(com.xiaomi.push.service.ah.a(a, hm.PLUGIN_CONFIG));
        Cif cif = new Cif(LivenessStat.TYPE_STRING_DEFAULT, false);
        cif.c(hq.DailyCheckClientConfig.f489a);
        cif.a(iq.a(hyVar));
        ay.a(this.a).a((ay) cif, hg.Notification, (ht) null);
    }
}
