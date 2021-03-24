package f.a.z;

import f.a.o;
import f.a.x.i.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class b<T> implements o<T>, f.a.t.b {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.a.t.b> f67535e = new AtomicReference<>();

    public void a() {
    }

    @Override // f.a.t.b
    public final void dispose() {
        DisposableHelper.dispose(this.f67535e);
    }

    @Override // f.a.t.b
    public final boolean isDisposed() {
        return this.f67535e.get() == DisposableHelper.DISPOSED;
    }

    @Override // f.a.o
    public final void onSubscribe(f.a.t.b bVar) {
        if (d.c(this.f67535e, bVar, getClass())) {
            a();
        }
    }
}
