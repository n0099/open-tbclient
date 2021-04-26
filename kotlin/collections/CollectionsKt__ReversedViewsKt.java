package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001f\u0010\n\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"T", "", "asReversed", "(Ljava/util/List;)Ljava/util/List;", "", "asReversedMutable", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "(Ljava/util/List;I)I", "reverseElementIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes7.dex */
public class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final <T> List<T> asReversed(List<? extends T> asReversed) {
        Intrinsics.checkNotNullParameter(asReversed, "$this$asReversed");
        return new ReversedListReadOnly(asReversed);
    }

    @JvmName(name = "asReversedMutable")
    public static final <T> List<T> asReversedMutable(List<T> asReversed) {
        Intrinsics.checkNotNullParameter(asReversed, "$this$asReversed");
        return new ReversedList(asReversed);
    }

    public static final int reverseElementIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i2) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i2 < 0 || lastIndex < i2) {
            throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)) + "].");
        }
        return CollectionsKt__CollectionsKt.getLastIndex(list) - i2;
    }

    public static final int reversePositionIndex$CollectionsKt__ReversedViewsKt(List<?> list, int i2) {
        int size = list.size();
        if (i2 < 0 || size < i2) {
            throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new IntRange(0, list.size()) + "].");
        }
        return list.size() - i2;
    }
}
