package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.u.a;
import f.b.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableUsing$UsingObserver<T, D> extends AtomicBoolean implements o<T>, b {
    public static final long serialVersionUID = 5904473792286235046L;
    public final o<? super T> actual;
    public final g<? super D> disposer;
    public final boolean eager;
    public final D resource;
    public b s;

    public ObservableUsing$UsingObserver(o<? super T> oVar, D d2, g<? super D> gVar, boolean z) {
        this.actual = oVar;
        this.resource = d2;
        this.disposer = gVar;
        this.eager = z;
    }

    @Override // f.b.t.b
    public void dispose() {
        disposeAfter();
        this.s.dispose();
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: D, ? super D */
    public void disposeAfter() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept((D) this.resource);
            } catch (Throwable th) {
                a.a(th);
                f.b.a0.a.f(th);
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get();
    }

    /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: D, ? super D */
    @Override // f.b.o
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
            this.s.dispose();
            this.actual.onComplete();
            return;
        }
        this.actual.onComplete();
        this.s.dispose();
        disposeAfter();
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: D, ? super D */
    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept((D) this.resource);
                } catch (Throwable th2) {
                    a.a(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.s.dispose();
            this.actual.onError(th);
            return;
        }
        this.actual.onError(th);
        this.s.dispose();
        disposeAfter();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
