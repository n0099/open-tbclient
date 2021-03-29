package f.a.x.e.c;

import f.a.o;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator;
/* loaded from: classes7.dex */
public final class k<T> implements o<T> {

    /* renamed from: e  reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator<T> f67508e;

    /* renamed from: f  reason: collision with root package name */
    public final f.a.x.f.a<T> f67509f;

    /* renamed from: g  reason: collision with root package name */
    public final int f67510g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f67511h;
    public Throwable i;

    public k(ObservableSequenceEqualSingle$EqualCoordinator<T> observableSequenceEqualSingle$EqualCoordinator, int i, int i2) {
        this.f67508e = observableSequenceEqualSingle$EqualCoordinator;
        this.f67510g = i;
        this.f67509f = new f.a.x.f.a<>(i2);
    }

    @Override // f.a.o
    public void onComplete() {
        this.f67511h = true;
        this.f67508e.drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.i = th;
        this.f67511h = true;
        this.f67508e.drain();
    }

    @Override // f.a.o
    public void onNext(T t) {
        this.f67509f.offer(t);
        this.f67508e.drain();
    }

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        this.f67508e.setDisposable(bVar, this.f67510g);
    }
}
