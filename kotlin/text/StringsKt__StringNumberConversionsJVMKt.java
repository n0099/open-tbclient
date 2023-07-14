package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000Z\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b¢\u0006\u0002\b\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010 \u001a\u00020!*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¨\u0006%"}, d2 = {"screenFloatValue", ExifInterface.GPS_DIRECTION_TRUE, "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toBooleanNullable", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes2.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return new BigDecimal(str, mathContext);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(byte b, int i) {
        String num = Integer.toString(b, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(version = "1.2")
    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @InlineOnly
    public static final /* synthetic */ boolean toBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Boolean.parseBoolean(str);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "toBooleanNullable")
    public static final boolean toBooleanNullable(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    public static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    @InlineOnly
    public static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    public static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    public static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    @InlineOnly
    public static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    @InlineOnly
    public static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.2")
    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i2 = 1;
            }
            while (i2 < length) {
                if (CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
                i2++;
            }
        } else if (CharsKt__CharJVMKt.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        return new BigInteger(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(int i, int i2) {
        String num = Integer.toString(i, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(long j, int i) {
        String l = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l, "toString(this, checkRadix(radix))");
        return l;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(short s, int i) {
        String num = Integer.toString(s, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }
}
