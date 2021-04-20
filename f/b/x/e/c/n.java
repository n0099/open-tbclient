package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableZip$ZipCoordinator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class n<T, R> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableZip$ZipCoordinator<T, R> f68521e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.x.f.a<T> f68522f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f68523g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f68524h;
    public final AtomicReference<f.b.t.b> i = new AtomicReference<>();

    public n(ObservableZip$ZipCoordinator<T, R> observableZip$ZipCoordinator, int i) {
        this.f68521e = observableZip$ZipCoordinator;
        this.f68522f = new f.b.x.f.a<>(i);
    }

    public void a() {
        DisposableHelper.dispose(this.i);
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68523g = true;
        this.f68521e.drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.f68524h = th;
        this.f68523g = true;
        this.f68521e.drain();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.f68522f.offer(t);
        this.f68521e.drain();
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        DisposableHelper.setOnce(this.i, bVar);
    }
}
