package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes8.dex */
final class o extends ai.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ il f77a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(il ilVar, Context context) {
        this.f77a = ilVar;
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo163a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f77a != null) {
            this.f77a.a(com.xiaomi.push.service.an.a());
            aq.a(this.a.getApplicationContext()).a((aq) this.f77a, hm.Notification, true, (hz) null, true);
        }
    }
}
