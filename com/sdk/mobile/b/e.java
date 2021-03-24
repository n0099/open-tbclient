package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38601a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38602b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38603c;

    public e(a aVar, long j) {
        this.f38603c = aVar;
        this.f38602b = j;
    }

    public final void a() {
        this.f38601a.postDelayed(this, this.f38602b);
    }

    public final void b() {
        this.f38601a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38603c.f38581f;
        if (fVar != null) {
            str = a.f38576a;
            bool = a.f38577b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38603c.f38581f;
            fVar2.a();
        }
        this.f38603c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
