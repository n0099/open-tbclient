package kotlin;

import com.baidu.media.duplayer.LibsInfoDef;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\b\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u0003\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\f\u0010\u0003\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0087\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0087\f¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u0014\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\rH\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\u001cH\u0087\b¢\u0006\u0004\b\u001a\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\u001f\u0010\u0003¨\u0006 "}, d2 = {"Ljava/math/BigInteger;", "other", "and", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;", "dec", "(Ljava/math/BigInteger;)Ljava/math/BigInteger;", "div", "inc", "inv", "minus", "or", "plus", "rem", "", "n", "shl", "(Ljava/math/BigInteger;I)Ljava/math/BigInteger;", "shr", "times", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/math/BigInteger;)Ljava/math/BigDecimal;", "scale", "Ljava/math/MathContext;", "mathContext", "(Ljava/math/BigInteger;ILjava/math/MathContext;)Ljava/math/BigDecimal;", "toBigInteger", "(I)Ljava/math/BigInteger;", "", "(J)Ljava/math/BigInteger;", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/NumbersKt")
/* loaded from: classes10.dex */
public class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger dec(BigInteger dec) {
        Intrinsics.checkNotNullParameter(dec, "$this$dec");
        BigInteger subtract = dec.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InlineOnly
    public static final BigInteger div(BigInteger div, BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(div, "$this$div");
        BigInteger divide = div.divide(bigInteger);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger inc(BigInteger inc) {
        Intrinsics.checkNotNullParameter(inc, "$this$inc");
        BigInteger add = inc.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger inv(BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }

    @InlineOnly
    public static final BigInteger minus(BigInteger minus, BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        BigInteger subtract = minus.subtract(bigInteger);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }

    @InlineOnly
    public static final BigInteger plus(BigInteger plus, BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        BigInteger add = plus.add(bigInteger);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final BigInteger rem(BigInteger rem, BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(rem, "$this$rem");
        BigInteger remainder = rem.remainder(bigInteger);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger shl(BigInteger bigInteger, int i2) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i2);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger shr(BigInteger bigInteger, int i2) {
        BigInteger shiftRight = bigInteger.shiftRight(i2);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InlineOnly
    public static final BigInteger times(BigInteger times, BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        BigInteger multiply = times.multiply(bigInteger);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    public static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger toBigInteger(int i2) {
        BigInteger valueOf = BigInteger.valueOf(i2);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    public static final BigInteger unaryMinus(BigInteger unaryMinus) {
        Intrinsics.checkNotNullParameter(unaryMinus, "$this$unaryMinus");
        BigInteger negate = unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(BigInteger bigInteger, int i2, MathContext mathContext) {
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigInteger toBigInteger(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }
}
