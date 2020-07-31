package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.j;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class FlowableMapNotification<T, R> extends a<T, R> {
    final Callable<? extends R> onCompleteSupplier;
    final h<? super Throwable, ? extends R> onErrorMapper;
    final h<? super T, ? extends R> onNextMapper;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        this.nSE.a((j) new MapNotificationSubscriber(cVar, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
    }

    /* loaded from: classes7.dex */
    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final h<? super Throwable, ? extends R> onErrorMapper;
        final h<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(org.a.c<? super R> cVar, h<? super T, ? extends R> hVar, h<? super Throwable, ? extends R> hVar2, Callable<? extends R> callable) {
            super(cVar);
            this.onNextMapper = hVar;
            this.onErrorMapper = hVar2;
            this.onCompleteSupplier = callable;
        }

        @Override // org.a.c
        public void onNext(T t) {
            try {
                Object k = io.reactivex.internal.functions.a.k(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.actual.onNext(k);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                this.actual.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onError(Throwable th) {
            try {
                complete(io.reactivex.internal.functions.a.k(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.K(th2);
                this.actual.onError(new CompositeException(th, th2));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: io.reactivex.internal.operators.flowable.FlowableMapNotification$MapNotificationSubscriber<T, R> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.a.c
        public void onComplete() {
            try {
                complete(io.reactivex.internal.functions.a.k(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                this.actual.onError(th);
            }
        }
    }
}
