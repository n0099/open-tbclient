package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f36564a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f36565b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f36566c;

    public d(a aVar, long j) {
        this.f36566c = aVar;
        this.f36565b = j;
    }

    public final void a() {
        this.f36564a.postDelayed(this, this.f36565b);
    }

    public final void b() {
        this.f36564a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f36566c.f36557e;
        if (fVar != null) {
            str = a.f36553a;
            bool = a.f36554b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f36566c.f36557e;
            fVar2.a();
        }
        this.f36566c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
