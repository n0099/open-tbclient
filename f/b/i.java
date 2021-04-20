package f.b;
/* loaded from: classes7.dex */
public interface i<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(f.b.t.b bVar);

    void onSuccess(T t);
}
