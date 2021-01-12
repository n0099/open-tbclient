package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f13383a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f13384b;
    private h c;

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public i() {
        this(c.f13373a, true, h.f13382a);
    }

    public i(int i, boolean z, h hVar) {
        this.f13383a = c.f13373a;
        this.f13384b = true;
        this.c = h.f13382a;
        a(i);
        a(z);
        a(hVar);
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f13383a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public void a(int i) {
        this.f13383a = i;
    }

    public boolean d() {
        return this.f13384b;
    }

    public void a(boolean z) {
        this.f13384b = z;
    }

    public h e() {
        return this.c;
    }

    public void a(h hVar) {
        this.c = hVar;
    }
}
