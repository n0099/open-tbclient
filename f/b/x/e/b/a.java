package f.b.x.e.b;

import f.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a<T> implements i<T> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68498e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super T> f68499f;

    public a(AtomicReference<f.b.t.b> atomicReference, i<? super T> iVar) {
        this.f68498e = atomicReference;
        this.f68499f = iVar;
    }

    @Override // f.b.i
    public void onComplete() {
        this.f68499f.onComplete();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.f68499f.onError(th);
    }

    @Override // f.b.i
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.replace(this.f68498e, bVar);
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        this.f68499f.onSuccess(t);
    }
}
