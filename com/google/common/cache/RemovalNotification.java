package com.google.common.cache;

import d.h.c.a.n;
import java.util.AbstractMap;
/* loaded from: classes6.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    public static final long serialVersionUID = 0;
    public final RemovalCause cause;

    public RemovalNotification(K k, V v, RemovalCause removalCause) {
        super(k, v);
        n.p(removalCause);
        this.cause = removalCause;
    }

    public static <K, V> RemovalNotification<K, V> create(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
