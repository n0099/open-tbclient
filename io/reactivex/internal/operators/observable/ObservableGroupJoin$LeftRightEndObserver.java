package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.e.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableGroupJoin$LeftRightEndObserver extends AtomicReference<b> implements o<Object>, b {
    public static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final f parent;

    public ObservableGroupJoin$LeftRightEndObserver(f fVar, boolean z, int i) {
        this.parent = fVar;
        this.isLeft = z;
        this.index = i;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.o
    public void onComplete() {
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.parent.innerCloseError(th);
    }

    @Override // f.a.o
    public void onNext(Object obj) {
        if (DisposableHelper.dispose(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
