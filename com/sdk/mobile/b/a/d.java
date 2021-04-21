package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38979a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38980b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38981c;

    public d(a aVar, long j) {
        this.f38981c = aVar;
        this.f38980b = j;
    }

    public final void a() {
        this.f38979a.postDelayed(this, this.f38980b);
    }

    public final void b() {
        this.f38979a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38981c.f38972e;
        if (fVar != null) {
            str = a.f38968a;
            bool = a.f38969b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38981c.f38972e;
            fVar2.a();
        }
        this.f38981c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
