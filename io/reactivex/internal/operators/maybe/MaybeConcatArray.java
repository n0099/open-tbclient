package io.reactivex.internal.operators.maybe;

import io.reactivex.g;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes6.dex */
public final class MaybeConcatArray<T> extends g<T> {
    final o<? extends T>[] sources;

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(cVar, this.sources);
        cVar.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.drain();
    }

    /* loaded from: classes6.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements m<T>, d {
        private static final long serialVersionUID = 3520831347801429610L;
        final c<? super T> actual;
        int index;
        long produced;
        final o<? extends T>[] sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        ConcatMaybeObserver(c<? super T> cVar, o<? extends T>[] oVarArr) {
            this.actual = cVar;
            this.sources = oVarArr;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.disposables.dispose();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.disposables.replace(bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            drain();
        }

        void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.current;
                c<? super T> cVar = this.actual;
                SequentialDisposable sequentialDisposable = this.disposables;
                while (!sequentialDisposable.isDisposed()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        if (obj != NotificationLite.COMPLETE) {
                            long j = this.produced;
                            if (j != this.requested.get()) {
                                this.produced = j + 1;
                                atomicReference.lazySet(null);
                                cVar.onNext(obj);
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            atomicReference.lazySet(null);
                            z = true;
                        }
                        if (z && !sequentialDisposable.isDisposed()) {
                            int i = this.index;
                            if (i == this.sources.length) {
                                cVar.onComplete();
                                return;
                            } else {
                                this.index = i + 1;
                                this.sources[i].a(this);
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet(null);
            }
        }
    }
}
