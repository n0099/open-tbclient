package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.s;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    public static final long serialVersionUID = 7000911171163930287L;
    public final r<? super T> actual;
    public final s<? extends T> source;
    public final SequentialDisposable task = new SequentialDisposable();

    public SingleSubscribeOn$SubscribeOnObserver(r<? super T> rVar, s<? extends T> sVar) {
        this.actual = rVar;
        this.source = sVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
