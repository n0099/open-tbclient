package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0006\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\u0010\u001a\u00020\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0010\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0016\u0010\u0016\u001a\u00020\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0016\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u001a\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001b\u001a\u0016\u0010\u001c\u001a\u00020\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0010\u001f\u001a\u0004\u0018\u00010\n*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!\u001a\u0016\u0010\"\u001a\u00020\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001e\u0010\"\u001a\u00020\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010$\u001a\u0018\u0010%\u001a\u0004\u0018\u00010\r*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0010%\u001a\u0004\u0018\u00010\r*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlin/UByte;", "", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "toString", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "(Ljava/lang/String;)Lkotlin/UByte;", "(Ljava/lang/String;I)Lkotlin/UByte;", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "(Ljava/lang/String;)Lkotlin/UInt;", "(Ljava/lang/String;I)Lkotlin/UInt;", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "(Ljava/lang/String;)Lkotlin/ULong;", "(Ljava/lang/String;I)Lkotlin/ULong;", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "(Ljava/lang/String;)Lkotlin/UShort;", "(Ljava/lang/String;I)Lkotlin/UShort;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "UStringsKt")
/* loaded from: classes8.dex */
public final class UStringsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-JSWoG40  reason: not valid java name */
    public static final String m1882toStringJSWoG40(long j, int i2) {
        return UnsignedKt.ulongToString(j, CharsKt__CharJVMKt.checkRadix(i2));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-LxnNnR4  reason: not valid java name */
    public static final String m1883toStringLxnNnR4(byte b2, int i2) {
        String num = Integer.toString(b2 & 255, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-V7xB4Y4  reason: not valid java name */
    public static final String m1884toStringV7xB4Y4(int i2, int i3) {
        String l = Long.toString(i2 & 4294967295L, CharsKt__CharJVMKt.checkRadix(i3));
        Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: toString-olVBNx4  reason: not valid java name */
    public static final String m1885toStringolVBNx4(short s, int i2) {
        String num = Integer.toString(s & UShort.MAX_VALUE, CharsKt__CharJVMKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(String toUByte) {
        Intrinsics.checkNotNullParameter(toUByte, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(toUByte);
        if (uByteOrNull != null) {
            return uByteOrNull.m694unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUByte);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UByte toUByteOrNull(String toUByteOrNull) {
        Intrinsics.checkNotNullParameter(toUByteOrNull, "$this$toUByteOrNull");
        return toUByteOrNull(toUByteOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(String toUInt) {
        Intrinsics.checkNotNullParameter(toUInt, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(toUInt);
        if (uIntOrNull != null) {
            return uIntOrNull.m764unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUInt);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UInt toUIntOrNull(String toUIntOrNull) {
        Intrinsics.checkNotNullParameter(toUIntOrNull, "$this$toUIntOrNull");
        return toUIntOrNull(toUIntOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(String toULong) {
        Intrinsics.checkNotNullParameter(toULong, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(toULong);
        if (uLongOrNull != null) {
            return uLongOrNull.m834unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toULong);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULong toULongOrNull(String toULongOrNull) {
        Intrinsics.checkNotNullParameter(toULongOrNull, "$this$toULongOrNull");
        return toULongOrNull(toULongOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(String toUShort) {
        Intrinsics.checkNotNullParameter(toUShort, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(toUShort);
        if (uShortOrNull != null) {
            return uShortOrNull.m930unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUShort);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UShort toUShortOrNull(String toUShortOrNull) {
        Intrinsics.checkNotNullParameter(toUShortOrNull, "$this$toUShortOrNull");
        return toUShortOrNull(toUShortOrNull, 10);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte toUByte(String toUByte, int i2) {
        Intrinsics.checkNotNullParameter(toUByte, "$this$toUByte");
        UByte uByteOrNull = toUByteOrNull(toUByte, i2);
        if (uByteOrNull != null) {
            return uByteOrNull.m694unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUByte);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UByte toUByteOrNull(String toUByteOrNull, int i2) {
        Intrinsics.checkNotNullParameter(toUByteOrNull, "$this$toUByteOrNull");
        UInt uIntOrNull = toUIntOrNull(toUByteOrNull, i2);
        if (uIntOrNull != null) {
            int m764unboximpl = uIntOrNull.m764unboximpl();
            if (UnsignedKt.uintCompare(m764unboximpl, UInt.m721constructorimpl(255)) > 0) {
                return null;
            }
            return UByte.m647boximpl(UByte.m653constructorimpl((byte) m764unboximpl));
        }
        return null;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int toUInt(String toUInt, int i2) {
        Intrinsics.checkNotNullParameter(toUInt, "$this$toUInt");
        UInt uIntOrNull = toUIntOrNull(toUInt, i2);
        if (uIntOrNull != null) {
            return uIntOrNull.m764unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUInt);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UInt toUIntOrNull(String toUIntOrNull, int i2) {
        Intrinsics.checkNotNullParameter(toUIntOrNull, "$this$toUIntOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toUIntOrNull.charAt(0);
        int i4 = 1;
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i4 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int m721constructorimpl = UInt.m721constructorimpl(i2);
        int i5 = 119304647;
        while (i4 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(toUIntOrNull.charAt(i4), i2);
            if (digitOf < 0) {
                return null;
            }
            if (UnsignedKt.uintCompare(i3, i5) > 0) {
                if (i5 == 119304647) {
                    i5 = UnsignedKt.m950uintDivideJ1ME1BU(-1, m721constructorimpl);
                    if (UnsignedKt.uintCompare(i3, i5) > 0) {
                    }
                }
                return null;
            }
            int m721constructorimpl2 = UInt.m721constructorimpl(i3 * m721constructorimpl);
            int m721constructorimpl3 = UInt.m721constructorimpl(UInt.m721constructorimpl(digitOf) + m721constructorimpl2);
            if (UnsignedKt.uintCompare(m721constructorimpl3, m721constructorimpl2) < 0) {
                return null;
            }
            i4++;
            i3 = m721constructorimpl3;
        }
        return UInt.m715boximpl(i3);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long toULong(String toULong, int i2) {
        Intrinsics.checkNotNullParameter(toULong, "$this$toULong");
        ULong uLongOrNull = toULongOrNull(toULong, i2);
        if (uLongOrNull != null) {
            return uLongOrNull.m834unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toULong);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final ULong toULongOrNull(String toULongOrNull, int i2) {
        int digitOf;
        Intrinsics.checkNotNullParameter(toULongOrNull, "$this$toULongOrNull");
        CharsKt__CharJVMKt.checkRadix(i2);
        int length = toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        long j = -1;
        int i3 = 0;
        char charAt = toULongOrNull.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long m791constructorimpl = ULong.m791constructorimpl(i2);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i3 < length) {
            if (CharsKt__CharJVMKt.digitOf(toULongOrNull.charAt(i3), i2) < 0) {
                return null;
            }
            if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = UnsignedKt.m952ulongDivideeb3DHEI(j, m791constructorimpl);
                    if (UnsignedKt.ulongCompare(j2, j3) > 0) {
                    }
                }
                return null;
            }
            long m791constructorimpl2 = ULong.m791constructorimpl(j2 * m791constructorimpl);
            long m791constructorimpl3 = ULong.m791constructorimpl(ULong.m791constructorimpl(UInt.m721constructorimpl(digitOf) & 4294967295L) + m791constructorimpl2);
            if (UnsignedKt.ulongCompare(m791constructorimpl3, m791constructorimpl2) < 0) {
                return null;
            }
            i3++;
            j2 = m791constructorimpl3;
            j = -1;
        }
        return ULong.m785boximpl(j2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final short toUShort(String toUShort, int i2) {
        Intrinsics.checkNotNullParameter(toUShort, "$this$toUShort");
        UShort uShortOrNull = toUShortOrNull(toUShort, i2);
        if (uShortOrNull != null) {
            return uShortOrNull.m930unboximpl();
        }
        StringsKt__StringNumberConversionsKt.numberFormatError(toUShort);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final UShort toUShortOrNull(String toUShortOrNull, int i2) {
        Intrinsics.checkNotNullParameter(toUShortOrNull, "$this$toUShortOrNull");
        UInt uIntOrNull = toUIntOrNull(toUShortOrNull, i2);
        if (uIntOrNull != null) {
            int m764unboximpl = uIntOrNull.m764unboximpl();
            if (UnsignedKt.uintCompare(m764unboximpl, UInt.m721constructorimpl(65535)) > 0) {
                return null;
            }
            return UShort.m883boximpl(UShort.m889constructorimpl((short) m764unboximpl));
        }
        return null;
    }
}
