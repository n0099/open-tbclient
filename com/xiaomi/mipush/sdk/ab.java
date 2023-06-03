package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes10.dex */
public class ab implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0769a a;

    public ab(MiTinyDataClient.a.C0769a c0769a) {
        this.a = c0769a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f43a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f44a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f44a;
            scheduledFuture2.cancel(false);
            this.a.f44a = null;
        }
    }
}
