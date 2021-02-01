package com.yy.videoplayer.utils;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public class FP {

    /* loaded from: classes4.dex */
    public interface BinaryFunc<R, A, B> {
        R apply(A a2, B b2);
    }

    /* loaded from: classes4.dex */
    public interface UnaryFunc<R, A> {
        R apply(A a2);
    }

    /* loaded from: classes4.dex */
    public static abstract class Pred<A> implements UnaryFunc<Boolean, A> {
        public abstract boolean pred(A a2);

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yy.videoplayer.utils.FP.UnaryFunc
        public /* bridge */ /* synthetic */ Boolean apply(Object obj) {
            return apply((Pred<A>) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yy.videoplayer.utils.FP.UnaryFunc
        public Boolean apply(A a2) {
            return Boolean.valueOf(pred(a2));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Eq<A> implements BinaryFunc<Boolean, A, A> {
        public abstract boolean eq(A a2, A a3);

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.yy.videoplayer.utils.FP.BinaryFunc
        public Boolean apply(A a2, A a3) {
            return Boolean.valueOf(eq(a2, a3));
        }
    }

    /* loaded from: classes4.dex */
    public static class Tuple<A, B, C> {

        /* renamed from: a  reason: collision with root package name */
        public A f14399a;

        /* renamed from: b  reason: collision with root package name */
        public B f14400b;
        public C c;

        public Tuple(A a2, B b2, C c) {
            this.f14399a = a2;
            this.f14400b = b2;
            this.c = c;
        }
    }

    public static <A, B, C> Tuple<A, B, C> makeTuple(A a2, B b2, C c) {
        return new Tuple<>(a2, b2, c);
    }

    public static <E> Pred<E> negate(final Pred<E> pred) {
        return new Pred<E>() { // from class: com.yy.videoplayer.utils.FP.1
            @Override // com.yy.videoplayer.utils.FP.Pred
            public boolean pred(E e) {
                return !Pred.this.pred(e);
            }
        };
    }

    public static int limit(int i, int i2, int i3) {
        return Math.min(Math.max(i2, i), i3);
    }

    public static int maximum(int... iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    public static <E> E find(Pred<E> pred, List<E> list) {
        if (!empty(list)) {
            for (E e : list) {
                if (pred.pred(e)) {
                    return e;
                }
            }
        }
        return null;
    }

    public static <E> E find(final E e, List<E> list) {
        return (E) find((Pred<Object>) new Pred<E>() { // from class: com.yy.videoplayer.utils.FP.2
            @Override // com.yy.videoplayer.utils.FP.Pred
            public boolean pred(E e2) {
                return e2.equals(e);
            }
        }, (List<Object>) list);
    }

    public static <E> int findIndex(Pred<E> pred, List<E> list) {
        int length = length(list);
        int i = 0;
        while (i < length && !pred.pred(list.get(i))) {
            i++;
        }
        if (i == length) {
            return -1;
        }
        return i;
    }

    public static <K, V> V lookup(K k, List<Pair<K, V>> list) {
        if (!empty(list)) {
            for (Pair<K, V> pair : list) {
                if (k == pair.first) {
                    return (V) pair.second;
                }
            }
        }
        return null;
    }

    public static <E> E lookup(int i, SparseArray<E> sparseArray) {
        if (empty((SparseArray<?>) sparseArray)) {
            return null;
        }
        return sparseArray.get(i);
    }

    public static <E> List<E> nubBy(final Eq<E> eq, List<E> list) {
        ArrayList arrayList = new ArrayList();
        if (!empty(list)) {
            for (final E e : list) {
                if (find((Pred<Object>) new Pred<E>() { // from class: com.yy.videoplayer.utils.FP.3
                    @Override // com.yy.videoplayer.utils.FP.Pred
                    public boolean pred(E e2) {
                        return Eq.this.eq(e, e2);
                    }
                }, (List<Object>) arrayList) == null) {
                    arrayList.add(e);
                }
            }
        }
        return arrayList;
    }

    public static <E> List<E> nub(List<E> list) {
        return nubBy(new Eq<E>() { // from class: com.yy.videoplayer.utils.FP.4
            @Override // com.yy.videoplayer.utils.FP.Eq
            public boolean eq(E e, E e2) {
                return e2.equals(e);
            }
        }, list);
    }

    public static boolean empty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean empty(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static boolean empty(SparseArray<?> sparseArray) {
        return sparseArray == null || sparseArray.size() == 0;
    }

    public static boolean empty(SparseIntArray sparseIntArray) {
        return sparseIntArray == null || sparseIntArray.size() == 0;
    }

    public static boolean empty(int[] iArr) {
        return iArr == null || iArr.length == 0;
    }

    public static boolean empty(long[] jArr) {
        return jArr == null || jArr.length == 0;
    }

    public static boolean empty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean empty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static int size(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static int size(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static <T> int size(T[] tArr) {
        if (tArr == null) {
            return 0;
        }
        return tArr.length;
    }

    public static int size(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        return iArr.length;
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static int size(SparseArray<?> sparseArray) {
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.size();
    }

    public static int size(SparseIntArray sparseIntArray) {
        if (sparseIntArray == null) {
            return 0;
        }
        return sparseIntArray.size();
    }

    public static int length(Collection<?> collection) {
        return size(collection);
    }

    public static int length(CharSequence charSequence) {
        return size(charSequence);
    }

    public static <T> int length(T[] tArr) {
        return size(tArr);
    }

    public static int length(int[] iArr) {
        return size(iArr);
    }

    public static int length(Map<?, ?> map) {
        return size(map);
    }

    public static int length(SparseArray<?> sparseArray) {
        return size(sparseArray);
    }

    public static int length(SparseIntArray sparseIntArray) {
        return size(sparseIntArray);
    }

    public static <T> boolean elem(T t, T[] tArr) {
        return !empty(tArr) && Arrays.asList(tArr).contains(t);
    }

    public static <T> boolean elem(T t, Collection<T> collection) {
        return !empty((Collection<?>) collection) && collection.contains(t);
    }

    public static <T> void swap(List<T> list, int i, int i2) {
        T t = list.get(i);
        list.set(i, list.get(i2));
        list.set(i2, t);
    }

    public static <T> void swap(T[] tArr, int i, int i2) {
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public static <T> void shift(List<T> list, int i, int i2) {
        T t = list.get(i);
        int i3 = i < i2 ? 1 : -1;
        while (i != i2) {
            list.set(i, list.get(i + i3));
            i += i3;
        }
        list.set(i2, t);
    }

    public static <T> void shift(T[] tArr, int i, int i2) {
        T t = tArr[i];
        int i3 = i < i2 ? 1 : -1;
        while (i != i2) {
            tArr[i] = tArr[i + i3];
            i += i3;
        }
        tArr[i2] = t;
    }

    public static <E> List<E> add(List<E> list, E e) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(e);
        return list;
    }

    public static <E> List<E> delBy(Eq<E> eq, List<E> list, E e) {
        int length = length(list);
        int i = 0;
        while (i < length && !eq.eq(list.get(i), e)) {
            i++;
        }
        if (i < length) {
            list.remove(i);
        }
        return list;
    }

    public static <E> List<E> del(List<E> list, E e) {
        return delBy(new Eq<E>() { // from class: com.yy.videoplayer.utils.FP.5
            @Override // com.yy.videoplayer.utils.FP.Eq
            public boolean eq(E e2, E e3) {
                return FP.eq(e2, e3);
            }
        }, list, e);
    }

    public static <E> Pair<List<E>, List<E>> span(Pred<E> pred, List<E> list) {
        return Pair.create(takeWhile(pred, list), dropWhile(pred, list));
    }

    public static <E> List<E> take(int i, List<E> list) {
        ArrayList arrayList = new ArrayList();
        if (!empty(list) && i > 0) {
            arrayList.addAll(list.subList(0, Math.min(i, length(list))));
        }
        return arrayList;
    }

    public static String take(int i, String str) {
        return str.substring(0, limit(i, 0, length(str)));
    }

    public static <K, V> Map<K, V> take(int i, Map<K, V> map) {
        HashMap hashMap = new HashMap();
        for (K k : map.keySet()) {
            int i2 = i - 1;
            if (i > 0) {
                hashMap.put(k, map.get(k));
            }
            i = i2;
        }
        return hashMap;
    }

    public static <E> List<E> takeWhile(Pred<E> pred, List<E> list) {
        int length = length(list);
        int i = 0;
        while (i < length && pred.pred(list.get(i))) {
            i++;
        }
        return take(i, list);
    }

    public static <E> List<E> drop(int i, List<E> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && i <= length(list)) {
            arrayList.addAll(list.subList(Math.max(0, i), length(list)));
        }
        return arrayList;
    }

    public static String drop(int i, String str) {
        return (str == null || i > length(str)) ? "" : str.substring(Math.max(0, i));
    }

    public static <E> List<E> dropWhile(Pred<E> pred, List<E> list) {
        int length = length(list);
        for (int i = 0; i < length && pred.pred(list.get(i)); i++) {
        }
        return drop(length, list);
    }

    public static <E> E head(LinkedList<E> linkedList) {
        if (empty(linkedList)) {
            return null;
        }
        return linkedList.element();
    }

    public static <E> LinkedList<E> tail(LinkedList<E> linkedList) {
        if (!empty(linkedList)) {
            LinkedList<E> linkedList2 = new LinkedList<>(linkedList);
            linkedList2.remove();
            return linkedList2;
        }
        return linkedList;
    }

    public static <E> LinkedList<E> cons(E e, LinkedList<E> linkedList) {
        if (empty(linkedList)) {
            linkedList = new LinkedList<>();
        }
        linkedList.addFirst(e);
        return linkedList;
    }

    public static <E> E first(List<E> list) {
        if (empty(list)) {
            return null;
        }
        return list.get(0);
    }

    public static <E> E second(List<E> list) {
        if (size(list) < 2) {
            return null;
        }
        return list.get(1);
    }

    public static <E> E last(List<E> list) {
        if (empty(list)) {
            return null;
        }
        return list.get(lastIndex(list));
    }

    public static int lastIndex(List<?> list) {
        if (empty(list)) {
            return -1;
        }
        return list.size() - 1;
    }

    public static <E> E first(Collection<E> collection) {
        if (empty((Collection<?>) collection)) {
            return null;
        }
        return collection.iterator().next();
    }

    public static <E> List<E> toList(Collection<? extends E> collection) {
        return empty(collection) ? new ArrayList() : new ArrayList(collection);
    }

    public static <T> List<T> toList(T t) {
        return Collections.singletonList(t);
    }

    public static <T> List<T> toList(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        if (!empty(tArr)) {
            for (T t : tArr) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static List<Integer> toList(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (!empty(iArr)) {
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public static List<Long> toList(long[] jArr) {
        ArrayList arrayList = new ArrayList();
        if (!empty(jArr)) {
            for (long j : jArr) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    public static <E> List<Pair<Integer, E>> toList(SparseArray<E> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (!empty((SparseArray<?>) sparseArray)) {
            for (int i = 0; i < sparseArray.size(); i++) {
                arrayList.add(Pair.create(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i)));
            }
        }
        return arrayList;
    }

    public static List<Pair<Integer, Integer>> toList(SparseIntArray sparseIntArray) {
        ArrayList arrayList = new ArrayList();
        if (!empty(sparseIntArray)) {
            for (int i = 0; i < sparseIntArray.size(); i++) {
                arrayList.add(Pair.create(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i))));
            }
        }
        return arrayList;
    }

    public static int[] toArray(List<Integer> list) {
        int length = length(list);
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public static <E> List<E> ref(List<E> list) {
        return list == null ? new ArrayList() : list;
    }

    public static <E> E[] ref(E[] eArr) {
        return eArr == null ? (E[]) new Object[0] : eArr;
    }

    public static int[] ref(int[] iArr) {
        return iArr == null ? new int[0] : iArr;
    }

    public static String ref(String str) {
        return str == null ? "" : str;
    }

    public static <A, B> List<Pair<A, B>> zip(List<A> list, List<B> list2) {
        ArrayList arrayList = new ArrayList();
        if (!empty(list) && !empty(list2)) {
            Iterator<A> it = list.iterator();
            Iterator<B> it2 = list2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                arrayList.add(Pair.create(it.next(), it2.next()));
            }
        }
        return arrayList;
    }

    public static boolean eq(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static boolean isPrefixOf(String str, String str2) {
        if (empty(str)) {
            return true;
        }
        return !empty(str2) && str2.startsWith(str);
    }

    public static <E> boolean isPrefixOf(List<E> list, List<E> list2) {
        if (empty(list)) {
            return true;
        }
        return !empty(list2) && eq(list, take(length(list), list2));
    }

    public static <T> void convert(T[] tArr, Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            tArr[i] = objArr;
        }
    }

    public static <T> List<T> concat(List<T> list, List<T> list2) {
        List<T> ref = ref(list);
        ref.addAll(ref(list2));
        return ref;
    }

    public static <T> T[] concat(T[] tArr, T[] tArr2) {
        int i = 0;
        T[] tArr3 = (T[]) new Object[length(tArr) + length(tArr2)];
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            tArr3[i3] = tArr[i2];
            i2++;
            i3++;
        }
        int length2 = tArr2.length;
        while (i < length2) {
            tArr3[i3] = tArr2[i];
            i++;
            i3++;
        }
        return tArr3;
    }

    public static int[] concat(int[] iArr, int[] iArr2) {
        int i = 0;
        int[] iArr3 = new int[length(iArr) + length(iArr2)];
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            iArr3[i3] = iArr[i2];
            i2++;
            i3++;
        }
        int length2 = iArr2.length;
        while (i < length2) {
            iArr3[i3] = iArr2[i];
            i++;
            i3++;
        }
        return iArr3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.yy.videoplayer.utils.FP$Eq<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> unionBy(Eq<T> eq, List<T> list, List<T> list2) {
        List<T> ref = ref(list2);
        if (empty(list)) {
            return ref;
        }
        for (T t : ref) {
            boolean z = false;
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (eq.eq(it.next(), t)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                list.add(t);
            }
        }
        return list;
    }

    public static <T> List<T> union(List<T> list, List<T> list2) {
        return unionBy(new Eq<T>() { // from class: com.yy.videoplayer.utils.FP.6
            @Override // com.yy.videoplayer.utils.FP.Eq
            public boolean eq(T t, T t2) {
                return FP.eq(t, t2);
            }
        }, list, list2);
    }

    public static <T> List<T> diffBy(Eq<T> eq, List<T> list, List<T> list2) {
        List<T> list3 = toList((Collection) list);
        for (T t : list2) {
            list3 = delBy(eq, list3, t);
        }
        return list3;
    }

    public static <T> List<T> diff(List<T> list, List<T> list2) {
        return diffBy(new Eq<T>() { // from class: com.yy.videoplayer.utils.FP.7
            @Override // com.yy.videoplayer.utils.FP.Eq
            public boolean eq(T t, T t2) {
                return FP.eq(t, t2);
            }
        }, list, list2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.yy.videoplayer.utils.FP$UnaryFunc<B, A> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <A, B> List<B> map(UnaryFunc<B, A> unaryFunc, List<A> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : ref(list)) {
            arrayList.add(unaryFunc.apply(obj));
        }
        return arrayList;
    }

    public static <E> List<E> filter(Pred<E> pred, List<E> list) {
        ArrayList arrayList = new ArrayList();
        for (E e : list) {
            if (pred.pred(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <S, E> S fold(BinaryFunc<S, S, E> binaryFunc, S s, Collection<E> collection) {
        if (!empty((Collection<?>) collection)) {
            for (E e : collection) {
                s = binaryFunc.apply(s, e);
            }
        }
        return s;
    }

    public static <E> List<E> insert(Comparator<E> comparator, E e, List<E> list) {
        int binarySearch = Collections.binarySearch(list, e, comparator);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        list.add((-binarySearch) - 1, e);
        return list;
    }

    public static <E> List<E> sort(Comparator<E> comparator, List<E> list) {
        List<E> ref = ref(list);
        try {
            Collections.sort(ref, comparator);
        } catch (Exception e) {
            YMFLog.error(null, "[Util    ]", "Failed to sort %s, exception:%s", ref, e.toString());
        }
        return ref;
    }

    public static int sum(Integer[] numArr) {
        int length = numArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            i++;
            i2 = numArr[i].intValue() + i2;
        }
        return i2;
    }

    public static long sum(Long[] lArr) {
        long j = 0;
        for (Long l : lArr) {
            j += l.longValue();
        }
        return j;
    }

    public static int sum(List<Integer> list) {
        int i = 0;
        Iterator<Integer> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().intValue() + i2;
            } else {
                return i2;
            }
        }
    }

    public static int ord(boolean z) {
        return z ? 1 : 0;
    }

    public static int ord(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static <E> List<E> replicate(int i, E e) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                arrayList.add(e);
                i = i2;
            } else {
                return arrayList;
            }
        }
    }

    public static <E> List<E> replicate(int i, Callable<E> callable) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                arrayList.add(callable.call());
                i = i2;
            } catch (Exception e) {
                YMFLog.error(null, "[Util    ]", "replicate failed, exception:", e);
            }
        }
        return arrayList;
    }

    /* loaded from: classes4.dex */
    public static class M {
        public static <K, V> List<Pair<K, V>> toList(Map<K, V> map) {
            ArrayList arrayList = new ArrayList();
            if (!FP.empty((Map<?, ?>) map)) {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    arrayList.add(Pair.create(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.TreeMap */
        /* JADX WARN: Multi-variable type inference failed */
        public static <K extends Comparable<K>, V> Map<K, V> fromList(List<Pair<K, V>> list) {
            TreeMap treeMap = new TreeMap();
            if (!FP.empty(list)) {
                for (Pair<K, V> pair : list) {
                    treeMap.put(pair.first, pair.second);
                }
            }
            return treeMap;
        }

        public static <V> Map<Integer, V> fromList(SparseArray<V> sparseArray) {
            TreeMap treeMap = new TreeMap();
            if (!FP.empty((SparseArray<?>) sparseArray)) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    treeMap.put(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
                }
            }
            return treeMap;
        }

        public static <V> List<V> values(SparseArray<V> sparseArray) {
            ArrayList arrayList = new ArrayList();
            int size = FP.size((SparseArray<?>) sparseArray);
            for (int i = 0; i < size; i++) {
                arrayList.add(sparseArray.valueAt(i));
            }
            return arrayList;
        }
    }
}
