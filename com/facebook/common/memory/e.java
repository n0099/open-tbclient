package com.facebook.common.memory;
/* loaded from: classes11.dex */
public interface e<V> extends b, com.facebook.common.references.c<V> {
    V get(int i);

    @Override // com.facebook.common.references.c
    void release(V v);
}
