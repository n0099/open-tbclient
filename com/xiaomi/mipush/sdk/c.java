package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean d;
        String b;
        d = b.d(this.a);
        if (d) {
            b = b.b(com.xiaomi.push.service.an.a(this.a).a(com.xiaomi.xmpush.thrift.g.AggregationSdkMonitorDepth.a(), 4));
            if (TextUtils.isEmpty(b)) {
                return;
            }
            MiTinyDataClient.upload(this.a, "monitor_upload", "call_stack", 1L, b);
            b.e(this.a);
        }
    }
}
