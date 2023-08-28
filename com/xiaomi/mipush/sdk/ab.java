package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes10.dex */
public class ab implements Runnable {
    public final /* synthetic */ MiTinyDataClient.a.C0787a a;

    public ab(MiTinyDataClient.a.C0787a c0787a) {
        this.a = c0787a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.a.f44a.size() != 0) {
            this.a.b();
            return;
        }
        scheduledFuture = this.a.f45a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.a.f45a;
            scheduledFuture2.cancel(false);
            this.a.f45a = null;
        }
    }
}
