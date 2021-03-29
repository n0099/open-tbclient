package kotlin.collections;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.random.Random;
@Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\bÇ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0013\u001a\u00020\u0010*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u0010*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0013\u001a\u00020\u0010*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0013\u001a\u00020\u0010*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001d\u001a\u00020\u001a*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u001d\u001a\u00020\u001a*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u001d\u001a\u00020\u001a*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001e\u0010%\u001a\u00020&*\u00020\u00012\u0006\u0010%\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001e\u0010%\u001a\u00020)*\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010%\u001a\u00020,*\u00020\n2\u0006\u0010%\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001e\u0010%\u001a\u00020/*\u00020\r2\u0006\u0010%\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020&02*\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020)02*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020,02*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020/02*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lkotlin/collections/UArraysKt;", "Lkotlin/UByteArray;", "other", "", "contentEquals-kdPth3s", "([B[B)Z", "contentEquals", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "Lkotlin/random/Random;", "random", "Lkotlin/UByte;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UArraysKt {
    public static final UArraysKt INSTANCE = new UArraysKt();

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-ctEhBpI  reason: not valid java name */
    public static final boolean m959contentEqualsctEhBpI(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-kdPth3s  reason: not valid java name */
    public static final boolean m960contentEqualskdPth3s(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-mazbYpA  reason: not valid java name */
    public static final boolean m961contentEqualsmazbYpA(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-us8wMrg  reason: not valid java name */
    public static final boolean m962contentEqualsus8wMrg(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode--ajY-9A  reason: not valid java name */
    public static final int m963contentHashCodeajY9A(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-GBYM_sE  reason: not valid java name */
    public static final int m964contentHashCodeGBYM_sE(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-QwZRm1k  reason: not valid java name */
    public static final int m965contentHashCodeQwZRm1k(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-rL5Bavg  reason: not valid java name */
    public static final int m966contentHashCoderL5Bavg(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString--ajY-9A  reason: not valid java name */
    public static final String m967contentToStringajY9A(int[] iArr) {
        return CollectionsKt___CollectionsKt.joinToString$default(UIntArray.m757boximpl(iArr), StringUtil.ARRAY_ELEMENT_SEPARATOR, "[", "]", 0, null, null, 56, null);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-GBYM_sE  reason: not valid java name */
    public static final String m968contentToStringGBYM_sE(byte[] bArr) {
        return CollectionsKt___CollectionsKt.joinToString$default(UByteArray.m688boximpl(bArr), StringUtil.ARRAY_ELEMENT_SEPARATOR, "[", "]", 0, null, null, 56, null);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-QwZRm1k  reason: not valid java name */
    public static final String m969contentToStringQwZRm1k(long[] jArr) {
        return CollectionsKt___CollectionsKt.joinToString$default(ULongArray.m826boximpl(jArr), StringUtil.ARRAY_ELEMENT_SEPARATOR, "[", "]", 0, null, null, 56, null);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentToString-rL5Bavg  reason: not valid java name */
    public static final String m970contentToStringrL5Bavg(short[] sArr) {
        return CollectionsKt___CollectionsKt.joinToString$default(UShortArray.m921boximpl(sArr), StringUtil.ARRAY_ELEMENT_SEPARATOR, "[", "]", 0, null, null, 56, null);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM  reason: not valid java name */
    public static final int m971random2D5oskM(int[] iArr, Random random) {
        if (!UIntArray.m767isEmptyimpl(iArr)) {
            return UIntArray.m764getimpl(iArr, random.nextInt(UIntArray.m765getSizeimpl(iArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA  reason: not valid java name */
    public static final long m972randomJzugnMA(long[] jArr, Random random) {
        if (!ULongArray.m836isEmptyimpl(jArr)) {
            return ULongArray.m833getimpl(jArr, random.nextInt(ULongArray.m834getSizeimpl(jArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8  reason: not valid java name */
    public static final byte m973randomoSF2wD8(byte[] bArr, Random random) {
        if (!UByteArray.m698isEmptyimpl(bArr)) {
            return UByteArray.m695getimpl(bArr, random.nextInt(UByteArray.m696getSizeimpl(bArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8  reason: not valid java name */
    public static final short m974randoms5X_as8(short[] sArr, Random random) {
        if (!UShortArray.m931isEmptyimpl(sArr)) {
            return UShortArray.m928getimpl(sArr, random.nextInt(UShortArray.m929getSizeimpl(sArr)));
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray--ajY-9A  reason: not valid java name */
    public static final UInt[] m975toTypedArrayajY9A(int[] iArr) {
        int m765getSizeimpl = UIntArray.m765getSizeimpl(iArr);
        UInt[] uIntArr = new UInt[m765getSizeimpl];
        for (int i = 0; i < m765getSizeimpl; i++) {
            uIntArr[i] = UInt.m707boximpl(UIntArray.m764getimpl(iArr, i));
        }
        return uIntArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-GBYM_sE  reason: not valid java name */
    public static final UByte[] m976toTypedArrayGBYM_sE(byte[] bArr) {
        int m696getSizeimpl = UByteArray.m696getSizeimpl(bArr);
        UByte[] uByteArr = new UByte[m696getSizeimpl];
        for (int i = 0; i < m696getSizeimpl; i++) {
            uByteArr[i] = UByte.m640boximpl(UByteArray.m695getimpl(bArr, i));
        }
        return uByteArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-QwZRm1k  reason: not valid java name */
    public static final ULong[] m977toTypedArrayQwZRm1k(long[] jArr) {
        int m834getSizeimpl = ULongArray.m834getSizeimpl(jArr);
        ULong[] uLongArr = new ULong[m834getSizeimpl];
        for (int i = 0; i < m834getSizeimpl; i++) {
            uLongArr[i] = ULong.m776boximpl(ULongArray.m833getimpl(jArr, i));
        }
        return uLongArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: toTypedArray-rL5Bavg  reason: not valid java name */
    public static final UShort[] m978toTypedArrayrL5Bavg(short[] sArr) {
        int m929getSizeimpl = UShortArray.m929getSizeimpl(sArr);
        UShort[] uShortArr = new UShort[m929getSizeimpl];
        for (int i = 0; i < m929getSizeimpl; i++) {
            uShortArr[i] = UShort.m873boximpl(UShortArray.m928getimpl(sArr, i));
        }
        return uShortArr;
    }
}
