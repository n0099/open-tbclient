package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public final class i {
    public static <E> HashSet<E> esG() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> R(E... eArr) {
        HashSet<E> OU = OU(eArr.length);
        Collections.addAll(OU, eArr);
        return OU;
    }

    public static <E> HashSet<E> OU(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> esH() {
        return O(new IdentityHashMap());
    }

    public static <E> Set<E> O(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> esI() {
        return new CopyOnWriteArraySet<>();
    }
}
