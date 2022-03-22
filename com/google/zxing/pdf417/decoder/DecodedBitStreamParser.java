package com.google.zxing.pdf417.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AL = 28;
    public static final int AS = 27;
    public static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    public static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    public static final int BYTE_COMPACTION_MODE_LATCH = 901;
    public static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    public static final Charset DEFAULT_ENCODING;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final BigInteger[] EXP900;
    public static final int LL = 27;
    public static final int MACRO_PDF417_TERMINATOR = 922;
    public static final int MAX_NUMERIC_CODEWORDS = 15;
    public static final char[] MIXED_CHARS;
    public static final int ML = 28;
    public static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    public static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    public static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    public static final int PAL = 29;
    public static final int PL = 25;
    public static final int PS = 29;
    public static final char[] PUNCT_CHARS;
    public static final int TEXT_COMPACTION_MODE_LATCH = 900;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1785767789, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1785767789, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser$1;");
                    return;
                }
            }
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Mode ALPHA;
        public static final Mode ALPHA_SHIFT;
        public static final Mode LOWER;
        public static final Mode MIXED;
        public static final Mode PUNCT;
        public static final Mode PUNCT_SHIFT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1924186443, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser$Mode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1924186443, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser$Mode;");
                    return;
                }
            }
            ALPHA = new Mode("ALPHA", 0);
            LOWER = new Mode("LOWER", 1);
            MIXED = new Mode("MIXED", 2);
            PUNCT = new Mode("PUNCT", 3);
            ALPHA_SHIFT = new Mode("ALPHA_SHIFT", 4);
            Mode mode = new Mode("PUNCT_SHIFT", 5);
            PUNCT_SHIFT = mode;
            $VALUES = new Mode[]{ALPHA, LOWER, MIXED, PUNCT, ALPHA_SHIFT, mode};
        }

        public Mode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Mode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
        }

        public static Mode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1503532570, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1503532570, "Lcom/google/zxing/pdf417/decoder/DecodedBitStreamParser;");
                return;
            }
        }
        PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
        MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
        DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
            i++;
        }
    }

    public DecodedBitStreamParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), iArr, charset, Integer.valueOf(i2), sb})) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i6 = 922;
            int i7 = 923;
            int i8 = 928;
            int i9 = 902;
            long j = 900;
            if (i == 901) {
                int[] iArr2 = new int[6];
                i3 = i2 + 1;
                int i10 = iArr[i2];
                boolean z = false;
                loop0: while (true) {
                    i4 = 0;
                    long j2 = 0;
                    while (i3 < iArr[0] && !z) {
                        int i11 = i4 + 1;
                        iArr2[i4] = i10;
                        j2 = (j2 * j) + i10;
                        int i12 = i3 + 1;
                        i10 = iArr[i3];
                        if (i10 == 900 || i10 == 901 || i10 == 902 || i10 == 924 || i10 == 928 || i10 == i7 || i10 == i6) {
                            i3 = i12 - 1;
                            i4 = i11;
                            i6 = 922;
                            i7 = 923;
                            j = 900;
                            z = true;
                        } else if (i11 % 5 != 0 || i11 <= 0) {
                            i3 = i12;
                            i4 = i11;
                            i6 = 922;
                            i7 = 923;
                            j = 900;
                        } else {
                            int i13 = 0;
                            while (i13 < 6) {
                                byteArrayOutputStream.write((byte) (j2 >> ((5 - i13) * 8)));
                                i13++;
                                i6 = 922;
                                i7 = 923;
                            }
                            i3 = i12;
                            j = 900;
                        }
                    }
                }
                if (i3 != iArr[0] || i10 >= 900) {
                    i5 = i4;
                } else {
                    i5 = i4 + 1;
                    iArr2[i4] = i10;
                }
                for (int i14 = 0; i14 < i5; i14++) {
                    byteArrayOutputStream.write((byte) iArr2[i14]);
                }
            } else if (i == 924) {
                int i15 = i2;
                boolean z2 = false;
                int i16 = 0;
                long j3 = 0;
                while (i15 < iArr[0] && !z2) {
                    int i17 = i15 + 1;
                    int i18 = iArr[i15];
                    if (i18 < 900) {
                        i16++;
                        j3 = (j3 * 900) + i18;
                        i15 = i17;
                    } else {
                        if (i18 != 900 && i18 != 901 && i18 != i9 && i18 != 924 && i18 != i8) {
                            if (i18 != 923 && i18 != 922) {
                                i15 = i17;
                            }
                        }
                        i15 = i17 - 1;
                        z2 = true;
                    }
                    if (i16 % 5 == 0 && i16 > 0) {
                        for (int i19 = 0; i19 < 6; i19++) {
                            byteArrayOutputStream.write((byte) (j3 >> ((5 - i19) * 8)));
                        }
                        i16 = 0;
                        j3 = 0;
                    }
                    i8 = 928;
                    i9 = 902;
                }
                i3 = i15;
            } else {
                i3 = i2;
            }
            sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
            return i3;
        }
        return invokeCommon.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(int[] iArr, String str) throws FormatException {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, iArr, str)) == null) {
            StringBuilder sb = new StringBuilder(iArr.length << 1);
            Charset charset = DEFAULT_ENCODING;
            int i2 = iArr[1];
            PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
            int i3 = 2;
            while (i3 < iArr[0]) {
                if (i2 != 913) {
                    switch (i2) {
                        case 900:
                            i = textCompaction(iArr, i3, sb);
                            break;
                        case 901:
                            i = byteCompaction(i2, iArr, charset, i3, sb);
                            break;
                        case 902:
                            i = numericCompaction(iArr, i3, sb);
                            break;
                        default:
                            switch (i2) {
                                case 922:
                                case 923:
                                    throw FormatException.getFormatInstance();
                                case 924:
                                    break;
                                case 925:
                                    i = i3 + 1;
                                    break;
                                case 926:
                                    i = i3 + 2;
                                    break;
                                case 927:
                                    i = i3 + 1;
                                    charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                                    break;
                                case 928:
                                    i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                                    break;
                                default:
                                    i = textCompaction(iArr, i3 - 1, sb);
                                    break;
                            }
                    }
                } else {
                    i = i3 + 1;
                    sb.append((char) iArr[i3]);
                }
                if (i < iArr.length) {
                    i3 = i + 1;
                    i2 = iArr[i];
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
        return (DecoderResult) invokeLL.objValue;
    }

    public static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, i)) == null) {
            BigInteger bigInteger = BigInteger.ZERO;
            for (int i2 = 0; i2 < i; i2++) {
                bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
            }
            String bigInteger2 = bigInteger.toString();
            if (bigInteger2.charAt(0) == '1') {
                return bigInteger2.substring(1);
            }
            throw FormatException.getFormatInstance();
        }
        return (String) invokeLI.objValue;
    }

    public static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, null, iArr, i, pDF417ResultMetadata)) == null) {
            if (i + 2 <= iArr[0]) {
                int[] iArr2 = new int[2];
                int i2 = 0;
                while (i2 < 2) {
                    iArr2[i2] = iArr[i];
                    i2++;
                    i++;
                }
                pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int textCompaction = textCompaction(iArr, i, sb);
                pDF417ResultMetadata.setFileId(sb.toString());
                if (iArr[textCompaction] == 923) {
                    int i3 = textCompaction + 1;
                    int[] iArr3 = new int[iArr[0] - i3];
                    boolean z = false;
                    int i4 = 0;
                    while (i3 < iArr[0] && !z) {
                        int i5 = i3 + 1;
                        int i6 = iArr[i3];
                        if (i6 < 900) {
                            iArr3[i4] = i6;
                            i3 = i5;
                            i4++;
                        } else if (i6 == 922) {
                            pDF417ResultMetadata.setLastSegment(true);
                            i3 = i5 + 1;
                            z = true;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                    pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i4));
                    return i3;
                } else if (iArr[textCompaction] == 922) {
                    pDF417ResultMetadata.setLastSegment(true);
                    return textCompaction + 1;
                } else {
                    return textCompaction;
                }
            }
            throw FormatException.getFormatInstance();
        }
        return invokeLIL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65542, null, iArr, iArr2, i, sb) == null) {
            Mode mode2 = Mode.ALPHA;
            Mode mode3 = mode2;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = iArr[i3];
                int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()];
                char c2 = WebvttCueParser.CHAR_SPACE;
                switch (i5) {
                    case 1:
                        if (i4 < 26) {
                            i2 = i4 + 65;
                            c2 = (char) i2;
                            break;
                        } else if (i4 != 26) {
                            if (i4 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i4 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i4 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c2 = 0;
                                Mode mode4 = mode;
                                mode3 = mode2;
                                mode2 = mode4;
                                break;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2:
                        if (i4 < 26) {
                            i2 = i4 + 97;
                            c2 = (char) i2;
                            break;
                        } else if (i4 != 26) {
                            if (i4 != 27) {
                                if (i4 == 28) {
                                    mode2 = Mode.MIXED;
                                } else if (i4 == 29) {
                                    mode = Mode.PUNCT_SHIFT;
                                } else if (i4 == 913) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == 900) {
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
                        if (i4 < 25) {
                            c2 = MIXED_CHARS[i4];
                            break;
                        } else {
                            if (i4 == 25) {
                                mode2 = Mode.PUNCT;
                            } else if (i4 != 26) {
                                if (i4 == 27) {
                                    mode2 = Mode.LOWER;
                                } else if (i4 == 28) {
                                    mode2 = Mode.ALPHA;
                                } else if (i4 == 29) {
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode422 = mode;
                                    mode3 = mode2;
                                    mode2 = mode422;
                                    break;
                                } else if (i4 == 913) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == 900) {
                                    mode2 = Mode.ALPHA;
                                }
                            }
                            c2 = 0;
                            break;
                        }
                        break;
                    case 4:
                        if (i4 < 29) {
                            c2 = PUNCT_CHARS[i4];
                            break;
                        } else {
                            if (i4 == 29) {
                                mode2 = Mode.ALPHA;
                            } else if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            } else if (i4 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                            break;
                        }
                    case 5:
                        if (i4 < 26) {
                            c2 = (char) (i4 + 65);
                        } else if (i4 != 26) {
                            if (i4 == 900) {
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
                        if (i4 < 29) {
                            c2 = PUNCT_CHARS[i4];
                            mode2 = mode3;
                            break;
                        } else {
                            if (i4 == 29) {
                                mode2 = Mode.ALPHA;
                            } else {
                                if (i4 == 913) {
                                    sb.append((char) iArr2[i3]);
                                } else if (i4 == 900) {
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
    }

    public static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, iArr, i, sb)) == null) {
            int[] iArr2 = new int[15];
            boolean z = false;
            int i2 = 0;
            while (i < iArr[0] && !z) {
                int i3 = i + 1;
                int i4 = iArr[i];
                if (i3 == iArr[0]) {
                    z = true;
                }
                if (i4 < 900) {
                    iArr2[i2] = i4;
                    i2++;
                } else if (i4 == 900 || i4 == 901 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                    i3--;
                    z = true;
                }
                if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                    sb.append(decodeBase900toBase10(iArr2, i2));
                    i2 = 0;
                }
                i = i3;
            }
            return i;
        }
        return invokeLIL.intValue;
    }

    public static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65544, null, iArr, i, sb)) == null) {
            int[] iArr2 = new int[(iArr[0] - i) << 1];
            int[] iArr3 = new int[(iArr[0] - i) << 1];
            boolean z = false;
            int i2 = 0;
            while (i < iArr[0] && !z) {
                int i3 = i + 1;
                int i4 = iArr[i];
                if (i4 < 900) {
                    iArr2[i2] = i4 / 30;
                    iArr2[i2 + 1] = i4 % 30;
                    i2 += 2;
                } else if (i4 != 913) {
                    if (i4 != 928) {
                        switch (i4) {
                            case 900:
                                iArr2[i2] = 900;
                                i2++;
                                break;
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i4) {
                                }
                        }
                    }
                    i = i3 - 1;
                    z = true;
                } else {
                    iArr2[i2] = 913;
                    i = i3 + 1;
                    iArr3[i2] = iArr[i3];
                    i2++;
                }
                i = i3;
            }
            decodeTextCompaction(iArr2, iArr3, i2, sb);
            return i;
        }
        return invokeLIL.intValue;
    }
}
