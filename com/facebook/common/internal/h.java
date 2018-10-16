package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes2.dex */
public final class h {
    public static <E> HashSet<E> J(E... eArr) {
        HashSet<E> xc = xc(eArr.length);
        Collections.addAll(xc, eArr);
        return xc;
    }

    public static <E> HashSet<E> xc(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> bRB() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> bRC() {
        return new CopyOnWriteArraySet<>();
    }
}
