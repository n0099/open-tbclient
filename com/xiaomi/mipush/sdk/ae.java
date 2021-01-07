package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1294a f14099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1294a c1294a) {
        this.f14099a = c1294a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f14099a.f114a.size() != 0) {
            this.f14099a.b();
            return;
        }
        scheduledFuture = this.f14099a.f115a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f14099a.f115a;
            scheduledFuture2.cancel(false);
            this.f14099a.f115a = null;
        }
    }
}
