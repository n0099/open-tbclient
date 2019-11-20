package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> kBJ;
    final rx.functions.b<? super T> kDk;
    final rx.functions.a kDl;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kDk = bVar;
        this.kBJ = bVar2;
        this.kDl = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDk.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kBJ.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDl.call();
    }
}
