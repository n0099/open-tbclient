package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ae implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0944a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C0944a c0944a) {
        this.a = c0944a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f34a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f35a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f35a;
            scheduledFuture2.cancel(false);
            this.a.f35a = null;
        }
    }
}
