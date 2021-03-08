package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Runnable> f7137a;

    public aq(Runnable runnable) {
        this.f7137a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f7137a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
