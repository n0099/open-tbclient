package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator;
/* loaded from: classes7.dex */
public final class k<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator<T> f67503e;

    /* renamed from: f  reason: collision with root package name */
    public final f.a.x.f.a<T> f67504f;

    /* renamed from: g  reason: collision with root package name */
    public final int f67505g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f67506h;
    public Throwable i;

    public k(ObservableSequenceEqualSingle$EqualCoordinator<T> observableSequenceEqualSingle$EqualCoordinator, int i, int i2) {
        this.f67503e = observableSequenceEqualSingle$EqualCoordinator;
        this.f67505g = i;
        this.f67504f = new f.a.x.f.a<>(i2);
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67506h = true;
        this.f67503e.drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.i = th;
        this.f67506h = true;
        this.f67503e.drain();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.f67504f.offer(t);
        this.f67503e.drain();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        this.f67503e.setDisposable(bVar, this.f67505g);
    }
}
