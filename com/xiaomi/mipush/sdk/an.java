package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class an implements Runnable {
    final /* synthetic */ MiTinyDataClient.a.C0483a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MiTinyDataClient.a.C0483a c0483a) {
        this.a = c0483a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.d;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.d;
            scheduledFuture2.cancel(false);
            this.a.d = null;
        }
    }
}
