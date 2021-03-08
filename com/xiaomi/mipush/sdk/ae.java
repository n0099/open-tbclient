package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1265a f8208a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1265a c1265a) {
        this.f8208a = c1265a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f8208a.f34a.size() != 0) {
            this.f8208a.b();
            return;
        }
        scheduledFuture = this.f8208a.f35a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f8208a.f35a;
            scheduledFuture2.cancel(false);
            this.f8208a.f35a = null;
        }
    }
}
