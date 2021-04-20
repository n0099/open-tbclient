package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import f.b.x.e.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableGroupJoin$LeftRightObserver extends AtomicReference<b> implements o<Object>, b {
    public static final long serialVersionUID = 1883890389173668373L;
    public final boolean isLeft;
    public final f parent;

    public ObservableGroupJoin$LeftRightObserver(f fVar, boolean z) {
        this.parent = fVar;
        this.isLeft = z;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.o
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // f.b.o
    public void onNext(Object obj) {
        this.parent.innerValue(this.isLeft, obj);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
