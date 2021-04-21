package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.a.r;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class MultimapBuilder$EnumSetSupplier<V extends Enum<V>> implements r<Set<V>>, Serializable {
    public final Class<V> clazz;

    public MultimapBuilder$EnumSetSupplier(Class<V> cls) {
        n.p(cls);
        this.clazz = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.r
    public Set<V> get() {
        return EnumSet.noneOf(this.clazz);
    }
}
