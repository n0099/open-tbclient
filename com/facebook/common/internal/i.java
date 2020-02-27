package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> dkF() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> K(E... eArr) {
        HashSet<E> Hs = Hs(eArr.length);
        Collections.addAll(Hs, eArr);
        return Hs;
    }

    public static <E> HashSet<E> Hs(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dkG() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dkH() {
        return new CopyOnWriteArraySet<>();
    }
}
