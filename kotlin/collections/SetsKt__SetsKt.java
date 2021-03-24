package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a7\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000¢\u0006\u0004\b\u0006\u0010\n\u001a&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a7\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\f\"\u0004\b\u0000\u0010\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000¢\u0006\u0004\b\r\u0010\u000f\u001a\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0003\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0003\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "emptySet", "()Ljava/util/Set;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "hashSetOf", "()Ljava/util/HashSet;", "", "elements", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "linkedSetOf", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "(Ljava/util/Set;)Ljava/util/Set;", "orEmpty", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/SetsKt")
/* loaded from: classes7.dex */
public class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> HashSet<T> hashSetOf() {
        return new HashSet<>();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> LinkedHashSet<T> linkedSetOf() {
        return new LinkedHashSet<>();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> Set<T> mutableSetOf() {
        return new LinkedHashSet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> optimizeReadOnlySet(Set<? extends T> set) {
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : SetsKt__SetsJVMKt.setOf(set.iterator().next());
        }
        return emptySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Set<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <T> Set<T> orEmpty(Set<? extends T> set) {
        return set != 0 ? set : emptySet();
    }

    public static final <T> Set<T> setOf(T... tArr) {
        return tArr.length > 0 ? ArraysKt___ArraysKt.toSet(tArr) : emptySet();
    }

    public static final <T> HashSet<T> hashSetOf(T... tArr) {
        return (HashSet) ArraysKt___ArraysKt.toCollection(tArr, new HashSet(MapsKt__MapsKt.mapCapacity(tArr.length)));
    }

    public static final <T> LinkedHashSet<T> linkedSetOf(T... tArr) {
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt__MapsKt.mapCapacity(tArr.length)));
    }

    public static final <T> Set<T> mutableSetOf(T... tArr) {
        return (Set) ArraysKt___ArraysKt.toCollection(tArr, new LinkedHashSet(MapsKt__MapsKt.mapCapacity(tArr.length)));
    }

    @InlineOnly
    public static final <T> Set<T> setOf() {
        return emptySet();
    }
}
