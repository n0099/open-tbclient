package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes6.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f39508a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39509b;

    /* renamed from: c  reason: collision with root package name */
    public h f39510c;

    public i() {
        this(c.f39489a, true, h.f39507a);
    }

    public void a(int i) {
        this.f39508a = i;
    }

    public abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f39508a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f39509b;
    }

    public h e() {
        return this.f39510c;
    }

    public i(int i, boolean z, h hVar) {
        this.f39508a = c.f39489a;
        this.f39509b = true;
        this.f39510c = h.f39507a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f39509b = z;
    }

    public void a(h hVar) {
        this.f39510c = hVar;
    }
}
