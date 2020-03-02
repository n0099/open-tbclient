package com.squareup.wire2.internal;

import com.squareup.wire2.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static <T> List<T> dGz() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> dGA() {
        return new LinkedHashMap();
    }

    public static <T> List<T> t(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        return (list == Collections.emptyList() || (list instanceof ImmutableList)) ? new MutableOnWriteList(list) : new ArrayList(list);
    }

    public static <K, V> Map<K, V> o(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(str + " == null");
        }
        return new LinkedHashMap(map);
    }

    public static <T> List<T> u(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof MutableOnWriteList) {
            list = ((MutableOnWriteList) list).mutableList;
        }
        if (list != Collections.emptyList() && !(list instanceof ImmutableList)) {
            ImmutableList immutableList = new ImmutableList(list);
            if (immutableList.contains(null)) {
                throw new IllegalArgumentException(str + ".contains(null)");
            }
            return immutableList;
        }
        return list;
    }

    public static <K, V> Map<K, V> p(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(str + " == null");
        }
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (linkedHashMap.containsKey(null)) {
            throw new IllegalArgumentException(str + ".containsKey(null)");
        }
        if (linkedHashMap.containsValue(null)) {
            throw new IllegalArgumentException(str + ".containsValue(null)");
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static <T> void a(List<T> list, ProtoAdapter<T> protoAdapter) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, protoAdapter.redact(list.get(i)));
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void fq(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static void E(Map<?, ?> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (entry.getValue() == null) {
                throw new NullPointerException("Value for key " + entry.getKey() + " is null");
            }
        }
    }

    public static int a(Object obj, Object obj2, Object obj3) {
        return (obj3 == null ? 0 : 1) + (obj2 != null ? 1 : 0) + (obj != null ? 1 : 0);
    }
}
