package com.google.zxing.qrcode.decoder;

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
/* loaded from: classes20.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i = -1;
        int i2 = -1;
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        while (true) {
            try {
                int i3 = i2;
                int i4 = i;
                boolean z2 = z;
                if (bitSource.available() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bitSource.readBits(4));
                }
                if (forBits == Mode.TERMINATOR) {
                    z = z2;
                    i = i4;
                    i2 = i3;
                } else if (forBits == Mode.FNC1_FIRST_POSITION || forBits == Mode.FNC1_SECOND_POSITION) {
                    z = true;
                    i = i4;
                    i2 = i3;
                } else if (forBits == Mode.STRUCTURED_APPEND) {
                    if (bitSource.available() < 16) {
                        throw FormatException.getFormatInstance();
                    }
                    z = z2;
                    i = bitSource.readBits(8);
                    i2 = bitSource.readBits(8);
                } else if (forBits == Mode.ECI) {
                    characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                    if (characterSetECI == null) {
                        throw FormatException.getFormatInstance();
                    }
                    z = z2;
                    i = i4;
                    i2 = i3;
                } else if (forBits == Mode.HANZI) {
                    int readBits = bitSource.readBits(4);
                    int readBits2 = bitSource.readBits(forBits.getCharacterCountBits(version));
                    if (readBits == 1) {
                        decodeHanziSegment(bitSource, sb, readBits2);
                    }
                    z = z2;
                    i = i4;
                    i2 = i3;
                } else {
                    int readBits3 = bitSource.readBits(forBits.getCharacterCountBits(version));
                    if (forBits == Mode.NUMERIC) {
                        decodeNumericSegment(bitSource, sb, readBits3);
                        z = z2;
                        i = i4;
                        i2 = i3;
                    } else if (forBits == Mode.ALPHANUMERIC) {
                        decodeAlphanumericSegment(bitSource, sb, readBits3, z2);
                        z = z2;
                        i = i4;
                        i2 = i3;
                    } else if (forBits == Mode.BYTE) {
                        decodeByteSegment(bitSource, sb, readBits3, characterSetECI, arrayList, map);
                        z = z2;
                        i = i4;
                        i2 = i3;
                    } else if (forBits == Mode.KANJI) {
                        decodeKanjiSegment(bitSource, sb, readBits3);
                        z = z2;
                        i = i4;
                        i2 = i3;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                if (forBits == Mode.TERMINATOR) {
                    return new DecoderResult(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i, i2);
                }
            } catch (IllegalArgumentException e) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        int i2;
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
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
            i--;
            i3 += 2;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        int i2;
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
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
            i--;
            i3 += 2;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String name;
        if ((i << 3) > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
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
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        if (i >= ALPHANUMERIC_CHARS.length) {
            throw FormatException.getFormatInstance();
        }
        return ALPHANUMERIC_CHARS[i];
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(readBits / 45));
            sb.append(toAlphaNumericChar(readBits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1 && sb.charAt(length + 1) == '%') {
                        sb.deleteCharAt(length + 1);
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits / 100));
            sb.append(toAlphaNumericChar((readBits / 10) % 10));
            sb.append(toAlphaNumericChar(readBits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int readBits2 = bitSource.readBits(7);
            if (readBits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits2 / 10));
            sb.append(toAlphaNumericChar(readBits2 % 10));
        } else if (i == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int readBits3 = bitSource.readBits(4);
            if (readBits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(readBits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return ((readBits & 63) << 8) | bitSource.readBits(8);
        } else if ((readBits & 224) == 192) {
            return ((readBits & 31) << 16) | bitSource.readBits(16);
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
