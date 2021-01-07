package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes6.dex */
final class o extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f14135a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ il f158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(il ilVar, Context context) {
        this.f158a = ilVar;
        this.f14135a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo196a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f158a != null) {
            this.f158a.a(com.xiaomi.push.service.an.a());
            aq.a(this.f14135a.getApplicationContext()).a((aq) this.f158a, hm.Notification, true, (hz) null, true);
        }
    }
}
