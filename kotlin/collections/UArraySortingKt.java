package kotlin.collections;

import com.baidu.adp.widget.HorizontalTranslateLayout;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlin/UByteArray;", "array", "", "left", HorizontalTranslateLayout.RIGHT, "partition-4UcCI2c", "([BII)I", "partition", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "", "quickSort-4UcCI2c", "([BII)V", "quickSort", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m1067partitionnroSd4(long[] jArr, int i2, int i3) {
        long m859getsVKNKU = ULongArray.m859getsVKNKU(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.ulongCompare(ULongArray.m859getsVKNKU(jArr, i2), m859getsVKNKU) < 0) {
                i2++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m859getsVKNKU(jArr, i3), m859getsVKNKU) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long m859getsVKNKU2 = ULongArray.m859getsVKNKU(jArr, i2);
                ULongArray.m864setk8EXiF4(jArr, i2, ULongArray.m859getsVKNKU(jArr, i3));
                ULongArray.m864setk8EXiF4(jArr, i3, m859getsVKNKU2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m1068partition4UcCI2c(byte[] bArr, int i2, int i3) {
        int i4;
        byte m719getw2LRezQ = UByteArray.m719getw2LRezQ(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                i4 = m719getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m719getw2LRezQ(bArr, i2) & 255, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UByteArray.m719getw2LRezQ(bArr, i3) & 255, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte m719getw2LRezQ2 = UByteArray.m719getw2LRezQ(bArr, i2);
                UByteArray.m724setVurrAj0(bArr, i2, UByteArray.m719getw2LRezQ(bArr, i3));
                UByteArray.m724setVurrAj0(bArr, i3, m719getw2LRezQ2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m1069partitionAa5vz7o(short[] sArr, int i2, int i3) {
        int i4;
        short m955getMh2AYeg = UShortArray.m955getMh2AYeg(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m955getMh2AYeg2 = UShortArray.m955getMh2AYeg(sArr, i2) & UShort.MAX_VALUE;
                i4 = m955getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m955getMh2AYeg2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.compare(UShortArray.m955getMh2AYeg(sArr, i3) & UShort.MAX_VALUE, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short m955getMh2AYeg3 = UShortArray.m955getMh2AYeg(sArr, i2);
                UShortArray.m960set01HTLdE(sArr, i2, UShortArray.m955getMh2AYeg(sArr, i3));
                UShortArray.m960set01HTLdE(sArr, i3, m955getMh2AYeg3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m1070partitionoBK06Vg(int[] iArr, int i2, int i3) {
        int m789getpVg5ArA = UIntArray.m789getpVg5ArA(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (UnsignedKt.uintCompare(UIntArray.m789getpVg5ArA(iArr, i2), m789getpVg5ArA) < 0) {
                i2++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m789getpVg5ArA(iArr, i3), m789getpVg5ArA) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int m789getpVg5ArA2 = UIntArray.m789getpVg5ArA(iArr, i2);
                UIntArray.m794setVXSXFK8(iArr, i2, UIntArray.m789getpVg5ArA(iArr, i3));
                UIntArray.m794setVXSXFK8(iArr, i3, m789getpVg5ArA2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m1071quickSortnroSd4(long[] jArr, int i2, int i3) {
        int m1067partitionnroSd4 = m1067partitionnroSd4(jArr, i2, i3);
        int i4 = m1067partitionnroSd4 - 1;
        if (i2 < i4) {
            m1071quickSortnroSd4(jArr, i2, i4);
        }
        if (m1067partitionnroSd4 < i3) {
            m1071quickSortnroSd4(jArr, m1067partitionnroSd4, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m1072quickSort4UcCI2c(byte[] bArr, int i2, int i3) {
        int m1068partition4UcCI2c = m1068partition4UcCI2c(bArr, i2, i3);
        int i4 = m1068partition4UcCI2c - 1;
        if (i2 < i4) {
            m1072quickSort4UcCI2c(bArr, i2, i4);
        }
        if (m1068partition4UcCI2c < i3) {
            m1072quickSort4UcCI2c(bArr, m1068partition4UcCI2c, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m1073quickSortAa5vz7o(short[] sArr, int i2, int i3) {
        int m1069partitionAa5vz7o = m1069partitionAa5vz7o(sArr, i2, i3);
        int i4 = m1069partitionAa5vz7o - 1;
        if (i2 < i4) {
            m1073quickSortAa5vz7o(sArr, i2, i4);
        }
        if (m1069partitionAa5vz7o < i3) {
            m1073quickSortAa5vz7o(sArr, m1069partitionAa5vz7o, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m1074quickSortoBK06Vg(int[] iArr, int i2, int i3) {
        int m1070partitionoBK06Vg = m1070partitionoBK06Vg(iArr, i2, i3);
        int i4 = m1070partitionoBK06Vg - 1;
        if (i2 < i4) {
            m1074quickSortoBK06Vg(iArr, i2, i4);
        }
        if (m1070partitionoBK06Vg < i3) {
            m1074quickSortoBK06Vg(iArr, m1070partitionoBK06Vg, i3);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m1075sortArraynroSd4(long[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1071quickSortnroSd4(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m1076sortArray4UcCI2c(byte[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1072quickSort4UcCI2c(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m1077sortArrayAa5vz7o(short[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1073quickSortAa5vz7o(array, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m1078sortArrayoBK06Vg(int[] array, int i2, int i3) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1074quickSortoBK06Vg(array, i2, i3 - 1);
    }
}
