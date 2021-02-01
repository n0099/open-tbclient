package kotlin.coroutines.experimental;
@kotlin.e
/* loaded from: classes6.dex */
public interface b<T> {
    d getContext();

    void resume(T t);

    void resumeWithException(Throwable th);
}
