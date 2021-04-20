package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0535a f40438a;

    public aa(MiTinyDataClient.a.C0535a c0535a) {
        this.f40438a = c0535a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f40438a.f51a.size() != 0) {
            this.f40438a.b();
            return;
        }
        scheduledFuture = this.f40438a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f40438a.f52a;
            scheduledFuture2.cancel(false);
            this.f40438a.f52a = null;
        }
    }
}
