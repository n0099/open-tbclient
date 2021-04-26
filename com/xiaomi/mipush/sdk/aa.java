package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0482a f38048a;

    public aa(MiTinyDataClient.a.C0482a c0482a) {
        this.f38048a = c0482a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f38048a.f51a.size() != 0) {
            this.f38048a.b();
            return;
        }
        scheduledFuture = this.f38048a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f38048a.f52a;
            scheduledFuture2.cancel(false);
            this.f38048a.f52a = null;
        }
    }
}
