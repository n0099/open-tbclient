package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a/\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/UByte;", "init", "Lkotlin/UByteArray;", "UByteArray", "(ILkotlin/jvm/functions/Function1;)[B", "elements", "ubyteArrayOf-GBYM_sE", "([B)[B", "ubyteArrayOf", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UByteArrayKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    public static final byte[] UByteArray(int i, Function1<? super Integer, UByte> function1) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = function1.invoke(Integer.valueOf(i2)).m691unboximpl();
        }
        return UByteArray.m694constructorimpl(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: ubyteArrayOf-GBYM_sE  reason: not valid java name */
    public static final byte[] m709ubyteArrayOfGBYM_sE(byte... bArr) {
        return bArr;
    }
}
