package d.g.c.c;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashSet;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashSet;
import com.google.common.collect.MapMaker;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class n0 {
    public static <T> T[] a(Object[] objArr, int i2, int i3, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i2, i3, tArr.getClass());
    }

    public static <T> T[] b(T[] tArr, int i2) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
    }

    public static <K, V> Map<K, V> c(int i2) {
        return CompactHashMap.createWithExpectedSize(i2);
    }

    public static <E> Set<E> d(int i2) {
        return CompactHashSet.createWithExpectedSize(i2);
    }

    public static <K, V> Map<K, V> e(int i2) {
        return CompactLinkedHashMap.createWithExpectedSize(i2);
    }

    public static <E> Set<E> f(int i2) {
        return CompactLinkedHashSet.createWithExpectedSize(i2);
    }

    public static <E> Set<E> g() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> h() {
        return CompactHashMap.create();
    }

    public static MapMaker i(MapMaker mapMaker) {
        mapMaker.l();
        return mapMaker;
    }
}
