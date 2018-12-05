package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes2.dex */
public final class h {
    public static <E> HashSet<E> K(E... eArr) {
        HashSet<E> xS = xS(eArr.length);
        Collections.addAll(xS, eArr);
        return xS;
    }

    public static <E> HashSet<E> xS(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> bTc() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> bTd() {
        return new CopyOnWriteArraySet<>();
    }
}
