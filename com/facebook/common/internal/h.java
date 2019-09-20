package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes2.dex */
public final class h {
    public static <E> HashSet<E> M(E... eArr) {
        HashSet<E> DB = DB(eArr.length);
        Collections.addAll(DB, eArr);
        return DB;
    }

    public static <E> HashSet<E> DB(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> cFM() {
        return y(new IdentityHashMap());
    }

    public static <E> Set<E> y(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> CopyOnWriteArraySet<E> cFN() {
        return new CopyOnWriteArraySet<>();
    }
}
