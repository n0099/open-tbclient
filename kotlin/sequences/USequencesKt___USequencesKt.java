package kotlin.sequences;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "Lkotlin/UInt;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sum", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes7.dex */
public class USequencesKt___USequencesKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Sequence<UByte> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UByte uByte : sum) {
            i2 = UInt.m721constructorimpl(i2 + UInt.m721constructorimpl(uByte.m694unboximpl() & 255));
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Sequence<UInt> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UInt uInt : sum) {
            i2 = UInt.m721constructorimpl(i2 + uInt.m764unboximpl());
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Sequence<ULong> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        long j = 0;
        for (ULong uLong : sum) {
            j = ULong.m791constructorimpl(j + uLong.m834unboximpl());
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Sequence<UShort> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UShort uShort : sum) {
            i2 = UInt.m721constructorimpl(i2 + UInt.m721constructorimpl(uShort.m930unboximpl() & UShort.MAX_VALUE));
        }
        return i2;
    }
}
