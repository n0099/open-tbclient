package f.a.x.e.b;

import f.a.i;
import f.a.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class c<R> implements r<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67491e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f67492f;

    public c(AtomicReference<f.a.t.b> atomicReference, i<? super R> iVar) {
        this.f67491e = atomicReference;
        this.f67492f = iVar;
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f67492f.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67491e, bVar);
    }

    @Override // f.a.r
    public void onSuccess(R r) {
        this.f67492f.onSuccess(r);
    }
}
