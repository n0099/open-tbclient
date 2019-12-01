package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
/* loaded from: classes3.dex */
final class q extends ai.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f74a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Cif cif, Context context) {
        this.f74a = cif;
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo140a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f74a != null) {
            this.f74a.a(com.xiaomi.push.service.aj.a());
            ay.a(this.a.getApplicationContext()).a((ay) this.f74a, hg.Notification, true, (ht) null, true);
        }
    }
}
