package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes2.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m2013maxOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m2014maxOfJ1ME1BU(int i, int i2) {
        if (UnsignedKt.uintCompare(i, i2) < 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m2015maxOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m2016maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1004getSizeimpl = UIntArray.m1004getSizeimpl(other);
        for (int i2 = 0; i2 < m1004getSizeimpl; i2++) {
            i = m2014maxOfJ1ME1BU(i, UIntArray.m1003getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m2017maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1082getSizeimpl = ULongArray.m1082getSizeimpl(other);
        for (int i = 0; i < m1082getSizeimpl; i++) {
            j = m2022maxOfeb3DHEI(j, ULongArray.m1081getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m2020maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m926getSizeimpl = UByteArray.m926getSizeimpl(other);
        for (int i = 0; i < m926getSizeimpl; i++) {
            b = m2015maxOfKr8caGY(b, UByteArray.m925getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m2022maxOfeb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j, j2) < 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m2024maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1186getSizeimpl = UShortArray.m1186getSizeimpl(other);
        for (int i = 0; i < m1186getSizeimpl; i++) {
            s = m2013maxOf5PvTz6A(s, UShortArray.m1185getMh2AYeg(other, i));
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m2025minOf5PvTz6A(short s, short s2) {
        if (Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m2026minOfJ1ME1BU(int i, int i2) {
        if (UnsignedKt.uintCompare(i, i2) > 0) {
            return i2;
        }
        return i;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m2027minOfKr8caGY(byte b, byte b2) {
        if (Intrinsics.compare(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m2028minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1004getSizeimpl = UIntArray.m1004getSizeimpl(other);
        for (int i2 = 0; i2 < m1004getSizeimpl; i2++) {
            i = m2026minOfJ1ME1BU(i, UIntArray.m1003getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m2029minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1082getSizeimpl = ULongArray.m1082getSizeimpl(other);
        for (int i = 0; i < m1082getSizeimpl; i++) {
            j = m2034minOfeb3DHEI(j, ULongArray.m1081getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m2032minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m926getSizeimpl = UByteArray.m926getSizeimpl(other);
        for (int i = 0; i < m926getSizeimpl; i++) {
            b = m2027minOfKr8caGY(b, UByteArray.m925getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m2034minOfeb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j, j2) > 0) {
            return j2;
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m2036minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m1186getSizeimpl = UShortArray.m1186getSizeimpl(other);
        for (int i = 0; i < m1186getSizeimpl; i++) {
            s = m2025minOf5PvTz6A(s, UShortArray.m1185getMh2AYeg(other, i));
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    public static final short m2018maxOfVKSA0NQ(short s, short s2, short s3) {
        return m2013maxOf5PvTz6A(s, m2013maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    public static final int m2019maxOfWZ9TVnA(int i, int i2, int i3) {
        return m2014maxOfJ1ME1BU(i, m2014maxOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    public static final byte m2021maxOfb33U2AM(byte b, byte b2, byte b3) {
        return m2015maxOfKr8caGY(b, m2015maxOfKr8caGY(b2, b3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    public static final long m2023maxOfsambcqE(long j, long j2, long j3) {
        return m2022maxOfeb3DHEI(j, m2022maxOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    public static final short m2030minOfVKSA0NQ(short s, short s2, short s3) {
        return m2025minOf5PvTz6A(s, m2025minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    public static final int m2031minOfWZ9TVnA(int i, int i2, int i3) {
        return m2026minOfJ1ME1BU(i, m2026minOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    public static final byte m2033minOfb33U2AM(byte b, byte b2, byte b3) {
        return m2027minOfKr8caGY(b, m2027minOfKr8caGY(b2, b3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-sambcqE  reason: not valid java name */
    public static final long m2035minOfsambcqE(long j, long j2, long j3) {
        return m2034minOfeb3DHEI(j, m2034minOfeb3DHEI(j2, j3));
    }
}
