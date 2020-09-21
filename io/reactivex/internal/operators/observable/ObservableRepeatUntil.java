package io.reactivex.internal.operators.observable;

import io.reactivex.c.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes25.dex */
public final class ObservableRepeatUntil<T> extends a<T, T> {
    final e oxp;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        uVar.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(uVar, this.oxp, sequentialDisposable, this.source).subscribeNext();
    }

    /* loaded from: classes25.dex */
    static final class RepeatUntilObserver<T> extends AtomicInteger implements u<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final u<? super T> actual;
        final SequentialDisposable sd;
        final t<? extends T> source;
        final e stop;

        RepeatUntilObserver(u<? super T> uVar, e eVar, SequentialDisposable sequentialDisposable, t<? extends T> tVar) {
            this.actual = uVar;
            this.sd = sequentialDisposable;
            this.source = tVar;
            this.stop = eVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.sd.replace(bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                this.actual.onError(th);
            }
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
