package com.vivo.push;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class v implements Runnable {
    protected Context a;
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
        this.a = p.a().h();
    }

    public final int a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null && !(this.c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(this.a, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + (this.c == null ? "[null]" : this.c.toString()) + "}";
    }
}
