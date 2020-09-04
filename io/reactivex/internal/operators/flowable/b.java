package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class b<T> extends io.reactivex.internal.operators.flowable.a<T, T> {
    final long delay;
    final boolean delayError;
    final v scheduler;
    final TimeUnit unit;

    public b(io.reactivex.g<T> gVar, long j, TimeUnit timeUnit, v vVar, boolean z) {
        super(gVar);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = vVar;
        this.delayError = z;
    }

    @Override // io.reactivex.g
    protected void a(org.b.c<? super T> cVar) {
        this.omT.a((j) new a(this.delayError ? cVar : new io.reactivex.subscribers.b<>(cVar), this.delay, this.unit, this.scheduler.efd(), this.delayError));
    }

    /* loaded from: classes7.dex */
    static final class a<T> implements j<T>, org.b.d {
        final org.b.c<? super T> actual;
        final long delay;
        final boolean delayError;
        org.b.d s;
        final TimeUnit unit;
        final v.c w;

        a(org.b.c<? super T> cVar, long j, TimeUnit timeUnit, v.c cVar2, boolean z) {
            this.actual = cVar;
            this.delay = j;
            this.unit = timeUnit;
            this.w = cVar2;
            this.delayError = z;
        }

        @Override // io.reactivex.j, org.b.c
        public void onSubscribe(org.b.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.b.c
        public void onNext(T t) {
            this.w.c(new c(t), this.delay, this.unit);
        }

        @Override // org.b.c
        public void onError(Throwable th) {
            this.w.c(new RunnableC0964b(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // org.b.c
        public void onComplete() {
            this.w.c(new RunnableC0963a(), this.delay, this.unit);
        }

        @Override // org.b.d
        public void request(long j) {
            this.s.request(j);
        }

        @Override // org.b.d
        public void cancel() {
            this.s.cancel();
            this.w.dispose();
        }

        /* loaded from: classes7.dex */
        final class c implements Runnable {
            private final T t;

            c(T t) {
                this.t = t;
            }

            /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
            @Override // java.lang.Runnable
            public void run() {
                a.this.actual.onNext((T) this.t);
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        final class RunnableC0964b implements Runnable {
            private final Throwable awv;

            RunnableC0964b(Throwable th) {
                this.awv = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.actual.onError(this.awv);
                } finally {
                    a.this.w.dispose();
                }
            }
        }

        /* renamed from: io.reactivex.internal.operators.flowable.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        final class RunnableC0963a implements Runnable {
            RunnableC0963a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.actual.onComplete();
                } finally {
                    a.this.w.dispose();
                }
            }
        }
    }
}
