package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes17.dex */
public final class i {
    public static <E> HashSet<E> dSE() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> Ly = Ly(eArr.length);
        Collections.addAll(Ly, eArr);
        return Ly;
    }

    public static <E> HashSet<E> Ly(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dSF() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dSG() {
        return new CopyOnWriteArraySet<>();
    }
}
