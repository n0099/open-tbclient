package f.b.x.e.c;

import f.b.o;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator;
/* loaded from: classes7.dex */
public final class k<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator<T> f68661e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.x.f.a<T> f68662f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68663g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f68664h;
    public Throwable i;

    public k(ObservableSequenceEqualSingle$EqualCoordinator<T> observableSequenceEqualSingle$EqualCoordinator, int i, int i2) {
        this.f68661e = observableSequenceEqualSingle$EqualCoordinator;
        this.f68663g = i;
        this.f68662f = new f.b.x.f.a<>(i2);
    }

    @Override // f.b.o
    public void onComplete() {
        this.f68664h = true;
        this.f68661e.drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.i = th;
        this.f68664h = true;
        this.f68661e.drain();
    }

    @Override // f.b.o
    public void onNext(T t) {
        this.f68662f.offer(t);
        this.f68661e.drain();
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        this.f68661e.setDisposable(bVar, this.f68663g);
    }
}
