package kotlin;

import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.facebook.cache.disk.DefaultDiskStorage;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001a\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\f\u001a\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\f\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\"\u0010\u0018\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0004\b\u001e\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"", "v", "Lkotlin/UInt;", "doubleToUInt", "(D)I", "Lkotlin/ULong;", "doubleToULong", "(D)J", "", "v1", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, "uintCompare", "(II)I", "uintDivide-J1ME1BU", "uintDivide", "uintRemainder-J1ME1BU", "uintRemainder", "uintToDouble", "(I)D", "", "ulongCompare", "(JJ)I", "ulongDivide-eb3DHEI", "(JJ)J", "ulongDivide", "ulongRemainder-eb3DHEI", "ulongRemainder", "ulongToDouble", "(J)D", "", "ulongToString", "(J)Ljava/lang/String;", SchemeCollecter.CLASSIFY_BASE, "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "UnsignedKt")
/* loaded from: classes9.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d2) {
        if (!Double.isNaN(d2) && d2 > uintToDouble(0)) {
            if (d2 >= uintToDouble(-1)) {
                return -1;
            }
            double d3 = Integer.MAX_VALUE;
            if (d2 <= d3) {
                return UInt.m735constructorimpl((int) d2);
            }
            return UInt.m735constructorimpl(UInt.m735constructorimpl((int) (d2 - d3)) + UInt.m735constructorimpl(Integer.MAX_VALUE));
        }
        return 0;
    }

    @PublishedApi
    public static final long doubleToULong(double d2) {
        if (!Double.isNaN(d2) && d2 > ulongToDouble(0L)) {
            if (d2 >= ulongToDouble(-1L)) {
                return -1L;
            }
            if (d2 < Long.MAX_VALUE) {
                return ULong.m805constructorimpl((long) d2);
            }
            return ULong.m805constructorimpl(ULong.m805constructorimpl((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
        }
        return 0L;
    }

    @PublishedApi
    public static final int uintCompare(int i2, int i3) {
        return Intrinsics.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m964uintDivideJ1ME1BU(int i2, int i3) {
        return UInt.m735constructorimpl((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m965uintRemainderJ1ME1BU(int i2, int i3) {
        return UInt.m735constructorimpl((int) ((i2 & 4294967295L) % (i3 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i2) {
        return (Integer.MAX_VALUE & i2) + (((i2 >>> 31) << 30) * 2);
    }

    @PublishedApi
    public static final int ulongCompare(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m966ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? ULong.m805constructorimpl(0L) : ULong.m805constructorimpl(1L);
        } else if (j >= 0) {
            return ULong.m805constructorimpl(j / j2);
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            return ULong.m805constructorimpl(j3 + (ulongCompare(ULong.m805constructorimpl(j - (j3 * j2)), ULong.m805constructorimpl(j2)) < 0 ? 0 : 1));
        }
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m967ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? j : ULong.m805constructorimpl(j - j2);
        } else if (j >= 0) {
            return ULong.m805constructorimpl(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (ulongCompare(ULong.m805constructorimpl(j3), ULong.m805constructorimpl(j2)) < 0) {
                j2 = 0;
            }
            return ULong.m805constructorimpl(j3 - j2);
        }
    }

    @PublishedApi
    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    public static final String ulongToString(long j, int i2) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i2));
            Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i2;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        String l3 = Long.toString(j4, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}
