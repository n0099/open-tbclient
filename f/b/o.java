package f.b;
/* loaded from: classes7.dex */
public interface o<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(f.b.t.b bVar);
}
