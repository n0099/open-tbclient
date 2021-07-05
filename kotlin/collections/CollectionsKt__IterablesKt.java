package kotlin.collections;

import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0019\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aG\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00130\u001b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001a*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b0\u0004¢\u0006\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "", "Iterable", "(Lkotlin/Function0;)Ljava/lang/Iterable;", "", "default", "collectionSizeOrDefault", "(Ljava/lang/Iterable;I)I", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "", "convertToSetForSetOperation", "(Ljava/lang/Iterable;)Ljava/util/Collection;", "source", "convertToSetForSetOperationWith", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Collection;", "", "flatten", "(Ljava/lang/Iterable;)Ljava/util/List;", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "(Ljava/util/Collection;)Z", "safeToConvertToSet", "R", "Lkotlin/Pair;", ZeusPerformanceTiming.KEY_UNZIP, "(Ljava/lang/Iterable;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes10.dex */
public class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    @InlineOnly
    public static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> function0) {
        return new CollectionsKt__IterablesKt$Iterable$1(function0);
    }

    @PublishedApi
    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> collectionSizeOrDefault, int i2) {
        Intrinsics.checkNotNullParameter(collectionSizeOrDefault, "$this$collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection) collectionSizeOrDefault).size() : i2;
    }

    @PublishedApi
    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> collectionSizeOrNull) {
        Intrinsics.checkNotNullParameter(collectionSizeOrNull, "$this$collectionSizeOrNull");
        if (collectionSizeOrNull instanceof Collection) {
            return Integer.valueOf(((Collection) collectionSizeOrNull).size());
        }
        return null;
    }

    public static final <T> Collection<T> convertToSetForSetOperation(Iterable<? extends T> convertToSetForSetOperation) {
        Intrinsics.checkNotNullParameter(convertToSetForSetOperation, "$this$convertToSetForSetOperation");
        if (convertToSetForSetOperation instanceof Set) {
            return (Collection) convertToSetForSetOperation;
        }
        if (convertToSetForSetOperation instanceof Collection) {
            Collection<T> collection = (Collection) convertToSetForSetOperation;
            return safeToConvertToSet$CollectionsKt__IterablesKt(collection) ? CollectionsKt___CollectionsKt.toHashSet(convertToSetForSetOperation) : collection;
        }
        return CollectionsKt___CollectionsKt.toHashSet(convertToSetForSetOperation);
    }

    public static final <T> Collection<T> convertToSetForSetOperationWith(Iterable<? extends T> convertToSetForSetOperationWith, Iterable<? extends T> source) {
        Intrinsics.checkNotNullParameter(convertToSetForSetOperationWith, "$this$convertToSetForSetOperationWith");
        Intrinsics.checkNotNullParameter(source, "source");
        if (convertToSetForSetOperationWith instanceof Set) {
            return (Collection) convertToSetForSetOperationWith;
        }
        if (convertToSetForSetOperationWith instanceof Collection) {
            if (!(source instanceof Collection) || ((Collection) source).size() >= 2) {
                Collection<T> collection = (Collection) convertToSetForSetOperationWith;
                return safeToConvertToSet$CollectionsKt__IterablesKt(collection) ? CollectionsKt___CollectionsKt.toHashSet(convertToSetForSetOperationWith) : collection;
            }
            return (Collection) convertToSetForSetOperationWith;
        }
        return CollectionsKt___CollectionsKt.toHashSet(convertToSetForSetOperationWith);
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> flatten) {
        Intrinsics.checkNotNullParameter(flatten, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable : flatten) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, iterable);
        }
        return arrayList;
    }

    public static final <T> boolean safeToConvertToSet$CollectionsKt__IterablesKt(Collection<? extends T> collection) {
        return collection.size() > 2 && (collection instanceof ArrayList);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> unzip) {
        Intrinsics.checkNotNullParameter(unzip, "$this$unzip");
        int collectionSizeOrDefault = collectionSizeOrDefault(unzip, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (Pair<? extends T, ? extends R> pair : unzip) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}
