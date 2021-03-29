package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f39219a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39220b;

    /* renamed from: c  reason: collision with root package name */
    public h f39221c;

    public i() {
        this(c.f39200a, true, h.f39218a);
    }

    public void a(int i) {
        this.f39219a = i;
    }

    public abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f39219a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f39220b;
    }

    public h e() {
        return this.f39221c;
    }

    public i(int i, boolean z, h hVar) {
        this.f39219a = c.f39200a;
        this.f39220b = true;
        this.f39221c = h.f39218a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f39220b = z;
    }

    public void a(h hVar) {
        this.f39221c = hVar;
    }
}
