package io.reactivex.internal.operators.completable;

import f.b.b;
import f.b.u.a;
import f.b.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableUsing$UsingObserver<R> extends AtomicReference<Object> implements b, f.b.t.b {
    public static final long serialVersionUID = -674404550052917487L;
    public final b actual;

    /* renamed from: d  reason: collision with root package name */
    public f.b.t.b f69182d;
    public final g<? super R> disposer;
    public final boolean eager;

    public CompletableUsing$UsingObserver(b bVar, R r, g<? super R> gVar, boolean z) {
        super(r);
        this.actual = bVar;
        this.disposer = gVar;
        this.eager = z;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.f69182d.dispose();
        this.f69182d = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                a.a(th);
                f.b.a0.a.f(th);
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69182d.isDisposed();
    }

    @Override // f.b.b
    public void onComplete() {
        this.f69182d = DisposableHelper.DISPOSED;
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

    @Override // f.b.b
    public void onError(Throwable th) {
        this.f69182d = DisposableHelper.DISPOSED;
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

    @Override // f.b.b
    public void onSubscribe(f.b.t.b bVar) {
        if (DisposableHelper.validate(this.f69182d, bVar)) {
            this.f69182d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
