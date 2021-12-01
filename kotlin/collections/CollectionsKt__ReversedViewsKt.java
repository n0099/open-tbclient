package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes3.dex */
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
