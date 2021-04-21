package f.b.x.e.d;

import f.b.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a<R> implements i<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68672e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f68673f;

    public a(AtomicReference<f.b.t.b> atomicReference, i<? super R> iVar) {
        this.f68672e = atomicReference;
        this.f68673f = iVar;
    }

    @Override // f.b.i
    public void onComplete() {
        this.f68673f.onComplete();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        this.f68673f.onError(th);
    }

    @Override // f.b.i
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.replace(this.f68672e, bVar);
    }

    @Override // f.b.i
    public void onSuccess(R r) {
        this.f68673f.onSuccess(r);
    }
}
