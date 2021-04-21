package com.google.common.base;

import d.h.c.a.g;
import d.h.c.a.n;
import d.h.c.a.r;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes6.dex */
public final class Absent<T> extends Optional<T> {
    public static final Absent<Object> INSTANCE = new Absent<>();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        n.q(t, "use Optional.orNull() instead of Optional.or(null)");
        return t;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> gVar) {
        n.p(gVar);
        return Optional.absent();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.common.base.Optional<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        n.p(optional);
        return optional;
    }

    @Override // com.google.common.base.Optional
    public T or(r<? extends T> rVar) {
        T t = rVar.get();
        n.q(t, "use Optional.orNull() instead of a Supplier that returns null");
        return t;
    }
}
