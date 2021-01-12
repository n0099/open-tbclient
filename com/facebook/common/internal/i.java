package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes14.dex */
public final class i {
    public static <E> HashSet<E> eqf() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> R(E... eArr) {
        HashSet<E> Oy = Oy(eArr.length);
        Collections.addAll(Oy, eArr);
        return Oy;
    }

    public static <E> HashSet<E> Oy(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> eqg() {
        return M(new IdentityHashMap());
    }

    public static <E> Set<E> M(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> eqh() {
        return new CopyOnWriteArraySet<>();
    }
}
