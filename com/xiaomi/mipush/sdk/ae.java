package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ae implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0947a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C0947a c0947a) {
        this.a = c0947a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f35a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f36a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f36a;
            scheduledFuture2.cancel(false);
            this.a.f36a = null;
        }
    }
}
