package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0524a f41004a;

    public aa(MiTinyDataClient.a.C0524a c0524a) {
        this.f41004a = c0524a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f41004a.f51a.size() != 0) {
            this.f41004a.b();
            return;
        }
        scheduledFuture = this.f41004a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f41004a.f52a;
            scheduledFuture2.cancel(false);
            this.f41004a.f52a = null;
        }
    }
}
