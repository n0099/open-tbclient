package kotlin.ranges;

import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u001a\u001e\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0004\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0004\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u001e\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u0010\u001a\u00020\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u0010\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a&\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0016\u001a\u00020\u0005*\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0016\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0016\u001a\u00020\b*\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0016\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020%*\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010(\u001a\u00020%*\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a!\u0010(\u001a\u00020%*\u0002002\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u0010(\u001a\u00020%*\u0002002\u0006\u0010$\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u001f\u0010=\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001f\u0010=\u001a\u00020@*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u001f\u0010=\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0017\u0010E\u001a\u00020\u0005*\u00020#H\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u001e\u0010E\u001a\u00020\u0005*\u00020#2\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010H\u001a\u0017\u0010E\u001a\u00020\b*\u000200H\u0087\bø\u0001\u0000¢\u0006\u0004\bE\u0010I\u001a\u001e\u0010E\u001a\u00020\b*\u0002002\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010J\u001a\u0019\u0010K\u001a\u0004\u0018\u00010\u0005*\u00020#H\u0087\bø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001a \u0010K\u001a\u0004\u0018\u00010\u0005*\u00020#2\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010M\u001a\u0019\u0010K\u001a\u0004\u0018\u00010\b*\u000200H\u0087\bø\u0001\u0000¢\u0006\u0004\bK\u0010N\u001a \u0010K\u001a\u0004\u0018\u00010\b*\u0002002\u0006\u0010E\u001a\u00020GH\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010O\u001a\u0013\u0010P\u001a\u00020:*\u00020:H\u0007¢\u0006\u0004\bP\u0010Q\u001a\u0013\u0010P\u001a\u00020@*\u00020@H\u0007¢\u0006\u0004\bP\u0010R\u001a\u001c\u0010T\u001a\u00020:*\u00020:2\u0006\u0010T\u001a\u00020SH\u0087\u0004¢\u0006\u0004\bT\u0010U\u001a\u001c\u0010T\u001a\u00020@*\u00020@2\u0006\u0010T\u001a\u00020VH\u0087\u0004¢\u0006\u0004\bT\u0010W\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u00002\u0006\u00109\u001a\u00020\u0000H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b[\u0010\\\u001a\u001f\u0010Z\u001a\u000200*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a\u001f\u0010Z\u001a\u00020#*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006a"}, d2 = {"Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn-b33U2AM", "(BBB)B", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "Lkotlin/ranges/ClosedRange;", "range", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "Lkotlin/ranges/UIntRange;", "value", "", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains", "element", "contains-biwQdVI", "(Lkotlin/ranges/UIntRange;Lkotlin/UInt;)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "(Lkotlin/ranges/ULongRange;Lkotlin/ULong;)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "to", "Lkotlin/ranges/UIntProgression;", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "(Lkotlin/ranges/UIntRange;)Lkotlin/UInt;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)Lkotlin/UInt;", "(Lkotlin/ranges/ULongRange;)Lkotlin/ULong;", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)Lkotlin/ULong;", "reversed", "(Lkotlin/ranges/UIntProgression;)Lkotlin/ranges/UIntProgression;", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ranges/ULongProgression;", "", ShaderParams.VALUE_TYPE_STEP, "(Lkotlin/ranges/UIntProgression;I)Lkotlin/ranges/UIntProgression;", "", "(Lkotlin/ranges/ULongProgression;J)Lkotlin/ranges/ULongProgression;", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes3.dex */
public class URangesKt___URangesKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m1845coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m1846coerceAtLeastJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) < 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m1847coerceAtLeastKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) < 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m1848coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m1849coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m1850coerceAtMostJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) > 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m1851coerceAtMostKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) > 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m1852coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m1853coerceInJPwROB0(long j, ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m802boximpl(j), (ClosedFloatingPointRange<ULong>) range)).m851unboximpl();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.ulongCompare(j, range.getStart().m851unboximpl()) < 0 ? range.getStart().m851unboximpl() : UnsignedKt.ulongCompare(j, range.getEndInclusive().m851unboximpl()) > 0 ? range.getEndInclusive().m851unboximpl() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m1854coerceInVKSA0NQ(short s, short s2, short s3) {
        int i2 = s2 & UShort.MAX_VALUE;
        int i3 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i2, i3) <= 0) {
            int i4 = 65535 & s;
            return Intrinsics.compare(i4, i2) < 0 ? s2 : Intrinsics.compare(i4, i3) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m941toStringimpl(s3) + " is less than minimum " + UShort.m941toStringimpl(s2) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m1855coerceInWZ9TVnA(int i2, int i3, int i4) {
        if (UnsignedKt.uintCompare(i3, i4) <= 0) {
            return UnsignedKt.uintCompare(i2, i3) < 0 ? i3 : UnsignedKt.uintCompare(i2, i4) > 0 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m775toStringimpl(i4) + " is less than minimum " + UInt.m775toStringimpl(i3) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m1856coerceInb33U2AM(byte b2, byte b3, byte b4) {
        int i2 = b3 & 255;
        int i3 = b4 & 255;
        if (Intrinsics.compare(i2, i3) <= 0) {
            int i4 = b2 & 255;
            return Intrinsics.compare(i4, i2) < 0 ? b3 : Intrinsics.compare(i4, i3) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m705toStringimpl(b4) + " is less than minimum " + UByte.m705toStringimpl(b3) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m1857coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m845toStringimpl(j3) + " is less than minimum " + ULong.m845toStringimpl(j2) + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m1858coerceInwuiCnnA(int i2, ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m732boximpl(i2), (ClosedFloatingPointRange<UInt>) range)).m781unboximpl();
        }
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(i2, range.getStart().m781unboximpl()) < 0 ? range.getStart().m781unboximpl() : UnsignedKt.uintCompare(i2, range.getEndInclusive().m781unboximpl()) > 0 ? range.getEndInclusive().m781unboximpl() : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m1859contains68kG9v0(UIntRange contains, byte b2) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1836containsWZ4Q5Ns(UInt.m738constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-GYNo2lE  reason: not valid java name */
    public static final boolean m1860containsGYNo2lE(ULongRange contains, ULong uLong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uLong != null && contains.m1842containsVKZWuLQ(uLong.m851unboximpl());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m1861containsGab390E(ULongRange contains, int i2) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1842containsVKZWuLQ(ULong.m808constructorimpl(i2 & 4294967295L));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m1862containsULbyJY(ULongRange contains, byte b2) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1842containsVKZWuLQ(ULong.m808constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m1863containsZsK3CEQ(UIntRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1836containsWZ4Q5Ns(UInt.m738constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: contains-biwQdVI  reason: not valid java name */
    public static final boolean m1864containsbiwQdVI(UIntRange contains, UInt uInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return uInt != null && contains.m1836containsWZ4Q5Ns(uInt.m781unboximpl());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m1865containsfz5IDCE(UIntRange contains, long j) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return ULong.m808constructorimpl(j >>> 32) == 0 && contains.m1836containsWZ4Q5Ns(UInt.m738constructorimpl((int) j));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m1866containsuhHAxoY(ULongRange contains, short s) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1842containsVKZWuLQ(ULong.m808constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m1867downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m1835fromClosedRangeNkh28Cs(UInt.m738constructorimpl(s & UShort.MAX_VALUE), UInt.m738constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m1868downToJ1ME1BU(int i2, int i3) {
        return UIntProgression.Companion.m1835fromClosedRangeNkh28Cs(i2, i3, -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m1869downToKr8caGY(byte b2, byte b3) {
        return UIntProgression.Companion.m1835fromClosedRangeNkh28Cs(UInt.m738constructorimpl(b2 & 255), UInt.m738constructorimpl(b3 & 255), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m1870downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m1841fromClosedRange7ftBX0g(j, j2, -1L);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final int random(UIntRange uIntRange) {
        return random(uIntRange, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final UInt randomOrNull(UIntRange uIntRange) {
        return randomOrNull(uIntRange, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression reversed(UIntProgression reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return UIntProgression.Companion.m1835fromClosedRangeNkh28Cs(reversed.m1834getLastpVg5ArA(), reversed.m1833getFirstpVg5ArA(), -reversed.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UIntProgression step(UIntProgression step, int i2) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(i2 > 0, Integer.valueOf(i2));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int m1833getFirstpVg5ArA = step.m1833getFirstpVg5ArA();
        int m1834getLastpVg5ArA = step.m1834getLastpVg5ArA();
        if (step.getStep() <= 0) {
            i2 = -i2;
        }
        return companion.m1835fromClosedRangeNkh28Cs(m1833getFirstpVg5ArA, m1834getLastpVg5ArA, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m1871until5PvTz6A(short s, short s2) {
        int i2 = s2 & UShort.MAX_VALUE;
        return Intrinsics.compare(i2, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m738constructorimpl(s & UShort.MAX_VALUE), UInt.m738constructorimpl(UInt.m738constructorimpl(i2) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m1872untilJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i3, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(i2, UInt.m738constructorimpl(i3 - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m1873untilKr8caGY(byte b2, byte b3) {
        int i2 = b3 & 255;
        return Intrinsics.compare(i2, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m738constructorimpl(b2 & 255), UInt.m738constructorimpl(UInt.m738constructorimpl(i2) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m1874untileb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j2, 0L) <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange(j, ULong.m808constructorimpl(j2 - ULong.m808constructorimpl(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long random(ULongRange uLongRange) {
        return random(uLongRange, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final ULong randomOrNull(ULongRange uLongRange) {
        return randomOrNull(uLongRange, Random.Default);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression reversed(ULongProgression reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return ULongProgression.Companion.m1841fromClosedRange7ftBX0g(reversed.m1840getLastsVKNKU(), reversed.m1839getFirstsVKNKU(), -reversed.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int random(UIntRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandomKt.nextUInt(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final UInt randomOrNull(UIntRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m732boximpl(URandomKt.nextUInt(random, randomOrNull));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULongProgression step(ULongProgression step, long j) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long m1839getFirstsVKNKU = step.m1839getFirstsVKNKU();
        long m1840getLastsVKNKU = step.m1840getLastsVKNKU();
        if (step.getStep() <= 0) {
            j = -j;
        }
        return companion.m1841fromClosedRange7ftBX0g(m1839getFirstsVKNKU, m1840getLastsVKNKU, j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long random(ULongRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandomKt.nextULong(random2, random);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final ULong randomOrNull(ULongRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m802boximpl(URandomKt.nextULong(random, randomOrNull));
    }
}
