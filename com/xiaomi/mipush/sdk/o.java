package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes6.dex */
final class o extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13837a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ il f157a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(il ilVar, Context context) {
        this.f157a = ilVar;
        this.f13837a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f157a != null) {
            this.f157a.a(com.xiaomi.push.service.an.a());
            aq.a(this.f13837a.getApplicationContext()).a((aq) this.f157a, hm.Notification, true, (hz) null, true);
        }
    }
}
