package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\n\u0010\n\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\n\u0010\n\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0005\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\n\u0010\n\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0004\u001a+\u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010&\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010&\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\n\u0010\n\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010&\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00152\n\u0010\n\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010&\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u001d2\n\u0010\n\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "maxOf", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UByteArray;", "other", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf-Kr8caGY", "minOf", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes3.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m1791maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m1792maxOfJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) >= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m1793maxOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) >= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m1794maxOfMd2H83M(int i2, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i3 : other) {
            i2 = m1792maxOfJ1ME1BU(i2, i3);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m1795maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = m1800maxOfeb3DHEI(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    public static final short m1796maxOfVKSA0NQ(short s, short s2, short s3) {
        return m1791maxOf5PvTz6A(s, m1791maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    public static final int m1797maxOfWZ9TVnA(int i2, int i3, int i4) {
        return m1792maxOfJ1ME1BU(i2, m1792maxOfJ1ME1BU(i3, i4));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m1798maxOfWr6uiD8(byte b2, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b3 : other) {
            b2 = m1793maxOfKr8caGY(b2, b3);
        }
        return b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    public static final byte m1799maxOfb33U2AM(byte b2, byte b3, byte b4) {
        return m1793maxOfKr8caGY(b2, m1793maxOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m1800maxOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    public static final long m1801maxOfsambcqE(long j, long j2, long j3) {
        return m1800maxOfeb3DHEI(j, m1800maxOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m1802maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = m1791maxOf5PvTz6A(s, s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m1803minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m1804minOfJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) <= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m1805minOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) <= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m1806minOfMd2H83M(int i2, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i3 : other) {
            i2 = m1804minOfJ1ME1BU(i2, i3);
        }
        return i2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m1807minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = m1812minOfeb3DHEI(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    public static final short m1808minOfVKSA0NQ(short s, short s2, short s3) {
        return m1803minOf5PvTz6A(s, m1803minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    public static final int m1809minOfWZ9TVnA(int i2, int i3, int i4) {
        return m1804minOfJ1ME1BU(i2, m1804minOfJ1ME1BU(i3, i4));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m1810minOfWr6uiD8(byte b2, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b3 : other) {
            b2 = m1805minOfKr8caGY(b2, b3);
        }
        return b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    public static final byte m1811minOfb33U2AM(byte b2, byte b3, byte b4) {
        return m1805minOfKr8caGY(b2, m1805minOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m1812minOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-sambcqE  reason: not valid java name */
    public static final long m1813minOfsambcqE(long j, long j2, long j3) {
        return m1812minOfeb3DHEI(j, m1812minOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m1814minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = m1803minOf5PvTz6A(s, s2);
        }
        return s;
    }
}
