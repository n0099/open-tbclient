package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C0962a f4745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C0962a c0962a) {
        this.f4745a = c0962a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f4745a.f35a.size() != 0) {
            this.f4745a.b();
            return;
        }
        scheduledFuture = this.f4745a.f36a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f4745a.f36a;
            scheduledFuture2.cancel(false);
            this.f4745a.f36a = null;
        }
    }
}
