package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f39424a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f39425b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f39426c;

    public e(a aVar, long j) {
        this.f39426c = aVar;
        this.f39425b = j;
    }

    public final void a() {
        this.f39424a.postDelayed(this, this.f39425b);
    }

    public final void b() {
        this.f39424a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f39426c.f39404f;
        if (fVar != null) {
            str = a.f39399a;
            bool = a.f39400b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f39426c.f39404f;
            fVar2.a();
        }
        this.f39426c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
