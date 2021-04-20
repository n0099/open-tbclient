package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u0000*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u0018\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 \u001a\u0016\u0010!\u001a\u00020\u0007*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001e\u0010!\u001a\u00020\u0007*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/UInt;", "from", "until", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkUIntRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "checkULongRangeBounds", "Lkotlin/random/Random;", "", "size", "Lkotlin/UByteArray;", "nextUBytes", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class URandomKt {
    @ExperimentalUnsignedTypes
    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m1499checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (!(UnsignedKt.uintCompare(i2, i) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m711boximpl(i), UInt.m711boximpl(i2)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m1500checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m780boximpl(j), ULong.m780boximpl(j2)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(Random random, int i) {
        return UByteArray.m694constructorimpl(random.nextBytes(i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m1501nextUBytesEVgfTAA(Random random, byte[] bArr) {
        random.nextBytes(bArr);
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m1502nextUBytesWvrt4B4(Random random, byte[] bArr, int i, int i2) {
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m1503nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m700getSizeimpl(bArr);
        }
        return m1502nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(Random random) {
        return UInt.m717constructorimpl(random.nextInt());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m1504nextUInta8DCA5k(Random random, int i, int i2) {
        m1499checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m717constructorimpl(random.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m1505nextUIntqCasIEU(Random random, int i) {
        return m1504nextUInta8DCA5k(random, 0, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(Random random) {
        return ULong.m786constructorimpl(random.nextLong());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m1506nextULongV1Xi4fY(Random random, long j) {
        return m1507nextULongjmpaWc(random, 0L, j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m1507nextULongjmpaWc(Random random, long j, long j2) {
        m1500checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m786constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(Random random, UIntRange uIntRange) {
        if (!uIntRange.isEmpty()) {
            return UnsignedKt.uintCompare(uIntRange.getLast(), -1) < 0 ? m1504nextUInta8DCA5k(random, uIntRange.getFirst(), UInt.m717constructorimpl(uIntRange.getLast() + 1)) : UnsignedKt.uintCompare(uIntRange.getFirst(), 0) > 0 ? UInt.m717constructorimpl(m1504nextUInta8DCA5k(random, UInt.m717constructorimpl(uIntRange.getFirst() - 1), uIntRange.getLast()) + 1) : nextUInt(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(Random random, ULongRange uLongRange) {
        if (!uLongRange.isEmpty()) {
            if (UnsignedKt.ulongCompare(uLongRange.getLast(), -1L) < 0) {
                return m1507nextULongjmpaWc(random, uLongRange.getFirst(), ULong.m786constructorimpl(uLongRange.getLast() + ULong.m786constructorimpl(1 & 4294967295L)));
            }
            if (UnsignedKt.ulongCompare(uLongRange.getFirst(), 0L) > 0) {
                long j = 1 & 4294967295L;
                return ULong.m786constructorimpl(m1507nextULongjmpaWc(random, ULong.m786constructorimpl(uLongRange.getFirst() - ULong.m786constructorimpl(j)), uLongRange.getLast()) + ULong.m786constructorimpl(j));
            }
            return nextULong(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
    }
}
