package com.meizu.cloud.pushsdk.common.base;

import com.meizu.cloud.pushsdk.common.util.Logger;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public abstract class a<T> {
    protected T a;
    protected String b;
    private AtomicInteger c = new AtomicInteger(0);

    protected abstract void a();

    protected abstract void b();

    public a(String str) {
        this.b = str;
    }

    public final void a(T t) {
        synchronized (this.c) {
            if (this.c.incrementAndGet() == 1) {
                Logger.b(this.b, "call onInit");
                this.a = t;
                a();
            }
        }
    }

    public final void c() {
        synchronized (this.c) {
            if (this.c.decrementAndGet() == 0) {
                Logger.b(this.b, "call onDestroy");
                b();
            }
        }
    }
}
