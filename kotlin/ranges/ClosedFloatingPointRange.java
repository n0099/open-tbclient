package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u00032\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/ClosedFloatingPointRange;", "", "T", "Lkotlin/ranges/ClosedRange;", "Lkotlin/Any;", "value", "", "contains", "(Ljava/lang/Comparable;)Z", "isEmpty", "()Z", "a", "b", "lessThanOrEquals", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(ClosedFloatingPointRange<T> closedFloatingPointRange, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), value) && closedFloatingPointRange.lessThanOrEquals(value, closedFloatingPointRange.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(ClosedFloatingPointRange<T> closedFloatingPointRange) {
            return !closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), closedFloatingPointRange.getEndInclusive());
        }
    }

    @Override // kotlin.ranges.ClosedRange
    boolean contains(T t);

    @Override // kotlin.ranges.ClosedRange
    boolean isEmpty();

    boolean lessThanOrEquals(T t, T t2);
}
