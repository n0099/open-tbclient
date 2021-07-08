package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\n\u001a\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"", "input", "", "numberFormatError", "(Ljava/lang/String;)Ljava/lang/Void;", "", "toByteOrNull", "(Ljava/lang/String;)Ljava/lang/Byte;", "", "radix", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "", "toLongOrNull", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "", "toShortOrNull", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes9.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String toByteOrNull) {
        Intrinsics.checkNotNullParameter(toByteOrNull, "$this$toByteOrNull");
        return toByteOrNull(toByteOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String toIntOrNull) {
        Intrinsics.checkNotNullParameter(toIntOrNull, "$this$toIntOrNull");
        return toIntOrNull(toIntOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Long toLongOrNull(String toLongOrNull) {
        Intrinsics.checkNotNullParameter(toLongOrNull, "$this$toLongOrNull");
        return toLongOrNull(toLongOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String toShortOrNull) {
        Intrinsics.checkNotNullParameter(toShortOrNull, "$this$toShortOrNull");
        return toShortOrNull(toShortOrNull, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String toByteOrNull, int i2) {
        int intValue;
        Intrinsics.checkNotNullParameter(toByteOrNull, "$this$toByteOrNull");
        Integer intOrNull = toIntOrNull(toByteOrNull, i2);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String toIntOrNull, int i2) {
        boolean z;
        int i3;
        Intrinsics.checkNotNullParameter(toIntOrNull, "$this$toIntOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = toIntOrNull.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(toIntOrNull.charAt(i6), i2);
            if (digitOf < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + digitOf) {
                return null;
            }
            i4 = i3 - digitOf;
            i6++;
        }
        if (!z) {
            i4 = -i4;
        }
        return Integer.valueOf(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    @SinceKotlin(version = "1.1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Long toLongOrNull(String toLongOrNull, int i2) {
        Intrinsics.checkNotNullParameter(toLongOrNull, "$this$toLongOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toLongOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toLongOrNull.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                i3 = 1;
                long j2 = -256204778801521550L;
                long j3 = 0;
                long j4 = -256204778801521550L;
                while (i3 < length) {
                    int digitOf = CharsKt__CharJVMKt.digitOf(toLongOrNull.charAt(i3), i2);
                    if (digitOf < 0) {
                        return null;
                    }
                    if (j3 < j4) {
                        if (j4 == j2) {
                            j4 = j / i2;
                            if (j3 < j4) {
                            }
                        }
                        return null;
                    }
                    long j5 = j3 * i2;
                    long j6 = digitOf;
                    if (j5 < j + j6) {
                        return null;
                    }
                    j3 = j5 - j6;
                    i3++;
                    j2 = -256204778801521550L;
                }
                if (!z) {
                    j3 = -j3;
                }
                return Long.valueOf(j3);
            } else if (charAt != '+') {
                return null;
            } else {
                i3 = 1;
            }
        }
        z = false;
        long j22 = -256204778801521550L;
        long j32 = 0;
        long j42 = -256204778801521550L;
        while (i3 < length) {
        }
        if (!z) {
        }
        return Long.valueOf(j32);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String toShortOrNull, int i2) {
        int intValue;
        Intrinsics.checkNotNullParameter(toShortOrNull, "$this$toShortOrNull");
        Integer intOrNull = toIntOrNull(toShortOrNull, i2);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
