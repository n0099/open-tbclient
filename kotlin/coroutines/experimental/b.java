package kotlin.coroutines.experimental;

import kotlin.h;
@h
/* loaded from: classes20.dex */
public interface b<T> {
    d getContext();

    void resume(T t);

    void resumeWithException(Throwable th);
}
