package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ae implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0889a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C0889a c0889a) {
        this.a = c0889a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f36a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f37a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f37a;
            scheduledFuture2.cancel(false);
            this.a.f37a = null;
        }
    }
}
