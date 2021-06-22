package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39515a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f39516b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f39517c;

    public d(a aVar, long j) {
        this.f39517c = aVar;
        this.f39516b = j;
    }

    public final void a() {
        this.f39515a.postDelayed(this, this.f39516b);
    }

    public final void b() {
        this.f39515a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f39517c.f39508e;
        if (fVar != null) {
            str = a.f39504a;
            bool = a.f39505b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f39517c.f39508e;
            fVar2.a();
        }
        this.f39517c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
