package io.reactivex.internal.operators.completable;

import f.a.c;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableSubscribeOn$SubscribeOnObserver extends AtomicReference<b> implements f.a.b, b, Runnable {
    public static final long serialVersionUID = 7000911171163930287L;
    public final f.a.b actual;
    public final c source;
    public final SequentialDisposable task = new SequentialDisposable();

    public CompletableSubscribeOn$SubscribeOnObserver(f.a.b bVar, c cVar) {
        this.actual = bVar;
        this.source = cVar;
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

    @Override // f.a.b
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // f.a.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this);
    }
}
