package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobstat.Config;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a¢\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a¶\u0001\u0010\u0013\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u00032b\u0010\f\u001a^\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001aK\u0010\u0016\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00150\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aÃ\u0001\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000326\u0010\u0019\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00182K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u001aH\u0087\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a~\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u001d\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0018H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001e\u001a×\u0001\u0010\u001f\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u000326\u0010\u0019\u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u00182K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u001aH\u0087\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0092\u0001\u0010\u001f\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0010*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00028\u00032\u0006\u0010\u001d\u001a\u00028\u000226\u0010\f\u001a2\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00020\u0018H\u0087\b¢\u0006\u0004\b\u001f\u0010!\u001a\u008f\u0001\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\"\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\b¢\u0006\u0004\b#\u0010$\u001a£\u0001\u0010%\u001a\u00028\u0003\"\u0004\b\u0000\u0010\"\"\b\b\u0001\u0010\u0000*\u00028\u0000\"\u0004\b\u0002\u0010\u0001\"\u0016\b\u0003\u0010\u0011*\u0010\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00000\u0010*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u00032K\u0010\f\u001aG\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00028\u00000\u001aH\u0087\b¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "K", "R", "Lkotlin/collections/Grouping;", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", Config.TRACE_VISIT_FIRST, AppDownloadNetworkStateReceiver.KEY_OPERATION, "", "aggregate", "(Lkotlin/collections/Grouping;Lkotlin/Function4;)Ljava/util/Map;", "", "M", "destination", "aggregateTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "", "eachCountTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "Lkotlin/Function2;", "initialValueSelector", "Lkotlin/Function3;", "fold", "(Lkotlin/collections/Grouping;Lkotlin/Function2;Lkotlin/Function3;)Ljava/util/Map;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", ExifInterface.LATITUDE_SOUTH, "reduce", "(Lkotlin/collections/Grouping;Lkotlin/Function3;)Ljava/util/Map;", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/GroupingKt")
/* loaded from: classes7.dex */
public class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> aggregate(Grouping<T, ? extends K> grouping, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            Object obj = (K) grouping.keyOf(next);
            Object obj2 = (Object) linkedHashMap.get(obj);
            linkedHashMap.put(obj, function4.invoke(obj, obj2, next, Boolean.valueOf(obj2 == 0 && !linkedHashMap.containsKey(obj))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(Grouping<T, ? extends K> grouping, M m, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            Object keyOf = grouping.keyOf(next);
            Object obj = (Object) m.get(keyOf);
            m.put(keyOf, function4.invoke(keyOf, obj, next, Boolean.valueOf(obj == 0 && !m.containsKey(keyOf))));
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(Grouping<T, ? extends K> grouping, M m) {
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            K keyOf = grouping.keyOf(sourceIterator.next());
            Object obj = m.get(keyOf);
            if (obj == null && !m.containsKey(keyOf)) {
                obj = 0;
            }
            m.put(keyOf, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, Function2<? super K, ? super T, ? extends R> function2, Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            Object obj = (K) grouping.keyOf(next);
            R r = (Object) linkedHashMap.get(obj);
            if (r == null && !linkedHashMap.containsKey(obj)) {
                r = function2.invoke(obj, next);
            }
            linkedHashMap.put(obj, function3.invoke(obj, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M m, Function2<? super K, ? super T, ? extends R> function2, Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            Object keyOf = grouping.keyOf(next);
            R r = (Object) m.get(keyOf);
            if (r == null && !m.containsKey(keyOf)) {
                r = function2.invoke(keyOf, next);
            }
            m.put(keyOf, function3.invoke(keyOf, r, next));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ? super K */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.Grouping<T extends S, ? extends K> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <S, T extends S, K> Map<K, S> reduce(Grouping<T, ? extends K> grouping, Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            S s = (Object) sourceIterator.next();
            Object obj = (Object) grouping.keyOf(s);
            Object obj2 = (Object) linkedHashMap.get(obj);
            if (!(obj2 == 0 && !linkedHashMap.containsKey(obj))) {
                s = function3.invoke(obj, obj2, s);
            }
            linkedHashMap.put(obj, s);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: ? super K */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.collections.Grouping<T extends S, ? extends K> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(Grouping<T, ? extends K> grouping, M m, Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            S s = (Object) sourceIterator.next();
            Object obj = (Object) grouping.keyOf(s);
            Object obj2 = (Object) m.get(obj);
            if (!(obj2 == 0 && !m.containsKey(obj))) {
                s = function3.invoke(obj, obj2, s);
            }
            m.put(obj, s);
        }
        return m;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(Grouping<T, ? extends K> grouping, M m, R r, Function2<? super R, ? super T, ? extends R> function2) {
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            K keyOf = grouping.keyOf(next);
            Object obj = (Object) m.get(keyOf);
            if (obj == null && !m.containsKey(keyOf)) {
                obj = (Object) r;
            }
            m.put(keyOf, function2.invoke(obj, next));
        }
        return m;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @SinceKotlin(version = "1.1")
    public static final <T, K, R> Map<K, R> fold(Grouping<T, ? extends K> grouping, R r, Function2<? super R, ? super T, ? extends R> function2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            K keyOf = grouping.keyOf(next);
            Object obj = (Object) linkedHashMap.get(keyOf);
            if (obj == null && !linkedHashMap.containsKey(keyOf)) {
                obj = (Object) r;
            }
            linkedHashMap.put(keyOf, function2.invoke(obj, next));
        }
        return linkedHashMap;
    }
}
