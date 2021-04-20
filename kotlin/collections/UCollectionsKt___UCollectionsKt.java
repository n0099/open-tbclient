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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a\u001c\u0010\u000e\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00010\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00070\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\n0\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"", "Lkotlin/UByte;", "Lkotlin/UInt;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sum", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "", "Lkotlin/UByteArray;", "toUByteArray", "(Ljava/util/Collection;)[B", "Lkotlin/UIntArray;", "toUIntArray", "(Ljava/util/Collection;)[I", "Lkotlin/ULongArray;", "toULongArray", "(Ljava/util/Collection;)[J", "Lkotlin/UShortArray;", "toUShortArray", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes7.dex */
public class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(Iterable<UByte> iterable) {
        int i = 0;
        for (UByte uByte : iterable) {
            i = UInt.m717constructorimpl(i + UInt.m717constructorimpl(uByte.m691unboximpl() & 255));
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(Iterable<UInt> iterable) {
        int i = 0;
        for (UInt uInt : iterable) {
            i = UInt.m717constructorimpl(i + uInt.m760unboximpl());
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(Iterable<ULong> iterable) {
        long j = 0;
        for (ULong uLong : iterable) {
            j = ULong.m786constructorimpl(j + uLong.m829unboximpl());
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(Iterable<UShort> iterable) {
        int i = 0;
        for (UShort uShort : iterable) {
            i = UInt.m717constructorimpl(i + UInt.m717constructorimpl(uShort.m924unboximpl() & UShort.MAX_VALUE));
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] toUByteArray(Collection<UByte> collection) {
        byte[] m693constructorimpl = UByteArray.m693constructorimpl(collection.size());
        int i = 0;
        for (UByte uByte : collection) {
            UByteArray.m704setVurrAj0(m693constructorimpl, i, uByte.m691unboximpl());
            i++;
        }
        return m693constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int[] toUIntArray(Collection<UInt> collection) {
        int[] m762constructorimpl = UIntArray.m762constructorimpl(collection.size());
        int i = 0;
        for (UInt uInt : collection) {
            UIntArray.m773setVXSXFK8(m762constructorimpl, i, uInt.m760unboximpl());
            i++;
        }
        return m762constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long[] toULongArray(Collection<ULong> collection) {
        long[] m831constructorimpl = ULongArray.m831constructorimpl(collection.size());
        int i = 0;
        for (ULong uLong : collection) {
            ULongArray.m842setk8EXiF4(m831constructorimpl, i, uLong.m829unboximpl());
            i++;
        }
        return m831constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short[] toUShortArray(Collection<UShort> collection) {
        short[] m926constructorimpl = UShortArray.m926constructorimpl(collection.size());
        int i = 0;
        for (UShort uShort : collection) {
            UShortArray.m937set01HTLdE(m926constructorimpl, i, uShort.m924unboximpl());
            i++;
        }
        return m926constructorimpl;
    }
}
