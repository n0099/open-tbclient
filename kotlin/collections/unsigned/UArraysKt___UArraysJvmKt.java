package kotlin.collections.unsigned;

import java.util.List;
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
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.internal.InlineOnly;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0018\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a2\u0010\u0018\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0018\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0018\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\"\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "asList-rL5Bavg", "([S)Ljava/util/List;", "element", "", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "index", "elementAt-PpDY95g", "([BI)B", "elementAt", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes7.dex */
public class UArraysKt___UArraysJvmKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m983asListajY9A(int[] iArr) {
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m984asListGBYM_sE(byte[] bArr) {
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m985asListQwZRm1k(long[] jArr) {
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m986asListrL5Bavg(short[] sArr) {
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m987binarySearch2fe2U9s(int[] iArr, int i, int i2, int i3) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m769getSizeimpl(iArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(iArr[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m988binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m769getSizeimpl(iArr);
        }
        return m987binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m989binarySearchEtDCXyQ(short[] sArr, short s, int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m933getSizeimpl(sArr));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(sArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m990binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m933getSizeimpl(sArr);
        }
        return m989binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m991binarySearchK6DWlUc(long[] jArr, long j, int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m838getSizeimpl(jArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(jArr[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else if (ulongCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m992binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m838getSizeimpl(jArr);
        }
        return m991binarySearchK6DWlUc(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m993binarySearchWpHrYlw(byte[] bArr, byte b2, int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m700getSizeimpl(bArr));
        int i3 = b2 & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(bArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m994binarySearchWpHrYlw$default(byte[] bArr, byte b2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m700getSizeimpl(bArr);
        }
        return m993binarySearchWpHrYlw(bArr, b2, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    public static final byte m995elementAtPpDY95g(byte[] bArr, int i) {
        return UByteArray.m699getimpl(bArr, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    public static final short m996elementAtnggk6HY(short[] sArr, int i) {
        return UShortArray.m932getimpl(sArr, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    public static final int m997elementAtqFRl0hI(int[] iArr, int i) {
        return UIntArray.m768getimpl(iArr, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    public static final long m998elementAtr7IrZao(long[] jArr, int i) {
        return ULongArray.m837getimpl(jArr, i);
    }
}
