package com.google.zxing.pdf417.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.bumptech.glide.disklrucache.StrictLineReader;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes5.dex */
public final class PDF417HighLevelEncoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BYTE_COMPACTION = 1;
    public static final Charset DEFAULT_ENCODING;
    public static final int ECI_CHARSET = 927;
    public static final int ECI_GENERAL_PURPOSE = 926;
    public static final int ECI_USER_DEFINED = 925;
    public static final int LATCH_TO_BYTE = 924;
    public static final int LATCH_TO_BYTE_PADDED = 901;
    public static final int LATCH_TO_NUMERIC = 902;
    public static final int LATCH_TO_TEXT = 900;
    public static final byte[] MIXED;
    public static final int NUMERIC_COMPACTION = 2;
    public static final byte[] PUNCTUATION;
    public static final int SHIFT_TO_BYTE = 913;
    public static final int SUBMODE_ALPHA = 0;
    public static final int SUBMODE_LOWER = 1;
    public static final int SUBMODE_MIXED = 2;
    public static final int SUBMODE_PUNCTUATION = 3;
    public static final int TEXT_COMPACTION = 0;
    public static final byte[] TEXT_MIXED_RAW;
    public static final byte[] TEXT_PUNCTUATION_RAW;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1912155078, "Lcom/google/zxing/pdf417/encoder/PDF417HighLevelEncoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1912155078, "Lcom/google/zxing/pdf417/encoder/PDF417HighLevelEncoder;");
                return;
            }
        }
        TEXT_MIXED_RAW = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, StrictLineReader.CR, 9, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 58, Base64.INTERNAL_PADDING, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_END_OF_CAPTION, 43, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, 42, BaseNCodec.PAD_DEFAULT, 94, 0, 32, 0, 0, 0};
        TEXT_PUNCTUATION_RAW = new byte[]{59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, StrictLineReader.CR, 9, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 58, 10, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_END_OF_CAPTION, 34, 124, 42, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 63, 123, 125, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 0};
        MIXED = new byte[128];
        PUNCTUATION = new byte[128];
        DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
        Arrays.fill(MIXED, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i2 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if (b > 0) {
                MIXED[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i >= bArr2.length) {
                return;
            }
            byte b2 = bArr2[i];
            if (b2 > 0) {
                PUNCTUATION[b2] = (byte) i;
            }
            i++;
        }
    }

    public PDF417HighLevelEncoder() {
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int determineConsecutiveBinaryCount(String str, int i, Charset charset) throws WriterException {
        InterceptResult invokeLIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, str, i, charset)) == null) {
            CharsetEncoder newEncoder = charset.newEncoder();
            int length = str.length();
            int i3 = i;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                int i4 = 0;
                while (i4 < 13 && isDigit(charAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                    charAt = str.charAt(i2);
                }
                char charAt2 = str.charAt(i3);
                if (!newEncoder.canEncode(charAt2)) {
                    throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
                }
                i3++;
            }
            return i3 - i;
        }
        return invokeLIL.intValue;
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i)) == null) {
            int length = charSequence.length();
            int i2 = 0;
            if (i < length) {
                char charAt = charSequence.charAt(i);
                while (isDigit(charAt) && i < length) {
                    i2++;
                    i++;
                    if (i < length) {
                        charAt = charSequence.charAt(i);
                    }
                }
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int determineConsecutiveTextCount(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence, i)) == null) {
            int length = charSequence.length();
            int i2 = i;
            while (i2 < length) {
                char charAt = charSequence.charAt(i2);
                int i3 = 0;
                while (i3 < 13 && isDigit(charAt) && i2 < length) {
                    i3++;
                    i2++;
                    if (i2 < length) {
                        charAt = charSequence.charAt(i2);
                    }
                }
                if (i3 <= 0) {
                    if (!isText(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            }
            return i2 - i;
        }
        return invokeLI.intValue;
    }

    public static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), sb}) == null) {
            if (i2 == 1 && i3 == 0) {
                sb.append((char) 913);
            } else if (i2 % 6 == 0) {
                sb.append((char) 924);
            } else {
                sb.append((char) 901);
            }
            if (i2 >= 6) {
                char[] cArr = new char[5];
                i4 = i;
                while ((i + i2) - i4 >= 6) {
                    long j = 0;
                    for (int i5 = 0; i5 < 6; i5++) {
                        j = (j << 8) + (bArr[i4 + i5] & 255);
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        cArr[i6] = (char) (j % 900);
                        j /= 900;
                    }
                    for (int i7 = 4; i7 >= 0; i7--) {
                        sb.append(cArr[i7]);
                    }
                    i4 += 6;
                }
            } else {
                i4 = i;
            }
            while (i4 < i + i2) {
                sb.append((char) (bArr[i4] & 255));
                i4++;
            }
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        InterceptResult invokeLLL;
        CharacterSetECI characterSetECIByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, compaction, charset)) == null) {
            StringBuilder sb = new StringBuilder(str.length());
            if (charset == null) {
                charset = DEFAULT_ENCODING;
            } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
                encodingECI(characterSetECIByName.getValue(), sb);
            }
            int length = str.length();
            if (compaction == Compaction.TEXT) {
                encodeText(str, 0, length, sb, 0);
            } else if (compaction == Compaction.BYTE) {
                byte[] bytes = str.getBytes(charset);
                encodeBinary(bytes, 0, bytes.length, 1, sb);
            } else if (compaction == Compaction.NUMERIC) {
                sb.append((char) 902);
                encodeNumeric(str, 0, length, sb);
            } else {
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < length) {
                    int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i);
                    if (determineConsecutiveDigitCount >= 13) {
                        sb.append((char) 902);
                        i3 = 2;
                        encodeNumeric(str, i, determineConsecutiveDigitCount, sb);
                        i += determineConsecutiveDigitCount;
                        i2 = 0;
                    } else {
                        int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i);
                        if (determineConsecutiveTextCount < 5 && determineConsecutiveDigitCount != length) {
                            int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i, charset);
                            if (determineConsecutiveBinaryCount == 0) {
                                determineConsecutiveBinaryCount = 1;
                            }
                            int i4 = determineConsecutiveBinaryCount + i;
                            byte[] bytes2 = str.substring(i, i4).getBytes(charset);
                            if (bytes2.length == 1 && i3 == 0) {
                                encodeBinary(bytes2, 0, 1, 0, sb);
                            } else {
                                encodeBinary(bytes2, 0, bytes2.length, i3, sb);
                                i2 = 0;
                                i3 = 1;
                            }
                            i = i4;
                        } else {
                            if (i3 != 0) {
                                sb.append((char) 900);
                                i2 = 0;
                                i3 = 0;
                            }
                            i2 = encodeText(str, i, determineConsecutiveTextCount, sb, i2);
                            i += determineConsecutiveTextCount;
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), sb}) == null) {
            StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
            BigInteger valueOf = BigInteger.valueOf(900L);
            BigInteger valueOf2 = BigInteger.valueOf(0L);
            int i3 = 0;
            while (i3 < i2) {
                sb2.setLength(0);
                int min = Math.min(44, i2 - i3);
                StringBuilder sb3 = new StringBuilder("1");
                int i4 = i + i3;
                sb3.append(str.substring(i4, i4 + min));
                BigInteger bigInteger = new BigInteger(sb3.toString());
                do {
                    sb2.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
                for (int length = sb2.length() - 1; length >= 0; length--) {
                    sb.append(sb2.charAt(length));
                }
                i3 += min;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa A[EDGE_INSN: B:82:0x00fa->B:57:0x00fa ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int encodeText(CharSequence charSequence, int i, int i2, StringBuilder sb, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), sb, Integer.valueOf(i3)})) == null) {
            StringBuilder sb2 = new StringBuilder(i2);
            int i4 = i3;
            int i5 = 0;
            while (true) {
                int i6 = i + i5;
                char charAt = charSequence.charAt(i6);
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (isPunctuation(charAt)) {
                                sb2.append((char) PUNCTUATION[charAt]);
                            } else {
                                sb2.append(DecodedBitStreamParser.GS);
                                i4 = 0;
                            }
                        } else if (isMixed(charAt)) {
                            sb2.append((char) MIXED[charAt]);
                        } else if (isAlphaUpper(charAt)) {
                            sb2.append(DecodedBitStreamParser.FS);
                            i4 = 0;
                        } else if (isAlphaLower(charAt)) {
                            sb2.append((char) 27);
                            i4 = 1;
                        } else {
                            int i7 = i6 + 1;
                            if (i7 < i2 && isPunctuation(charSequence.charAt(i7))) {
                                i4 = 3;
                                sb2.append((char) 25);
                            } else {
                                sb2.append(DecodedBitStreamParser.GS);
                                sb2.append((char) PUNCTUATION[charAt]);
                            }
                        }
                    } else if (isAlphaLower(charAt)) {
                        if (charAt == ' ') {
                            sb2.append((char) 26);
                        } else {
                            sb2.append((char) (charAt - 'a'));
                        }
                    } else if (isAlphaUpper(charAt)) {
                        sb2.append((char) 27);
                        sb2.append((char) (charAt - 'A'));
                    } else if (isMixed(charAt)) {
                        sb2.append(DecodedBitStreamParser.FS);
                        i4 = 2;
                    } else {
                        sb2.append(DecodedBitStreamParser.GS);
                        sb2.append((char) PUNCTUATION[charAt]);
                    }
                    i5++;
                    if (i5 < i2) {
                        break;
                    }
                } else {
                    if (isAlphaUpper(charAt)) {
                        if (charAt == ' ') {
                            sb2.append((char) 26);
                        } else {
                            sb2.append((char) (charAt - 'A'));
                        }
                    } else if (isAlphaLower(charAt)) {
                        sb2.append((char) 27);
                        i4 = 1;
                    } else if (isMixed(charAt)) {
                        sb2.append(DecodedBitStreamParser.FS);
                        i4 = 2;
                    } else {
                        sb2.append(DecodedBitStreamParser.GS);
                        sb2.append((char) PUNCTUATION[charAt]);
                    }
                    i5++;
                    if (i5 < i2) {
                    }
                }
            }
            int length = sb2.length();
            char c = 0;
            for (int i8 = 0; i8 < length; i8++) {
                if (i8 % 2 != 0) {
                    c = (char) ((c * DecodedBitStreamParser.RS) + sb2.charAt(i8));
                    sb.append(c);
                } else {
                    c = sb2.charAt(i8);
                }
            }
            if (length % 2 != 0) {
                sb.append((char) ((c * DecodedBitStreamParser.RS) + 29));
            }
            return i4;
        }
        return invokeCommon.intValue;
    }

    public static void encodingECI(int i, StringBuilder sb) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i, sb) == null) {
            if (i >= 0 && i < 900) {
                sb.append((char) 927);
                sb.append((char) i);
            } else if (i < 810900) {
                sb.append((char) 926);
                sb.append((char) ((i / 900) - 1));
                sb.append((char) (i % 900));
            } else if (i < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i));
            } else {
                throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
            }
        }
    }

    public static boolean isAlphaLower(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c != ' ') {
                return c >= 'a' && c <= 'z';
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isAlphaUpper(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c != ' ') {
                return c >= 'A' && c <= 'Z';
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isDigit(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Character.valueOf(c)})) == null) ? c >= '0' && c <= '9' : invokeCommon.booleanValue;
    }

    public static boolean isMixed(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c)})) == null) ? MIXED[c] != -1 : invokeCommon.booleanValue;
    }

    public static boolean isPunctuation(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Character.valueOf(c)})) == null) ? PUNCTUATION[c] != -1 : invokeCommon.booleanValue;
    }

    public static boolean isText(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c == '\t' || c == '\n' || c == '\r') {
                return true;
            }
            return c >= ' ' && c <= '~';
        }
        return invokeCommon.booleanValue;
    }
}
