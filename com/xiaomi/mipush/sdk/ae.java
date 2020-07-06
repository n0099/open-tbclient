package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ae implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0880a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C0880a c0880a) {
        this.a = c0880a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f40a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f41a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f41a;
            scheduledFuture2.cancel(false);
            this.a.f41a = null;
        }
    }
}
