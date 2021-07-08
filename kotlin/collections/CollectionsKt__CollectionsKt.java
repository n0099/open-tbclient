package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.BuilderInference;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aJ\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aJ\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00028\u00000\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a&\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0013\u001aU\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u001f\b\u0001\u0010\u0018\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0019\u0010\n\u001aM\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00142\u001f\b\u0001\u0010\u0018\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\"\u001a5\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\b\b\u0000\u0010\u0000*\u00020\u001f2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0011\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b!\u0010\u001e\u001a\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b#\u0010\u001c\u001a-\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\"\u00028\u0000¢\u0006\u0004\b#\u0010\u001e\u001a'\u0010(\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0002¢\u0006\u0004\b&\u0010'\u001a\u000f\u0010)\u001a\u00020\u0016H\u0001¢\u0006\u0004\b)\u0010*\u001a\u000f\u0010+\u001a\u00020\u0016H\u0001¢\u0006\u0004\b+\u0010*\u001a'\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0004\b-\u0010.\u001aU\u00102\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010 \u001a\u00028\u00002\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000/j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`02\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u0001¢\u0006\u0004\b2\u00103\u001aE\u00102\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b2\u00105\u001aG\u00102\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000006*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b2\b\u0010 \u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u0001¢\u0006\u0004\b2\u00107\u001ai\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u00108*\b\u0012\u0004\u0012\u00028\u000106*\b\u0012\u0004\u0012\u00028\u00000\b2\b\u00109\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\u0016\b\u0004\u0010:\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a3\u0010?\u001a\u00020>\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b=*\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0087\b¢\u0006\u0004\b?\u0010@\u001a=\u0010E\u001a\u00028\u0001\"\u0010\b\u0000\u0010A*\u0006\u0012\u0002\b\u00030,*\u00028\u0001\"\u0004\b\u0001\u0010B*\u00028\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010CH\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a \u0010G\u001a\u00020>\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000,H\u0087\b¢\u0006\u0004\bG\u0010H\u001a3\u0010I\u001a\u00020>\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\bI\u0010H\u001a%\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0000¢\u0006\u0004\bJ\u0010K\u001a(\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,H\u0087\b¢\u0006\u0004\bL\u0010M\u001a(\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0087\b¢\u0006\u0004\bL\u0010K\u001a-\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000N2\u0006\u0010P\u001a\u00020OH\u0007¢\u0006\u0004\bQ\u0010R\"\u001b\u0010V\u001a\u00020S*\u0006\u0012\u0002\b\u00030,8F@\u0006¢\u0006\u0006\u001a\u0004\bT\u0010U\"#\u0010Y\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b8F@\u0006¢\u0006\u0006\u001a\u0004\bW\u0010X\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Z"}, d2 = {"T", "", "size", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "init", "", "List", "(ILkotlin/Function1;)Ljava/util/List;", "", "MutableList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "()Ljava/util/ArrayList;", "", "elements", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "E", "capacity", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "buildList", "(Lkotlin/Function1;)Ljava/util/List;", "emptyList", "()Ljava/util/List;", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "element", "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "(III)V", "rangeCheck", "throwCountOverflow", "()V", "throwIndexOverflow", "", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "binarySearch", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "(Ljava/util/List;IILkotlin/Function1;)I", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "K", "key", "selector", "binarySearchBy", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "Lkotlin/internal/OnlyInputTypes;", "", "containsAll", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Ljava/util/Collection;)Z", "isNullOrEmpty", "optimizeReadOnlyList", "(Ljava/util/List;)Ljava/util/List;", "orEmpty", "(Ljava/util/Collection;)Ljava/util/Collection;", "", "Lkotlin/random/Random;", "random", "shuffled", "(Ljava/lang/Iterable;Lkotlin/random/Random;)Ljava/util/List;", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes9.dex */
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> List<T> List(int i2, Function1<? super Integer, ? extends T> function1) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> List<T> MutableList(int i2, Function1<? super Integer, ? extends T> function1) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(function1.invoke(Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<>();
    }

    public static final <T> Collection<T> asCollection(T[] asCollection) {
        Intrinsics.checkNotNullParameter(asCollection, "$this$asCollection");
        return new ArrayAsCollection(asCollection, false);
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> binarySearch, T t, int i2, int i3) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int compareValues = ComparisonsKt__ComparisonsKt.compareValues(binarySearch.get(i5), t);
            if (compareValues < 0) {
                i2 = i5 + 1;
            } else if (compareValues <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int binarySearch$default(List list, Comparable comparable, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, comparable, i2, i3);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> binarySearchBy, K k, int i2, int i3, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(binarySearchBy, "$this$binarySearchBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return binarySearch(binarySearchBy, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }

    public static /* synthetic */ int binarySearchBy$default(List binarySearchBy, Comparable comparable, int i2, int i3, Function1 selector, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = binarySearchBy.size();
        }
        Intrinsics.checkNotNullParameter(binarySearchBy, "$this$binarySearchBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return binarySearch(binarySearchBy, i2, i3, new CollectionsKt__CollectionsKt$binarySearchBy$1(selector, comparable));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final <E> List<E> buildList(@BuilderInference Function1<? super List<E>, Unit> function1) {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        function1.invoke(createListBuilder);
        return CollectionsKt__CollectionsJVMKt.build(createListBuilder);
    }

    @InlineOnly
    public static final <T> boolean containsAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        return collection.containsAll(collection2);
    }

    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final IntRange getIndices(Collection<?> indices) {
        Intrinsics.checkNotNullParameter(indices, "$this$indices");
        return new IntRange(0, indices.size() - 1);
    }

    public static final <T> int getLastIndex(List<? extends T> lastIndex) {
        Intrinsics.checkNotNullParameter(lastIndex, "$this$lastIndex");
        return lastIndex.size() - 1;
    }

    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final Object ifEmpty(Collection collection, Function0 function0) {
        return collection.isEmpty() ? function0.invoke() : collection;
    }

    @InlineOnly
    public static final <T> boolean isNotEmpty(Collection<? extends T> collection) {
        return !collection.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt___ArraysJvmKt.asList(elements) : emptyList();
    }

    public static final <T> List<T> listOfNotNull(T t) {
        return t != null ? CollectionsKt__CollectionsJVMKt.listOf(t) : emptyList();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> optimizeReadOnlyList) {
        Intrinsics.checkNotNullParameter(optimizeReadOnlyList, "$this$optimizeReadOnlyList");
        int size = optimizeReadOnlyList.size();
        if (size != 0) {
            return size != 1 ? optimizeReadOnlyList : CollectionsKt__CollectionsJVMKt.listOf(optimizeReadOnlyList.get(0));
        }
        return emptyList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Collection<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <T> Collection<T> orEmpty(Collection<? extends T> collection) {
        return collection != 0 ? collection : emptyList();
    }

    public static final void rangeCheck$CollectionsKt__CollectionsKt(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("fromIndex (" + i3 + ") is greater than toIndex (" + i4 + ").");
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i3 + ") is less than zero.");
        } else if (i4 <= i2) {
        } else {
            throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i2 + ").");
        }
    }

    @SinceKotlin(version = "1.3")
    public static final <T> List<T> shuffled(Iterable<? extends T> shuffled, Random random) {
        Intrinsics.checkNotNullParameter(shuffled, "$this$shuffled");
        Intrinsics.checkNotNullParameter(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(shuffled);
        CollectionsKt___CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T> ArrayList<T> arrayListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList<>() : new ArrayList<>(new ArrayAsCollection(elements, true));
    }

    public static /* synthetic */ int binarySearch$default(List list, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, obj, comparator, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final <E> List<E> buildList(int i2, @BuilderInference Function1<? super List<E>, Unit> function1) {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder(i2);
        function1.invoke(createListBuilder);
        return CollectionsKt__CollectionsJVMKt.build(createListBuilder);
    }

    @InlineOnly
    public static final <T> List<T> listOf() {
        return emptyList();
    }

    public static final <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt___ArraysKt.filterNotNull(elements);
    }

    public static final <T> List<T> mutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <T> List<T> orEmpty(List<? extends T> list) {
        return list != 0 ? list : emptyList();
    }

    public static /* synthetic */ int binarySearch$default(List list, int i2, int i3, Function1 function1, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = list.size();
        }
        return binarySearch(list, i2, i3, function1);
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
    public static final <T> int binarySearch(List<? extends T> binarySearch, T t, Comparator<? super T> comparator, int i2, int i3) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int compare = comparator.compare((T) binarySearch.get(i5), t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else if (compare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
    public static final <T> int binarySearch(List<? extends T> binarySearch, int i2, int i3, Function1<? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(binarySearch.size(), i2, i3);
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int intValue = comparison.invoke((T) binarySearch.get(i5)).intValue();
            if (intValue < 0) {
                i2 = i5 + 1;
            } else if (intValue <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }
}
