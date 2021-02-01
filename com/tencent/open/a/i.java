package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes15.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f13385a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f13386b;
    private h c;

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public i() {
        this(c.f13375a, true, h.f13384a);
    }

    public i(int i, boolean z, h hVar) {
        this.f13385a = c.f13375a;
        this.f13386b = true;
        this.c = h.f13384a;
        a(i);
        a(z);
        a(hVar);
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f13385a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public void a(int i) {
        this.f13385a = i;
    }

    public boolean d() {
        return this.f13386b;
    }

    public void a(boolean z) {
        this.f13386b = z;
    }

    public h e() {
        return this.c;
    }

    public void a(h hVar) {
        this.c = hVar;
    }
}
