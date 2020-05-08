package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> dmV() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> N(E... eArr) {
        HashSet<E> FZ = FZ(eArr.length);
        Collections.addAll(FZ, eArr);
        return FZ;
    }

    public static <E> HashSet<E> FZ(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dmW() {
        return w(new IdentityHashMap());
    }

    public static <E> Set<E> w(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dmX() {
        return new CopyOnWriteArraySet<>();
    }
}
