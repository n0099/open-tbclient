package io.reactivex.internal.operators.single;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public enum SingleInternalHelper$NoSuchElementCallable implements Callable<NoSuchElementException> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public NoSuchElementException call() throws Exception {
        return new NoSuchElementException();
    }
}
