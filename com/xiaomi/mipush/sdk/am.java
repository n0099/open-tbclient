package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class am implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0705a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MiTinyDataClient.a.C0705a c0705a) {
        this.a = c0705a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f33a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f34a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f34a;
            scheduledFuture2.cancel(false);
            this.a.f34a = null;
        }
    }
}
