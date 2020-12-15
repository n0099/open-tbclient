package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableDebounce<T, U> extends a<T, T> {
    final h<? super T, ? extends org.a.b<U>> debounceSelector;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.pFi.a((j) new DebounceSubscriber(new io.reactivex.subscribers.b(cVar), this.debounceSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class DebounceSubscriber<T, U> extends AtomicLong implements j<T>, d {
        private static final long serialVersionUID = 6725975399620862591L;
        final org.a.c<? super T> actual;
        final h<? super T, ? extends org.a.b<U>> debounceSelector;
        final AtomicReference<io.reactivex.disposables.b> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;
        d s;

        DebounceSubscriber(org.a.c<? super T> cVar, h<? super T, ? extends org.a.b<U>> hVar) {
            this.actual = cVar;
            this.debounceSelector = hVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                long j = 1 + this.index;
                this.index = j;
                io.reactivex.disposables.b bVar = this.debouncer.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                try {
                    org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.m(this.debounceSelector.apply(t), "The publisher supplied is null");
                    a aVar = new a(this, j, t);
                    if (this.debouncer.compareAndSet(bVar, aVar)) {
                        bVar2.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    cancel();
                    this.actual.onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                io.reactivex.disposables.b bVar = this.debouncer.get();
                if (!DisposableHelper.isDisposed(bVar)) {
                    ((a) bVar).emit();
                    DisposableHelper.dispose(this.debouncer);
                    this.actual.onComplete();
                }
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.s.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        void emit(long j, T t) {
            if (j == this.index) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                    return;
                }
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            }
        }

        /* loaded from: classes9.dex */
        static final class a<T, U> extends io.reactivex.subscribers.a<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceSubscriber<T, U> pFy;
            final T value;

            a(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.pFy = debounceSubscriber;
                this.index = j;
                this.value = t;
            }

            @Override // org.a.c
            public void onNext(U u) {
                if (!this.done) {
                    this.done = true;
                    cancel();
                    emit();
                }
            }

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.pFy.emit(this.index, this.value);
                }
            }

            @Override // org.a.c
            public void onError(Throwable th) {
                if (this.done) {
                    io.reactivex.d.a.onError(th);
                    return;
                }
                this.done = true;
                this.pFy.onError(th);
            }

            @Override // org.a.c
            public void onComplete() {
                if (!this.done) {
                    this.done = true;
                    emit();
                }
            }
        }
    }
}
