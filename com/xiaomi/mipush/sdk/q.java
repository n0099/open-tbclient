package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class q extends ai.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f79a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Cif cif, Context context) {
        this.f79a = cif;
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo143a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f79a != null) {
            this.f79a.a(com.xiaomi.push.service.aj.a());
            ay.a(this.a.getApplicationContext()).a((ay) this.f79a, hg.Notification, true, (ht) null, true);
        }
    }
}
