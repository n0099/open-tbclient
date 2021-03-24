package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.media.duplayer.LibsInfoDef;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\t\u001a4\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0001H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\t\u0010\r\u001a\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\n\u001a\u001d\u0010\u000e\u001a\u0004\u0018\u00010\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0011\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u0019*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001a\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u001d*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0015\u0010 \u001a\u0004\u0018\u00010\u001d*\u00020\u0001H\u0007¢\u0006\u0004\b \u0010!\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u0001H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\u0015\u0010%\u001a\u0004\u0018\u00010\"*\u00020\u0001H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020\u0012*\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010'\u001a\u00020\u0012*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b'\u0010)\u001a\u0014\u0010+\u001a\u00020**\u00020\u0001H\u0087\b¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010+\u001a\u00020**\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b+\u0010-\u001a\u0014\u0010/\u001a\u00020.*\u00020\u0001H\u0087\b¢\u0006\u0004\b/\u00100\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b/\u00101\u001a\u001c\u00102\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b2\u00103\u001a\u001c\u00102\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b2\u00104\u001a\u001c\u00102\u001a\u00020\u0001*\u00020*2\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b2\u00105\u001a\u001c\u00102\u001a\u00020\u0001*\u00020.2\u0006\u0010\u0013\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b2\u00106¨\u00067"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "str", "Lkotlin/Function1;", "parse", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenFloatValue", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(Ljava/lang/String;Ljava/math/MathContext;)Ljava/math/BigDecimal;", "toBigDecimalOrNull", "Ljava/math/BigInteger;", "toBigInteger", "(Ljava/lang/String;)Ljava/math/BigInteger;", "", "radix", "(Ljava/lang/String;I)Ljava/math/BigInteger;", "toBigIntegerOrNull", "", "toBoolean", "(Ljava/lang/String;)Z", "", "toByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "", "toDouble", "(Ljava/lang/String;)D", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "", "toFloat", "(Ljava/lang/String;)F", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "", "toLong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "", "toShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toString", "(BI)Ljava/lang/String;", "(II)Ljava/lang/String;", "(JI)Ljava/lang/String;", "(SI)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
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
    public static final BigDecimal toBigDecimalOrNull(String str) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str);
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
    public static final BigInteger toBigIntegerOrNull(String str) {
        return toBigIntegerOrNull(str, 10);
    }

    @InlineOnly
    public static final boolean toBoolean(String str) {
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
    public static final Double toDoubleOrNull(String str) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
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
    public static final Float toFloatOrNull(String str) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
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
    public static final String toString(byte b2, int i) {
        String num = Integer.toString(b2, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i)));
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger toBigInteger(String str, int i) {
        return new BigInteger(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                    if (CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                        return null;
                    }
                }
            } else if (CharsKt__CharJVMKt.digitOf(str.charAt(0), i) < 0) {
                return null;
            }
            return new BigInteger(str, CharsKt__CharJVMKt.checkRadix(i));
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final byte toByte(String str, int i) {
        return Byte.parseByte(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int toInt(String str, int i) {
        return Integer.parseInt(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final long toLong(String str, int i) {
        return Long.parseLong(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final short toShort(String str, int i) {
        return Short.parseShort(str, CharsKt__CharJVMKt.checkRadix(i));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(short s, int i) {
        String num = Integer.toString(s, CharsKt__CharJVMKt.checkRadix(CharsKt__CharJVMKt.checkRadix(i)));
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(int i, int i2) {
        String num = Integer.toString(i, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkExpressionValueIsNotNull(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String toString(long j, int i) {
        String l = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkExpressionValueIsNotNull(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }
}
