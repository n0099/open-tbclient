package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\"\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\"\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0004\u001a+\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\b\u001a\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000b\u001a+\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\r\u001a\"\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0010\u001a+\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0012\u001a\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0015\u001a+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "maxOf", "c", "maxOf-b33U2AM", "(BBB)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "minOf-Kr8caGY", "minOf", "minOf-b33U2AM", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-5PvTz6A", "minOf-VKSA0NQ", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes7.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m1475maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m1476maxOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) >= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m1477maxOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) >= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    public static final short m1478maxOfVKSA0NQ(short s, short s2, short s3) {
        return m1475maxOf5PvTz6A(s, m1475maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    public static final int m1479maxOfWZ9TVnA(int i, int i2, int i3) {
        return m1476maxOfJ1ME1BU(i, m1476maxOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    public static final byte m1480maxOfb33U2AM(byte b2, byte b3, byte b4) {
        return m1477maxOfKr8caGY(b2, m1477maxOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m1481maxOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    public static final long m1482maxOfsambcqE(long j, long j2, long j3) {
        return m1481maxOfeb3DHEI(j, m1481maxOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m1483minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m1484minOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) <= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m1485minOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) <= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    public static final short m1486minOfVKSA0NQ(short s, short s2, short s3) {
        return m1483minOf5PvTz6A(s, m1483minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    public static final int m1487minOfWZ9TVnA(int i, int i2, int i3) {
        return m1484minOfJ1ME1BU(i, m1484minOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    public static final byte m1488minOfb33U2AM(byte b2, byte b3, byte b4) {
        return m1485minOfKr8caGY(b2, m1485minOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m1489minOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-sambcqE  reason: not valid java name */
    public static final long m1490minOfsambcqE(long j, long j2, long j3) {
        return m1489minOfeb3DHEI(j, m1489minOfeb3DHEI(j2, j3));
    }
}
