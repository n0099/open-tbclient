package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u00032\u00020\u00042\u00020\u0005J\u0017\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/collections/MapWithDefault;", "K", "V", "Ljava/util/Map;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/Any;", "key", "getOrImplicitDefault", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getMap", "()Ljava/util/Map;", "map", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface MapWithDefault<K, V> extends Map<K, V>, KMappedMarker {
    Map<K, V> getMap();

    V getOrImplicitDefault(K k);
}
