package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.hs;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
/* loaded from: classes6.dex */
public class af extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f13800a;

    public af(Context context) {
        this.f13800a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo192a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.ak a2 = com.xiaomi.push.service.ak.a(this.f13800a);
        ie ieVar = new ie();
        ieVar.a(com.xiaomi.push.service.al.a(a2, hs.MISC_CONFIG));
        ieVar.b(com.xiaomi.push.service.al.a(a2, hs.PLUGIN_CONFIG));
        il ilVar = new il("-1", false);
        ilVar.c(hw.DailyCheckClientConfig.f555a);
        ilVar.a(iw.a(ieVar));
        aq.a(this.f13800a).a((aq) ilVar, hm.Notification, (hz) null);
    }
}
