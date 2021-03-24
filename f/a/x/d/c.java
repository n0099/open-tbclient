package f.a.x.d;

import f.a.r;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class c<T> implements r<T> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67475e;

    /* renamed from: f  reason: collision with root package name */
    public final r<? super T> f67476f;

    public c(AtomicReference<f.a.t.b> atomicReference, r<? super T> rVar) {
        this.f67475e = atomicReference;
        this.f67476f = rVar;
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.f67476f.onError(th);
    }

    @Override // f.a.r
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.replace(this.f67475e, bVar);
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.f67476f.onSuccess(t);
    }
}
