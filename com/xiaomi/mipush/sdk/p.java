package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
final class p extends h.a {
    final /* synthetic */ com.xiaomi.xmpush.thrift.ai a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(com.xiaomi.xmpush.thrift.ai aiVar, Context context) {
        this.a = aiVar;
        this.b = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.a.a(com.xiaomi.push.service.aq.a());
            az.a(this.b.getApplicationContext()).a((az) this.a, com.xiaomi.xmpush.thrift.a.Notification, true, (com.xiaomi.xmpush.thrift.u) null, true);
        }
    }
}
