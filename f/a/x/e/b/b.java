package f.a.x.e.b;

import f.a.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class b<R> implements r<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67489e;

    /* renamed from: f  reason: collision with root package name */
    public final r<? super R> f67490f;

    public b(AtomicReference<f.a.t.b> atomicReference, r<? super R> rVar) {
        this.f67489e = atomicReference;
        this.f67490f = rVar;
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f67490f.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67489e, bVar);
    }

    @Override // f.a.r
    public void onSuccess(R r) {
        this.f67490f.onSuccess(r);
    }
}
