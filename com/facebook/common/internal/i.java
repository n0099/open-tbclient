package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes11.dex */
public final class i {
    public static <E> HashSet<E> dip() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> K(E... eArr) {
        HashSet<E> Hi = Hi(eArr.length);
        Collections.addAll(Hi, eArr);
        return Hi;
    }

    public static <E> HashSet<E> Hi(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> diq() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dir() {
        return new CopyOnWriteArraySet<>();
    }
}
