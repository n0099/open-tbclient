package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1215partitionnroSd4(long[] jArr, int i, int i2) {
        long m999getsVKNKU = ULongArray.m999getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m999getsVKNKU(jArr, i), m999getsVKNKU) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m999getsVKNKU(jArr, i2), m999getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m999getsVKNKU2 = ULongArray.m999getsVKNKU(jArr, i);
                ULongArray.m1004setk8EXiF4(jArr, i, ULongArray.m999getsVKNKU(jArr, i2));
                ULongArray.m1004setk8EXiF4(jArr, i2, m999getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1216partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m843getw2LRezQ = UByteArray.m843getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m843getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m843getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m843getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m843getw2LRezQ2 = UByteArray.m843getw2LRezQ(bArr, i);
                UByteArray.m848setVurrAj0(bArr, i, UByteArray.m843getw2LRezQ(bArr, i2));
                UByteArray.m848setVurrAj0(bArr, i2, m843getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1217partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m1103getMh2AYeg = UShortArray.m1103getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m1103getMh2AYeg2 = UShortArray.m1103getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m1103getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m1103getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m1103getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m1103getMh2AYeg3 = UShortArray.m1103getMh2AYeg(sArr, i);
                UShortArray.m1108set01HTLdE(sArr, i, UShortArray.m1103getMh2AYeg(sArr, i2));
                UShortArray.m1108set01HTLdE(sArr, i2, m1103getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1218partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m921getpVg5ArA = UIntArray.m921getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m921getpVg5ArA(iArr, i), m921getpVg5ArA) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m921getpVg5ArA(iArr, i2), m921getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m921getpVg5ArA2 = UIntArray.m921getpVg5ArA(iArr, i);
                UIntArray.m926setVXSXFK8(iArr, i, UIntArray.m921getpVg5ArA(iArr, i2));
                UIntArray.m926setVXSXFK8(iArr, i2, m921getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1219quickSortnroSd4(long[] jArr, int i, int i2) {
        int m1215partitionnroSd4 = m1215partitionnroSd4(jArr, i, i2);
        int i3 = m1215partitionnroSd4 - 1;
        if (i < i3) {
            m1219quickSortnroSd4(jArr, i, i3);
        }
        if (m1215partitionnroSd4 < i2) {
            m1219quickSortnroSd4(jArr, m1215partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1220quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m1216partition4UcCI2c = m1216partition4UcCI2c(bArr, i, i2);
        int i3 = m1216partition4UcCI2c - 1;
        if (i < i3) {
            m1220quickSort4UcCI2c(bArr, i, i3);
        }
        if (m1216partition4UcCI2c < i2) {
            m1220quickSort4UcCI2c(bArr, m1216partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1221quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m1217partitionAa5vz7o = m1217partitionAa5vz7o(sArr, i, i2);
        int i3 = m1217partitionAa5vz7o - 1;
        if (i < i3) {
            m1221quickSortAa5vz7o(sArr, i, i3);
        }
        if (m1217partitionAa5vz7o < i2) {
            m1221quickSortAa5vz7o(sArr, m1217partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1222quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m1218partitionoBK06Vg = m1218partitionoBK06Vg(iArr, i, i2);
        int i3 = m1218partitionoBK06Vg - 1;
        if (i < i3) {
            m1222quickSortoBK06Vg(iArr, i, i3);
        }
        if (m1218partitionoBK06Vg < i2) {
            m1222quickSortoBK06Vg(iArr, m1218partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1223sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1219quickSortnroSd4(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1224sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1220quickSort4UcCI2c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1225sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1221quickSortAa5vz7o(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1226sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1222quickSortoBK06Vg(array, i, i2 - 1);
    }
}
