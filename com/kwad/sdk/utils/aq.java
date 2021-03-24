package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Runnable> f36757a;

    public aq(Runnable runnable) {
        this.f36757a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f36757a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
