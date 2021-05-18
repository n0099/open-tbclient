package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f35809a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f35810b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f35811c;

    public d(a aVar, long j) {
        this.f35811c = aVar;
        this.f35810b = j;
    }

    public final void a() {
        this.f35809a.postDelayed(this, this.f35810b);
    }

    public final void b() {
        this.f35809a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f35811c.f35802e;
        if (fVar != null) {
            str = a.f35798a;
            bool = a.f35799b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f35811c.f35802e;
            fVar2.a();
        }
        this.f35811c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
