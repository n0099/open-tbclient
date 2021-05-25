package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0470a f37222a;

    public aa(MiTinyDataClient.a.C0470a c0470a) {
        this.f37222a = c0470a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f37222a.f51a.size() != 0) {
            this.f37222a.b();
            return;
        }
        scheduledFuture = this.f37222a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f37222a.f52a;
            scheduledFuture2.cancel(false);
            this.f37222a.f52a = null;
        }
    }
}
