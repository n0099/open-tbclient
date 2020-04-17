package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class am implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0778a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MiTinyDataClient.a.C0778a c0778a) {
        this.a = c0778a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f29a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f30a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f30a;
            scheduledFuture2.cancel(false);
            this.a.f30a = null;
        }
    }
}
