package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1034a f4743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MiTinyDataClient.a.C1034a c1034a) {
        this.f4743a = c1034a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f4743a.f32a.size() != 0) {
            this.f4743a.b();
            return;
        }
        scheduledFuture = this.f4743a.f33a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f4743a.f33a;
            scheduledFuture2.cancel(false);
            this.f4743a.f33a = null;
        }
    }
}
