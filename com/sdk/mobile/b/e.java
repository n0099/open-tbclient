package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38891a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38892b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38893c;

    public e(a aVar, long j) {
        this.f38893c = aVar;
        this.f38892b = j;
    }

    public final void a() {
        this.f38891a.postDelayed(this, this.f38892b);
    }

    public final void b() {
        this.f38891a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38893c.f38871f;
        if (fVar != null) {
            str = a.f38866a;
            bool = a.f38867b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38893c.f38871f;
            fVar2.a();
        }
        this.f38893c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
