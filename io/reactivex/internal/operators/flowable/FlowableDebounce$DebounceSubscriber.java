package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.w.h;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableDebounce$DebounceSubscriber<T, U> extends AtomicLong implements g<T>, d {
    public static final long serialVersionUID = 6725975399620862591L;
    public final c<? super T> actual;
    public final h<? super T, ? extends b<U>> debounceSelector;
    public final AtomicReference<f.b.t.b> debouncer = new AtomicReference<>();
    public boolean done;
    public volatile long index;
    public d s;

    /* loaded from: classes7.dex */
    public static final class a<T, U> extends f.b.e0.a<U> {

        /* renamed from: f  reason: collision with root package name */
        public final FlowableDebounce$DebounceSubscriber<T, U> f69036f;

        /* renamed from: g  reason: collision with root package name */
        public final long f69037g;

        /* renamed from: h  reason: collision with root package name */
        public final T f69038h;
        public boolean i;
        public final AtomicBoolean j = new AtomicBoolean();

        public a(FlowableDebounce$DebounceSubscriber<T, U> flowableDebounce$DebounceSubscriber, long j, T t) {
            this.f69036f = flowableDebounce$DebounceSubscriber;
            this.f69037g = j;
            this.f69038h = t;
        }

        public void c() {
            if (this.j.compareAndSet(false, true)) {
                this.f69036f.emit(this.f69037g, this.f69038h);
            }
        }

        @Override // g.d.c
        public void onComplete() {
            if (this.i) {
                return;
            }
            this.i = true;
            c();
        }

        @Override // g.d.c
        public void onError(Throwable th) {
            if (this.i) {
                f.b.a0.a.f(th);
                return;
            }
            this.i = true;
            this.f69036f.onError(th);
        }

        @Override // g.d.c
        public void onNext(U u) {
            if (this.i) {
                return;
            }
            this.i = true;
            a();
            c();
        }
    }

    public FlowableDebounce$DebounceSubscriber(c<? super T> cVar, h<? super T, ? extends b<U>> hVar) {
        this.actual = cVar;
        this.debounceSelector = hVar;
    }

    @Override // g.d.d
    public void cancel() {
        this.s.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long j, T t) {
        if (j == this.index) {
            if (get() != 0) {
                this.actual.onNext(t);
                f.b.x.i.b.e(this, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        f.b.t.b bVar = this.debouncer.get();
        if (DisposableHelper.isDisposed(bVar)) {
            return;
        }
        ((a) bVar).c();
        DisposableHelper.dispose(this.debouncer);
        this.actual.onComplete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        DisposableHelper.dispose(this.debouncer);
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        f.b.t.b bVar = this.debouncer.get();
        if (bVar != null) {
            bVar.dispose();
        }
        try {
            b<U> apply = this.debounceSelector.apply(t);
            f.b.x.b.a.b(apply, "The publisher supplied is null");
            b<U> bVar2 = apply;
            a aVar = new a(this, j, t);
            if (this.debouncer.compareAndSet(bVar, aVar)) {
                bVar2.subscribe(aVar);
            }
        } catch (Throwable th) {
            f.b.u.a.a(th);
            cancel();
            this.actual.onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this, j);
        }
    }
}
