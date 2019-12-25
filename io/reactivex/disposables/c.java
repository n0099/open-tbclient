package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
/* loaded from: classes4.dex */
public final class c {
    public static b D(Runnable runnable) {
        io.reactivex.internal.functions.a.h(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    public static b dDQ() {
        return EmptyDisposable.INSTANCE;
    }
}
