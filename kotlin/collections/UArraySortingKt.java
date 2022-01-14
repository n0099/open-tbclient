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
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1161partitionnroSd4(long[] jArr, int i2, int i3) {
        long m945getsVKNKU = ULongArray.m945getsVKNKU(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.ulongCompare(ULongArray.m945getsVKNKU(jArr, i2), m945getsVKNKU) < 0) {
                i2++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m945getsVKNKU(jArr, i3), m945getsVKNKU) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long m945getsVKNKU2 = ULongArray.m945getsVKNKU(jArr, i2);
                ULongArray.m950setk8EXiF4(jArr, i2, ULongArray.m945getsVKNKU(jArr, i3));
                ULongArray.m950setk8EXiF4(jArr, i3, m945getsVKNKU2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1162partition4UcCI2c(byte[] bArr, int i2, int i3) {
        int i4;
        byte m789getw2LRezQ = UByteArray.m789getw2LRezQ(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = m789getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m789getw2LRezQ(bArr, i2) & 255, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UByteArray.m789getw2LRezQ(bArr, i3) & 255, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte m789getw2LRezQ2 = UByteArray.m789getw2LRezQ(bArr, i2);
                UByteArray.m794setVurrAj0(bArr, i2, UByteArray.m789getw2LRezQ(bArr, i3));
                UByteArray.m794setVurrAj0(bArr, i3, m789getw2LRezQ2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1163partitionAa5vz7o(short[] sArr, int i2, int i3) {
        int i4;
        short m1049getMh2AYeg = UShortArray.m1049getMh2AYeg(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m1049getMh2AYeg2 = UShortArray.m1049getMh2AYeg(sArr, i2) & UShort.MAX_VALUE;
                i4 = m1049getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m1049getMh2AYeg2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UShortArray.m1049getMh2AYeg(sArr, i3) & UShort.MAX_VALUE, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short m1049getMh2AYeg3 = UShortArray.m1049getMh2AYeg(sArr, i2);
                UShortArray.m1054set01HTLdE(sArr, i2, UShortArray.m1049getMh2AYeg(sArr, i3));
                UShortArray.m1054set01HTLdE(sArr, i3, m1049getMh2AYeg3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1164partitionoBK06Vg(int[] iArr, int i2, int i3) {
        int m867getpVg5ArA = UIntArray.m867getpVg5ArA(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.uintCompare(UIntArray.m867getpVg5ArA(iArr, i2), m867getpVg5ArA) < 0) {
                i2++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m867getpVg5ArA(iArr, i3), m867getpVg5ArA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int m867getpVg5ArA2 = UIntArray.m867getpVg5ArA(iArr, i2);
                UIntArray.m872setVXSXFK8(iArr, i2, UIntArray.m867getpVg5ArA(iArr, i3));
                UIntArray.m872setVXSXFK8(iArr, i3, m867getpVg5ArA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1165quickSortnroSd4(long[] jArr, int i2, int i3) {
        int m1161partitionnroSd4 = m1161partitionnroSd4(jArr, i2, i3);
        int i4 = m1161partitionnroSd4 - 1;
        if (i2 < i4) {
            m1165quickSortnroSd4(jArr, i2, i4);
        }
        if (m1161partitionnroSd4 < i3) {
            m1165quickSortnroSd4(jArr, m1161partitionnroSd4, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1166quickSort4UcCI2c(byte[] bArr, int i2, int i3) {
        int m1162partition4UcCI2c = m1162partition4UcCI2c(bArr, i2, i3);
        int i4 = m1162partition4UcCI2c - 1;
        if (i2 < i4) {
            m1166quickSort4UcCI2c(bArr, i2, i4);
        }
        if (m1162partition4UcCI2c < i3) {
            m1166quickSort4UcCI2c(bArr, m1162partition4UcCI2c, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1167quickSortAa5vz7o(short[] sArr, int i2, int i3) {
        int m1163partitionAa5vz7o = m1163partitionAa5vz7o(sArr, i2, i3);
        int i4 = m1163partitionAa5vz7o - 1;
        if (i2 < i4) {
            m1167quickSortAa5vz7o(sArr, i2, i4);
        }
        if (m1163partitionAa5vz7o < i3) {
            m1167quickSortAa5vz7o(sArr, m1163partitionAa5vz7o, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1168quickSortoBK06Vg(int[] iArr, int i2, int i3) {
        int m1164partitionoBK06Vg = m1164partitionoBK06Vg(iArr, i2, i3);
        int i4 = m1164partitionoBK06Vg - 1;
        if (i2 < i4) {
            m1168quickSortoBK06Vg(iArr, i2, i4);
        }
        if (m1164partitionoBK06Vg < i3) {
            m1168quickSortoBK06Vg(iArr, m1164partitionoBK06Vg, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1169sortArraynroSd4(long[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1165quickSortnroSd4(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1170sortArray4UcCI2c(byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1166quickSort4UcCI2c(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1171sortArrayAa5vz7o(short[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1167quickSortAa5vz7o(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1172sortArrayoBK06Vg(int[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1168quickSortoBK06Vg(array, i2, i3 - 1);
    }
}
