package io.reactivex.internal.operators.single;

import f.b.e;
import f.b.r;
import f.b.s;
import f.b.t.b;
import g.d.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
/* loaded from: classes7.dex */
public final class SingleToFlowable<T> extends e<T> {

    /* renamed from: f  reason: collision with root package name */
    public final s<? extends T> f69243f;

    /* loaded from: classes7.dex */
    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements r<T> {
        public static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d  reason: collision with root package name */
        public b f69244d;

        public SingleToFlowableObserver(c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
        public void cancel() {
            super.cancel();
            this.f69244d.dispose();
        }

        @Override // f.b.r
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // f.b.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f69244d, bVar)) {
                this.f69244d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // f.b.r
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToFlowable(s<? extends T> sVar) {
        this.f69243f = sVar;
    }

    @Override // f.b.e
    public void c(c<? super T> cVar) {
        this.f69243f.a(new SingleToFlowableObserver(cVar));
    }
}
