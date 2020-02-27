package io.reactivex.internal.operators.mixed;

import io.reactivex.c.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class MaybeFlatMapPublisher<T, R> extends g<R> {
    final h<? super T, ? extends b<? extends R>> mapper;
    final o<T> source;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.source.a(new FlatMapPublisherSubscriber(cVar, this.mapper));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<d> implements j<R>, m<T>, d {
        private static final long serialVersionUID = -8948264376121066672L;
        final c<? super R> downstream;
        final h<? super T, ? extends b<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        io.reactivex.disposables.b upstream;

        FlatMapPublisherSubscriber(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar) {
            this.downstream = cVar;
            this.mapper = hVar;
        }

        @Override // org.a.c
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            try {
                ((b) io.reactivex.internal.functions.a.h(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.H(th);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, dVar);
        }
    }
}
