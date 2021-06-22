package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39522a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f39523b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f39524c;

    public e(a aVar, long j) {
        this.f39524c = aVar;
        this.f39523b = j;
    }

    public final void a() {
        this.f39522a.postDelayed(this, this.f39523b);
    }

    public final void b() {
        this.f39522a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f39524c.f39502f;
        if (fVar != null) {
            str = a.f39497a;
            bool = a.f39498b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f39524c.f39502f;
            fVar2.a();
        }
        this.f39524c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
