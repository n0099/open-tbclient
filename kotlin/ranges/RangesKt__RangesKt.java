package kotlin.ranges;

import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aB\u0010\r\u001a\u00020\u0000\"\b\b\u0000\u0010\b*\u00020\u0007\"\u0018\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\t*\b\u0012\u0004\u0012\u00028\u00000\n*\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000e\u001a2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u000f*\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0014*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0013H\u0087\u0002¢\u0006\u0004\b\u0011\u0010\u0015\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0087\u0002¢\u0006\u0004\b\u0011\u0010\u0017¨\u0006\u0018"}, d2 = {"", "isPositive", "", ShaderParams.VALUE_TYPE_STEP, "", "checkStepIsPositive", "(ZLjava/lang/Number;)V", "", "T", "", "Lkotlin/ranges/ClosedRange;", "R", "element", "contains", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "", "that", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(DD)Lkotlin/ranges/ClosedFloatingPointRange;", "", "(FF)Lkotlin/ranges/ClosedFloatingPointRange;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes3.dex */
public class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z, Number step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Object;R::Ljava/lang/Iterable<+TT;>;:Lkotlin/ranges/ClosedRange<TT;>;>(TR;TT;)Z */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final boolean contains(Iterable contains, Object obj) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return obj != null && ((ClosedRange) contains).contains((Comparable) obj);
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T rangeTo, T that) {
        Intrinsics.checkNotNullParameter(rangeTo, "$this$rangeTo");
        Intrinsics.checkNotNullParameter(that, "that");
        return new ComparableRange(rangeTo, that);
    }

    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Double> rangeTo(double d2, double d3) {
        return new ClosedDoubleRange(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Float> rangeTo(float f2, float f3) {
        return new ClosedFloatRange(f2, f3);
    }
}
