package com.google.zxing.qrcode.encoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Encoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ALPHANUMERIC_TABLE;
    public static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1711323423, "Lcom/google/zxing/qrcode/encoder/Encoder$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1711323423, "Lcom/google/zxing/qrcode/encoder/Encoder$1;");
                    return;
                }
            }
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2097867852, "Lcom/google/zxing/qrcode/encoder/Encoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2097867852, "Lcom/google/zxing/qrcode/encoder/Encoder;");
                return;
            }
        }
        ALPHANUMERIC_TABLE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    }

    public Encoder() {
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

    public static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, bitArray, str2) == null) {
            try {
                for (byte b2 : str.getBytes(str2)) {
                    bitArray.appendBits(b2, 8);
                }
            } catch (UnsupportedEncodingException e2) {
                throw new WriterException(e2);
            }
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, charSequence, bitArray) == null) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int alphanumericCode = getAlphanumericCode(charSequence.charAt(i2));
                if (alphanumericCode == -1) {
                    throw new WriterException();
                }
                int i3 = i2 + 1;
                if (i3 < length) {
                    int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i3));
                    if (alphanumericCode2 != -1) {
                        bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                        i2 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    bitArray.appendBits(alphanumericCode, 6);
                    i2 = i3;
                }
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, mode, bitArray, str2) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
            if (i2 == 1) {
                appendNumericBytes(str, bitArray);
            } else if (i2 == 2) {
                appendAlphanumericBytes(str, bitArray);
            } else if (i2 == 3) {
                append8BitBytes(str, bitArray, str2);
            } else if (i2 == 4) {
                appendKanjiBytes(str, bitArray);
            } else {
                throw new WriterException("Invalid mode: " + mode);
            }
        }
    }

    public static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, characterSetECI, bitArray) == null) {
            bitArray.appendBits(Mode.ECI.getBits(), 4);
            bitArray.appendBits(characterSetECI.getValue(), 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[LOOP:0: B:6:0x000c->B:19:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void appendKanjiBytes(String str, BitArray bitArray) throws WriterException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, bitArray) == null) {
            try {
                byte[] bytes = str.getBytes("Shift_JIS");
                int length = bytes.length;
                for (int i3 = 0; i3 < length; i3 += 2) {
                    int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                    int i5 = 33088;
                    if (i4 < 33088 || i4 > 40956) {
                        if (i4 < 57408 || i4 > 60351) {
                            i2 = -1;
                            if (i2 == -1) {
                                bitArray.appendBits(((i2 >> 8) * 192) + (i2 & 255), 13);
                            } else {
                                throw new WriterException("Invalid byte sequence");
                            }
                        } else {
                            i5 = 49472;
                        }
                    }
                    i2 = i4 - i5;
                    if (i2 == -1) {
                    }
                }
            } catch (UnsupportedEncodingException e2) {
                throw new WriterException(e2);
            }
        }
    }

    public static void appendLengthInfo(int i2, Version version, Mode mode, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i2), version, mode, bitArray}) == null) {
            int characterCountBits = mode.getCharacterCountBits(version);
            int i3 = 1 << characterCountBits;
            if (i2 < i3) {
                bitArray.appendBits(i2, characterCountBits);
                return;
            }
            throw new WriterException(i2 + " is bigger than " + (i3 - 1));
        }
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, mode, bitArray) == null) {
            bitArray.appendBits(mode.getBits(), 4);
        }
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, charSequence, bitArray) == null) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                int charAt = charSequence.charAt(i2) - '0';
                int i3 = i2 + 2;
                if (i3 < length) {
                    bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                    i2 += 3;
                } else {
                    i2++;
                    if (i2 < length) {
                        bitArray.appendBits((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                        i2 = i3;
                    } else {
                        bitArray.appendBits(charAt, 4);
                    }
                }
            }
        }
    }

    public static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, mode, bitArray, bitArray2, version)) == null) ? bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize() : invokeLLLL.intValue;
    }

    public static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, byteMatrix)) == null) ? MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix) : invokeL.intValue;
    }

    public static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, bitArray, errorCorrectionLevel, version, byteMatrix)) == null) {
            int i2 = Integer.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < 8; i4++) {
                MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i4, byteMatrix);
                int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
                if (calculateMaskPenalty < i2) {
                    i3 = i4;
                    i2 = calculateMaskPenalty;
                }
            }
            return i3;
        }
        return invokeLLLL.intValue;
    }

    public static Mode chooseMode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? chooseMode(str, null) : (Mode) invokeL.objValue;
    }

    public static Version chooseVersion(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, errorCorrectionLevel)) == null) {
            for (int i3 = 1; i3 <= 40; i3++) {
                Version versionForNumber = Version.getVersionForNumber(i3);
                if (willFit(i2, versionForNumber, errorCorrectionLevel)) {
                    return versionForNumber;
                }
            }
            throw new WriterException("Data too big");
        }
        return (Version) invokeIL.objValue;
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, errorCorrectionLevel)) == null) ? encode(str, errorCorrectionLevel, null) : (QRCode) invokeLL.objValue;
    }

    public static byte[] generateECBytes(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, bArr, i2)) == null) {
            int length = bArr.length;
            int[] iArr = new int[length + i2];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = bArr[i3] & 255;
            }
            new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i2);
            byte[] bArr2 = new byte[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr2[i4] = (byte) iArr[length + i4];
            }
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static int getAlphanumericCode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) {
            int[] iArr = ALPHANUMERIC_TABLE;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, iArr2}) == null) {
            if (i5 < i4) {
                int i6 = i2 % i4;
                int i7 = i4 - i6;
                int i8 = i2 / i4;
                int i9 = i8 + 1;
                int i10 = i3 / i4;
                int i11 = i10 + 1;
                int i12 = i8 - i10;
                int i13 = i9 - i11;
                if (i12 != i13) {
                    throw new WriterException("EC bytes mismatch");
                }
                if (i4 != i7 + i6) {
                    throw new WriterException("RS blocks mismatch");
                }
                if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                    throw new WriterException("Total bytes mismatch");
                }
                if (i5 < i7) {
                    iArr[0] = i10;
                    iArr2[0] = i12;
                    return;
                }
                iArr[0] = i11;
                iArr2[0] = i13;
                return;
            }
            throw new WriterException("Block ID too large");
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i2, int i3, int i4) throws WriterException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65557, null, bitArray, i2, i3, i4)) == null) {
            if (bitArray.getSizeInBytes() == i3) {
                ArrayList<BlockPair> arrayList = new ArrayList(i4);
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    int[] iArr = new int[1];
                    int[] iArr2 = new int[1];
                    getNumDataBytesAndNumECBytesForBlockID(i2, i3, i4, i8, iArr, iArr2);
                    int i9 = iArr[0];
                    byte[] bArr = new byte[i9];
                    bitArray.toBytes(i5 << 3, bArr, 0, i9);
                    byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
                    arrayList.add(new BlockPair(bArr, generateECBytes));
                    i6 = Math.max(i6, i9);
                    i7 = Math.max(i7, generateECBytes.length);
                    i5 += iArr[0];
                }
                if (i3 == i5) {
                    BitArray bitArray2 = new BitArray();
                    for (int i10 = 0; i10 < i6; i10++) {
                        for (BlockPair blockPair : arrayList) {
                            byte[] dataBytes = blockPair.getDataBytes();
                            if (i10 < dataBytes.length) {
                                bitArray2.appendBits(dataBytes[i10], 8);
                            }
                        }
                    }
                    for (int i11 = 0; i11 < i7; i11++) {
                        for (BlockPair blockPair2 : arrayList) {
                            byte[] errorCorrectionBytes = blockPair2.getErrorCorrectionBytes();
                            if (i11 < errorCorrectionBytes.length) {
                                bitArray2.appendBits(errorCorrectionBytes[i11], 8);
                            }
                        }
                    }
                    if (i2 == bitArray2.getSizeInBytes()) {
                        return bitArray2;
                    }
                    throw new WriterException("Interleaving error: " + i2 + " and " + bitArray2.getSizeInBytes() + " differ.");
                }
                throw new WriterException("Data bytes does not match offset");
            }
            throw new WriterException("Number of bits and data bytes does not match");
        }
        return (BitArray) invokeLIII.objValue;
    }

    public static boolean isOnlyDoubleByteKanji(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            try {
                byte[] bytes = str.getBytes("Shift_JIS");
                int length = bytes.length;
                if (length % 2 != 0) {
                    return false;
                }
                for (int i2 = 0; i2 < length; i2 += 2) {
                    int i3 = bytes[i2] & 255;
                    if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                        return false;
                    }
                }
                return true;
            } catch (UnsupportedEncodingException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65559, null, errorCorrectionLevel, mode, bitArray, bitArray2)) == null) ? chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel) : (Version) invokeLLLL.objValue;
    }

    public static void terminateBits(int i2, BitArray bitArray) throws WriterException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65560, null, i2, bitArray) == null) {
            int i3 = i2 << 3;
            if (bitArray.getSize() <= i3) {
                for (int i4 = 0; i4 < 4 && bitArray.getSize() < i3; i4++) {
                    bitArray.appendBit(false);
                }
                int size = bitArray.getSize() & 7;
                if (size > 0) {
                    while (size < 8) {
                        bitArray.appendBit(false);
                        size++;
                    }
                }
                int sizeInBytes = i2 - bitArray.getSizeInBytes();
                for (int i5 = 0; i5 < sizeInBytes; i5++) {
                    bitArray.appendBits((i5 & 1) == 0 ? 236 : 17, 8);
                }
                if (bitArray.getSize() != i3) {
                    throw new WriterException("Bits size does not equal capacity");
                }
                return;
            }
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i3);
        }
    }

    public static boolean willFit(int i2, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(65561, null, i2, version, errorCorrectionLevel)) == null) ? version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i2 + 7) / 8 : invokeILL.booleanValue;
    }

    public static Mode chooseMode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
                return Mode.KANJI;
            }
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt >= '0' && charAt <= '9') {
                    z2 = true;
                } else if (getAlphanumericCode(charAt) == -1) {
                    return Mode.BYTE;
                } else {
                    z = true;
                }
            }
            if (z) {
                return Mode.ALPHANUMERIC;
            }
            if (z2) {
                return Mode.NUMERIC;
            }
            return Mode.BYTE;
        }
        return (Mode) invokeLL.objValue;
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        InterceptResult invokeLLL;
        Version recommendVersion;
        CharacterSetECI characterSetECIByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65553, null, str, errorCorrectionLevel, map)) == null) {
            String obj = (map == null || !map.containsKey(EncodeHintType.CHARACTER_SET)) ? "ISO-8859-1" : map.get(EncodeHintType.CHARACTER_SET).toString();
            Mode chooseMode = chooseMode(str, obj);
            BitArray bitArray = new BitArray();
            if (chooseMode == Mode.BYTE && !"ISO-8859-1".equals(obj) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
                appendECI(characterSetECIByName, bitArray);
            }
            appendModeInfo(chooseMode, bitArray);
            BitArray bitArray2 = new BitArray();
            appendBytes(str, chooseMode, bitArray2, obj);
            if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
                recommendVersion = Version.getVersionForNumber(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
                if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, recommendVersion), recommendVersion, errorCorrectionLevel)) {
                    throw new WriterException("Data too big for requested version");
                }
            } else {
                recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
            }
            BitArray bitArray3 = new BitArray();
            bitArray3.appendBitArray(bitArray);
            appendLengthInfo(chooseMode == Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray3);
            bitArray3.appendBitArray(bitArray2);
            Version.ECBlocks eCBlocksForLevel = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
            int totalCodewords = recommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
            terminateBits(totalCodewords, bitArray3);
            BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, recommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
            QRCode qRCode = new QRCode();
            qRCode.setECLevel(errorCorrectionLevel);
            qRCode.setMode(chooseMode);
            qRCode.setVersion(recommendVersion);
            int dimensionForVersion = recommendVersion.getDimensionForVersion();
            ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
            int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, byteMatrix);
            qRCode.setMaskPattern(chooseMaskPattern);
            MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, chooseMaskPattern, byteMatrix);
            qRCode.setMatrix(byteMatrix);
            return qRCode;
        }
        return (QRCode) invokeLLL.objValue;
    }
}
