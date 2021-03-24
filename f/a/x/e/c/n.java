package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableZip$ZipCoordinator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class n<T, R> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableZip$ZipCoordinator<T, R> f67510e;

    /* renamed from: f  reason: collision with root package name */
    public final f.a.x.f.a<T> f67511f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f67512g;

    /* renamed from: h  reason: collision with root package name */
    public Throwable f67513h;
    public final AtomicReference<f.a.t.b> i = new AtomicReference<>();

    public n(ObservableZip$ZipCoordinator<T, R> observableZip$ZipCoordinator, int i) {
        this.f67510e = observableZip$ZipCoordinator;
        this.f67511f = new f.a.x.f.a<>(i);
    }

    public void a() {
        DisposableHelper.dispose(this.i);
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67512g = true;
        this.f67510e.drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.f67513h = th;
        this.f67512g = true;
        this.f67510e.drain();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.f67511f.offer(t);
        this.f67510e.drain();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        DisposableHelper.setOnce(this.i, bVar);
    }
}
