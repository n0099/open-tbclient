package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class bd implements Runnable {
    public WeakReference<Runnable> a;

    public bd(Runnable runnable) {
        this.a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
