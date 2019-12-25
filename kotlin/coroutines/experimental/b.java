package kotlin.coroutines.experimental;
/* loaded from: classes4.dex */
public interface b<T> {
    d getContext();

    void resume(T t);

    void resumeWithException(Throwable th);
}
