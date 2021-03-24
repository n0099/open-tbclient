package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38594a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38595b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38596c;

    public d(a aVar, long j) {
        this.f38596c = aVar;
        this.f38595b = j;
    }

    public final void a() {
        this.f38594a.postDelayed(this, this.f38595b);
    }

    public final void b() {
        this.f38594a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38596c.f38587e;
        if (fVar != null) {
            str = a.f38583a;
            bool = a.f38584b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38596c.f38587e;
            fVar2.a();
        }
        this.f38596c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
