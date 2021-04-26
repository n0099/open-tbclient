package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class DecodedBitStreamParser {
    public static final int AL = 28;
    public static final int AS = 27;
    public static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    public static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    public static final int BYTE_COMPACTION_MODE_LATCH = 901;
    public static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final BigInteger[] EXP900;
    public static final int LL = 27;
    public static final int MACRO_PDF417_TERMINATOR = 922;
    public static final int MAX_NUMERIC_CODEWORDS = 15;
    public static final int ML = 28;
    public static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    public static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    public static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    public static final int PAL = 29;
    public static final int PL = 25;
    public static final int PS = 29;
    public static final int TEXT_COMPACTION_MODE_LATCH = 900;
    public static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i2++;
        }
    }

    public static int byteCompaction(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 922;
        int i8 = 923;
        int i9 = 928;
        int i10 = 902;
        long j = 900;
        if (i2 == 901) {
            int[] iArr2 = new int[6];
            i4 = i3 + 1;
            int i11 = iArr[i3];
            boolean z = false;
            loop0: while (true) {
                i5 = 0;
                long j2 = 0;
                while (i4 < iArr[0] && !z) {
                    int i12 = i5 + 1;
                    iArr2[i5] = i11;
                    j2 = (j2 * j) + i11;
                    int i13 = i4 + 1;
                    i11 = iArr[i4];
                    if (i11 == 900 || i11 == 901 || i11 == 902 || i11 == 924 || i11 == 928 || i11 == i8 || i11 == i7) {
                        i4 = i13 - 1;
                        i5 = i12;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                        z = true;
                    } else if (i12 % 5 != 0 || i12 <= 0) {
                        i4 = i13;
                        i5 = i12;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                    } else {
                        int i14 = 0;
                        while (i14 < 6) {
                            byteArrayOutputStream.write((byte) (j2 >> ((5 - i14) * 8)));
                            i14++;
                            i7 = 922;
                            i8 = 923;
                        }
                        i4 = i13;
                        j = 900;
                    }
                }
            }
            if (i4 != iArr[0] || i11 >= 900) {
                i6 = i5;
            } else {
                i6 = i5 + 1;
                iArr2[i5] = i11;
            }
            for (int i15 = 0; i15 < i6; i15++) {
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
        } else if (i2 == 924) {
            int i16 = i3;
            boolean z2 = false;
            int i17 = 0;
            long j3 = 0;
            while (i16 < iArr[0] && !z2) {
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                if (i19 < 900) {
                    i17++;
                    j3 = (j3 * 900) + i19;
                    i16 = i18;
                } else {
                    if (i19 != 900 && i19 != 901 && i19 != i10 && i19 != 924 && i19 != i9) {
                        if (i19 != 923 && i19 != 922) {
                            i16 = i18;
                        }
                    }
                    i16 = i18 - 1;
                    z2 = true;
                }
                if (i17 % 5 == 0 && i17 > 0) {
                    for (int i20 = 0; i20 < 6; i20++) {
                        byteArrayOutputStream.write((byte) (j3 >> ((5 - i20) * 8)));
                    }
                    i17 = 0;
                    j3 = 0;
                }
                i9 = 928;
                i10 = 902;
            }
            i4 = i16;
        } else {
            i4 = i3;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i2;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i3 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i4 = 2;
        while (i4 < iArr[0]) {
            if (i3 != 913) {
                switch (i3) {
                    case 900:
                        i2 = textCompaction(iArr, i4, sb);
                        break;
                    case 901:
                        i2 = byteCompaction(i3, iArr, charset, i4, sb);
                        break;
                    case 902:
                        i2 = numericCompaction(iArr, i4, sb);
                        break;
                    default:
                        switch (i3) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i2 = i4 + 1;
                                break;
                            case 926:
                                i2 = i4 + 2;
                                break;
                            case 927:
                                i2 = i4 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i4]).name());
                                break;
                            case 928:
                                i2 = decodeMacroBlock(iArr, i4, pDF417ResultMetadata);
                                break;
                            default:
                                i2 = textCompaction(iArr, i4 - 1, sb);
                                break;
                        }
                }
            } else {
                i2 = i4 + 1;
                sb.append((char) iArr[i4]);
            }
            if (i2 < iArr.length) {
                i4 = i2 + 1;
                i3 = iArr[i2];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    public static String decodeBase900toBase10(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(EXP900[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int decodeMacroBlock(int[] iArr, int i2, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == 923) {
                int i4 = textCompaction + 1;
                int[] iArr3 = new int[iArr[0] - i4];
                boolean z = false;
                int i5 = 0;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < 900) {
                        iArr3[i5] = i7;
                        i4 = i6;
                        i5++;
                    } else if (i7 == 922) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i4 = i6 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
                return i4;
            } else if (iArr[textCompaction] == 922) {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            } else {
                return textCompaction;
            }
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void decodeTextCompaction(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        Mode mode;
        int i3;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            char c2 = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else if (i5 != 26) {
                        if (i5 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i5 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i5 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c2 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else if (i5 != 26) {
                        if (i5 != 27) {
                            if (i5 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i5 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i5 == 913) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c2 = 0;
                        Mode mode42 = mode;
                        mode3 = mode2;
                        mode2 = mode42;
                        break;
                    }
                    break;
                case 3:
                    if (i5 < 25) {
                        c2 = MIXED_CHARS[i5];
                        break;
                    } else {
                        if (i5 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i5 != 26) {
                            if (i5 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i5 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i5 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c2 = 0;
                                Mode mode422 = mode;
                                mode3 = mode2;
                                mode2 = mode422;
                                break;
                            } else if (i5 == 913) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = PUNCT_CHARS[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == 913) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                            c2 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c2 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i5 < 29) {
                        c2 = PUNCT_CHARS[i5];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i5 == 913) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c2 = 0;
                        break;
                    }
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    public static int numericCompaction(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == 900 || i5 == 901 || i5 == 924 || i5 == 928 || i5 == 923 || i5 == 922) {
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == 902 || z) && i3 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    public static int textCompaction(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) << 1];
        int[] iArr3 = new int[(iArr[0] - i2) << 1];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != 913) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = 913;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i2;
    }
}
