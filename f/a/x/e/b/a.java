package f.a.x.e.b;

import f.a.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a<T> implements i<T> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67487e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super T> f67488f;

    public a(AtomicReference<f.a.t.b> atomicReference, i<? super T> iVar) {
        this.f67487e = atomicReference;
        this.f67488f = iVar;
    }

    @Override // f.a.i
    public void onComplete() {
        this.f67488f.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.f67488f.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67487e, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.f67488f.onSuccess(t);
    }
}
