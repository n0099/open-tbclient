package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u0000*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 \u001a\u0016\u0010!\u001a\u00020\u0007*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001e\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/UInt;", "from", "until", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkUIntRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "checkULongRangeBounds", "Lkotlin/random/Random;", "", "size", "Lkotlin/UByteArray;", "nextUBytes", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class URandomKt {
    @ExperimentalUnsignedTypes
    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m1807checkUIntRangeBoundsJ1ME1BU(int i2, int i3) {
        if (!(UnsignedKt.uintCompare(i3, i2) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m715boximpl(i2), UInt.m715boximpl(i3)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m1808checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m785boximpl(j), ULong.m785boximpl(j2)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(Random nextUBytes, int i2) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        return UByteArray.m697constructorimpl(nextUBytes.nextBytes(i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m1809nextUBytesEVgfTAA(Random nextUBytes, byte[] array) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m1810nextUBytesWvrt4B4(Random nextUBytes, byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i2, i3);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m1811nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UByteArray.m703getSizeimpl(bArr);
        }
        return m1810nextUBytesWvrt4B4(random, bArr, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(Random nextUInt) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return UInt.m721constructorimpl(nextUInt.nextInt());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m1812nextUInta8DCA5k(Random nextUInt, int i2, int i3) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m1807checkUIntRangeBoundsJ1ME1BU(i2, i3);
        return UInt.m721constructorimpl(nextUInt.nextInt(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m1813nextUIntqCasIEU(Random nextUInt, int i2) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m1812nextUInta8DCA5k(nextUInt, 0, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(Random nextULong) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return ULong.m791constructorimpl(nextULong.nextLong());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m1814nextULongV1Xi4fY(Random nextULong, long j) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m1815nextULongjmpaWc(nextULong, 0L, j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m1815nextULongjmpaWc(Random nextULong, long j, long j2) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m1808checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m791constructorimpl(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(Random nextUInt, UIntRange range) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(range.m1817getLastpVg5ArA(), -1) < 0 ? m1812nextUInta8DCA5k(nextUInt, range.m1816getFirstpVg5ArA(), UInt.m721constructorimpl(range.m1817getLastpVg5ArA() + 1)) : UnsignedKt.uintCompare(range.m1816getFirstpVg5ArA(), 0) > 0 ? UInt.m721constructorimpl(m1812nextUInta8DCA5k(nextUInt, UInt.m721constructorimpl(range.m1816getFirstpVg5ArA() - 1), range.m1817getLastpVg5ArA()) + 1) : nextUInt(nextUInt);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(Random nextULong, ULongRange range) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (UnsignedKt.ulongCompare(range.m1823getLastsVKNKU(), -1L) < 0) {
                return m1815nextULongjmpaWc(nextULong, range.m1822getFirstsVKNKU(), ULong.m791constructorimpl(range.m1823getLastsVKNKU() + ULong.m791constructorimpl(1 & 4294967295L)));
            }
            if (UnsignedKt.ulongCompare(range.m1822getFirstsVKNKU(), 0L) > 0) {
                long j = 1 & 4294967295L;
                return ULong.m791constructorimpl(m1815nextULongjmpaWc(nextULong, ULong.m791constructorimpl(range.m1822getFirstsVKNKU() - ULong.m791constructorimpl(j)), range.m1823getLastsVKNKU()) + ULong.m791constructorimpl(j));
            }
            return nextULong(nextULong);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }
}
