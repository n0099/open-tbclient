package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.t.b;
import f.a.u.a;
import f.a.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleUsing$UsingSingleObserver<T, U> extends AtomicReference<Object> implements r<T>, b {
    public static final long serialVersionUID = -5331524057054083935L;
    public final r<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68092d;
    public final g<? super U> disposer;
    public final boolean eager;

    public SingleUsing$UsingSingleObserver(r<? super T> rVar, U u, boolean z, g<? super U> gVar) {
        super(u);
        this.actual = rVar;
        this.eager = z;
        this.disposer = gVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68092d.dispose();
        this.f68092d = DisposableHelper.DISPOSED;
        disposeAfter();
    }

    public void disposeAfter() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f68092d.isDisposed();
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f68092d = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th2) {
                a.a(th2);
                th = new CompositeException(th, th2);
            }
        }
        this.actual.onError(th);
        if (this.eager) {
            return;
        }
        disposeAfter();
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68092d, bVar)) {
            this.f68092d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.f68092d = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                a.a(th);
                this.actual.onError(th);
                return;
            }
        }
        this.actual.onSuccess(t);
        if (this.eager) {
            return;
        }
        disposeAfter();
    }
}
