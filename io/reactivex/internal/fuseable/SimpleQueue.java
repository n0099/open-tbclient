package io.reactivex.internal.fuseable;
/* loaded from: classes8.dex */
public interface SimpleQueue {
    void clear();

    boolean isEmpty();

    boolean offer(Object obj);

    boolean offer(Object obj, Object obj2);

    Object poll() throws Exception;
}
