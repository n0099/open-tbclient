package io.reactivex.internal.operators.observable;

import io.reactivex.c.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableRetryBiPredicate<T> extends a<T, T> {
    final d<? super Integer, ? super Throwable> predicate;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        uVar.onSubscribe(sequentialDisposable);
        new RetryBiObserver(uVar, this.predicate, sequentialDisposable, this.source).subscribeNext();
    }

    /* loaded from: classes7.dex */
    static final class RetryBiObserver<T> extends AtomicInteger implements u<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final u<? super T> actual;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final SequentialDisposable sa;
        final t<? extends T> source;

        RetryBiObserver(u<? super T> uVar, d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, t<? extends T> tVar) {
            this.actual = uVar;
            this.sa = sequentialDisposable;
            this.source = tVar;
            this.predicate = dVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.sa.update(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            try {
                d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i = this.retries + 1;
                this.retries = i;
                if (!dVar.j(Integer.valueOf(i), th)) {
                    this.actual.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.sa.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
