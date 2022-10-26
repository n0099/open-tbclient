package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface PoolBackend {
    @Nullable
    Object get(int i);

    int getSize(Object obj);

    @Nullable
    Object pop();

    void put(Object obj);
}
