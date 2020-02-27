package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class SingleFlatMapPublisher<T, R> extends g<R> {
    final h<? super T, ? extends b<? extends R>> mapper;
    final aa<T> source;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.source.a(new SingleFlatMapPublisherObserver(cVar, this.mapper));
    }

    /* loaded from: classes7.dex */
    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements j<T>, y<S>, d {
        private static final long serialVersionUID = 7759721921468635667L;
        final c<? super T> actual;
        io.reactivex.disposables.b disposable;
        final h<? super S, ? extends b<? extends T>> mapper;
        final AtomicReference<d> parent = new AtomicReference<>();

        SingleFlatMapPublisherObserver(c<? super T> cVar, h<? super S, ? extends b<? extends T>> hVar) {
            this.actual = cVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.disposable = bVar;
            this.actual.onSubscribe(this);
        }

        @Override // io.reactivex.y
        public void onSuccess(S s) {
            try {
                ((b) io.reactivex.internal.functions.a.h(this.mapper.apply(s), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this.parent, this, dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // org.a.c
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this.parent, this, j);
        }

        @Override // org.a.d
        public void cancel() {
            this.disposable.dispose();
            SubscriptionHelper.cancel(this.parent);
        }
    }
}
