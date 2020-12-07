package kotlin.coroutines.experimental;
@kotlin.e
/* loaded from: classes17.dex */
public interface b<T> {
    d getContext();

    void resume(T t);

    void resumeWithException(Throwable th);
}
