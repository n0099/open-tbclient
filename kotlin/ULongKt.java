package kotlin;

import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\t\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"", "Lkotlin/ULong;", "toULong", "(B)J", "", "(D)J", "", "(F)J", "", "(I)J", "", "(J)J", "", "(S)J", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ULongKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(byte b2) {
        return ULong.m786constructorimpl(b2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(short s) {
        return ULong.m786constructorimpl(s);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(int i) {
        return ULong.m786constructorimpl(i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(long j) {
        return ULong.m786constructorimpl(j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(float f2) {
        return UnsignedKt.doubleToULong(f2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long toULong(double d2) {
        return UnsignedKt.doubleToULong(d2);
    }
}
