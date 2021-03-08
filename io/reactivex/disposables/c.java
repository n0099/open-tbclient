package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes6.dex */
public final class c {
    public static b D(Runnable runnable) {
        io.reactivex.internal.functions.a.n(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b eJZ() {
        return EmptyDisposable.INSTANCE;
    }
}
