package com.sdk.base.framework.a.c;
/* loaded from: classes5.dex */
public final class n extends k<Runnable> implements Runnable {
    public n(int i, Runnable runnable) {
        super(i, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Runnable) this.b).run();
    }
}
