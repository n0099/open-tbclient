package kotlin.collections;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a\u001c\u0010\u000e\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00010\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00070\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\n0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"", "Lkotlin/UByte;", "Lkotlin/UInt;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sum", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "", "Lkotlin/UByteArray;", "toUByteArray", "(Ljava/util/Collection;)[B", "Lkotlin/UIntArray;", "toUIntArray", "(Ljava/util/Collection;)[I", "Lkotlin/ULongArray;", "toULongArray", "(Ljava/util/Collection;)[J", "Lkotlin/UShortArray;", "toUShortArray", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes10.dex */
public class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<UByte> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UByte uByte : sum) {
            i2 = UInt.m735constructorimpl(i2 + UInt.m735constructorimpl(uByte.m708unboximpl() & 255));
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<UInt> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UInt uInt : sum) {
            i2 = UInt.m735constructorimpl(i2 + uInt.m778unboximpl());
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Iterable<ULong> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        long j = 0;
        for (ULong uLong : sum) {
            j = ULong.m805constructorimpl(j + uLong.m848unboximpl());
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<UShort> sum) {
        Intrinsics.checkNotNullParameter(sum, "$this$sum");
        int i2 = 0;
        for (UShort uShort : sum) {
            i2 = UInt.m735constructorimpl(i2 + UInt.m735constructorimpl(uShort.m944unboximpl() & UShort.MAX_VALUE));
        }
        return i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(Collection<UByte> toUByteArray) {
        Intrinsics.checkNotNullParameter(toUByteArray, "$this$toUByteArray");
        byte[] m710constructorimpl = UByteArray.m710constructorimpl(toUByteArray.size());
        int i2 = 0;
        for (UByte uByte : toUByteArray) {
            UByteArray.m721setVurrAj0(m710constructorimpl, i2, uByte.m708unboximpl());
            i2++;
        }
        return m710constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(Collection<UInt> toUIntArray) {
        Intrinsics.checkNotNullParameter(toUIntArray, "$this$toUIntArray");
        int[] m780constructorimpl = UIntArray.m780constructorimpl(toUIntArray.size());
        int i2 = 0;
        for (UInt uInt : toUIntArray) {
            UIntArray.m791setVXSXFK8(m780constructorimpl, i2, uInt.m778unboximpl());
            i2++;
        }
        return m780constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(Collection<ULong> toULongArray) {
        Intrinsics.checkNotNullParameter(toULongArray, "$this$toULongArray");
        long[] m850constructorimpl = ULongArray.m850constructorimpl(toULongArray.size());
        int i2 = 0;
        for (ULong uLong : toULongArray) {
            ULongArray.m861setk8EXiF4(m850constructorimpl, i2, uLong.m848unboximpl());
            i2++;
        }
        return m850constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(Collection<UShort> toUShortArray) {
        Intrinsics.checkNotNullParameter(toUShortArray, "$this$toUShortArray");
        short[] m946constructorimpl = UShortArray.m946constructorimpl(toUShortArray.size());
        int i2 = 0;
        for (UShort uShort : toUShortArray) {
            UShortArray.m957set01HTLdE(m946constructorimpl, i2, uShort.m944unboximpl());
            i2++;
        }
        return m946constructorimpl;
    }
}
