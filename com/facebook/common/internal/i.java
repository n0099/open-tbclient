package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public final class i {
    public static <E> HashSet<E> ekc() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> Oq = Oq(eArr.length);
        Collections.addAll(Oq, eArr);
        return Oq;
    }

    public static <E> HashSet<E> Oq(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> ekd() {
        return H(new IdentityHashMap());
    }

    public static <E> Set<E> H(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> eke() {
        return new CopyOnWriteArraySet<>();
    }
}
