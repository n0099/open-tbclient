package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.ai;
import com.xiaomi.push.hm;
import com.xiaomi.push.hz;
import com.xiaomi.push.il;
/* loaded from: classes12.dex */
final class o extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4775a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ il f79a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(il ilVar, Context context) {
        this.f79a = ilVar;
        this.f4775a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo167a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f79a != null) {
            this.f79a.a(com.xiaomi.push.service.an.a());
            aq.a(this.f4775a.getApplicationContext()).a((aq) this.f79a, hm.Notification, true, (hz) null, true);
        }
    }
}
