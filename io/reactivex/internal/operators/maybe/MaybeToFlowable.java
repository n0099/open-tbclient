package io.reactivex.internal.operators.maybe;

import f.a.e;
import f.a.i;
import f.a.j;
import f.a.t.b;
import g.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
/* loaded from: classes7.dex */
public final class MaybeToFlowable<T> extends e<T> {

    /* renamed from: f  reason: collision with root package name */
    public final j<T> f68050f;

    /* loaded from: classes7.dex */
    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements i<T> {
        public static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d  reason: collision with root package name */
        public b f68051d;

        public MaybeToFlowableSubscriber(c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
        public void cancel() {
            super.cancel();
            this.f68051d.dispose();
        }

        @Override // f.a.i
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // f.a.i
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // f.a.i
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f68051d, bVar)) {
                this.f68051d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // f.a.i
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToFlowable(j<T> jVar) {
        this.f68050f = jVar;
    }

    @Override // f.a.e
    public void c(c<? super T> cVar) {
        this.f68050f.a(new MaybeToFlowableSubscriber(cVar));
    }
}
