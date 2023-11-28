package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes10.dex */
public class ab implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0756a a;

    public ab(MiTinyDataClient.a.C0756a c0756a) {
        this.a = c0756a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f39a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f40a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f40a;
            scheduledFuture2.cancel(false);
            this.a.f40a = null;
        }
    }
}
