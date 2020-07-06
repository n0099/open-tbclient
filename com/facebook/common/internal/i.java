package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> dzk() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> O(E... eArr) {
        HashSet<E> HU = HU(eArr.length);
        Collections.addAll(HU, eArr);
        return HU;
    }

    public static <E> HashSet<E> HU(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dzl() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dzm() {
        return new CopyOnWriteArraySet<>();
    }
}
