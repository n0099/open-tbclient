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
        HashSet<E> BX = BX(eArr.length);
        Collections.addAll(BX, eArr);
        return BX;
    }

    public static <E> HashSet<E> BX(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> cCK() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> cCL() {
        return new CopyOnWriteArraySet<>();
    }
}
