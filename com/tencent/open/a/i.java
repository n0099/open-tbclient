package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f39218a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39219b;

    /* renamed from: c  reason: collision with root package name */
    public h f39220c;

    public i() {
        this(c.f39199a, true, h.f39217a);
    }

    public void a(int i) {
        this.f39218a = i;
    }

    public abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f39218a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f39219b;
    }

    public h e() {
        return this.f39220c;
    }

    public i(int i, boolean z, h hVar) {
        this.f39218a = c.f39199a;
        this.f39219b = true;
        this.f39220c = h.f39217a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f39219b = z;
    }

    public void a(h hVar) {
        this.f39220c = hVar;
    }
}
