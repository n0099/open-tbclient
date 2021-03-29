package io.reactivex.internal.operators.completable;

import f.a.b;
import f.a.u.a;
import f.a.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableUsing$UsingObserver<R> extends AtomicReference<Object> implements b, f.a.t.b {
    public static final long serialVersionUID = -674404550052917487L;
    public final b actual;

    /* renamed from: d  reason: collision with root package name */
    public f.a.t.b f68029d;
    public final g<? super R> disposer;
    public final boolean eager;

    public CompletableUsing$UsingObserver(b bVar, R r, g<? super R> gVar, boolean z) {
        super(r);
        this.actual = bVar;
        this.disposer = gVar;
        this.eager = z;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68029d.dispose();
        this.f68029d = DisposableHelper.DISPOSED;
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
        return this.f68029d.isDisposed();
    }

    @Override // f.a.b
    public void onComplete() {
        this.f68029d = DisposableHelper.DISPOSED;
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

    @Override // f.a.b
    public void onError(Throwable th) {
        this.f68029d = DisposableHelper.DISPOSED;
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

    @Override // f.a.b
    public void onSubscribe(f.a.t.b bVar) {
        if (DisposableHelper.validate(this.f68029d, bVar)) {
            this.f68029d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
