package io.reactivex.internal.operators.single;

import f.a.r;
import f.a.s;
import f.a.t.b;
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

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
