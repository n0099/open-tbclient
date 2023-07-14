package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.aj;
import com.xiaomi.push.hh;
import com.xiaomi.push.hn;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hz;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
/* loaded from: classes10.dex */
public class ae extends aj.a {
    public Context a;

    public ae(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo297a() {
        return "2";
    }

    @Override // java.lang.Runnable
    public void run() {
        ba a = ba.a(this.a);
        hz hzVar = new hz();
        hzVar.a(bb.a(a, hn.MISC_CONFIG));
        hzVar.b(bb.a(a, hn.PLUGIN_CONFIG));
        ig igVar = new ig("-1", false);
        igVar.c(hr.DailyCheckClientConfig.f508a);
        igVar.a(ir.a(hzVar));
        ao.a(this.a).a((ao) igVar, hh.Notification, (hu) null);
    }
}
