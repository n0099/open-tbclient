package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes17.dex */
public final class c {
    public static b J(Runnable runnable) {
        io.reactivex.internal.functions.a.l(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b eAD() {
        return EmptyDisposable.INSTANCE;
    }
}
