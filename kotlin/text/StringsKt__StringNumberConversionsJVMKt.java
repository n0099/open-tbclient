package kotlin.text;

import com.baidu.media.duplayer.LibsInfoDef;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\t\u001a4\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0001H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\t\u0010\r\u001a\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\n\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0016\u0010\u0017\u001a\u00020\u0016*\u0004\u0018\u00010\u0001H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0014\u0010\u001b\u001a\u00020\u001a*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b\u001b\u0010\u001d\u001a\u0014\u0010\u001f\u001a\u00020\u001e*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0015\u0010!\u001a\u0004\u0018\u00010\u001e*\u00020\u0001H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u0001H\u0087\b¢\u0006\u0004\b$\u0010%\u001a\u0015\u0010&\u001a\u0004\u0018\u00010#*\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0014\u0010(\u001a\u00020\u0012*\u00020\u0001H\u0087\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010(\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b(\u0010*\u001a\u0014\u0010,\u001a\u00020+*\u00020\u0001H\u0087\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010,\u001a\u00020+*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b,\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u0001H\u0087\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00100\u001a\u00020/*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b0\u00102\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u00104\u001a\u001c\u00103\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u00105\u001a\u001c\u00103\u001a\u00020\u0001*\u00020+2\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u00106\u001a\u001c\u00103\u001a\u00020\u0001*\u00020/2\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u00107¨\u00068"}, d2 = {"T", "", "str", "Lkotlin/Function1;", "parse", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenFloatValue", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(Ljava/lang/String;Ljava/math/MathContext;)Ljava/math/BigDecimal;", "toBigDecimalOrNull", "Ljava/math/BigInteger;", "toBigInteger", "(Ljava/lang/String;)Ljava/math/BigInteger;", "", "radix", "(Ljava/lang/String;I)Ljava/math/BigInteger;", "toBigIntegerOrNull", "", "toBoolean", "(Ljava/lang/String;)Z", "toBooleanNullable", "", "toByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "", "toDouble", "(Ljava/lang/String;)D", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "", "toFloat", "(Ljava/lang/String;)F", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "", "toLong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "", "toShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toString", "(BI)Ljava/lang/String;", "(II)Ljava/lang/String;", "(JI)Ljava/lang/String;", "(SI)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes9.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return function1.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(String str) {
        return new BigDecimal(str);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigDecimal toBigDecimalOrNull(String toBigDecimalOrNull) {
        Intrinsics.checkNotNullParameter(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger toBigInteger(String str) {
        return new BigInteger(str);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigInteger toBigIntegerOrNull(String toBigIntegerOrNull) {
        Intrinsics.checkNotNullParameter(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        return toBigIntegerOrNull(toBigIntegerOrNull, 10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "toBooleanNullable")
    public static final boolean toBooleanNullable(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    public static final byte toByte(String str) {
        return Byte.parseByte(str);
    }

    @InlineOnly
    public static final double toDouble(String str) {
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    public static final Double toDoubleOrNull(String toDoubleOrNull) {
        Intrinsics.checkNotNullParameter(toDoubleOrNull, "$this$toDoubleOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble(toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    public static final float toFloat(String str) {
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    public static final Float toFloatOrNull(String toFloatOrNull) {
        Intrinsics.checkNotNullParameter(toFloatOrNull, "$this$toFloatOrNull");
        try {
            if (ScreenFloatValueRegEx.value.matches(toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat(toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    public static final int toInt(String str) {
        return Integer.parseInt(str);
    }

    @InlineOnly
    public static final long toLong(String str) {
        return Long.parseLong(str);
    }

    @InlineOnly
    public static final short toShort(String str) {
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(byte b2, int i2) {
        String num = Integer.toString(b2, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i2)));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger toBigInteger(String str, int i2) {
        return new BigInteger(str, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigInteger toBigIntegerOrNull(String toBigIntegerOrNull, int i2) {
        Intrinsics.checkNotNullParameter(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toBigIntegerOrNull.length();
        if (length != 0) {
            if (length != 1) {
                for (int i3 = toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                    if (CharsKt__CharJVMKt.digitOf(toBigIntegerOrNull.charAt(i3), i2) < 0) {
                        return null;
                    }
                }
            } else if (CharsKt__CharJVMKt.digitOf(toBigIntegerOrNull.charAt(0), i2) < 0) {
                return null;
            }
            return new BigInteger(toBigIntegerOrNull, CharsKt__CharJVMKt.checkRadix(i2));
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte toByte(String str, int i2) {
        return Byte.parseByte(str, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int toInt(String str, int i2) {
        return Integer.parseInt(str, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long toLong(String str, int i2) {
        return Long.parseLong(str, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short toShort(String str, int i2) {
        return Short.parseShort(str, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(short s, int i2) {
        String num = Integer.toString(s, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i2)));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigDecimal toBigDecimalOrNull(String toBigDecimalOrNull, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (ScreenFloatValueRegEx.value.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(int i2, int i3) {
        String num = Integer.toString(i2, CharsKt__CharJVMKt.checkRadix(i3));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(long j, int i2) {
        String l = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }
}
