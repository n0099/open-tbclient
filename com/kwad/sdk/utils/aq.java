package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Runnable> f10811a;

    public aq(Runnable runnable) {
        this.f10811a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f10811a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
