package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes9.dex */
public final class i {
    public static <E> HashSet<E> dOG() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> KT = KT(eArr.length);
        Collections.addAll(KT, eArr);
        return KT;
    }

    public static <E> HashSet<E> KT(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dOH() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dOI() {
        return new CopyOnWriteArraySet<>();
    }
}
