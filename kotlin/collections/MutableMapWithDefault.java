package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0004\bb\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/collections/MutableMapWithDefault;", "K", "V", "Ljava/util/Map;", "Lkotlin/collections/MapWithDefault;", "Lkotlin/jvm/internal/markers/KMutableMap;", "Lkotlin/Any;", "", "getMap", "()Ljava/util/Map;", "map", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V>, KMutableMap {
    @Override // kotlin.collections.MapWithDefault
    Map<K, V> getMap();
}
