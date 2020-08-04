package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes12.dex */
public final class i {
    public static <E> HashSet<E> dCx() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> O(E... eArr) {
        HashSet<E> Ip = Ip(eArr.length);
        Collections.addAll(Ip, eArr);
        return Ip;
    }

    public static <E> HashSet<E> Ip(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dCy() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dCz() {
        return new CopyOnWriteArraySet<>();
    }
}
