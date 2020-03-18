package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> dlf() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> L(E... eArr) {
        HashSet<E> Hy = Hy(eArr.length);
        Collections.addAll(Hy, eArr);
        return Hy;
    }

    public static <E> HashSet<E> Hy(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> dlg() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dlh() {
        return new CopyOnWriteArraySet<>();
    }
}
