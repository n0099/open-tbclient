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
    public static final int m947partitionnroSd4(long[] jArr, int i, int i2) {
        long m833getimpl = ULongArray.m833getimpl(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m833getimpl(jArr, i), m833getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m833getimpl(jArr, i2), m833getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m833getimpl2 = ULongArray.m833getimpl(jArr, i);
                ULongArray.m838setk8EXiF4(jArr, i, ULongArray.m833getimpl(jArr, i2));
                ULongArray.m838setk8EXiF4(jArr, i2, m833getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    public static final int m948partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m695getimpl = UByteArray.m695getimpl(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m695getimpl & 255;
                if (Intrinsics.compare(UByteArray.m695getimpl(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m695getimpl(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m695getimpl2 = UByteArray.m695getimpl(bArr, i);
                UByteArray.m700setVurrAj0(bArr, i, UByteArray.m695getimpl(bArr, i2));
                UByteArray.m700setVurrAj0(bArr, i2, m695getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    public static final int m949partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m928getimpl = UShortArray.m928getimpl(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m928getimpl2 = UShortArray.m928getimpl(sArr, i) & UShort.MAX_VALUE;
                i3 = m928getimpl & UShort.MAX_VALUE;
                if (Intrinsics.compare(m928getimpl2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m928getimpl(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m928getimpl3 = UShortArray.m928getimpl(sArr, i);
                UShortArray.m933set01HTLdE(sArr, i, UShortArray.m928getimpl(sArr, i2));
                UShortArray.m933set01HTLdE(sArr, i2, m928getimpl3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    public static final int m950partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m764getimpl = UIntArray.m764getimpl(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m764getimpl(iArr, i), m764getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m764getimpl(iArr, i2), m764getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m764getimpl2 = UIntArray.m764getimpl(iArr, i);
                UIntArray.m769setVXSXFK8(iArr, i, UIntArray.m764getimpl(iArr, i2));
                UIntArray.m769setVXSXFK8(iArr, i2, m764getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    public static final void m951quickSortnroSd4(long[] jArr, int i, int i2) {
        int m947partitionnroSd4 = m947partitionnroSd4(jArr, i, i2);
        int i3 = m947partitionnroSd4 - 1;
        if (i < i3) {
            m951quickSortnroSd4(jArr, i, i3);
        }
        if (m947partitionnroSd4 < i2) {
            m951quickSortnroSd4(jArr, m947partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    public static final void m952quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m948partition4UcCI2c = m948partition4UcCI2c(bArr, i, i2);
        int i3 = m948partition4UcCI2c - 1;
        if (i < i3) {
            m952quickSort4UcCI2c(bArr, i, i3);
        }
        if (m948partition4UcCI2c < i2) {
            m952quickSort4UcCI2c(bArr, m948partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    public static final void m953quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m949partitionAa5vz7o = m949partitionAa5vz7o(sArr, i, i2);
        int i3 = m949partitionAa5vz7o - 1;
        if (i < i3) {
            m953quickSortAa5vz7o(sArr, i, i3);
        }
        if (m949partitionAa5vz7o < i2) {
            m953quickSortAa5vz7o(sArr, m949partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    public static final void m954quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m950partitionoBK06Vg = m950partitionoBK06Vg(iArr, i, i2);
        int i3 = m950partitionoBK06Vg - 1;
        if (i < i3) {
            m954quickSortoBK06Vg(iArr, i, i3);
        }
        if (m950partitionoBK06Vg < i2) {
            m954quickSortoBK06Vg(iArr, m950partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--ajY-9A  reason: not valid java name */
    public static final void m955sortArrayajY9A(int[] iArr) {
        m954quickSortoBK06Vg(iArr, 0, UIntArray.m765getSizeimpl(iArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-GBYM_sE  reason: not valid java name */
    public static final void m956sortArrayGBYM_sE(byte[] bArr) {
        m952quickSort4UcCI2c(bArr, 0, UByteArray.m696getSizeimpl(bArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-QwZRm1k  reason: not valid java name */
    public static final void m957sortArrayQwZRm1k(long[] jArr) {
        m951quickSortnroSd4(jArr, 0, ULongArray.m834getSizeimpl(jArr) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-rL5Bavg  reason: not valid java name */
    public static final void m958sortArrayrL5Bavg(short[] sArr) {
        m953quickSortAa5vz7o(sArr, 0, UShortArray.m929getSizeimpl(sArr) - 1);
    }
}
