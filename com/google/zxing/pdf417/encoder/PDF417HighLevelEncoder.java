package com.google.zxing.pdf417.encoder;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.maxicode.decoder.DecodedBitStreamParser;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes3.dex */
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
        TEXT_MIXED_RAW = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, Base64.INTERNAL_PADDING, UtilsBlink.VER_TYPE_SEPARATOR, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
        TEXT_PUNCTUATION_RAW = new byte[]{59, 60, 62, 64, 91, 92, 93, 95, 96, 126, PublicSuffixDatabase.EXCEPTION_MARKER, 13, 9, 44, 58, 10, UtilsBlink.VER_TYPE_SEPARATOR, 46, 36, 47, 34, 124, 42, 40, 41, 63, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 125, 39, 0};
        MIXED = new byte[128];
        PUNCTUATION = new byte[128];
        DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
        Arrays.fill(MIXED, (byte) -1);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = TEXT_MIXED_RAW;
            if (i3 >= bArr.length) {
                break;
            }
            byte b2 = bArr[i3];
            if (b2 > 0) {
                MIXED[b2] = (byte) i3;
            }
            i3++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr2 = TEXT_PUNCTUATION_RAW;
            if (i2 >= bArr2.length) {
                return;
            }
            byte b3 = bArr2[i2];
            if (b3 > 0) {
                PUNCTUATION[b3] = (byte) i2;
            }
            i2++;
        }
    }

    public PDF417HighLevelEncoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public static int determineConsecutiveBinaryCount(String str, int i2, Charset charset) throws WriterException {
        InterceptResult invokeLIL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, str, i2, charset)) == null) {
            CharsetEncoder newEncoder = charset.newEncoder();
            int length = str.length();
            int i4 = i2;
            while (i4 < length) {
                char charAt = str.charAt(i4);
                int i5 = 0;
                while (i5 < 13 && isDigit(charAt) && (i3 = i4 + (i5 = i5 + 1)) < length) {
                    charAt = str.charAt(i3);
                }
                char charAt2 = str.charAt(i4);
                if (!newEncoder.canEncode(charAt2)) {
                    throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
                }
                i4++;
            }
            return i4 - i2;
        }
        return invokeLIL.intValue;
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, charSequence, i2)) == null) {
            int length = charSequence.length();
            int i3 = 0;
            if (i2 < length) {
                char charAt = charSequence.charAt(i2);
                while (isDigit(charAt) && i2 < length) {
                    i3++;
                    i2++;
                    if (i2 < length) {
                        charAt = charSequence.charAt(i2);
                    }
                }
            }
            return i3;
        }
        return invokeLI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int determineConsecutiveTextCount(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, charSequence, i2)) == null) {
            int length = charSequence.length();
            int i3 = i2;
            while (i3 < length) {
                char charAt = charSequence.charAt(i3);
                int i4 = 0;
                while (i4 < 13 && isDigit(charAt) && i3 < length) {
                    i4++;
                    i3++;
                    if (i3 < length) {
                        charAt = charSequence.charAt(i3);
                    }
                }
                if (i4 <= 0) {
                    if (!isText(charSequence.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
            }
            return i3 - i2;
        }
        return invokeLI.intValue;
    }

    public static void encodeBinary(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), sb}) == null) {
            if (i3 == 1 && i4 == 0) {
                sb.append((char) 913);
            } else if (i3 % 6 == 0) {
                sb.append((char) 924);
            } else {
                sb.append((char) 901);
            }
            if (i3 >= 6) {
                char[] cArr = new char[5];
                i5 = i2;
                while ((i2 + i3) - i5 >= 6) {
                    long j2 = 0;
                    for (int i6 = 0; i6 < 6; i6++) {
                        j2 = (j2 << 8) + (bArr[i5 + i6] & 255);
                    }
                    for (int i7 = 0; i7 < 5; i7++) {
                        cArr[i7] = (char) (j2 % 900);
                        j2 /= 900;
                    }
                    for (int i8 = 4; i8 >= 0; i8--) {
                        sb.append(cArr[i8]);
                    }
                    i5 += 6;
                }
            } else {
                i5 = i2;
            }
            while (i5 < i2 + i3) {
                sb.append((char) (bArr[i5] & 255));
                i5++;
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
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < length) {
                    int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i2);
                    if (determineConsecutiveDigitCount >= 13) {
                        sb.append((char) 902);
                        i4 = 2;
                        encodeNumeric(str, i2, determineConsecutiveDigitCount, sb);
                        i2 += determineConsecutiveDigitCount;
                        i3 = 0;
                    } else {
                        int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i2);
                        if (determineConsecutiveTextCount < 5 && determineConsecutiveDigitCount != length) {
                            int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i2, charset);
                            if (determineConsecutiveBinaryCount == 0) {
                                determineConsecutiveBinaryCount = 1;
                            }
                            int i5 = determineConsecutiveBinaryCount + i2;
                            byte[] bytes2 = str.substring(i2, i5).getBytes(charset);
                            if (bytes2.length == 1 && i4 == 0) {
                                encodeBinary(bytes2, 0, 1, 0, sb);
                            } else {
                                encodeBinary(bytes2, 0, bytes2.length, i4, sb);
                                i3 = 0;
                                i4 = 1;
                            }
                            i2 = i5;
                        } else {
                            if (i4 != 0) {
                                sb.append((char) 900);
                                i3 = 0;
                                i4 = 0;
                            }
                            i3 = encodeText(str, i2, determineConsecutiveTextCount, sb, i3);
                            i2 += determineConsecutiveTextCount;
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static void encodeNumeric(String str, int i2, int i3, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), sb}) == null) {
            StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
            BigInteger valueOf = BigInteger.valueOf(900L);
            BigInteger valueOf2 = BigInteger.valueOf(0L);
            int i4 = 0;
            while (i4 < i3) {
                sb2.setLength(0);
                int min = Math.min(44, i3 - i4);
                StringBuilder sb3 = new StringBuilder("1");
                int i5 = i2 + i4;
                sb3.append(str.substring(i5, i5 + min));
                BigInteger bigInteger = new BigInteger(sb3.toString());
                do {
                    sb2.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
                for (int length = sb2.length() - 1; length >= 0; length--) {
                    sb.append(sb2.charAt(length));
                }
                i4 += min;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa A[EDGE_INSN: B:82:0x00fa->B:57:0x00fa ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int encodeText(CharSequence charSequence, int i2, int i3, StringBuilder sb, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), sb, Integer.valueOf(i4)})) == null) {
            StringBuilder sb2 = new StringBuilder(i3);
            int i5 = i4;
            int i6 = 0;
            while (true) {
                int i7 = i2 + i6;
                char charAt = charSequence.charAt(i7);
                if (i5 != 0) {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            if (isPunctuation(charAt)) {
                                sb2.append((char) PUNCTUATION[charAt]);
                            } else {
                                sb2.append(DecodedBitStreamParser.GS);
                                i5 = 0;
                            }
                        } else if (isMixed(charAt)) {
                            sb2.append((char) MIXED[charAt]);
                        } else if (isAlphaUpper(charAt)) {
                            sb2.append(DecodedBitStreamParser.FS);
                            i5 = 0;
                        } else if (isAlphaLower(charAt)) {
                            sb2.append((char) 27);
                            i5 = 1;
                        } else {
                            int i8 = i7 + 1;
                            if (i8 < i3 && isPunctuation(charSequence.charAt(i8))) {
                                i5 = 3;
                                sb2.append((char) 25);
                            } else {
                                sb2.append(DecodedBitStreamParser.GS);
                                sb2.append((char) PUNCTUATION[charAt]);
                            }
                        }
                    } else if (isAlphaLower(charAt)) {
                        if (charAt == ' ') {
                            sb2.append(JSONLexer.EOI);
                        } else {
                            sb2.append((char) (charAt - 'a'));
                        }
                    } else if (isAlphaUpper(charAt)) {
                        sb2.append((char) 27);
                        sb2.append((char) (charAt - 'A'));
                    } else if (isMixed(charAt)) {
                        sb2.append(DecodedBitStreamParser.FS);
                        i5 = 2;
                    } else {
                        sb2.append(DecodedBitStreamParser.GS);
                        sb2.append((char) PUNCTUATION[charAt]);
                    }
                    i6++;
                    if (i6 < i3) {
                        break;
                    }
                } else {
                    if (isAlphaUpper(charAt)) {
                        if (charAt == ' ') {
                            sb2.append(JSONLexer.EOI);
                        } else {
                            sb2.append((char) (charAt - 'A'));
                        }
                    } else if (isAlphaLower(charAt)) {
                        sb2.append((char) 27);
                        i5 = 1;
                    } else if (isMixed(charAt)) {
                        sb2.append(DecodedBitStreamParser.FS);
                        i5 = 2;
                    } else {
                        sb2.append(DecodedBitStreamParser.GS);
                        sb2.append((char) PUNCTUATION[charAt]);
                    }
                    i6++;
                    if (i6 < i3) {
                    }
                }
            }
            int length = sb2.length();
            char c2 = 0;
            for (int i9 = 0; i9 < length; i9++) {
                if (i9 % 2 != 0) {
                    c2 = (char) ((c2 * DecodedBitStreamParser.RS) + sb2.charAt(i9));
                    sb.append(c2);
                } else {
                    c2 = sb2.charAt(i9);
                }
            }
            if (length % 2 != 0) {
                sb.append((char) ((c2 * DecodedBitStreamParser.RS) + 29));
            }
            return i5;
        }
        return invokeCommon.intValue;
    }

    public static void encodingECI(int i2, StringBuilder sb) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, null, i2, sb) == null) {
            if (i2 >= 0 && i2 < 900) {
                sb.append((char) 927);
                sb.append((char) i2);
            } else if (i2 < 810900) {
                sb.append((char) 926);
                sb.append((char) ((i2 / 900) - 1));
                sb.append((char) (i2 % 900));
            } else if (i2 < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i2));
            } else {
                throw new WriterException("ECI number not in valid range from 0..811799, but was " + i2);
            }
        }
    }

    public static boolean isAlphaLower(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 != ' ') {
                return c2 >= 'a' && c2 <= 'z';
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isAlphaUpper(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 != ' ') {
                return c2 >= 'A' && c2 <= 'Z';
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Character.valueOf(c2)})) == null) ? c2 >= '0' && c2 <= '9' : invokeCommon.booleanValue;
    }

    public static boolean isMixed(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Character.valueOf(c2)})) == null) ? MIXED[c2] != -1 : invokeCommon.booleanValue;
    }

    public static boolean isPunctuation(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Character.valueOf(c2)})) == null) ? PUNCTUATION[c2] != -1 : invokeCommon.booleanValue;
    }

    public static boolean isText(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 == '\t' || c2 == '\n' || c2 == '\r') {
                return true;
            }
            return c2 >= ' ' && c2 <= '~';
        }
        return invokeCommon.booleanValue;
    }
}
