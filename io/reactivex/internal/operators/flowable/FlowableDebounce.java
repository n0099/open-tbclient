package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableDebounce<T, U> extends a<T, T> {
    final h<? super T, ? extends org.b.b<U>> debounceSelector;

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omT.a((j) new DebounceSubscriber(new io.reactivex.subscribers.b(cVar), this.debounceSelector));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class DebounceSubscriber<T, U> extends AtomicLong implements j<T>, org.b.d {
        private static final long serialVersionUID = 6725975399620862591L;
        final org.b.c<? super T> actual;
        final h<? super T, ? extends org.b.b<U>> debounceSelector;
        final AtomicReference<io.reactivex.disposables.b> debouncer = new AtomicReference<>();
        boolean done;
        volatile long index;
        org.b.d s;

        DebounceSubscriber(org.b.c<? super T> cVar, h<? super T, ? extends org.b.b<U>> hVar) {
            this.actual = cVar;
            this.debounceSelector = hVar;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            if (!this.done) {
                long j = 1 + this.index;
                this.index = j;
                io.reactivex.disposables.b bVar = this.debouncer.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                try {
                    org.b.b bVar2 = (org.b.b) io.reactivex.internal.functions.a.k(this.debounceSelector.apply(t), "The publisher supplied is null");
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

        @Override // org.b.c
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.debouncer);
            this.actual.onError(th);
        }

        @Override // org.b.c
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

        @Override // org.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
            }
        }

        @Override // org.b.d
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

        /* loaded from: classes7.dex */
        static final class a<T, U> extends io.reactivex.subscribers.a<U> {
            boolean done;
            final long index;
            final AtomicBoolean once = new AtomicBoolean();
            final DebounceSubscriber<T, U> onl;
            final T value;

            a(DebounceSubscriber<T, U> debounceSubscriber, long j, T t) {
                this.onl = debounceSubscriber;
                this.index = j;
                this.value = t;
            }

            @Override // org.b.c
            public void onNext(U u) {
                if (!this.done) {
                    this.done = true;
                    cancel();
                    emit();
                }
            }

            void emit() {
                if (this.once.compareAndSet(false, true)) {
                    this.onl.emit(this.index, this.value);
                }
            }

            @Override // org.b.c
            public void onError(Throwable th) {
                if (this.done) {
                    io.reactivex.e.a.onError(th);
                    return;
                }
                this.done = true;
                this.onl.onError(th);
            }

            @Override // org.b.c
            public void onComplete() {
                if (!this.done) {
                    this.done = true;
                    emit();
                }
            }
        }
    }
}
