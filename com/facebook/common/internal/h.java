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
        HashSet<E> BW = BW(eArr.length);
        Collections.addAll(BW, eArr);
        return BW;
    }

    public static <E> HashSet<E> BW(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> cCI() {
        return x(new IdentityHashMap());
    }

    public static <E> Set<E> x(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> cCJ() {
        return new CopyOnWriteArraySet<>();
    }
}
