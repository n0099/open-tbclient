package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes5.dex */
public final class c {
    public static b G(Runnable runnable) {
        io.reactivex.internal.functions.a.m(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b eHT() {
        return EmptyDisposable.INSTANCE;
    }
}
