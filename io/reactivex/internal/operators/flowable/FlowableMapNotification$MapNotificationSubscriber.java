package io.reactivex.internal.operators.flowable;

import f.b.w.h;
import f.b.x.b.a;
import g.d.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    public static final long serialVersionUID = 2757120512858778108L;
    public final Callable<? extends R> onCompleteSupplier;
    public final h<? super Throwable, ? extends R> onErrorMapper;
    public final h<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(c<? super R> cVar, h<? super T, ? extends R> hVar, h<? super Throwable, ? extends R> hVar2, Callable<? extends R> callable) {
        super(cVar);
        this.onNextMapper = hVar;
        this.onErrorMapper = hVar2;
        this.onCompleteSupplier = callable;
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onComplete() {
        try {
            R call = this.onCompleteSupplier.call();
            a.b(call, "The onComplete publisher returned is null");
            complete(call);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.actual.onError(th);
        }
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onError(Throwable th) {
        try {
            R apply = this.onErrorMapper.apply(th);
            a.b(apply, "The onError publisher returned is null");
            complete(apply);
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, g.d.c
    public void onNext(T t) {
        try {
            R apply = this.onNextMapper.apply(t);
            a.b(apply, "The onNext publisher returned is null");
            this.produced++;
            this.actual.onNext(apply);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.actual.onError(th);
        }
    }
}
