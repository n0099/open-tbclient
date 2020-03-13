package io.reactivex.internal.operators.maybe;

import io.reactivex.g;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.m;
import io.reactivex.o;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class MaybeConcatIterable<T> extends g<T> {
    final Iterable<? extends o<? extends T>> nwz;

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        try {
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(cVar, (Iterator) io.reactivex.internal.functions.a.h(this.nwz.iterator(), "The sources Iterable returned a null Iterator"));
            cVar.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.drain();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.H(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements m<T>, d {
        private static final long serialVersionUID = 3520831347801429610L;
        final c<? super T> actual;
        long produced;
        final Iterator<? extends o<? extends T>> sources;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable disposables = new SequentialDisposable();
        final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        ConcatMaybeObserver(c<? super T> cVar, Iterator<? extends o<? extends T>> it) {
            this.actual = cVar;
            this.sources = it;
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
                            try {
                                if (this.sources.hasNext()) {
                                    try {
                                        ((o) io.reactivex.internal.functions.a.h(this.sources.next(), "The source Iterator returned a null MaybeSource")).a(this);
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.H(th);
                                        cVar.onError(th);
                                        return;
                                    }
                                } else {
                                    cVar.onComplete();
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.H(th2);
                                cVar.onError(th2);
                                return;
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
