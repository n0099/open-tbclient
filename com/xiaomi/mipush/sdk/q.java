package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class q extends ai.a {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f77a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Cif cif, Context context) {
        this.f77a = cif;
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo152a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f77a != null) {
            this.f77a.a(com.xiaomi.push.service.aj.a());
            ay.a(this.a.getApplicationContext()).a((ay) this.f77a, hg.Notification, true, (ht) null, true);
        }
    }
}
