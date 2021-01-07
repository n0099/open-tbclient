package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public final class i {
    public static <E> HashSet<E> etZ() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> R(E... eArr) {
        HashSet<E> Qf = Qf(eArr.length);
        Collections.addAll(Qf, eArr);
        return Qf;
    }

    public static <E> HashSet<E> Qf(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> eua() {
        return M(new IdentityHashMap());
    }

    public static <E> Set<E> M(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> eub() {
        return new CopyOnWriteArraySet<>();
    }
}
