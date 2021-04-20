package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u001a\u001e\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0004\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0004\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u001e\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u0010\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a&\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0016\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0016\u001a\u00020\b*\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0016\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020%*\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a!\u0010(\u001a\u00020%*\u0002002\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001f\u0010=\u001a\u00020@*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u001f\u0010=\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0017\u0010E\u001a\u00020\u0005*\u00020#H\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u001e\u0010E\u001a\u00020\u0005*\u00020#2\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010H\u001a\u0017\u0010E\u001a\u00020\b*\u000200H\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u0010I\u001a\u001e\u0010E\u001a\u00020\b*\u0002002\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010J\u001a\u0013\u0010K\u001a\u00020:*\u00020:H\u0007¢\u0006\u0004\bK\u0010L\u001a\u0013\u0010K\u001a\u00020@*\u00020@H\u0007¢\u0006\u0004\bK\u0010M\u001a\u001c\u0010O\u001a\u00020:*\u00020:2\u0006\u0010O\u001a\u00020NH\u0087\u0004¢\u0006\u0004\bO\u0010P\u001a\u001c\u0010O\u001a\u00020@*\u00020@2\u0006\u0010O\u001a\u00020QH\u0087\u0004¢\u0006\u0004\bO\u0010R\u001a\u001f\u0010U\u001a\u00020#*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010U\u001a\u00020#*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a\u001f\u0010U\u001a\u000200*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u001f\u0010U\u001a\u00020#*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\\"}, d2 = {"Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn-b33U2AM", "(BBB)B", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "Lkotlin/ranges/ClosedRange;", "range", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "Lkotlin/ranges/UIntRange;", "value", "", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains", "element", "contains-biwQdVI", "(Lkotlin/ranges/UIntRange;Lkotlin/UInt;)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "(Lkotlin/ranges/ULongRange;Lkotlin/ULong;)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "to", "Lkotlin/ranges/UIntProgression;", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "reversed", "(Lkotlin/ranges/UIntProgression;)Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ranges/ULongProgression;", "", "step", "(Lkotlin/ranges/UIntProgression;I)Lkotlin/ranges/UIntProgression;", "", "(Lkotlin/ranges/ULongProgression;J)Lkotlin/ranges/ULongProgression;", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes7.dex */
public class URangesKt___URangesKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m1512coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m1513coerceAtLeastJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m1514coerceAtLeastKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) < 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m1515coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m1516coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m1517coerceAtMostJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m1518coerceAtMostKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) > 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m1519coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m1520coerceInJPwROB0(long j, ClosedRange<ULong> closedRange) {
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m780boximpl(j), (ClosedFloatingPointRange<ULong>) closedRange)).m829unboximpl();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedKt.ulongCompare(j, closedRange.getStart().m829unboximpl()) < 0 ? closedRange.getStart().m829unboximpl() : UnsignedKt.ulongCompare(j, closedRange.getEndInclusive().m829unboximpl()) > 0 ? closedRange.getEndInclusive().m829unboximpl() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m1521coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            return Intrinsics.compare(i3, i) < 0 ? s2 : Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m918toStringimpl(s3) + " is less than minimum " + UShort.m918toStringimpl(s2) + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m1522coerceInWZ9TVnA(int i, int i2, int i3) {
        if (UnsignedKt.uintCompare(i2, i3) <= 0) {
            return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m754toStringimpl(i3) + " is less than minimum " + UInt.m754toStringimpl(i2) + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m1523coerceInb33U2AM(byte b2, byte b3, byte b4) {
        int i = b3 & 255;
        int i2 = b4 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b2 & 255;
            return Intrinsics.compare(i3, i) < 0 ? b3 : Intrinsics.compare(i3, i2) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m685toStringimpl(b4) + " is less than minimum " + UByte.m685toStringimpl(b3) + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m1524coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m823toStringimpl(j3) + " is less than minimum " + ULong.m823toStringimpl(j2) + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m1525coerceInwuiCnnA(int i, ClosedRange<UInt> closedRange) {
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m711boximpl(i), (ClosedFloatingPointRange<UInt>) closedRange)).m760unboximpl();
        }
        if (!closedRange.isEmpty()) {
            return UnsignedKt.uintCompare(i, closedRange.getStart().m760unboximpl()) < 0 ? closedRange.getStart().m760unboximpl() : UnsignedKt.uintCompare(i, closedRange.getEndInclusive().m760unboximpl()) > 0 ? closedRange.getEndInclusive().m760unboximpl() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + IStringUtil.EXTENSION_SEPARATOR);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m1526contains68kG9v0(UIntRange uIntRange, byte b2) {
        return uIntRange.m1509containsWZ4Q5Ns(UInt.m717constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    public static final boolean m1527containsGYNo2lE(ULongRange uLongRange, ULong uLong) {
        return uLong != null && uLongRange.m1511containsVKZWuLQ(uLong.m829unboximpl());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m1528containsGab390E(ULongRange uLongRange, int i) {
        return uLongRange.m1511containsVKZWuLQ(ULong.m786constructorimpl(i & 4294967295L));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m1529containsULbyJY(ULongRange uLongRange, byte b2) {
        return uLongRange.m1511containsVKZWuLQ(ULong.m786constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m1530containsZsK3CEQ(UIntRange uIntRange, short s) {
        return uIntRange.m1509containsWZ4Q5Ns(UInt.m717constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-biwQdVI  reason: not valid java name */
    public static final boolean m1531containsbiwQdVI(UIntRange uIntRange, UInt uInt) {
        return uInt != null && uIntRange.m1509containsWZ4Q5Ns(uInt.m760unboximpl());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m1532containsfz5IDCE(UIntRange uIntRange, long j) {
        return ULong.m786constructorimpl(j >>> 32) == 0 && uIntRange.m1509containsWZ4Q5Ns(UInt.m717constructorimpl((int) j));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m1533containsuhHAxoY(ULongRange uLongRange, short s) {
        return uLongRange.m1511containsVKZWuLQ(ULong.m786constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m1534downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m1508fromClosedRangeNkh28Cs(UInt.m717constructorimpl(s & UShort.MAX_VALUE), UInt.m717constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m1535downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m1508fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m1536downToKr8caGY(byte b2, byte b3) {
        return UIntProgression.Companion.m1508fromClosedRangeNkh28Cs(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(b3 & 255), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m1537downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m1510fromClosedRange7ftBX0g(j, j2, -1L);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final int random(UIntRange uIntRange) {
        return random(uIntRange, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression reversed(UIntProgression uIntProgression) {
        return UIntProgression.Companion.m1508fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression step(UIntProgression uIntProgression, int i) {
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m1508fromClosedRangeNkh28Cs(first, last, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m1538until5PvTz6A(short s, short s2) {
        int i = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m717constructorimpl(s & UShort.MAX_VALUE), UInt.m717constructorimpl(UInt.m717constructorimpl(i) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m1539untilJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i2, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(i, UInt.m717constructorimpl(i2 - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m1540untilKr8caGY(byte b2, byte b3) {
        int i = b3 & 255;
        return Intrinsics.compare(i, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m717constructorimpl(b2 & 255), UInt.m717constructorimpl(UInt.m717constructorimpl(i) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m1541untileb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j2, 0L) <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange(j, ULong.m786constructorimpl(j2 - ULong.m786constructorimpl(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long random(ULongRange uLongRange) {
        return random(uLongRange, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression reversed(ULongProgression uLongProgression) {
        return ULongProgression.Companion.m1510fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int random(UIntRange uIntRange, Random random) {
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression step(ULongProgression uLongProgression, long j) {
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m1510fromClosedRange7ftBX0g(first, last, j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long random(ULongRange uLongRange, Random random) {
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
