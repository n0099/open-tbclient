package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes6.dex */
public final class Sets {
    public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> newHashSetWithCapacity(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> newIdentityHashSet() {
        return newSetFromMap(new IdentityHashMap());
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> newHashSetWithCapacity = newHashSetWithCapacity(eArr.length);
        Collections.addAll(newHashSetWithCapacity, eArr);
        return newHashSetWithCapacity;
    }

    public static <E> HashSet<E> newHashSet(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>((Collection) iterable) : newHashSet(iterable.iterator());
    }

    public static <E> HashSet<E> newHashSet(Iterator<? extends E> it) {
        HashSet<E> newHashSet = newHashSet();
        while (it.hasNext()) {
            newHashSet.add(it.next());
        }
        return newHashSet;
    }
}
