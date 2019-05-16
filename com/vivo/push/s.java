package com.vivo.push;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class s implements Runnable {
    protected Context a;
    private int b;
    private v c;

    protected abstract void a(v vVar);

    public s(v vVar) {
        this.b = -1;
        this.c = vVar;
        this.b = vVar.b();
        if (this.b < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.a = m.a().i();
    }

    public final int a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a != null && !(this.c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.m.a(this.a, "[执行指令]" + this.c);
        }
        a(this.c);
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + (this.c == null ? "[null]" : this.c.toString()) + "}";
    }
}
