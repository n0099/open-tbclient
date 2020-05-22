package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes7.dex */
public final class c {
    public static b L(Runnable runnable) {
        io.reactivex.internal.functions.a.k(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b dKA() {
        return EmptyDisposable.INSTANCE;
    }
}
