package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface PoolBackend<T> {
    @Nullable
    T get(int i);

    int getSize(T t);

    @Nullable
    T pop();

    void put(T t);
}
