package com.tencent.open.a;

import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public volatile int f36449a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36450b;

    /* renamed from: c  reason: collision with root package name */
    public h f36451c;

    public i() {
        this(c.f36429a, true, h.f36448a);
    }

    public void a(int i2) {
        this.f36449a = i2;
    }

    public abstract void a(int i2, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f36449a, i2)) {
            a(i2, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.f36450b;
    }

    public h e() {
        return this.f36451c;
    }

    public i(int i2, boolean z, h hVar) {
        this.f36449a = c.f36429a;
        this.f36450b = true;
        this.f36451c = h.f36448a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        this.f36450b = z;
    }

    public void a(h hVar) {
        this.f36451c = hVar;
    }
}
