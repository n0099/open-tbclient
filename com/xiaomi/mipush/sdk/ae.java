package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1057a f4745a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1057a c1057a) {
        this.f4745a = c1057a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f4745a.f37a.size() != 0) {
            this.f4745a.b();
            return;
        }
        scheduledFuture = this.f4745a.f38a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f4745a.f38a;
            scheduledFuture2.cancel(false);
            this.f4745a.f38a = null;
        }
    }
}
