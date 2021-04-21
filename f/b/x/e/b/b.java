package f.b.x.e.b;

import f.b.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class b<R> implements r<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68647e;

    /* renamed from: f  reason: collision with root package name */
    public final r<? super R> f68648f;

    public b(AtomicReference<f.b.t.b> atomicReference, r<? super R> rVar) {
        this.f68647e = atomicReference;
        this.f68648f = rVar;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.f68648f.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.replace(this.f68647e, bVar);
    }

    @Override // f.b.r
    public void onSuccess(R r) {
        this.f68648f.onSuccess(r);
    }
}
