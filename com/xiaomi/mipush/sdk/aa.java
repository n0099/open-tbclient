package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0469a f37293a;

    public aa(MiTinyDataClient.a.C0469a c0469a) {
        this.f37293a = c0469a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f37293a.f51a.size() != 0) {
            this.f37293a.b();
            return;
        }
        scheduledFuture = this.f37293a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f37293a.f52a;
            scheduledFuture2.cancel(false);
            this.f37293a.f52a = null;
        }
    }
}
