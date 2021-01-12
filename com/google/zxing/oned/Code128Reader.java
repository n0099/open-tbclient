package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int i;
        int i2;
        boolean z;
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int i3 = 0;
        int[] iArr = new int[6];
        boolean z2 = false;
        int i4 = nextSet;
        int i5 = nextSet;
        while (i4 < size) {
            if (bitArray.get(i4) ^ z2) {
                iArr[i3] = iArr[i3] + 1;
                z = z2;
                i = i3;
            } else {
                if (i3 == 5) {
                    float f = 0.25f;
                    int i6 = -1;
                    int i7 = 103;
                    while (i7 <= 105) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i7], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            i6 = i7;
                        } else {
                            patternMatchVariance = f;
                        }
                        i7++;
                        f = patternMatchVariance;
                    }
                    if (i6 >= 0 && bitArray.isRange(Math.max(0, i5 - ((i4 - i5) / 2)), i5, false)) {
                        return new int[]{i5, i4, i6};
                    }
                    i2 = iArr[0] + iArr[1] + i5;
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i = i3 - 1;
                } else {
                    i = i3 + 1;
                    i2 = i5;
                }
                iArr[i] = 1;
                z = !z2;
                i5 = i2;
            }
            i4++;
            z2 = z;
            i3 = i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        for (int i3 = 0; i3 < CODE_PATTERNS.length; i3++) {
            float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c;
        int i2;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i3 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i3));
        switch (i3) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        boolean z3 = false;
        boolean z4 = false;
        StringBuilder sb = new StringBuilder(20);
        int i4 = findStartPattern[0];
        int i5 = findStartPattern[1];
        int[] iArr = new int[6];
        int i6 = 0;
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = false;
        int i7 = 0;
        int i8 = 0;
        int i9 = i4;
        char c2 = c;
        while (!z3) {
            boolean z8 = false;
            int decodeCode = decodeCode(bitArray, iArr, i5);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z5 = true;
            }
            if (decodeCode != 106) {
                i2 = i6 + 1;
                i3 = (i2 * decodeCode) + i3;
            } else {
                i2 = i6;
            }
            int i10 = i5;
            for (int i11 = 0; i11 < 6; i11++) {
                i10 += iArr[i11];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c2) {
                        case 'c':
                            if (decodeCode < 100) {
                                if (decodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(decodeCode);
                                break;
                            } else {
                                boolean z9 = decodeCode != 106 ? false : z5;
                                switch (decodeCode) {
                                    case 100:
                                        c2 = 'd';
                                        z5 = z9;
                                        break;
                                    case 101:
                                        c2 = 'e';
                                        z5 = z9;
                                        break;
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                z5 = z9;
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                z5 = z9;
                                                break;
                                            }
                                        }
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        z5 = z9;
                                        break;
                                    case 106:
                                        z3 = true;
                                        z5 = z9;
                                        break;
                                }
                            }
                        case 'd':
                            if (decodeCode < 96) {
                                if (z7 == z6) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z7 = false;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z5 = false;
                                }
                                switch (decodeCode) {
                                    case 98:
                                        c2 = 'e';
                                        z8 = true;
                                        break;
                                    case 99:
                                        c2 = 'c';
                                        break;
                                    case 100:
                                        if (!z6 && z7) {
                                            z6 = true;
                                            z7 = false;
                                            break;
                                        } else if (z6 && z7) {
                                            z6 = false;
                                            z7 = false;
                                            break;
                                        } else {
                                            z7 = true;
                                            break;
                                        }
                                    case 101:
                                        c2 = 'e';
                                        break;
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                break;
                                            }
                                        }
                                        break;
                                    case 106:
                                        z3 = true;
                                        break;
                                }
                            }
                            break;
                        case 'e':
                            if (decodeCode < 64) {
                                if (z7 == z6) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z7 = false;
                                break;
                            } else if (decodeCode < 96) {
                                if (z7 == z6) {
                                    sb.append((char) (decodeCode - 64));
                                } else {
                                    sb.append((char) (decodeCode + 64));
                                }
                                z7 = false;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z5 = false;
                                }
                                switch (decodeCode) {
                                    case 96:
                                    case 97:
                                        break;
                                    case 98:
                                        c2 = 'd';
                                        z8 = true;
                                        break;
                                    case 99:
                                        c2 = 'c';
                                        break;
                                    case 100:
                                        c2 = 'd';
                                        break;
                                    case 101:
                                        if (!z6 && z7) {
                                            z6 = true;
                                            z7 = false;
                                            break;
                                        } else if (z6 && z7) {
                                            z6 = false;
                                            z7 = false;
                                            break;
                                        } else {
                                            z7 = true;
                                            break;
                                        }
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                break;
                                            }
                                        }
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        z = z3;
                                        z3 = z;
                                        break;
                                    case 106:
                                        z = true;
                                        z3 = z;
                                        break;
                                }
                            }
                            break;
                    }
                    if (z4) {
                        c2 = c2 == 'e' ? 'd' : 'e';
                    }
                    i6 = i2;
                    i8 = i7;
                    i9 = i5;
                    z4 = z8;
                    i7 = decodeCode;
                    i5 = i10;
            }
        }
        int i12 = i5 - i9;
        int nextUnset = bitArray.getNextUnset(i5);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i9) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((i3 - (i6 * i8)) % 103 != i8) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z5) {
            if (c2 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f = (findStartPattern[1] + findStartPattern[0]) / 2.0f;
        float f2 = i9 + (i12 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i13 = 0; i13 < size; i13++) {
            bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
        }
        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, i), new ResultPoint(f2, i)}, BarcodeFormat.CODE_128);
    }
}
