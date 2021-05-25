package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f35745a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f35746b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f35747c;

    public e(a aVar, long j) {
        this.f35747c = aVar;
        this.f35746b = j;
    }

    public final void a() {
        this.f35745a.postDelayed(this, this.f35746b);
    }

    public final void b() {
        this.f35745a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f35747c.f35725f;
        if (fVar != null) {
            str = a.f35720a;
            bool = a.f35721b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f35747c.f35725f;
            fVar2.a();
        }
        this.f35747c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
