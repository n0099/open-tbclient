package com.vivo.push;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f14009a;

    /* renamed from: b  reason: collision with root package name */
    private int f14010b;
    private y c;

    protected abstract void a(y yVar);

    public v(y yVar) {
        this.f14010b = -1;
        this.c = yVar;
        this.f14010b = yVar.b();
        if (this.f14010b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f14009a = p.a().h();
    }

    public final int a() {
        return this.f14010b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f14009a != null && !(this.c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(this.f14009a, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + (this.c == null ? "[null]" : this.c.toString()) + "}";
    }
}
