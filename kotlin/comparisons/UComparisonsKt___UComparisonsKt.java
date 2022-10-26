package kotlin.comparisons;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", ImageViewerConfig.FROM_OTHER, "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes8.dex */
public class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m1861maxOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m1862maxOfJ1ME1BU(int i, int i2) {
        if (UnsignedKt.uintCompare(i, i2) < 0) {
            return i2;
        }
        return i;
    }

    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m1863maxOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m1864maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = m1862maxOfJ1ME1BU(i, i2);
        }
        return i;
    }

    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m1865maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = m1870maxOfeb3DHEI(j, j2);
        }
        return j;
    }

    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m1868maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = m1863maxOfKr8caGY(b, b2);
        }
        return b;
    }

    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m1870maxOfeb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j, j2) < 0) {
            return j2;
        }
        return j;
    }

    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m1872maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = m1861maxOf5PvTz6A(s, s2);
        }
        return s;
    }

    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m1873minOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m1874minOfJ1ME1BU(int i, int i2) {
        if (UnsignedKt.uintCompare(i, i2) > 0) {
            return i2;
        }
        return i;
    }

    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m1875minOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m1876minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = m1874minOfJ1ME1BU(i, i2);
        }
        return i;
    }

    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m1877minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = m1882minOfeb3DHEI(j, j2);
        }
        return j;
    }

    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m1880minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = m1875minOfKr8caGY(b, b2);
        }
        return b;
    }

    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m1882minOfeb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j, j2) > 0) {
            return j2;
        }
        return j;
    }

    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m1884minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s2 : other) {
            s = m1873minOf5PvTz6A(s, s2);
        }
        return s;
    }

    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    public static final short m1866maxOfVKSA0NQ(short s, short s2, short s3) {
        return m1861maxOf5PvTz6A(s, m1861maxOf5PvTz6A(s2, s3));
    }

    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    public static final int m1867maxOfWZ9TVnA(int i, int i2, int i3) {
        return m1862maxOfJ1ME1BU(i, m1862maxOfJ1ME1BU(i2, i3));
    }

    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    public static final byte m1869maxOfb33U2AM(byte b, byte b2, byte b3) {
        return m1863maxOfKr8caGY(b, m1863maxOfKr8caGY(b2, b3));
    }

    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    public static final long m1871maxOfsambcqE(long j, long j2, long j3) {
        return m1870maxOfeb3DHEI(j, m1870maxOfeb3DHEI(j2, j3));
    }

    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    public static final short m1878minOfVKSA0NQ(short s, short s2, short s3) {
        return m1873minOf5PvTz6A(s, m1873minOf5PvTz6A(s2, s3));
    }

    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    public static final int m1879minOfWZ9TVnA(int i, int i2, int i3) {
        return m1874minOfJ1ME1BU(i, m1874minOfJ1ME1BU(i2, i3));
    }

    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    public static final byte m1881minOfb33U2AM(byte b, byte b2, byte b3) {
        return m1875minOfKr8caGY(b, m1875minOfKr8caGY(b2, b3));
    }

    /* renamed from: minOf-sambcqE  reason: not valid java name */
    public static final long m1883minOfsambcqE(long j, long j2, long j3) {
        return m1882minOfeb3DHEI(j, m1882minOfeb3DHEI(j2, j3));
    }
}
