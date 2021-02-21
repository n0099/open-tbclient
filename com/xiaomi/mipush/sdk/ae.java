package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1283a f13801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1283a c1283a) {
        this.f13801a = c1283a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f13801a.f113a.size() != 0) {
            this.f13801a.b();
            return;
        }
        scheduledFuture = this.f13801a.f114a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f13801a.f114a;
            scheduledFuture2.cancel(false);
            this.f13801a.f114a = null;
        }
    }
}
