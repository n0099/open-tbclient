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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlin/UByteArray;", "array", "", CustomDialogData.POS_LEFT, "right", "partition-4UcCI2c", "([BII)I", "partition", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "", "quickSort-4UcCI2c", "([BII)V", "quickSort", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray-GBYM_sE", "([B)V", "sortArray", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "sortArray-rL5Bavg", "([S)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4  reason: not valid java name */
    public static final int m951partitionnroSd4(long[] jArr, int i, int i2) {
        long m837getimpl = ULongArray.m837getimpl(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m837getimpl(jArr, i), m837getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m837getimpl(jArr, i2), m837getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m837getimpl2 = ULongArray.m837getimpl(jArr, i);
                ULongArray.m842setk8EXiF4(jArr, i, ULongArray.m837getimpl(jArr, i2));
                ULongArray.m842setk8EXiF4(jArr, i2, m837getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m952partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m699getimpl = UByteArray.m699getimpl(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m699getimpl & 255;
                if (Intrinsics.compare(UByteArray.m699getimpl(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m699getimpl(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m699getimpl2 = UByteArray.m699getimpl(bArr, i);
                UByteArray.m704setVurrAj0(bArr, i, UByteArray.m699getimpl(bArr, i2));
                UByteArray.m704setVurrAj0(bArr, i2, m699getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m953partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m932getimpl = UShortArray.m932getimpl(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m932getimpl2 = UShortArray.m932getimpl(sArr, i) & UShort.MAX_VALUE;
                i3 = m932getimpl & UShort.MAX_VALUE;
                if (Intrinsics.compare(m932getimpl2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m932getimpl(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m932getimpl3 = UShortArray.m932getimpl(sArr, i);
                UShortArray.m937set01HTLdE(sArr, i, UShortArray.m932getimpl(sArr, i2));
                UShortArray.m937set01HTLdE(sArr, i2, m932getimpl3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m954partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m768getimpl = UIntArray.m768getimpl(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m768getimpl(iArr, i), m768getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m768getimpl(iArr, i2), m768getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m768getimpl2 = UIntArray.m768getimpl(iArr, i);
                UIntArray.m773setVXSXFK8(iArr, i, UIntArray.m768getimpl(iArr, i2));
                UIntArray.m773setVXSXFK8(iArr, i2, m768getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m955quickSortnroSd4(long[] jArr, int i, int i2) {
        int m951partitionnroSd4 = m951partitionnroSd4(jArr, i, i2);
        int i3 = m951partitionnroSd4 - 1;
        if (i < i3) {
            m955quickSortnroSd4(jArr, i, i3);
        }
        if (m951partitionnroSd4 < i2) {
            m955quickSortnroSd4(jArr, m951partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m956quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m952partition4UcCI2c = m952partition4UcCI2c(bArr, i, i2);
        int i3 = m952partition4UcCI2c - 1;
        if (i < i3) {
            m956quickSort4UcCI2c(bArr, i, i3);
        }
        if (m952partition4UcCI2c < i2) {
            m956quickSort4UcCI2c(bArr, m952partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m957quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m953partitionAa5vz7o = m953partitionAa5vz7o(sArr, i, i2);
        int i3 = m953partitionAa5vz7o - 1;
        if (i < i3) {
            m957quickSortAa5vz7o(sArr, i, i3);
        }
        if (m953partitionAa5vz7o < i2) {
            m957quickSortAa5vz7o(sArr, m953partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m958quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m954partitionoBK06Vg = m954partitionoBK06Vg(iArr, i, i2);
        int i3 = m954partitionoBK06Vg - 1;
        if (i < i3) {
            m958quickSortoBK06Vg(iArr, i, i3);
        }
        if (m954partitionoBK06Vg < i2) {
            m958quickSortoBK06Vg(iArr, m954partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--ajY-9A  reason: not valid java name */
    public static final void m959sortArrayajY9A(int[] iArr) {
        m958quickSortoBK06Vg(iArr, 0, UIntArray.m769getSizeimpl(iArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-GBYM_sE  reason: not valid java name */
    public static final void m960sortArrayGBYM_sE(byte[] bArr) {
        m956quickSort4UcCI2c(bArr, 0, UByteArray.m700getSizeimpl(bArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-QwZRm1k  reason: not valid java name */
    public static final void m961sortArrayQwZRm1k(long[] jArr) {
        m955quickSortnroSd4(jArr, 0, ULongArray.m838getSizeimpl(jArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-rL5Bavg  reason: not valid java name */
    public static final void m962sortArrayrL5Bavg(short[] sArr) {
        m957quickSortAa5vz7o(sArr, 0, UShortArray.m933getSizeimpl(sArr) - 1);
    }
}
