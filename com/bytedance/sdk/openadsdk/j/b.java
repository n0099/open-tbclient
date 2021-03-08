package com.bytedance.sdk.openadsdk.j;

import android.os.SystemClock;
import android.util.Log;
/* loaded from: classes6.dex */
class b implements Comparable, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private g f4864a;
    private a b;
    private long c;
    private Thread d = null;

    public b(g gVar, a aVar) {
        this.f4864a = null;
        this.b = null;
        this.c = 0L;
        this.f4864a = gVar;
        this.b = aVar;
        this.c = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.c;
        this.d = Thread.currentThread();
        if (this.f4864a != null) {
            this.f4864a.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (this.b != null) {
            d.a(this.b, j, uptimeMillis2);
        }
        Log.i("DelegateRunnable", "run: pool  = " + this.b.a() + " waitTime =" + j + " taskCost = " + uptimeMillis2);
    }

    public g a() {
        return this.f4864a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.f4864a.compareTo(((b) obj).a());
        }
        return 0;
    }

    public int hashCode() {
        return this.f4864a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.f4864a != null && this.f4864a.equals(((b) obj).a());
    }
}
