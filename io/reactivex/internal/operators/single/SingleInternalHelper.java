package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.q;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class SingleInternalHelper {

    /* loaded from: classes5.dex */
    enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    /* loaded from: classes5.dex */
    enum ToFlowable implements h<aa, org.a.b> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        public org.a.b apply(aa aaVar) {
            return new SingleToFlowable(aaVar);
        }
    }

    /* loaded from: classes5.dex */
    enum ToObservable implements h<aa, q> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.h
        public q apply(aa aaVar) {
            return new b(aaVar);
        }
    }
}
