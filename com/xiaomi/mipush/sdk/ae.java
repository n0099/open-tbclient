package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1035a f4515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1035a c1035a) {
        this.f4515a = c1035a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f4515a.f35a.size() != 0) {
            this.f4515a.b();
            return;
        }
        scheduledFuture = this.f4515a.f36a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f4515a.f36a;
            scheduledFuture2.cancel(false);
            this.f4515a.f36a = null;
        }
    }
}
