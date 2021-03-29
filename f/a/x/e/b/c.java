package f.a.x.e.b;

import f.a.i;
import f.a.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class c<R> implements r<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67496e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f67497f;

    public c(AtomicReference<f.a.t.b> atomicReference, i<? super R> iVar) {
        this.f67496e = atomicReference;
        this.f67497f = iVar;
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f67497f.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67496e, bVar);
    }

    @Override // f.a.r
    public void onSuccess(R r) {
        this.f67497f.onSuccess(r);
    }
}
