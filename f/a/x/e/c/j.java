package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual$EqualCoordinator;
/* loaded from: classes7.dex */
public final class j<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator<T> f67499e;

    /* renamed from: f  reason: collision with root package name */
    public final f.a.x.f.a<T> f67500f;

    /* renamed from: g  reason: collision with root package name */
    public final int f67501g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f67502h;
    public Throwable i;

    public j(ObservableSequenceEqual$EqualCoordinator<T> observableSequenceEqual$EqualCoordinator, int i, int i2) {
        this.f67499e = observableSequenceEqual$EqualCoordinator;
        this.f67501g = i;
        this.f67500f = new f.a.x.f.a<>(i2);
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67502h = true;
        this.f67499e.drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.i = th;
        this.f67502h = true;
        this.f67499e.drain();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.f67500f.offer(t);
        this.f67499e.drain();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        this.f67499e.setDisposable(bVar, this.f67501g);
    }
}
