package f.b.x.e.b;

import f.b.i;
import f.b.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class c<R> implements r<R> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68649e;

    /* renamed from: f  reason: collision with root package name */
    public final i<? super R> f68650f;

    public c(AtomicReference<f.b.t.b> atomicReference, i<? super R> iVar) {
        this.f68649e = atomicReference;
        this.f68650f = iVar;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.f68650f.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.replace(this.f68649e, bVar);
    }

    @Override // f.b.r
    public void onSuccess(R r) {
        this.f68650f.onSuccess(r);
    }
}
