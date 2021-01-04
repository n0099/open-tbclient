package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes4.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f13682a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f13683b;
    private h c;

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public i() {
        this(c.f13672a, true, h.f13681a);
    }

    public i(int i, boolean z, h hVar) {
        this.f13682a = c.f13672a;
        this.f13683b = true;
        this.c = h.f13681a;
        a(i);
        a(z);
        a(hVar);
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f13682a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public void a(int i) {
        this.f13682a = i;
    }

    public boolean d() {
        return this.f13683b;
    }

    public void a(boolean z) {
        this.f13683b = z;
    }

    public h e() {
        return this.c;
    }

    public void a(h hVar) {
        this.c = hVar;
    }
}
