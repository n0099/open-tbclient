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
/* loaded from: classes9.dex */
public class af extends ai.a {
    private Context a;

    public af(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.ak a = com.xiaomi.push.service.ak.a(this.a);
        ie ieVar = new ie();
        ieVar.a(com.xiaomi.push.service.al.a(a, hs.MISC_CONFIG));
        ieVar.b(com.xiaomi.push.service.al.a(a, hs.PLUGIN_CONFIG));
        il ilVar = new il("-1", false);
        ilVar.c(hw.DailyCheckClientConfig.f476a);
        ilVar.a(iw.a(ieVar));
        aq.a(this.a).a((aq) ilVar, hm.Notification, (hz) null);
    }
}
