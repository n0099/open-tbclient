package f.a.x.e.d;

import f.a.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a<R> implements i<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67519e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f67520f;

    public a(AtomicReference<f.a.t.b> atomicReference, i<? super R> iVar) {
        this.f67519e = atomicReference;
        this.f67520f = iVar;
    }

    @Override // f.a.i
    public void onComplete() {
        this.f67520f.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.f67520f.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67519e, bVar);
    }

    @Override // f.a.i
    public void onSuccess(R r) {
        this.f67520f.onSuccess(r);
    }
}
