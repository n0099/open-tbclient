package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Runnable> f11108a;

    public aq(Runnable runnable) {
        this.f11108a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f11108a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
