package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean m79b;
        String b;
        m79b = b.m79b(this.a);
        if (m79b) {
            b = b.b(com.xiaomi.push.service.ag.a(this.a).a(hl.AggregationSdkMonitorDepth.a(), 4));
            if (TextUtils.isEmpty(b)) {
                return;
            }
            MiTinyDataClient.upload(this.a, "monitor_upload", "call_stack", 1L, b);
            b.c(this.a);
        }
    }
}
