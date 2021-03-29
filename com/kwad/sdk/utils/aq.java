package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Runnable> f36758a;

    public aq(Runnable runnable) {
        this.f36758a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f36758a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
