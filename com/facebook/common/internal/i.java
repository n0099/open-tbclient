package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> duD() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> O(E... eArr) {
        HashSet<E> GN = GN(eArr.length);
        Collections.addAll(GN, eArr);
        return GN;
    }

    public static <E> HashSet<E> GN(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> duE() {
        return w(new IdentityHashMap());
    }

    public static <E> Set<E> w(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> duF() {
        return new CopyOnWriteArraySet<>();
    }
}
