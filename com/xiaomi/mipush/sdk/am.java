package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class am implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0590a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MiTinyDataClient.a.C0590a c0590a) {
        this.a = c0590a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f28a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f29a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f29a;
            scheduledFuture2.cancel(false);
            this.a.f29a = null;
        }
    }
}
