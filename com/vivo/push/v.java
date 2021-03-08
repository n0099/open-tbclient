package com.vivo.push;

import android.content.Context;
/* loaded from: classes14.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f8089a;
    private int b;
    private y c;

    protected abstract void a(y yVar);

    public v(y yVar) {
        this.b = -1;
        this.c = yVar;
        this.b = yVar.b();
        if (this.b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f8089a = p.a().h();
    }

    public final int a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f8089a != null && !(this.c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(this.f8089a, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + (this.c == null ? "[null]" : this.c.toString()) + "}";
    }
}
