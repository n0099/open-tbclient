package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableBufferBoundary$BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<b> implements o<Object>, b {
    public static final long serialVersionUID = -8498650778633225126L;
    public final long index;
    public final ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> parent;

    public ObservableBufferBoundary$BufferCloseObserver(ObservableBufferBoundary$BufferBoundaryObserver<T, C, ?, ?> observableBufferBoundary$BufferBoundaryObserver, long j) {
        this.parent = observableBufferBoundary$BufferBoundaryObserver;
        this.index = j;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.o
    public void onComplete() {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.close(this, this.index);
        }
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            this.parent.boundaryError(this, th);
            return;
        }
        a.f(th);
    }

    @Override // f.b.o
    public void onNext(Object obj) {
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            lazySet(disposableHelper);
            bVar.dispose();
            this.parent.close(this, this.index);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
