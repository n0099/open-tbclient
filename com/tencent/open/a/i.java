package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f39603a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39604b;

    /* renamed from: c  reason: collision with root package name */
    public h f39605c;

    public i() {
        this(c.f39584a, true, h.f39602a);
    }

    public void a(int i) {
        this.f39603a = i;
    }

    public abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f39603a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f39604b;
    }

    public h e() {
        return this.f39605c;
    }

    public i(int i, boolean z, h hVar) {
        this.f39603a = c.f39584a;
        this.f39604b = true;
        this.f39605c = h.f39602a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f39604b = z;
    }

    public void a(h hVar) {
        this.f39605c = hVar;
    }
}
