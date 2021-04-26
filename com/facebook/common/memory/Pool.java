package com.facebook.common.memory;

import com.facebook.common.references.ResourceReleaser;
/* loaded from: classes6.dex */
public interface Pool<V> extends ResourceReleaser<V>, MemoryTrimmable {
    V get(int i2);

    @Override // com.facebook.common.references.ResourceReleaser
    void release(V v);
}
