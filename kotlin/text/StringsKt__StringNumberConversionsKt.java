package kotlin.text;

import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes2.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toByteOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toShortOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    public static final Byte toByteOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    public static final Short toShortOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }

    @SinceKotlin(version = "1.1")
    public static final Integer toIntOrNull(String str, int i) {
        boolean z;
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        } else {
            z = false;
            i5 = 0;
        }
        int i6 = -59652323;
        while (i5 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i5), i);
            if (digitOf < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + digitOf) {
                return null;
            }
            i3 = i2 - digitOf;
            i5++;
        }
        if (z) {
            return Integer.valueOf(i3);
        }
        return Integer.valueOf(-i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    @SinceKotlin(version = "1.1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Long toLongOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int compare = Intrinsics.compare((int) charAt, 48);
        long j = C.TIME_UNSET;
        boolean z = true;
        if (compare < 0) {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                long j2 = -256204778801521550L;
                long j3 = 0;
                long j4 = -256204778801521550L;
                while (i2 < length) {
                    int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
                    if (digitOf < 0) {
                        return null;
                    }
                    if (j3 < j4) {
                        if (j4 == j2) {
                            j4 = j / i;
                            if (j3 < j4) {
                            }
                        }
                        return null;
                    }
                    long j5 = j3 * i;
                    long j6 = digitOf;
                    if (j5 < j + j6) {
                        return null;
                    }
                    j3 = j5 - j6;
                    i2++;
                    j2 = -256204778801521550L;
                }
                if (!z) {
                    return Long.valueOf(j3);
                }
                return Long.valueOf(-j3);
            } else if (charAt != '+') {
                return null;
            } else {
                i2 = 1;
            }
        }
        z = false;
        long j22 = -256204778801521550L;
        long j32 = 0;
        long j42 = -256204778801521550L;
        while (i2 < length) {
        }
        if (!z) {
        }
    }
}
