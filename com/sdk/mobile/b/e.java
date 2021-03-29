package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38602a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38603b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38604c;

    public e(a aVar, long j) {
        this.f38604c = aVar;
        this.f38603b = j;
    }

    public final void a() {
        this.f38602a.postDelayed(this, this.f38603b);
    }

    public final void b() {
        this.f38602a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38604c.f38582f;
        if (fVar != null) {
            str = a.f38577a;
            bool = a.f38578b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38604c.f38582f;
            fVar2.a();
        }
        this.f38604c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
