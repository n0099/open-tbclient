package com.sdk.mobile.b;

import android.os.Handler;
import android.os.Looper;
import com.sdk.base.framework.a.f;
/* loaded from: classes6.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Handler f36571a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public long f36572b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ a f36573c;

    public e(a aVar, long j) {
        this.f36573c = aVar;
        this.f36572b = j;
    }

    public final void a() {
        this.f36571a.postDelayed(this, this.f36572b);
    }

    public final void b() {
        this.f36571a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        String str;
        Boolean bool;
        f fVar2;
        fVar = this.f36573c.f36551f;
        if (fVar != null) {
            str = a.f36546a;
            bool = a.f36547b;
            com.sdk.base.framework.a.a.c.c(str, "超时，已取消请求", bool);
            fVar2 = this.f36573c.f36551f;
            fVar2.a();
        }
        this.f36573c.a(1, "超时", 101005, null, com.sdk.base.framework.f.f.a.b().a());
    }
}
