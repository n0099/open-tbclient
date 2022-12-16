package com.google.zxing.qrcode.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes8.dex */
public final class DecodedBitStreamParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char[] ALPHANUMERIC_CHARS;
    public static final int GB2312_SUBSET = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-278092160, "Lcom/google/zxing/qrcode/decoder/DecodedBitStreamParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-278092160, "Lcom/google/zxing/qrcode/decoder/DecodedBitStreamParser;");
                return;
            }
        }
        ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
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

    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb A[LOOP:0: B:70:0x0022->B:63:0x00eb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        InterceptResult invokeLLLL;
        Mode forBits;
        Mode mode;
        ArrayList arrayList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, bArr, version, errorCorrectionLevel, map)) == null) {
            BitSource bitSource = new BitSource(bArr);
            StringBuilder sb = new StringBuilder(50);
            int i = 1;
            ArrayList arrayList2 = new ArrayList(1);
            CharacterSetECI characterSetECI = null;
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            while (true) {
                try {
                    if (bitSource.available() < 4) {
                        forBits = Mode.TERMINATOR;
                    } else {
                        forBits = Mode.forBits(bitSource.readBits(4));
                    }
                    Mode mode2 = forBits;
                    if (mode2 != Mode.TERMINATOR) {
                        if (mode2 != Mode.FNC1_FIRST_POSITION && mode2 != Mode.FNC1_SECOND_POSITION) {
                            if (mode2 == Mode.STRUCTURED_APPEND) {
                                if (bitSource.available() >= 16) {
                                    int readBits = bitSource.readBits(8);
                                    i3 = bitSource.readBits(8);
                                    i2 = readBits;
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (mode2 == Mode.ECI) {
                                characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                                if (characterSetECI == null) {
                                    throw FormatException.getFormatInstance();
                                }
                            } else if (mode2 == Mode.HANZI) {
                                int readBits2 = bitSource.readBits(4);
                                int readBits3 = bitSource.readBits(mode2.getCharacterCountBits(version));
                                if (readBits2 == i) {
                                    decodeHanziSegment(bitSource, sb, readBits3);
                                }
                            } else {
                                int readBits4 = bitSource.readBits(mode2.getCharacterCountBits(version));
                                if (mode2 == Mode.NUMERIC) {
                                    decodeNumericSegment(bitSource, sb, readBits4);
                                } else if (mode2 == Mode.ALPHANUMERIC) {
                                    decodeAlphanumericSegment(bitSource, sb, readBits4, z);
                                } else {
                                    if (mode2 == Mode.BYTE) {
                                        mode = mode2;
                                        decodeByteSegment(bitSource, sb, readBits4, characterSetECI, arrayList2, map);
                                    } else {
                                        mode = mode2;
                                        if (mode == Mode.KANJI) {
                                            decodeKanjiSegment(bitSource, sb, readBits4);
                                        } else {
                                            throw FormatException.getFormatInstance();
                                        }
                                    }
                                    if (mode == Mode.TERMINATOR) {
                                        String sb2 = sb.toString();
                                        if (arrayList2.isEmpty()) {
                                            arrayList = null;
                                        } else {
                                            arrayList = arrayList2;
                                        }
                                        if (errorCorrectionLevel == null) {
                                            str = null;
                                        } else {
                                            str = errorCorrectionLevel.toString();
                                        }
                                        return new DecoderResult(bArr, sb2, arrayList, str, i2, i3);
                                    }
                                    i = 1;
                                }
                            }
                        }
                        mode = mode2;
                        z = true;
                        if (mode == Mode.TERMINATOR) {
                        }
                    }
                    mode = mode2;
                    if (mode == Mode.TERMINATOR) {
                    }
                } catch (IllegalArgumentException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
        } else {
            return (DecoderResult) invokeLLLL.objValue;
        }
    }

    public static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bitSource, sb, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            while (i > 1) {
                if (bitSource.available() >= 11) {
                    int readBits = bitSource.readBits(11);
                    sb.append(toAlphaNumericChar(readBits / 45));
                    sb.append(toAlphaNumericChar(readBits % 45));
                    i -= 2;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i == 1) {
                if (bitSource.available() >= 6) {
                    sb.append(toAlphaNumericChar(bitSource.readBits(6)));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (z) {
                for (int length = sb.length(); length < sb.length(); length++) {
                    if (sb.charAt(length) == '%') {
                        if (length < sb.length() - 1) {
                            int i2 = length + 1;
                            if (sb.charAt(i2) == '%') {
                                sb.deleteCharAt(i2);
                            }
                        }
                        sb.setCharAt(length, com.google.zxing.maxicode.decoder.DecodedBitStreamParser.GS);
                    }
                }
            }
        }
    }

    public static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitSource, sb, Integer.valueOf(i), characterSetECI, collection, map}) == null) {
            if ((i << 3) <= bitSource.available()) {
                byte[] bArr = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = (byte) bitSource.readBits(8);
                }
                if (characterSetECI == null) {
                    name = StringUtils.guessEncoding(bArr, map);
                } else {
                    name = characterSetECI.name();
                }
                try {
                    sb.append(new String(bArr, name));
                    collection.add(bArr);
                    return;
                } catch (UnsupportedEncodingException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, bitSource, sb, i) == null) {
            if (i * 13 <= bitSource.available()) {
                byte[] bArr = new byte[i * 2];
                int i3 = 0;
                while (i > 0) {
                    int readBits = bitSource.readBits(13);
                    int i4 = (readBits % 96) | ((readBits / 96) << 8);
                    if (i4 < 959) {
                        i2 = 41377;
                    } else {
                        i2 = 42657;
                    }
                    int i5 = i4 + i2;
                    bArr[i3] = (byte) (i5 >> 8);
                    bArr[i3 + 1] = (byte) i5;
                    i3 += 2;
                    i--;
                }
                try {
                    sb.append(new String(bArr, StringUtils.GB2312));
                    return;
                } catch (UnsupportedEncodingException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, bitSource, sb, i) == null) {
            if (i * 13 <= bitSource.available()) {
                byte[] bArr = new byte[i * 2];
                int i3 = 0;
                while (i > 0) {
                    int readBits = bitSource.readBits(13);
                    int i4 = (readBits % 192) | ((readBits / 192) << 8);
                    if (i4 < 7936) {
                        i2 = 33088;
                    } else {
                        i2 = 49472;
                    }
                    int i5 = i4 + i2;
                    bArr[i3] = (byte) (i5 >> 8);
                    bArr[i3 + 1] = (byte) i5;
                    i3 += 2;
                    i--;
                }
                try {
                    sb.append(new String(bArr, StringUtils.SHIFT_JIS));
                    return;
                } catch (UnsupportedEncodingException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
            throw FormatException.getFormatInstance();
        }
    }

    public static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, null, bitSource, sb, i) == null) {
            while (i >= 3) {
                if (bitSource.available() >= 10) {
                    int readBits = bitSource.readBits(10);
                    if (readBits < 1000) {
                        sb.append(toAlphaNumericChar(readBits / 100));
                        sb.append(toAlphaNumericChar((readBits / 10) % 10));
                        sb.append(toAlphaNumericChar(readBits % 10));
                        i -= 3;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i == 2) {
                if (bitSource.available() >= 7) {
                    int readBits2 = bitSource.readBits(7);
                    if (readBits2 < 100) {
                        sb.append(toAlphaNumericChar(readBits2 / 10));
                        sb.append(toAlphaNumericChar(readBits2 % 10));
                        return;
                    }
                    throw FormatException.getFormatInstance();
                }
                throw FormatException.getFormatInstance();
            } else if (i == 1) {
                if (bitSource.available() >= 4) {
                    int readBits3 = bitSource.readBits(4);
                    if (readBits3 < 10) {
                        sb.append(toAlphaNumericChar(readBits3));
                        return;
                    }
                    throw FormatException.getFormatInstance();
                }
                throw FormatException.getFormatInstance();
            }
        }
    }

    public static int parseECIValue(BitSource bitSource) throws FormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bitSource)) == null) {
            int readBits = bitSource.readBits(8);
            if ((readBits & 128) == 0) {
                return readBits & 127;
            }
            if ((readBits & 192) == 128) {
                return bitSource.readBits(8) | ((readBits & 63) << 8);
            }
            if ((readBits & 224) == 192) {
                return bitSource.readBits(16) | ((readBits & 31) << 16);
            }
            throw FormatException.getFormatInstance();
        }
        return invokeL.intValue;
    }

    public static char toAlphaNumericChar(int i) throws FormatException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            char[] cArr = ALPHANUMERIC_CHARS;
            if (i < cArr.length) {
                return cArr[i];
            }
            throw FormatException.getFormatInstance();
        }
        return invokeI.charValue;
    }
}
