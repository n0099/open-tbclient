package kotlin;

import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\r\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b\r\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"", "", "countLeadingZeroBits", "(B)I", "", "(S)I", "countOneBits", "countTrailingZeroBits", "bitCount", "rotateLeft", "(BI)B", "(SI)S", "rotateRight", "takeHighestOneBit", "(B)B", "(S)S", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/NumbersKt")
/* loaded from: classes7.dex */
public class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countLeadingZeroBits(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countOneBits(byte b2) {
        return Integer.bitCount(b2 & 255);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countTrailingZeroBits(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte rotateLeft(byte b2, int i) {
        int i2 = i & 7;
        return (byte) (((b2 & 255) >>> (8 - i2)) | (b2 << i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final short rotateLeft(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> (16 - i2)) | (s << i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte rotateRight(byte b2, int i) {
        int i2 = i & 7;
        return (byte) (((b2 & 255) >>> i2) | (b2 << (8 - i2)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final short rotateRight(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & 65535) >>> i2) | (s << (16 - i2)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final byte takeHighestOneBit(byte b2) {
        return (byte) Integer.highestOneBit(b2 & 255);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final byte takeLowestOneBit(byte b2) {
        return (byte) Integer.lowestOneBit(b2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countOneBits(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
