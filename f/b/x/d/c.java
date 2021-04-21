package f.b.x.d;

import f.b.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class c<T> implements r<T> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68633e;

    /* renamed from: f  reason: collision with root package name */
    public final r<? super T> f68634f;

    public c(AtomicReference<f.b.t.b> atomicReference, r<? super T> rVar) {
        this.f68633e = atomicReference;
        this.f68634f = rVar;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.f68634f.onError(th);
    }

    @Override // f.b.r
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.replace(this.f68633e, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.f68634f.onSuccess(t);
    }
}
