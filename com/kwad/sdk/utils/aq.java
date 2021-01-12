package com.kwad.sdk.utils;

import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Runnable> f10809a;

    public aq(Runnable runnable) {
        this.f10809a = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f10809a.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
