package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Runnable> f37047a;

    public aq(Runnable runnable) {
        this.f37047a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f37047a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
