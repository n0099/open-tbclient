package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes25.dex */
public final class c {
    public static b H(Runnable runnable) {
        io.reactivex.internal.functions.a.k(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b ejd() {
        return EmptyDisposable.INSTANCE;
    }
}
