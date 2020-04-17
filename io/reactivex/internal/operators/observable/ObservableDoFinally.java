package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.u;
/* loaded from: classes7.dex */
public final class ObservableDoFinally<T> extends a<T, T> {
    final io.reactivex.c.a onFinally;

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.source.subscribe(new DoFinallyObserver(uVar, this.onFinally));
    }

    /* loaded from: classes7.dex */
    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements u<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final u<? super T> actual;
        io.reactivex.disposables.b d;
        final io.reactivex.c.a onFinally;
        io.reactivex.internal.a.b<T> qd;
        boolean syncFused;

        DoFinallyObserver(u<? super T> uVar, io.reactivex.c.a aVar) {
            this.actual = uVar;
            this.onFinally = aVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    this.qd = (io.reactivex.internal.a.b) bVar;
                }
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.d.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            io.reactivex.internal.a.b<T> bVar = this.qd;
            if (bVar == null || (i & 4) != 0) {
                return 0;
            }
            int requestFusion = bVar.requestFusion(i);
            if (requestFusion != 0) {
                this.syncFused = requestFusion == 1;
            }
            return requestFusion;
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            T poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    io.reactivex.e.a.onError(th);
                }
            }
        }
    }
}
