package org.chromium.base;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class CollectionUtil {
    public static boolean[] booleanListToBooleanArray(@NonNull List<Boolean> list) {
        boolean[] zArr = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            zArr[i] = list.get(i).booleanValue();
        }
        return zArr;
    }

    public static int[] integerListToIntArray(@NonNull List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static long[] longListToLongArray(@NonNull List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.HashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SafeVarargs
    public static <K, V> HashMap<K, V> newHashMap(Pair<? extends K, ? extends V>... pairArr) {
        HashMap<K, V> hashMap = (HashMap<K, V>) new HashMap();
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            hashMap.put(pair.first, pair.second);
        }
        return hashMap;
    }

    @SafeVarargs
    public static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> hashSet = new HashSet<>(eArr.length);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }

    public static <T> List<T> strengthen(Collection<WeakReference<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<WeakReference<T>> it = collection.iterator();
        while (it.hasNext()) {
            T t = it.next().get();
            if (t == null) {
                it.remove();
            } else {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> void forEach(Collection<? extends T> collection, Callback<T> callback) {
        for (T t : collection) {
            callback.onResult(t);
        }
    }

    public static <K, V> void forEach(Map<? extends K, ? extends V> map, Callback<Map.Entry<K, V>> callback) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            callback.onResult(entry);
        }
    }
}
