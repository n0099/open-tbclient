package rx;
/* loaded from: classes12.dex */
public interface e<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
