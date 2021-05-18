package kotlin.collections;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlin/UByteArray;", "array", "", CustomDialogData.POS_LEFT, "right", "partition-4UcCI2c", "([BII)I", "partition", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "", "quickSort-4UcCI2c", "([BII)V", "quickSort", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1050partitionnroSd4(long[] jArr, int i2, int i3) {
        long m842getsVKNKU = ULongArray.m842getsVKNKU(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.ulongCompare(ULongArray.m842getsVKNKU(jArr, i2), m842getsVKNKU) < 0) {
                i2++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m842getsVKNKU(jArr, i3), m842getsVKNKU) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long m842getsVKNKU2 = ULongArray.m842getsVKNKU(jArr, i2);
                ULongArray.m847setk8EXiF4(jArr, i2, ULongArray.m842getsVKNKU(jArr, i3));
                ULongArray.m847setk8EXiF4(jArr, i3, m842getsVKNKU2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1051partition4UcCI2c(byte[] bArr, int i2, int i3) {
        int i4;
        byte m702getw2LRezQ = UByteArray.m702getw2LRezQ(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = m702getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m702getw2LRezQ(bArr, i2) & 255, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UByteArray.m702getw2LRezQ(bArr, i3) & 255, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte m702getw2LRezQ2 = UByteArray.m702getw2LRezQ(bArr, i2);
                UByteArray.m707setVurrAj0(bArr, i2, UByteArray.m702getw2LRezQ(bArr, i3));
                UByteArray.m707setVurrAj0(bArr, i3, m702getw2LRezQ2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1052partitionAa5vz7o(short[] sArr, int i2, int i3) {
        int i4;
        short m938getMh2AYeg = UShortArray.m938getMh2AYeg(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m938getMh2AYeg2 = UShortArray.m938getMh2AYeg(sArr, i2) & UShort.MAX_VALUE;
                i4 = m938getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m938getMh2AYeg2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UShortArray.m938getMh2AYeg(sArr, i3) & UShort.MAX_VALUE, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short m938getMh2AYeg3 = UShortArray.m938getMh2AYeg(sArr, i2);
                UShortArray.m943set01HTLdE(sArr, i2, UShortArray.m938getMh2AYeg(sArr, i3));
                UShortArray.m943set01HTLdE(sArr, i3, m938getMh2AYeg3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1053partitionoBK06Vg(int[] iArr, int i2, int i3) {
        int m772getpVg5ArA = UIntArray.m772getpVg5ArA(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.uintCompare(UIntArray.m772getpVg5ArA(iArr, i2), m772getpVg5ArA) < 0) {
                i2++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m772getpVg5ArA(iArr, i3), m772getpVg5ArA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int m772getpVg5ArA2 = UIntArray.m772getpVg5ArA(iArr, i2);
                UIntArray.m777setVXSXFK8(iArr, i2, UIntArray.m772getpVg5ArA(iArr, i3));
                UIntArray.m777setVXSXFK8(iArr, i3, m772getpVg5ArA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1054quickSortnroSd4(long[] jArr, int i2, int i3) {
        int m1050partitionnroSd4 = m1050partitionnroSd4(jArr, i2, i3);
        int i4 = m1050partitionnroSd4 - 1;
        if (i2 < i4) {
            m1054quickSortnroSd4(jArr, i2, i4);
        }
        if (m1050partitionnroSd4 < i3) {
            m1054quickSortnroSd4(jArr, m1050partitionnroSd4, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1055quickSort4UcCI2c(byte[] bArr, int i2, int i3) {
        int m1051partition4UcCI2c = m1051partition4UcCI2c(bArr, i2, i3);
        int i4 = m1051partition4UcCI2c - 1;
        if (i2 < i4) {
            m1055quickSort4UcCI2c(bArr, i2, i4);
        }
        if (m1051partition4UcCI2c < i3) {
            m1055quickSort4UcCI2c(bArr, m1051partition4UcCI2c, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1056quickSortAa5vz7o(short[] sArr, int i2, int i3) {
        int m1052partitionAa5vz7o = m1052partitionAa5vz7o(sArr, i2, i3);
        int i4 = m1052partitionAa5vz7o - 1;
        if (i2 < i4) {
            m1056quickSortAa5vz7o(sArr, i2, i4);
        }
        if (m1052partitionAa5vz7o < i3) {
            m1056quickSortAa5vz7o(sArr, m1052partitionAa5vz7o, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1057quickSortoBK06Vg(int[] iArr, int i2, int i3) {
        int m1053partitionoBK06Vg = m1053partitionoBK06Vg(iArr, i2, i3);
        int i4 = m1053partitionoBK06Vg - 1;
        if (i2 < i4) {
            m1057quickSortoBK06Vg(iArr, i2, i4);
        }
        if (m1053partitionoBK06Vg < i3) {
            m1057quickSortoBK06Vg(iArr, m1053partitionoBK06Vg, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1058sortArraynroSd4(long[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1054quickSortnroSd4(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1059sortArray4UcCI2c(byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1055quickSort4UcCI2c(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1060sortArrayAa5vz7o(short[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1056quickSortAa5vz7o(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1061sortArrayoBK06Vg(int[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1057quickSortoBK06Vg(array, i2, i3 - 1);
    }
}
