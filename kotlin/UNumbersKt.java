package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0014\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0003\u001a\u0017\u0010\u0014\u001a\u00020\u0001*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0014\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0014\u001a\u00020\u0001*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u001b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001b\u001a\u00020\b*\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u001b\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001a\u001a\u001f\u0010#\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010#\u001a\u00020\b*\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010#\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010!\u001a\u0017\u0010)\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010)\u001a\u00020\u0005*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010)\u001a\u00020\b*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010)\u001a\u00020\u000b*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u00100\u001a\u00020\u0000*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b/\u0010(\u001a\u0017\u00100\u001a\u00020\u0005*\u00020\u0005H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007\u001a\u0017\u00100\u001a\u00020\b*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u0010,\u001a\u0017\u00100\u001a\u00020\u000b*\u00020\u000bH\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u0010.\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lkotlin/UByte;", "", "countLeadingZeroBits-7apg3OU", "(B)I", "countLeadingZeroBits", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits-7apg3OU", "countOneBits", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight-LxnNnR4", "rotateRight", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit-7apg3OU", "takeLowestOneBit", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "UNumbersKt")
/* loaded from: classes7.dex */
public final class UNumbersKt {
    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-7apg3OU  reason: not valid java name */
    public static final int m855countLeadingZeroBits7apg3OU(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-VKZWuLQ  reason: not valid java name */
    public static final int m856countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns  reason: not valid java name */
    public static final int m857countLeadingZeroBitsWZ4Q5Ns(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countLeadingZeroBits-xj2QHRw  reason: not valid java name */
    public static final int m858countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-7apg3OU  reason: not valid java name */
    public static final int m859countOneBits7apg3OU(byte b2) {
        return Integer.bitCount(UInt.m722constructorimpl(b2 & 255));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-VKZWuLQ  reason: not valid java name */
    public static final int m860countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-WZ4Q5Ns  reason: not valid java name */
    public static final int m861countOneBitsWZ4Q5Ns(int i2) {
        return Integer.bitCount(i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countOneBits-xj2QHRw  reason: not valid java name */
    public static final int m862countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m722constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-7apg3OU  reason: not valid java name */
    public static final int m863countTrailingZeroBits7apg3OU(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-VKZWuLQ  reason: not valid java name */
    public static final int m864countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns  reason: not valid java name */
    public static final int m865countTrailingZeroBitsWZ4Q5Ns(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: countTrailingZeroBits-xj2QHRw  reason: not valid java name */
    public static final int m866countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | UShort.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40  reason: not valid java name */
    public static final long m867rotateLeftJSWoG40(long j, int i2) {
        return ULong.m792constructorimpl(Long.rotateLeft(j, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4  reason: not valid java name */
    public static final byte m868rotateLeftLxnNnR4(byte b2, int i2) {
        return UByte.m654constructorimpl(NumbersKt__NumbersKt.rotateLeft(b2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4  reason: not valid java name */
    public static final int m869rotateLeftV7xB4Y4(int i2, int i3) {
        return UInt.m722constructorimpl(Integer.rotateLeft(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4  reason: not valid java name */
    public static final short m870rotateLeftolVBNx4(short s, int i2) {
        return UShort.m890constructorimpl(NumbersKt__NumbersKt.rotateLeft(s, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40  reason: not valid java name */
    public static final long m871rotateRightJSWoG40(long j, int i2) {
        return ULong.m792constructorimpl(Long.rotateRight(j, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4  reason: not valid java name */
    public static final byte m872rotateRightLxnNnR4(byte b2, int i2) {
        return UByte.m654constructorimpl(NumbersKt__NumbersKt.rotateRight(b2, i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4  reason: not valid java name */
    public static final int m873rotateRightV7xB4Y4(int i2, int i3) {
        return UInt.m722constructorimpl(Integer.rotateRight(i2, i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4  reason: not valid java name */
    public static final short m874rotateRightolVBNx4(short s, int i2) {
        return UShort.m890constructorimpl(NumbersKt__NumbersKt.rotateRight(s, i2));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-7apg3OU  reason: not valid java name */
    public static final byte m875takeHighestOneBit7apg3OU(byte b2) {
        return UByte.m654constructorimpl((byte) Integer.highestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-VKZWuLQ  reason: not valid java name */
    public static final long m876takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m792constructorimpl(Long.highestOneBit(j));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-WZ4Q5Ns  reason: not valid java name */
    public static final int m877takeHighestOneBitWZ4Q5Ns(int i2) {
        return UInt.m722constructorimpl(Integer.highestOneBit(i2));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeHighestOneBit-xj2QHRw  reason: not valid java name */
    public static final short m878takeHighestOneBitxj2QHRw(short s) {
        return UShort.m890constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-7apg3OU  reason: not valid java name */
    public static final byte m879takeLowestOneBit7apg3OU(byte b2) {
        return UByte.m654constructorimpl((byte) Integer.lowestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-VKZWuLQ  reason: not valid java name */
    public static final long m880takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m792constructorimpl(Long.lowestOneBit(j));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-WZ4Q5Ns  reason: not valid java name */
    public static final int m881takeLowestOneBitWZ4Q5Ns(int i2) {
        return UInt.m722constructorimpl(Integer.lowestOneBit(i2));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* renamed from: takeLowestOneBit-xj2QHRw  reason: not valid java name */
    public static final short m882takeLowestOneBitxj2QHRw(short s) {
        return UShort.m890constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }
}
