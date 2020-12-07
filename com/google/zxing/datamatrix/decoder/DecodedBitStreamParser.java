package com.google.zxing.datamatrix.decoder;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes16.dex */
final class DecodedBitStreamParser {
    private static final char[] C40_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] C40_SHIFT2_SET_CHARS = {'!', '\"', UgcConstant.TOPIC_PATTERN_TAG, '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', UgcConstant.AT_PATTERN_TAG, '[', '\\', ']', '^', '_'};
    private static final char[] TEXT_BASIC_SET_CHARS = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] TEXT_SHIFT2_SET_CHARS = C40_SHIFT2_SET_CHARS;
    private static final char[] TEXT_SHIFT3_SET_CHARS = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DecoderResult decode(byte[] bArr) throws FormatException {
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            if (mode == Mode.ASCII_ENCODE) {
                mode = decodeAsciiSegment(bitSource, sb, sb2);
            } else {
                switch (mode) {
                    case C40_ENCODE:
                        decodeC40Segment(bitSource, sb);
                        break;
                    case TEXT_ENCODE:
                        decodeTextSegment(bitSource, sb);
                        break;
                    case ANSIX12_ENCODE:
                        decodeAnsiX12Segment(bitSource, sb);
                        break;
                    case EDIFACT_ENCODE:
                        decodeEdifactSegment(bitSource, sb);
                        break;
                    case BASE256_ENCODE:
                        decodeBase256Segment(bitSource, sb, arrayList);
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
                mode = Mode.ASCII_ENCODE;
            }
            if (mode != Mode.PAD_ENCODE) {
            }
            if (sb2.length() > 0) {
                sb.append((CharSequence) sb2);
            }
            return new DecoderResult(bArr, sb.toString(), !arrayList.isEmpty() ? null : arrayList, null);
        } while (bitSource.available() > 0);
        if (sb2.length() > 0) {
        }
        return new DecoderResult(bArr, sb.toString(), !arrayList.isEmpty() ? null : arrayList, null);
    }

    private static Mode decodeAsciiSegment(BitSource bitSource, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int readBits = bitSource.readBits(8);
            if (readBits == 0) {
                throw FormatException.getFormatInstance();
            }
            if (readBits <= 128) {
                sb.append((char) ((z ? readBits + 128 : readBits) - 1));
                return Mode.ASCII_ENCODE;
            } else if (readBits == 129) {
                return Mode.PAD_ENCODE;
            } else {
                if (readBits <= 229) {
                    int i = readBits - 130;
                    if (i < 10) {
                        sb.append('0');
                    }
                    sb.append(i);
                } else if (readBits == 230) {
                    return Mode.C40_ENCODE;
                } else {
                    if (readBits == 231) {
                        return Mode.BASE256_ENCODE;
                    }
                    if (readBits == 232) {
                        sb.append((char) 29);
                    } else if (readBits != 233 && readBits != 234) {
                        if (readBits == 235) {
                            z = true;
                        } else if (readBits == 236) {
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (readBits == 237) {
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                        } else if (readBits == 238) {
                            return Mode.ANSIX12_ENCODE;
                        } else {
                            if (readBits == 239) {
                                return Mode.TEXT_ENCODE;
                            }
                            if (readBits == 240) {
                                return Mode.EDIFACT_ENCODE;
                            }
                            if (readBits != 241 && readBits >= 242 && (readBits != 254 || bitSource.available() != 0)) {
                                throw FormatException.getFormatInstance();
                            }
                        }
                    }
                }
            }
        } while (bitSource.available() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void decodeC40Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 < 3) {
                            i = i3 + 1;
                            break;
                        } else if (i3 < C40_BASIC_SET_CHARS.length) {
                            char c = C40_BASIC_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c + 128));
                                z = false;
                                break;
                            } else {
                                sb.append(c);
                                break;
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < C40_SHIFT2_SET_CHARS.length) {
                            char c2 = C40_SHIFT2_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                            } else {
                                sb.append(c2);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else if (i3 == 30) {
                            z = true;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        i = 0;
                        break;
                    case 3:
                        if (z) {
                            sb.append((char) (i3 + 224));
                            z = false;
                        } else {
                            sb.append((char) (i3 + 96));
                        }
                        i = 0;
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeTextSegment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        int i = 0;
        boolean z = false;
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                switch (i) {
                    case 0:
                        if (i3 < 3) {
                            i = i3 + 1;
                            break;
                        } else if (i3 < TEXT_BASIC_SET_CHARS.length) {
                            char c = TEXT_BASIC_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c + 128));
                                z = false;
                                break;
                            } else {
                                sb.append(c);
                                break;
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 1:
                        if (z) {
                            sb.append((char) (i3 + 128));
                            z = false;
                        } else {
                            sb.append((char) i3);
                        }
                        i = 0;
                        break;
                    case 2:
                        if (i3 < TEXT_SHIFT2_SET_CHARS.length) {
                            char c2 = TEXT_SHIFT2_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c2 + 128));
                                z = false;
                            } else {
                                sb.append(c2);
                            }
                        } else if (i3 == 27) {
                            sb.append((char) 29);
                        } else if (i3 == 30) {
                            z = true;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        i = 0;
                        break;
                    case 3:
                        if (i3 < TEXT_SHIFT3_SET_CHARS.length) {
                            char c3 = TEXT_SHIFT3_SET_CHARS[i3];
                            if (z) {
                                sb.append((char) (c3 + 128));
                                z = false;
                            } else {
                                sb.append(c3);
                            }
                            i = 0;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void decodeAnsiX12Segment(BitSource bitSource, StringBuilder sb) throws FormatException {
        int readBits;
        int[] iArr = new int[3];
        while (bitSource.available() != 8 && (readBits = bitSource.readBits(8)) != 254) {
            parseTwoBytes(readBits, bitSource.readBits(8), iArr);
            for (int i = 0; i < 3; i++) {
                int i2 = iArr[i];
                if (i2 == 0) {
                    sb.append('\r');
                } else if (i2 == 1) {
                    sb.append('*');
                } else if (i2 == 2) {
                    sb.append('>');
                } else if (i2 == 3) {
                    sb.append(' ');
                } else if (i2 < 14) {
                    sb.append((char) (i2 + 44));
                } else if (i2 < 40) {
                    sb.append((char) (i2 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (bitSource.available() <= 0) {
                return;
            }
        }
    }

    private static void parseTwoBytes(int i, int i2, int[] iArr) {
        int i3 = ((i << 8) + i2) - 1;
        int i4 = i3 / FeatureCodes.ADVANCE_BEAUTY;
        iArr[0] = i4;
        int i5 = i3 - (i4 * FeatureCodes.ADVANCE_BEAUTY);
        int i6 = i5 / 40;
        iArr[1] = i6;
        iArr[2] = i5 - (i6 * 40);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r3.available() > 0) goto L1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void decodeEdifactSegment(BitSource bitSource, StringBuilder sb) {
        while (bitSource.available() > 16) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 4) {
                    int readBits = bitSource.readBits(6);
                    if (readBits == 31) {
                        int bitOffset = 8 - bitSource.getBitOffset();
                        if (bitOffset != 8) {
                            bitSource.readBits(bitOffset);
                            return;
                        }
                        return;
                    }
                    if ((readBits & 32) == 0) {
                        readBits |= 64;
                    }
                    sb.append((char) readBits);
                    i = i2 + 1;
                }
            }
        }
    }

    private static void decodeBase256Segment(BitSource bitSource, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int unrandomize255State;
        int byteOffset = bitSource.getByteOffset() + 1;
        int i = byteOffset + 1;
        int unrandomize255State2 = unrandomize255State(bitSource.readBits(8), byteOffset);
        if (unrandomize255State2 == 0) {
            unrandomize255State = bitSource.available() / 8;
        } else if (unrandomize255State2 < 250) {
            unrandomize255State = unrandomize255State2;
        } else {
            unrandomize255State = ((unrandomize255State2 - 249) * 250) + unrandomize255State(bitSource.readBits(8), i);
            i++;
        }
        if (unrandomize255State < 0) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[unrandomize255State];
        int i2 = 0;
        while (i2 < unrandomize255State) {
            if (bitSource.available() < 8) {
                throw FormatException.getFormatInstance();
            }
            bArr[i2] = (byte) unrandomize255State(bitSource.readBits(8), i);
            i2++;
            i++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Platform does not support required encoding: " + e);
        }
    }

    private static int unrandomize255State(int i, int i2) {
        int i3 = i - (((i2 * Opcodes.FCMPL) % 255) + 1);
        return i3 >= 0 ? i3 : i3 + 256;
    }
}
