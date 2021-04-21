package f.b.z;

import f.b.o;
import f.b.x.i.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public abstract class b<T> implements o<T>, f.b.t.b {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<f.b.t.b> f68693e = new AtomicReference<>();

    public void a() {
    }

    @Override // f.b.t.b
    public final void dispose() {
        DisposableHelper.dispose(this.f68693e);
    }

    @Override // f.b.t.b
    public final boolean isDisposed() {
        return this.f68693e.get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.o
    public final void onSubscribe(f.b.t.b bVar) {
        if (d.c(this.f68693e, bVar, getClass())) {
            a();
        }
    }
}
