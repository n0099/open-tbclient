package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes12.dex */
public final class i {
    public static <E> HashSet<E> eka() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> OT = OT(eArr.length);
        Collections.addAll(OT, eArr);
        return OT;
    }

    public static <E> HashSet<E> OT(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> ekb() {
        return H(new IdentityHashMap());
    }

    public static <E> Set<E> H(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> ekc() {
        return new CopyOnWriteArraySet<>();
    }
}
