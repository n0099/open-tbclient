package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes13.dex */
public final class i {
    public static <E> HashSet<E> dup() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> O(E... eArr) {
        HashSet<E> GL = GL(eArr.length);
        Collections.addAll(GL, eArr);
        return GL;
    }

    public static <E> HashSet<E> GL(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> duq() {
        return w(new IdentityHashMap());
    }

    public static <E> Set<E> w(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> dur() {
        return new CopyOnWriteArraySet<>();
    }
}
