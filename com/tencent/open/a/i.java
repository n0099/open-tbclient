package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes6.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f4583a;
    private volatile boolean b;
    private h c;

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public i() {
        this(c.f4577a, true, h.f4582a);
    }

    public i(int i, boolean z, h hVar) {
        this.f4583a = c.f4577a;
        this.b = true;
        this.c = h.f4582a;
        a(i);
        a(z);
        a(hVar);
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f4583a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public void a(int i) {
        this.f4583a = i;
    }

    public boolean d() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public h e() {
        return this.c;
    }

    public void a(h hVar) {
        this.c = hVar;
    }
}
