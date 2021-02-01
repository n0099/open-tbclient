package com.google.zxing.pdf417.encoder;

import com.alibaba.fastjson.parser.JSONLexer;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] MIXED = new byte[128];
    private static final byte[] PUNCTUATION = new byte[128];
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    static {
        Arrays.fill(MIXED, (byte) -1);
        for (int i = 0; i < TEXT_MIXED_RAW.length; i++) {
            byte b2 = TEXT_MIXED_RAW[i];
            if (b2 > 0) {
                MIXED[b2] = (byte) i;
            }
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        for (int i2 = 0; i2 < TEXT_PUNCTUATION_RAW.length; i2++) {
            byte b3 = TEXT_PUNCTUATION_RAW[i2];
            if (b3 > 0) {
                PUNCTUATION[b3] = (byte) i2;
            }
        }
    }

    private PDF417HighLevelEncoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
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
            while (i3 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i3);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append((char) 902);
                    i = 2;
                    encodeNumeric(str, i3, determineConsecutiveDigitCount, sb);
                    i2 = 0;
                    i3 = determineConsecutiveDigitCount + i3;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i3);
                    if (determineConsecutiveTextCount >= 5 || determineConsecutiveDigitCount == length) {
                        if (i != 0) {
                            sb.append((char) 900);
                            i = 0;
                            i2 = 0;
                        }
                        i2 = encodeText(str, i3, determineConsecutiveTextCount, sb, i2);
                        i3 += determineConsecutiveTextCount;
                    } else {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i3, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        byte[] bytes2 = str.substring(i3, i3 + determineConsecutiveBinaryCount).getBytes(charset);
                        if (bytes2.length == 1 && i == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i, sb);
                            i = 1;
                            i2 = 0;
                        }
                        i3 = determineConsecutiveBinaryCount + i3;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static int encodeText(CharSequence charSequence, int i, int i2, StringBuilder sb, int i3) {
        char charAt;
        StringBuilder sb2 = new StringBuilder(i2);
        int i4 = 0;
        while (true) {
            char charAt2 = charSequence.charAt(i + i4);
            switch (i3) {
                case 0:
                    if (isAlphaUpper(charAt2)) {
                        if (charAt2 == ' ') {
                            sb2.append(JSONLexer.EOI);
                            break;
                        } else {
                            sb2.append((char) (charAt2 - 'A'));
                            break;
                        }
                    } else if (isAlphaLower(charAt2)) {
                        sb2.append((char) 27);
                        i3 = 1;
                        continue;
                    } else if (isMixed(charAt2)) {
                        i3 = 2;
                        sb2.append((char) 28);
                    } else {
                        sb2.append((char) 29);
                        sb2.append((char) PUNCTUATION[charAt2]);
                        break;
                    }
                case 1:
                    if (isAlphaLower(charAt2)) {
                        if (charAt2 == ' ') {
                            sb2.append(JSONLexer.EOI);
                            break;
                        } else {
                            sb2.append((char) (charAt2 - 'a'));
                            break;
                        }
                    } else if (isAlphaUpper(charAt2)) {
                        sb2.append((char) 27);
                        sb2.append((char) (charAt2 - 'A'));
                        break;
                    } else if (isMixed(charAt2)) {
                        i3 = 2;
                        sb2.append((char) 28);
                        continue;
                    } else {
                        sb2.append((char) 29);
                        sb2.append((char) PUNCTUATION[charAt2]);
                        break;
                    }
                case 2:
                    if (isMixed(charAt2)) {
                        sb2.append((char) MIXED[charAt2]);
                        break;
                    } else if (isAlphaUpper(charAt2)) {
                        sb2.append((char) 28);
                        i3 = 0;
                        continue;
                    } else if (isAlphaLower(charAt2)) {
                        sb2.append((char) 27);
                        i3 = 1;
                    } else if (i + i4 + 1 < i2 && isPunctuation(charSequence.charAt(i + i4 + 1))) {
                        i3 = 3;
                        sb2.append((char) 25);
                    } else {
                        sb2.append((char) 29);
                        sb2.append((char) PUNCTUATION[charAt2]);
                        break;
                    }
                    break;
                default:
                    if (isPunctuation(charAt2)) {
                        sb2.append((char) PUNCTUATION[charAt2]);
                        break;
                    } else {
                        sb2.append((char) 29);
                        i3 = 0;
                        continue;
                    }
            }
            i4++;
            if (i4 >= i2) {
                int length = sb2.length();
                int i5 = 0;
                char c = 0;
                while (i5 < length) {
                    if (i5 % 2 != 0) {
                        charAt = (char) ((c * 30) + sb2.charAt(i5));
                        sb.append(charAt);
                    } else {
                        charAt = sb2.charAt(i5);
                    }
                    i5++;
                    c = charAt;
                }
                if (length % 2 != 0) {
                    sb.append((char) ((c * 30) + 29));
                }
                return i3;
            }
        }
    }

    private static void encodeBinary(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
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

    private static void encodeNumeric(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            BigInteger bigInteger = new BigInteger("1" + str.substring(i + i3, i + i3 + min));
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

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isAlphaUpper(char c) {
        return c == ' ' || (c >= 'A' && c <= 'Z');
    }

    private static boolean isAlphaLower(char c) {
        return c == ' ' || (c >= 'a' && c <= 'z');
    }

    private static boolean isMixed(char c) {
        return MIXED[c] != -1;
    }

    private static boolean isPunctuation(char c) {
        return PUNCTUATION[c] != -1;
    }

    private static boolean isText(char c) {
        return c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= '~');
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        int i2 = 0;
        int length = charSequence.length();
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        return (r0 - r7) - r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int determineConsecutiveTextCount(CharSequence charSequence, int i) {
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

    private static int determineConsecutiveBinaryCount(String str, int i, Charset charset) throws WriterException {
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && isDigit(charAt)) {
                i3++;
                int i4 = i2 + i3;
                if (i4 >= length) {
                    break;
                }
                charAt = str.charAt(i4);
            }
            if (i3 >= 13) {
                return i2 - i;
            }
            char charAt2 = str.charAt(i2);
            if (!newEncoder.canEncode(charAt2)) {
                throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
            i2++;
        }
        return i2 - i;
    }

    private static void encodingECI(int i, StringBuilder sb) throws WriterException {
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
