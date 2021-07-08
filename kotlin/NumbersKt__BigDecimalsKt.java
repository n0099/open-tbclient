package kotlin;

import com.baidu.media.duplayer.LibsInfoDef;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\t\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u0005\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u000bH\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\f\u0010\u0010\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0011H\u0087\b¢\u0006\u0004\b\f\u0010\u0012\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\f\u0010\u0013\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0014H\u0087\b¢\u0006\u0004\b\f\u0010\u0015\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\f\u0010\u0016\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0017H\u0087\b¢\u0006\u0004\b\f\u0010\u0018\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\f\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001a\u0010\u0002¨\u0006\u001b"}, d2 = {"Ljava/math/BigDecimal;", "dec", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "other", "div", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "inc", "minus", "plus", "rem", "times", "", "toBigDecimal", "(D)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(DLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(F)Ljava/math/BigDecimal;", "(FLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(I)Ljava/math/BigDecimal;", "(ILjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(J)Ljava/math/BigDecimal;", "(JLjava/math/MathContext;)Ljava/math/BigDecimal;", "unaryMinus", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/NumbersKt")
/* loaded from: classes9.dex */
public class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal dec(BigDecimal dec) {
        Intrinsics.checkNotNullParameter(dec, "$this$dec");
        BigDecimal subtract = dec.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    public static final BigDecimal div(BigDecimal div, BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(div, "$this$div");
        BigDecimal divide = div.divide(bigDecimal, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal inc(BigDecimal inc) {
        Intrinsics.checkNotNullParameter(inc, "$this$inc");
        BigDecimal add = inc.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal minus(BigDecimal minus, BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        BigDecimal subtract = minus.subtract(bigDecimal);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    public static final BigDecimal plus(BigDecimal plus, BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        BigDecimal add = plus.add(bigDecimal);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    public static final BigDecimal rem(BigDecimal rem, BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(rem, "$this$rem");
        BigDecimal remainder = rem.remainder(bigDecimal);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    public static final BigDecimal times(BigDecimal times, BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        BigDecimal multiply = times.multiply(bigDecimal);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf(i2);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @InlineOnly
    public static final BigDecimal unaryMinus(BigDecimal unaryMinus) {
        Intrinsics.checkNotNullParameter(unaryMinus, "$this$unaryMinus");
        BigDecimal negate = unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(int i2, MathContext mathContext) {
        return new BigDecimal(i2, mathContext);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final BigDecimal toBigDecimal(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigDecimal.valueOf(this)");
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
