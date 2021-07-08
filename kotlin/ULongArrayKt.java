package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/ULong;", "init", "Lkotlin/ULongArray;", "ULongArray", "(ILkotlin/jvm/functions/Function1;)[J", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "ulongArrayOf", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class ULongArrayKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final long[] ULongArray(int i2, Function1<? super Integer, ULong> function1) {
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = function1.invoke(Integer.valueOf(i3)).m848unboximpl();
        }
        return ULongArray.m851constructorimpl(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: ulongArrayOf-QwZRm1k  reason: not valid java name */
    public static final long[] m867ulongArrayOfQwZRm1k(long... jArr) {
        return jArr;
    }
}
