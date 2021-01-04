package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1253a f14098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1253a c1253a) {
        this.f14098a = c1253a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f14098a.f113a.size() != 0) {
            this.f14098a.b();
            return;
        }
        scheduledFuture = this.f14098a.f114a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f14098a.f114a;
            scheduledFuture2.cancel(false);
            this.f14098a.f114a = null;
        }
    }
}
