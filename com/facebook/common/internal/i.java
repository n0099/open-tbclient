package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes19.dex */
public final class i {
    public static <E> HashSet<E> epQ() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> PR = PR(eArr.length);
        Collections.addAll(PR, eArr);
        return PR;
    }

    public static <E> HashSet<E> PR(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> epR() {
        return H(new IdentityHashMap());
    }

    public static <E> Set<E> H(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> epS() {
        return new CopyOnWriteArraySet<>();
    }
}
