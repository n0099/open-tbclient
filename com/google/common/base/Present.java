package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import d.h.c.a.r;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes6.dex */
public final class Present<T> extends Optional<T> {
    public static final long serialVersionUID = 0;
    public final T reference;

    public Present(T t) {
        this.reference = t;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.reference.equals(((Present) obj).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T or(T t) {
        n.q(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> gVar) {
        V apply = gVar.apply((T) this.reference);
        n.q(apply, "the Function passed to Optional.transform() must not return null.");
        return new Present(apply);
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> optional) {
        n.p(optional);
        return this;
    }

    @Override // com.google.common.base.Optional
    public T or(r<? extends T> rVar) {
        n.p(rVar);
        return this.reference;
    }
}
