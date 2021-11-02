package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0007\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0006\u0010\b\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\t\u0010\u0003\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\f¢\u0006\u0004\b\t\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0087\f¢\u0006\u0004\b\n\u0010\u0005¨\u0006\u000b"}, d2 = {"", "other", "and", "(BB)B", "", "(SS)S", "inv", "(B)B", "(S)S", "or", "xor", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte and(byte b2, byte b3) {
        return (byte) (b2 & b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte inv(byte b2) {
        return (byte) (~b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short inv(short s) {
        return (short) (~s);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte or(byte b2, byte b3) {
        return (byte) (b2 | b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short or(short s, short s2) {
        return (short) (s | s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte xor(byte b2, byte b3) {
        return (byte) (b2 ^ b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
