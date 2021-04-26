package d.n.a.h;

import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.internal.ImmutableList;
import com.squareup.wire2.internal.MutableOnWriteList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class a {
    public static void a(List<?> list) {
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2) == null) {
                    throw new NullPointerException("Element at index " + i2 + " is null");
                }
            }
            return;
        }
        throw new NullPointerException("list == null");
    }

    public static void b(Map<?, ?> map) {
        if (map != null) {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    if (entry.getValue() == null) {
                        throw new NullPointerException("Value for key " + entry.getKey() + " is null");
                    }
                } else {
                    throw new NullPointerException("map.containsKey(null)");
                }
            }
            return;
        }
        throw new NullPointerException("map == null");
    }

    public static <T> List<T> c(String str, List<T> list) {
        if (list != null) {
            if (list != Collections.emptyList() && !(list instanceof ImmutableList)) {
                return new ArrayList(list);
            }
            return new MutableOnWriteList(list);
        }
        throw new NullPointerException(str + " == null");
    }

    public static <K, V> Map<K, V> d(String str, Map<K, V> map) {
        if (map != null) {
            return new LinkedHashMap(map);
        }
        throw new NullPointerException(str + " == null");
    }

    public static int e(Object obj, Object obj2, Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
    }

    public static boolean f(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> List<T> g(String str, List<T> list) {
        if (list != null) {
            if (list instanceof MutableOnWriteList) {
                list = ((MutableOnWriteList) list).mutableList;
            }
            if (list == Collections.emptyList() || (list instanceof ImmutableList)) {
                return list;
            }
            ImmutableList immutableList = new ImmutableList(list);
            if (immutableList.contains(null)) {
                throw new IllegalArgumentException(str + ".contains(null)");
            }
            return immutableList;
        }
        throw new NullPointerException(str + " == null");
    }

    public static <K, V> Map<K, V> h(String str, Map<K, V> map) {
        if (map != null) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            if (!linkedHashMap.containsKey(null)) {
                if (!linkedHashMap.containsValue(null)) {
                    return Collections.unmodifiableMap(linkedHashMap);
                }
                throw new IllegalArgumentException(str + ".containsValue(null)");
            }
            throw new IllegalArgumentException(str + ".containsKey(null)");
        }
        throw new NullPointerException(str + " == null");
    }

    public static <T> List<T> i() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> j() {
        return new LinkedHashMap();
    }

    public static <T> void k(List<T> list, ProtoAdapter<T> protoAdapter) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.set(i2, protoAdapter.redact(list.get(i2)));
        }
    }
}
