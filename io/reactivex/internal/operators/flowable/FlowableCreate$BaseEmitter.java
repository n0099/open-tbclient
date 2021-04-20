package io.reactivex.internal.operators.flowable;

import f.b.a0.a;
import f.b.f;
import f.b.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements f<T>, d {
    public static final long serialVersionUID = 7326289992464377023L;
    public final c<? super T> actual;
    public final SequentialDisposable serial = new SequentialDisposable();

    public FlowableCreate$BaseEmitter(c<? super T> cVar) {
        this.actual = cVar;
    }

    @Override // g.d.d
    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public void complete() {
        if (isCancelled()) {
            return;
        }
        try {
            this.actual.onComplete();
        } finally {
            this.serial.dispose();
        }
    }

    public boolean error(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isCancelled()) {
            return false;
        }
        try {
            this.actual.onError(th);
            this.serial.dispose();
            return true;
        } catch (Throwable th2) {
            this.serial.dispose();
            throw th2;
        }
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    @Override // f.b.d
    public void onComplete() {
        complete();
    }

    @Override // f.b.d
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        a.f(th);
    }

    @Override // f.b.d
    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // g.d.d
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this, j);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final f<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(f.b.w.f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public final void setDisposable(f.b.t.b bVar) {
        this.serial.update(bVar);
    }

    public boolean tryOnError(Throwable th) {
        return error(th);
    }
}
