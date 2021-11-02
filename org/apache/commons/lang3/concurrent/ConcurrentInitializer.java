package org.apache.commons.lang3.concurrent;
/* loaded from: classes3.dex */
public interface ConcurrentInitializer<T> {
    T get() throws ConcurrentException;
}
