package kotlin.coroutines.experimental;
/* loaded from: classes5.dex */
public interface b<T> {
    d getContext();

    void resume(T t);

    void resumeWithException(Throwable th);
}
