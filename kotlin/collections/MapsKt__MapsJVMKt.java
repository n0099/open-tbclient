package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0001\u0010\u00012*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\b\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aB\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0015\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0004H\u0087\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a8\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0081\b¢\u0006\u0004\b\u0019\u0010\u0018\u001aA\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001b\u001aG\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001a\u0010\u001e¨\u0006\u001f"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "pair", "", "mapOf", "(Lkotlin/Pair;)Ljava/util/Map;", "", "", "pairs", "Ljava/util/SortedMap;", "sortedMapOf", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "Ljava/util/concurrent/ConcurrentMap;", "key", "Lkotlin/Function0;", "defaultValue", "getOrPut", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Ljava/util/Properties;", "toProperties", "(Ljava/util/Map;)Ljava/util/Properties;", "toSingletonMap", "(Ljava/util/Map;)Ljava/util/Map;", "toSingletonMapOrSelf", "toSortedMap", "(Ljava/util/Map;)Ljava/util/SortedMap;", "Ljava/util/Comparator;", "comparator", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/SortedMap;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/MapsKt")
/* loaded from: classes7.dex */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V invoke = function0.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
        return putIfAbsent != null ? putIfAbsent : invoke;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        TreeMap treeMap = new TreeMap();
        MapsKt__MapsKt.putAll(treeMap, pairArr);
        return treeMap;
    }

    @InlineOnly
    public static final Properties toProperties(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "java.util.Collections.singletonMap(key, value)");
        Intrinsics.checkExpressionValueIsNotNull(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @InlineOnly
    public static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> map) {
        return toSingletonMap(map);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        return new TreeMap(map);
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
