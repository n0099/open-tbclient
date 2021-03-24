package io.reactivex.internal.operators.flowable;

import f.a.d;
import f.a.u.a;
import f.a.w.g;
import f.a.x.i.b;
import g.d.c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableGenerate$GeneratorSubscription<T, S> extends AtomicLong implements d<T>, g.d.d {
    public static final long serialVersionUID = 7565982551505011832L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final g<? super S> disposeState;
    public final f.a.w.c<S, ? super d<T>, S> generator;
    public boolean hasNext;
    public S state;
    public boolean terminate;

    public FlowableGenerate$GeneratorSubscription(c<? super T> cVar, f.a.w.c<S, ? super d<T>, S> cVar2, g<? super S> gVar, S s) {
        this.actual = cVar;
        this.generator = cVar2;
        this.disposeState = gVar;
        this.state = s;
    }

    public final void a(S s) {
        try {
            this.disposeState.accept(s);
        } catch (Throwable th) {
            a.a(th);
            f.a.a0.a.f(th);
        }
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (b.a(this, 1L) == 0) {
            S s = this.state;
            this.state = null;
            a(s);
        }
    }

    @Override // f.a.d
    public void onComplete() {
        if (this.terminate) {
            return;
        }
        this.terminate = true;
        this.actual.onComplete();
    }

    @Override // f.a.d
    public void onError(Throwable th) {
        if (this.terminate) {
            f.a.a0.a.f(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.terminate = true;
        this.actual.onError(th);
    }

    @Override // f.a.d
    public void onNext(T t) {
        if (this.terminate) {
            return;
        }
        if (this.hasNext) {
            onError(new IllegalStateException("onNext already called in this generate turn"));
        } else if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.hasNext = true;
            this.actual.onNext(t);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && b.a(this, j) == 0) {
            S s = this.state;
            f.a.w.c<S, ? super d<T>, S> cVar = this.generator;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            this.state = null;
                            a(s);
                            return;
                        }
                        this.hasNext = false;
                        try {
                            s = cVar.apply(s, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                a(s);
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            a.a(th);
                            this.cancelled = true;
                            this.state = null;
                            onError(th);
                            a(s);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            this.state = s;
                            j = addAndGet(-j2);
                        }
                    }
                }
            } while (j != 0);
        }
    }
}
