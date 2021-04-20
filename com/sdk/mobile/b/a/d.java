package com.sdk.mobile.b.a;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f38884a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f38885b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f38886c;

    public d(a aVar, long j) {
        this.f38886c = aVar;
        this.f38885b = j;
    }

    public final void a() {
        this.f38884a.postDelayed(this, this.f38885b);
    }

    public final void b() {
        this.f38884a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f38886c.f38877e;
        if (fVar != null) {
            str = a.f38873a;
            bool = a.f38874b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f38886c.f38877e;
            fVar2.a();
        }
        this.f38886c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
