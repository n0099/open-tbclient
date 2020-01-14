package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes12.dex */
public final class i {
    public static <E> HashSet<E> djs() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> K(E... eArr) {
        HashSet<E> Hn = Hn(eArr.length);
        Collections.addAll(Hn, eArr);
        return Hn;
    }

    public static <E> HashSet<E> Hn(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> djt() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dju() {
        return new CopyOnWriteArraySet<>();
    }
}
