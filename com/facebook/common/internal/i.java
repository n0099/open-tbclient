package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes4.dex */
public final class i {
    public static <E> HashSet<E> esP() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> Q(E... eArr) {
        HashSet<E> OY = OY(eArr.length);
        Collections.addAll(OY, eArr);
        return OY;
    }

    public static <E> HashSet<E> OY(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> esQ() {
        return O(new IdentityHashMap());
    }

    public static <E> Set<E> O(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> esR() {
        return new CopyOnWriteArraySet<>();
    }
}
