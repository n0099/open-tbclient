package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
/* loaded from: classes9.dex */
public final class CollectionsKt {
    public static final <T> void addIfNotNull(Collection<T> collection, T t) {
        if (t != null) {
            collection.add(t);
        }
    }

    public static final int capacity(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    public static final <T> List<T> compact(ArrayList<T> arrayList) {
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                arrayList.trimToSize();
                return arrayList;
            }
            return CollectionsKt__CollectionsJVMKt.listOf(CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <K> Map<K, Integer> mapToIndex(Iterable<? extends K> iterable) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (K k : iterable) {
            linkedHashMap.put(k, Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }

    public static final <E> HashSet<E> newHashSetWithExpectedSize(int i) {
        return new HashSet<>(capacity(i));
    }

    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int i) {
        return new LinkedHashSet<>(capacity(i));
    }
}
