package f.a.x.e.d;

import f.a.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class a<R> implements i<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67514e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f67515f;

    public a(AtomicReference<f.a.t.b> atomicReference, i<? super R> iVar) {
        this.f67514e = atomicReference;
        this.f67515f = iVar;
    }

    @Override // f.a.i
    public void onComplete() {
        this.f67515f.onComplete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.f67515f.onError(th);
    }

    @Override // f.a.i
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67514e, bVar);
    }

    @Override // f.a.i
    public void onSuccess(R r) {
        this.f67515f.onSuccess(r);
    }
}
