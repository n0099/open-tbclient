package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.u.a;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements g<T>, d {
    public static final long serialVersionUID = 5904473792286235046L;
    public final c<? super T> actual;
    public final f.a.w.g<? super D> disposer;
    public final boolean eager;
    public final D resource;
    public d s;

    public FlowableUsing$UsingSubscriber(c<? super T> cVar, D d2, f.a.w.g<? super D> gVar, boolean z) {
        this.actual = cVar;
        this.resource = d2;
        this.disposer = gVar;
        this.eager = z;
    }

    @Override // g.d.d
    public void cancel() {
        disposeAfter();
        this.s.cancel();
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
    public void disposeAfter() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept((D) this.resource);
            } catch (Throwable th) {
                a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: D, ? super D */
    @Override // g.d.c
    public void onComplete() {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th) {
                    a.a(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.s.cancel();
            this.actual.onComplete();
            return;
        }
        this.actual.onComplete();
        this.s.cancel();
        disposeAfter();
    }

    /* JADX DEBUG: Type inference failed for r4v0. Raw type applied. Possible types: D, ? super D */
    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.eager) {
            Throwable th2 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th3) {
                    th2 = th3;
                    a.a(th2);
                }
            }
            this.s.cancel();
            if (th2 != null) {
                this.actual.onError(new CompositeException(th, th2));
                return;
            } else {
                this.actual.onError(th);
                return;
            }
        }
        this.actual.onError(th);
        this.s.cancel();
        disposeAfter();
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        this.s.request(j);
    }
}
