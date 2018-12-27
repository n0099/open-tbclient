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
        HashSet<E> yf = yf(eArr.length);
        Collections.addAll(yf, eArr);
        return yf;
    }

    public static <E> HashSet<E> yf(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> bTS() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> bTT() {
        return new CopyOnWriteArraySet<>();
    }
}
