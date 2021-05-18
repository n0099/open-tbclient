package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Runnable> f34122a;

    public ap(Runnable runnable) {
        this.f34122a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f34122a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
