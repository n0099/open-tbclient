package rx.internal.util;
/* loaded from: classes2.dex */
public final class a<T> implements rx.e<T> {
    final rx.functions.b<? super Throwable> kBS;
    final rx.functions.b<? super T> kDt;
    final rx.functions.a kDu;

    public a(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        this.kDt = bVar;
        this.kBS = bVar2;
        this.kDu = aVar;
    }

    @Override // rx.e
    public void onNext(T t) {
        this.kDt.call(t);
    }

    @Override // rx.e
    public void onError(Throwable th) {
        this.kBS.call(th);
    }

    @Override // rx.e
    public void onCompleted() {
        this.kDu.call();
    }
}
