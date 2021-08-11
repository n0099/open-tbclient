package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\r\u001a/\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0005\u0010\b\u001a-\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0005\u0010\n\u001a;\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a;\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0013\u001a*\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a0\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0018\u001a0\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0019\u001a0\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\n¢\u0006\u0004\b\u0016\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u001b\u0010\u0017\u001a0\u0010\u001b\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0087\n¢\u0006\u0004\b\u001b\u0010\u0018\u001a0\u0010\u001b\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0087\n¢\u0006\u0004\b\u001b\u0010\u0019\u001a0\u0010\u001b\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\n¢\u0006\u0004\b\u001b\u0010\u001a\u001a/\u0010\u001d\u001a\u00020\u0004\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001c*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a(\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010 \u001a\u00020\u001fH\u0087\b¢\u0006\u0004\b\u001d\u0010!\u001a/\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b\"\u0010\u0006\u001a-\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\"\u0010\b\u001a-\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\"\u0010\n\u001a5\u0010\"\u001a\u00020\u0004\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001c*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0087\b¢\u0006\u0004\b\"\u0010$\u001a1\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\"\u0010%\u001a1\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\"\u0010&\u001a\u001f\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0007¢\u0006\u0004\b'\u0010(\u001a!\u0010)\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0007¢\u0006\u0004\b)\u0010(\u001a\u001f\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0007¢\u0006\u0004\b*\u0010(\u001a!\u0010+\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0007¢\u0006\u0004\b+\u0010(\u001a/\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002¢\u0006\u0004\b,\u0010\u0006\u001a-\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b,\u0010\b\u001a-\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b,\u0010\n\u001a5\u0010,\u001a\u00020\u0004\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001c*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0087\b¢\u0006\u0004\b,\u0010$\u001a1\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b,\u0010%\u001a1\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b,\u0010&\u001a\u0017\u0010/\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b-\u0010.¨\u00060"}, d2 = {"T", "", "", "elements", "", "addAll", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "(Ljava/util/Collection;Ljava/lang/Iterable;)Z", "Lkotlin/sequences/Sequence;", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)Z", "", "Lkotlin/Function1;", "predicate", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "(Ljava/lang/Iterable;Lkotlin/Function1;Z)Z", "filterInPlace", "", "(Ljava/util/List;Lkotlin/Function1;Z)Z", "element", "", "minusAssign", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "(Ljava/util/Collection;Ljava/lang/Iterable;)V", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)V", "plusAssign", "Lkotlin/internal/OnlyInputTypes;", "remove", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "index", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "(Ljava/lang/Iterable;Lkotlin/Function1;)Z", "(Ljava/util/List;Lkotlin/Function1;)Z", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing$CollectionsKt__MutableCollectionsKt", "(Ljava/util/Collection;)Z", "retainNothing", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes2.dex */
public class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    public static final <T> boolean addAll(Collection<? super T> addAll, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(addAll, "$this$addAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            return addAll.addAll((Collection) elements);
        }
        boolean z = false;
        Iterator<? extends T> it = elements.iterator();
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    public static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke((T) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @InlineOnly
    public static final <T> void minusAssign(Collection<? super T> minusAssign, T t) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        minusAssign.remove(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <T> void plusAssign(Collection<? super T> plusAssign, T t) {
        Intrinsics.checkNotNullParameter(plusAssign, "$this$plusAssign");
        plusAssign.add(t);
    }

    @InlineOnly
    public static final <T> boolean remove(Collection<? extends T> collection, T t) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).remove(t);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @InlineOnly
    public static final <T> boolean removeAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).removeAll(collection2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirst(List<T> removeFirst) {
        Intrinsics.checkNotNullParameter(removeFirst, "$this$removeFirst");
        if (removeFirst.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return removeFirst.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirstOrNull(List<T> removeFirstOrNull) {
        Intrinsics.checkNotNullParameter(removeFirstOrNull, "$this$removeFirstOrNull");
        if (removeFirstOrNull.isEmpty()) {
            return null;
        }
        return removeFirstOrNull.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeLast(List<T> removeLast) {
        Intrinsics.checkNotNullParameter(removeLast, "$this$removeLast");
        if (removeLast.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return removeLast.remove(CollectionsKt__CollectionsKt.getLastIndex(removeLast));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeLastOrNull(List<T> removeLastOrNull) {
        Intrinsics.checkNotNullParameter(removeLastOrNull, "$this$removeLastOrNull");
        if (removeLastOrNull.isEmpty()) {
            return null;
        }
        return removeLastOrNull.remove(CollectionsKt__CollectionsKt.getLastIndex(removeLastOrNull));
    }

    @InlineOnly
    public static final <T> boolean retainAll(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection != null) {
            return TypeIntrinsics.asMutableCollection(collection).retainAll(collection2);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    public static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    @InlineOnly
    public static final <T> void minusAssign(Collection<? super T> minusAssign, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, iterable);
    }

    @InlineOnly
    public static final <T> void plusAssign(Collection<? super T> plusAssign, Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(plusAssign, "$this$plusAssign");
        addAll(plusAssign, iterable);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    public static final <T> T remove(List<T> list, int i2) {
        return list.remove(i2);
    }

    public static final <T> boolean removeAll(Collection<? super T> removeAll, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(removeAll, "$this$removeAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection(removeAll).removeAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(elements, removeAll));
    }

    public static final <T> boolean retainAll(Collection<? super T> retainAll, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter(retainAll, "$this$retainAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection(retainAll).retainAll(CollectionsKt__IterablesKt.convertToSetForSetOperationWith(elements, retainAll));
    }

    @InlineOnly
    public static final <T> void minusAssign(Collection<? super T> minusAssign, T[] tArr) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, tArr);
    }

    @InlineOnly
    public static final <T> void plusAssign(Collection<? super T> plusAssign, T[] tArr) {
        Intrinsics.checkNotNullParameter(plusAssign, "$this$plusAssign");
        addAll(plusAssign, tArr);
    }

    public static final <T> boolean removeAll(Collection<? super T> removeAll, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(removeAll, "$this$removeAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(elements);
        return (hashSet.isEmpty() ^ true) && removeAll.removeAll(hashSet);
    }

    public static final <T> boolean retainAll(Collection<? super T> retainAll, T[] elements) {
        Intrinsics.checkNotNullParameter(retainAll, "$this$retainAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (!(elements.length == 0)) {
            return retainAll.retainAll(ArraysKt___ArraysKt.toHashSet(elements));
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(retainAll);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    public static final <T> boolean addAll(Collection<? super T> addAll, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(addAll, "$this$addAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (addAll.add((T) it.next())) {
                z = true;
            }
        }
        return z;
    }

    @InlineOnly
    public static final <T> void minusAssign(Collection<? super T> minusAssign, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(minusAssign, "$this$minusAssign");
        removeAll(minusAssign, sequence);
    }

    @InlineOnly
    public static final <T> void plusAssign(Collection<? super T> plusAssign, Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(plusAssign, "$this$plusAssign");
        addAll(plusAssign, sequence);
    }

    public static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i2;
        if (!(list instanceof RandomAccess)) {
            if (list != null) {
                return filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable(list), function1, z);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int i3 = 0;
            i2 = 0;
            while (true) {
                T t = list.get(i3);
                if (function1.invoke(t).booleanValue() != z) {
                    if (i2 != i3) {
                        list.set(i2, t);
                    }
                    i2++;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        } else {
            i2 = 0;
        }
        if (i2 >= list.size()) {
            return false;
        }
        int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex2 < i2) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i2) {
                return true;
            }
            lastIndex2--;
        }
    }

    public static final <T> boolean removeAll(Collection<? super T> removeAll, T[] elements) {
        Intrinsics.checkNotNullParameter(removeAll, "$this$removeAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ((elements.length == 0) ^ true) && removeAll.removeAll(ArraysKt___ArraysKt.toHashSet(elements));
    }

    public static final <T> boolean addAll(Collection<? super T> addAll, T[] elements) {
        Intrinsics.checkNotNullParameter(addAll, "$this$addAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return addAll.addAll(ArraysKt___ArraysJvmKt.asList(elements));
    }

    public static final <T> boolean removeAll(Iterable<? extends T> removeAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(removeAll, "$this$removeAll");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) removeAll, (Function1) predicate, true);
    }

    public static final <T> boolean retainAll(Collection<? super T> retainAll, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter(retainAll, "$this$retainAll");
        Intrinsics.checkNotNullParameter(elements, "elements");
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(elements);
        if (!hashSet.isEmpty()) {
            return retainAll.retainAll(hashSet);
        }
        return retainNothing$CollectionsKt__MutableCollectionsKt(retainAll);
    }

    public static final <T> boolean removeAll(List<T> removeAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(removeAll, "$this$removeAll");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) removeAll, (Function1) predicate, true);
    }

    public static final <T> boolean retainAll(Iterable<? extends T> retainAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(retainAll, "$this$retainAll");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((Iterable) retainAll, (Function1) predicate, false);
    }

    public static final <T> boolean retainAll(List<T> retainAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(retainAll, "$this$retainAll");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return filterInPlace$CollectionsKt__MutableCollectionsKt((List) retainAll, (Function1) predicate, false);
    }
}
