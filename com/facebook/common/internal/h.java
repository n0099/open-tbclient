package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes2.dex */
public final class h {
    public static <E> HashSet<E> M(E... eArr) {
        HashSet<E> Dx = Dx(eArr.length);
        Collections.addAll(Dx, eArr);
        return Dx;
    }

    public static <E> HashSet<E> Dx(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> cEY() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> cEZ() {
        return new CopyOnWriteArraySet<>();
    }
}
