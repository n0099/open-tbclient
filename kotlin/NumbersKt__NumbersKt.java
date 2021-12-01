package kotlin;

import kotlin.internal.InlineOnly;
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\b¨\u0006\u000b"}, d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
public class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countLeadingZeroBits(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countOneBits(byte b2) {
        return Integer.bitCount(b2 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countTrailingZeroBits(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte rotateLeft(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> (8 - i3)) | (b2 << i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final short rotateLeft(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> (16 - i3)) | (s << i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte rotateRight(byte b2, int i2) {
        int i3 = i2 & 7;
        return (byte) (((b2 & 255) >>> i3) | (b2 << (8 - i3)));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final short rotateRight(short s, int i2) {
        int i3 = i2 & 15;
        return (short) (((s & 65535) >>> i3) | (s << (16 - i3)));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final byte takeHighestOneBit(byte b2) {
        return (byte) Integer.highestOneBit(b2 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final byte takeLowestOneBit(byte b2) {
        return (byte) Integer.lowestOneBit(b2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countOneBits(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
