package kotlin;

import com.baidu.media.duplayer.LibsInfoDef;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u0005\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\fH\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\r\u0010\u0011\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\u0012H\u0087\b¢\u0006\u0004\b\r\u0010\u0013\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\r\u0010\u0014\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\u0015H\u0087\b¢\u0006\u0004\b\r\u0010\u0016\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\r\u0010\u0017\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\u0018H\u0087\b¢\u0006\u0004\b\r\u0010\u0019\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b\r\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001b\u0010\u0002¨\u0006\u001c"}, d2 = {"Ljava/math/BigDecimal;", "dec", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "other", "div", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "inc", "minus", "mod", "plus", "rem", "times", "", "toBigDecimal", "(D)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(DLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(F)Ljava/math/BigDecimal;", "(FLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(I)Ljava/math/BigDecimal;", "(ILjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(J)Ljava/math/BigDecimal;", "(JLjava/math/MathContext;)Ljava/math/BigDecimal;", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
public class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal dec(BigDecimal bigDecimal) {
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    public static final BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkExpressionValueIsNotNull(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal inc(BigDecimal bigDecimal) {
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(subtract, "this.subtract(other)");
        return subtract;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use rem(other) instead", replaceWith = @ReplaceWith(expression = "rem(other)", imports = {}))
    @InlineOnly
    public static final BigDecimal mod(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    public static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    public static final BigDecimal times(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkExpressionValueIsNotNull(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i) {
        BigDecimal valueOf = BigDecimal.valueOf(i);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    public static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkExpressionValueIsNotNull(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i, MathContext mathContext) {
        return new BigDecimal(i, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        return new BigDecimal(j, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(float f2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(double d2, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d2), mathContext);
    }
}
