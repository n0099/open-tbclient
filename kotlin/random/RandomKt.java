package kotlin.random;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.bdtask.model.response.NextActive;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", "", "", "boundsErrorMessage", "", "from", "", NextActive.keyUtil, "checkRangeBounds", "", "", "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RandomKt {
    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    @SinceKotlin(version = "1.3")
    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    public static final int fastLog2(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(version = "1.3")
    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final String boundsErrorMessage(Object from, Object until) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(until, "until");
        return "Random range is empty: [" + from + StringUtil.ARRAY_ELEMENT_SEPARATOR + until + ").";
    }

    public static final void checkRangeBounds(double d, double d2) {
        boolean z;
        if (d2 > d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
    }

    public static final void checkRangeBounds(int i, int i2) {
        boolean z;
        if (i2 > i) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
    }

    public static final void checkRangeBounds(long j, long j2) {
        boolean z;
        if (j2 > j) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
    }

    @SinceKotlin(version = "1.3")
    public static final int nextInt(Random random, IntRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (range.getLast() < Integer.MAX_VALUE) {
                return random.nextInt(range.getFirst(), range.getLast() + 1);
            }
            if (range.getFirst() > Integer.MIN_VALUE) {
                return random.nextInt(range.getFirst() - 1, range.getLast()) + 1;
            }
            return random.nextInt();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    public static final long nextLong(Random random, LongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (range.getLast() < Long.MAX_VALUE) {
                return random.nextLong(range.getFirst(), range.getLast() + 1);
            }
            if (range.getFirst() > Long.MIN_VALUE) {
                return random.nextLong(range.getFirst() - 1, range.getLast()) + 1;
            }
            return random.nextLong();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }
}
