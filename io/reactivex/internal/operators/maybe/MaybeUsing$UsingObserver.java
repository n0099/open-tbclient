package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import f.a.u.a;
import f.a.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements i<T>, b {
    public static final long serialVersionUID = -674404550052917487L;
    public final i<? super T> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68058d;
    public final g<? super D> disposer;
    public final boolean eager;

    public MaybeUsing$UsingObserver(i<? super T> iVar, D d2, g<? super D> gVar, boolean z) {
        super(d2);
        this.actual = iVar;
        this.disposer = gVar;
        this.eager = z;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68058d.dispose();
        this.f68058d = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
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
        return this.f68058d.isDisposed();
    }

    @Override // f.a.i
    public void onComplete() {
        this.f68058d = DisposableHelper.DISPOSED;
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
        this.actual.onComplete();
        if (this.eager) {
            return;
        }
        disposeResourceAfter();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.f68058d = DisposableHelper.DISPOSED;
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
        disposeResourceAfter();
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68058d, bVar)) {
            this.f68058d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.f68058d = DisposableHelper.DISPOSED;
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
        disposeResourceAfter();
    }
}
