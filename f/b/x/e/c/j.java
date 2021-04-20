package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual$EqualCoordinator;
/* loaded from: classes7.dex */
public final class j<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator<T> f68510e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.x.f.a<T> f68511f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68512g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f68513h;
    public Throwable i;

    public j(ObservableSequenceEqual$EqualCoordinator<T> observableSequenceEqual$EqualCoordinator, int i, int i2) {
        this.f68510e = observableSequenceEqual$EqualCoordinator;
        this.f68512g = i;
        this.f68511f = new f.b.x.f.a<>(i2);
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68513h = true;
        this.f68510e.drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.i = th;
        this.f68513h = true;
        this.f68510e.drain();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.f68511f.offer(t);
        this.f68510e.drain();
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        this.f68510e.setDisposable(bVar, this.f68512g);
    }
}
