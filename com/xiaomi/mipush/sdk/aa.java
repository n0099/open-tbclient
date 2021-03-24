package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import java.util.concurrent.ScheduledFuture;
/* loaded from: classes7.dex */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiTinyDataClient.a.C0520a f40148a;

    public aa(MiTinyDataClient.a.C0520a c0520a) {
        this.f40148a = c0520a;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScheduledFuture scheduledFuture;
        ScheduledFuture scheduledFuture2;
        if (this.f40148a.f51a.size() != 0) {
            this.f40148a.b();
            return;
        }
        scheduledFuture = this.f40148a.f52a;
        if (scheduledFuture != null) {
            scheduledFuture2 = this.f40148a.f52a;
            scheduledFuture2.cancel(false);
            this.f40148a.f52a = null;
        }
    }
}
