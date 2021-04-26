package kotlin;

import com.baidu.media.duplayer.LibsInfoDef;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0001\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0000*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\r*\u00020\f2\u0006\u0010\b\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\n\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\tH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u000f*\u00020\tH\u0087\b¢\u0006\u0004\b\u0013\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u000f*\u00020\rH\u0087\b¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u0014\u0010\u0014\u001a\u00020\u000f*\u00020\rH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u001c\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u0003*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0003*\u00020\u0003H\u0087\b¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u0014\u0010\u001d\u001a\u00020\u0003*\u00020\tH\u0087\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0014\u0010\u001d\u001a\u00020\u0000*\u00020\rH\u0087\b¢\u0006\u0004\b\u001d\u0010\u001f\u001a\u0014\u0010 \u001a\u00020\u0003*\u00020\tH\u0087\b¢\u0006\u0004\b \u0010\u001e\u001a\u0014\u0010 \u001a\u00020\u0000*\u00020\rH\u0087\b¢\u0006\u0004\b \u0010\u001f¨\u0006!"}, d2 = {"", "countLeadingZeroBits", "(I)I", "", "(J)I", "countOneBits", "countTrailingZeroBits", "Lkotlin/Double$Companion;", "bits", "", "fromBits", "(Lkotlin/Double$Companion;J)D", "Lkotlin/Float$Companion;", "", "(Lkotlin/Float$Companion;I)F", "", "isFinite", "(D)Z", "(F)Z", "isInfinite", "isNaN", "bitCount", "rotateLeft", "(II)I", "(JI)J", "rotateRight", "takeHighestOneBit", "(J)J", "takeLowestOneBit", "toBits", "(D)J", "(F)I", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/NumbersKt")
/* loaded from: classes7.dex */
public class NumbersKt__NumbersJVMKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countLeadingZeroBits(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countOneBits(int i2) {
        return Integer.bitCount(i2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countTrailingZeroBits(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final double fromBits(DoubleCompanionObject doubleCompanionObject, long j) {
        return Double.longBitsToDouble(j);
    }

    @InlineOnly
    public static final boolean isFinite(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    @InlineOnly
    public static final boolean isInfinite(double d2) {
        return Double.isInfinite(d2);
    }

    @InlineOnly
    public static final boolean isNaN(double d2) {
        return Double.isNaN(d2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int rotateLeft(int i2, int i3) {
        return Integer.rotateLeft(i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final int rotateRight(int i2, int i3) {
        return Integer.rotateRight(i2, i3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int takeHighestOneBit(int i2) {
        return Integer.highestOneBit(i2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int takeLowestOneBit(int i2) {
        return Integer.lowestOneBit(i2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final long toBits(double d2) {
        return Double.doubleToLongBits(d2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final long toRawBits(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countLeadingZeroBits(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countOneBits(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final int countTrailingZeroBits(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final float fromBits(FloatCompanionObject floatCompanionObject, int i2) {
        return Float.intBitsToFloat(i2);
    }

    @InlineOnly
    public static final boolean isFinite(float f2) {
        return (Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true;
    }

    @InlineOnly
    public static final boolean isInfinite(float f2) {
        return Float.isInfinite(f2);
    }

    @InlineOnly
    public static final boolean isNaN(float f2) {
        return Float.isNaN(f2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final long rotateLeft(long j, int i2) {
        return Long.rotateLeft(j, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    public static final long rotateRight(long j, int i2) {
        return Long.rotateRight(j, i2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final long takeHighestOneBit(long j) {
        return Long.highestOneBit(j);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    public static final long takeLowestOneBit(long j) {
        return Long.lowestOneBit(j);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final int toBits(float f2) {
        return Float.floatToIntBits(f2);
    }

    @SinceKotlin(version = LibsInfoDef.CYBER_VIDEO_SR_MODEL_VERSION)
    @InlineOnly
    public static final int toRawBits(float f2) {
        return Float.floatToRawIntBits(f2);
    }
}
