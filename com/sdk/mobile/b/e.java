package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes7.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f35816a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f35817b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f35818c;

    public e(a aVar, long j) {
        this.f35818c = aVar;
        this.f35817b = j;
    }

    public final void a() {
        this.f35816a.postDelayed(this, this.f35817b);
    }

    public final void b() {
        this.f35816a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f35818c.f35796f;
        if (fVar != null) {
            str = a.f35791a;
            bool = a.f35792b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f35818c.f35796f;
            fVar2.a();
        }
        this.f35818c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
