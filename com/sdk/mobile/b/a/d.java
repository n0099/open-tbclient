package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39417a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f39418b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f39419c;

    public d(a aVar, long j) {
        this.f39419c = aVar;
        this.f39418b = j;
    }

    public final void a() {
        this.f39417a.postDelayed(this, this.f39418b);
    }

    public final void b() {
        this.f39417a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f39419c.f39410e;
        if (fVar != null) {
            str = a.f39406a;
            bool = a.f39407b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f39419c.f39410e;
            fVar2.a();
        }
        this.f39419c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
