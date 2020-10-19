package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public final class i {
    public static <E> HashSet<E> dWp() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> Me = Me(eArr.length);
        Collections.addAll(Me, eArr);
        return Me;
    }

    public static <E> HashSet<E> Me(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dWq() {
        return H(new IdentityHashMap());
    }

    public static <E> Set<E> H(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dWr() {
        return new CopyOnWriteArraySet<>();
    }
}
