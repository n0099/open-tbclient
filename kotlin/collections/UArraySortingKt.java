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
/* loaded from: classes10.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1297partitionnroSd4(long[] jArr, int i, int i2) {
        long m1081getsVKNKU = ULongArray.m1081getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m1081getsVKNKU(jArr, i), m1081getsVKNKU) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m1081getsVKNKU(jArr, i2), m1081getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m1081getsVKNKU2 = ULongArray.m1081getsVKNKU(jArr, i);
                ULongArray.m1086setk8EXiF4(jArr, i, ULongArray.m1081getsVKNKU(jArr, i2));
                ULongArray.m1086setk8EXiF4(jArr, i2, m1081getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1298partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m925getw2LRezQ = UByteArray.m925getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m925getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m925getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m925getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m925getw2LRezQ2 = UByteArray.m925getw2LRezQ(bArr, i);
                UByteArray.m930setVurrAj0(bArr, i, UByteArray.m925getw2LRezQ(bArr, i2));
                UByteArray.m930setVurrAj0(bArr, i2, m925getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1299partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m1185getMh2AYeg = UShortArray.m1185getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m1185getMh2AYeg2 = UShortArray.m1185getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m1185getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m1185getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m1185getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m1185getMh2AYeg3 = UShortArray.m1185getMh2AYeg(sArr, i);
                UShortArray.m1190set01HTLdE(sArr, i, UShortArray.m1185getMh2AYeg(sArr, i2));
                UShortArray.m1190set01HTLdE(sArr, i2, m1185getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1300partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m1003getpVg5ArA = UIntArray.m1003getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m1003getpVg5ArA(iArr, i), m1003getpVg5ArA) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m1003getpVg5ArA(iArr, i2), m1003getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m1003getpVg5ArA2 = UIntArray.m1003getpVg5ArA(iArr, i);
                UIntArray.m1008setVXSXFK8(iArr, i, UIntArray.m1003getpVg5ArA(iArr, i2));
                UIntArray.m1008setVXSXFK8(iArr, i2, m1003getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1301quickSortnroSd4(long[] jArr, int i, int i2) {
        int m1297partitionnroSd4 = m1297partitionnroSd4(jArr, i, i2);
        int i3 = m1297partitionnroSd4 - 1;
        if (i < i3) {
            m1301quickSortnroSd4(jArr, i, i3);
        }
        if (m1297partitionnroSd4 < i2) {
            m1301quickSortnroSd4(jArr, m1297partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1302quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m1298partition4UcCI2c = m1298partition4UcCI2c(bArr, i, i2);
        int i3 = m1298partition4UcCI2c - 1;
        if (i < i3) {
            m1302quickSort4UcCI2c(bArr, i, i3);
        }
        if (m1298partition4UcCI2c < i2) {
            m1302quickSort4UcCI2c(bArr, m1298partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1303quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m1299partitionAa5vz7o = m1299partitionAa5vz7o(sArr, i, i2);
        int i3 = m1299partitionAa5vz7o - 1;
        if (i < i3) {
            m1303quickSortAa5vz7o(sArr, i, i3);
        }
        if (m1299partitionAa5vz7o < i2) {
            m1303quickSortAa5vz7o(sArr, m1299partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1304quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m1300partitionoBK06Vg = m1300partitionoBK06Vg(iArr, i, i2);
        int i3 = m1300partitionoBK06Vg - 1;
        if (i < i3) {
            m1304quickSortoBK06Vg(iArr, i, i3);
        }
        if (m1300partitionoBK06Vg < i2) {
            m1304quickSortoBK06Vg(iArr, m1300partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1305sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1301quickSortnroSd4(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1306sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1302quickSort4UcCI2c(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1307sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1303quickSortAa5vz7o(array, i, i2 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1308sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1304quickSortoBK06Vg(array, i, i2 - 1);
    }
}
