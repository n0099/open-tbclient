package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.fuseable.ScalarCallable;
/* loaded from: classes7.dex */
public final class MaybeJust<T> extends Maybe<T> implements ScalarCallable<T> {
    public final T value;

    public MaybeJust(T t) {
        this.value = t;
    }

    @Override // io.reactivex.internal.fuseable.ScalarCallable, java.util.concurrent.Callable
    public T call() {
        return this.value;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.onSubscribe(Disposables.disposed());
        maybeObserver.onSuccess((T) this.value);
    }
}
