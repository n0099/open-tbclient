package com.google.zxing.qrcode.encoder;

import cn.jingling.lib.file.Shared;
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
/* loaded from: classes.dex */
public final class Encoder {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = null;
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    static /* synthetic */ int[] $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode() {
        int[] iArr = $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode;
        if (iArr == null) {
            iArr = new int[Mode.valuesCustom().length];
            try {
                iArr[Mode.ALPHANUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mode.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mode.ECI.ordinal()] = 6;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mode.FNC1_FIRST_POSITION.ordinal()] = 8;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mode.FNC1_SECOND_POSITION.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Mode.KANJI.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Mode.NUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Mode.STRUCTURED_APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Mode.TERMINATOR.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            $SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode = iArr;
        }
        return iArr;
    }

    private Encoder() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [58=4] */
    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) {
        return encode(str, errorCorrectionLevel, null);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) {
        CharacterSetECI characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = DEFAULT_BYTE_MODE_ENCODING;
        }
        Mode chooseMode = chooseMode(str, str2);
        BitArray bitArray = new BitArray();
        if (chooseMode == Mode.BYTE && !DEFAULT_BYTE_MODE_ENCODING.equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, chooseMode, bitArray2, str2);
        Version chooseVersion = chooseVersion(chooseMode.getCharacterCountBits(chooseVersion(bitArray.getSize() + chooseMode.getCharacterCountBits(Version.getVersionForNumber(1)) + bitArray2.getSize(), errorCorrectionLevel)) + bitArray.getSize() + bitArray2.getSize(), errorCorrectionLevel);
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(chooseMode == Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), chooseVersion, chooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        Version.ECBlocks eCBlocksForLevel = chooseVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = chooseVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, chooseVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        QRCode qRCode = new QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(chooseMode);
        qRCode.setVersion(chooseVersion);
        int dimensionForVersion = chooseVersion.getDimensionForVersion();
        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, chooseVersion, byteMatrix);
        qRCode.setMaskPattern(chooseMaskPattern);
        MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, chooseVersion, chooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }

    static int getAlphanumericCode(int i) {
        if (i < ALPHANUMERIC_TABLE.length) {
            return ALPHANUMERIC_TABLE[i];
        }
        return -1;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return isOnlyDoubleByteKanji(str) ? Mode.KANJI : Mode.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
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

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) {
        int i = Shared.INFINITY;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i) {
                i2 = i3;
            } else {
                calculateMaskPenalty = i;
            }
            i3++;
            i = calculateMaskPenalty;
        }
        return i2;
    }

    private static Version chooseVersion(int i, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            if (versionForNumber.getTotalCodewords() - versionForNumber.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    static void terminateBits(int i, BitArray bitArray) {
        int i2 = i << 3;
        if (bitArray.getSize() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != (i5 * (i10 + i12)) + ((i9 + i11) * i6)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
            return;
        }
        iArr[0] = i10;
        iArr2[0] = i12;
    }

    static BitArray interleaveWithECBytes(BitArray bitArray, int i, int i2, int i3) {
        if (bitArray.getSizeInBytes() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList<BlockPair> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            bitArray.toBytes(i7 * 8, bArr, 0, i8);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, generateECBytes));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, generateECBytes.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i9 = 0; i9 < i6; i9++) {
            for (BlockPair blockPair : arrayList) {
                byte[] dataBytes = blockPair.getDataBytes();
                if (i9 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i9], 8);
                }
            }
        }
        for (int i10 = 0; i10 < i5; i10++) {
            for (BlockPair blockPair2 : arrayList) {
                byte[] errorCorrectionBytes = blockPair2.getErrorCorrectionBytes();
                if (i10 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i10], 8);
                }
            }
        }
        if (i != bitArray2.getSizeInBytes()) {
            throw new WriterException("Interleaving error: " + i + " and " + bitArray2.getSizeInBytes() + " differ.");
        }
        return bitArray2;
    }

    static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendLengthInfo(int i, Version version, Mode mode, BitArray bitArray) {
        int characterCountBits = mode.getCharacterCountBits(version);
        if (i >= (1 << characterCountBits)) {
            throw new WriterException(String.valueOf(i) + " is bigger than " + ((1 << characterCountBits) - 1));
        }
        bitArray.appendBits(i, characterCountBits);
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) {
        switch ($SWITCH_TABLE$com$google$zxing$qrcode$decoder$Mode()[mode.ordinal()]) {
            case 2:
                appendNumericBytes(str, bitArray);
                return;
            case 3:
                appendAlphanumericBytes(str, bitArray);
                return;
            case 4:
            case 6:
            default:
                throw new WriterException("Invalid mode: " + mode);
            case 5:
                append8BitBytes(str, bitArray, str2);
                return;
            case 7:
                appendKanjiBytes(str, bitArray);
                return;
        }
    }

    static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            if (i + 2 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i + 2) - '0'), 10);
                i += 3;
            } else if (i + 1 < length) {
                bitArray.appendBits((charAt * 10) + (charSequence.charAt(i + 1) - '0'), 7);
                i += 2;
            } else {
                bitArray.appendBits(charAt, 4);
                i++;
            }
        }
    }

    static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            if (i + 1 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i + 1));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i++;
            }
        }
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void appendKanjiBytes(String str, BitArray bitArray) {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - 33088;
                } else {
                    i = (i3 < 57408 || i3 > 60351) ? -1 : i3 - 49472;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits((i & 255) + ((i >> 8) * 192), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }
}
