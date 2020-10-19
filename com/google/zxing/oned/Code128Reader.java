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
/* loaded from: classes7.dex */
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[FALL_THROUGH, PHI: r8 
      PHI: (r8v12 boolean) = (r8v4 boolean), (r8v5 boolean), (r8v5 boolean) binds: [B:27:0x0096, B:107:0x022a, B:110:0x0238] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c;
        char c2;
        boolean z;
        boolean z2 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i2 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i2));
        switch (i2) {
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
        StringBuilder sb = new StringBuilder(20);
        int i3 = findStartPattern[0];
        int i4 = findStartPattern[1];
        int[] iArr = new int[6];
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i5 = i3;
        char c3 = c;
        int i6 = 0;
        int i7 = i2;
        boolean z7 = false;
        int i8 = 0;
        int i9 = 0;
        while (!z7) {
            boolean z8 = false;
            int decodeCode = decodeCode(bitArray, iArr, i4);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z3 = true;
            }
            if (decodeCode != 106) {
                i6++;
                i7 += i6 * decodeCode;
            }
            int i10 = i4;
            for (int i11 = 0; i11 < 6; i11++) {
                i10 += iArr[i11];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c3) {
                        case 'c':
                            if (decodeCode < 100) {
                                if (decodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(decodeCode);
                                boolean z9 = z7;
                                c2 = c3;
                                z = z9;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z3 = false;
                                }
                                switch (decodeCode) {
                                    case 100:
                                        boolean z10 = z7;
                                        c2 = 'd';
                                        z = z10;
                                        break;
                                    case 101:
                                        boolean z11 = z7;
                                        c2 = 'e';
                                        z = z11;
                                        break;
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                boolean z12 = z7;
                                                c2 = c3;
                                                z = z12;
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                boolean z13 = z7;
                                                c2 = c3;
                                                z = z13;
                                                break;
                                            }
                                        }
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        boolean z14 = z7;
                                        c2 = c3;
                                        z = z14;
                                        break;
                                    case 106:
                                        c2 = c3;
                                        z = true;
                                        break;
                                }
                            }
                        case 'd':
                            if (decodeCode < 96) {
                                if (z5 == z4) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z5 = false;
                                boolean z15 = z7;
                                c2 = c3;
                                z = z15;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z3 = false;
                                }
                                switch (decodeCode) {
                                    case 96:
                                    case 97:
                                        boolean z16 = z7;
                                        c2 = c3;
                                        z = z16;
                                        break;
                                    case 98:
                                        z8 = true;
                                        boolean z17 = z7;
                                        c2 = 'e';
                                        z = z17;
                                        break;
                                    case 99:
                                        boolean z18 = z7;
                                        c2 = 'c';
                                        z = z18;
                                        break;
                                    case 100:
                                        if (!z4 && z5) {
                                            z4 = true;
                                            z5 = false;
                                            boolean z19 = z7;
                                            c2 = c3;
                                            z = z19;
                                            break;
                                        } else if (z4 && z5) {
                                            z4 = false;
                                            z5 = false;
                                            boolean z20 = z7;
                                            c2 = c3;
                                            z = z20;
                                            break;
                                        } else {
                                            z5 = true;
                                            boolean z21 = z7;
                                            c2 = c3;
                                            z = z21;
                                            break;
                                        }
                                    case 101:
                                        boolean z22 = z7;
                                        c2 = 'e';
                                        z = z22;
                                        break;
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                boolean z23 = z7;
                                                c2 = c3;
                                                z = z23;
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                boolean z24 = z7;
                                                c2 = c3;
                                                z = z24;
                                                break;
                                            }
                                        }
                                        boolean z25 = z7;
                                        c2 = c3;
                                        z = z25;
                                        break;
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        boolean z252 = z7;
                                        c2 = c3;
                                        z = z252;
                                        break;
                                    case 106:
                                        z7 = true;
                                        boolean z2522 = z7;
                                        c2 = c3;
                                        z = z2522;
                                        break;
                                }
                            }
                        case 'e':
                            if (decodeCode < 64) {
                                if (z5 == z4) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + 128));
                                }
                                z5 = false;
                                boolean z26 = z7;
                                c2 = c3;
                                z = z26;
                                break;
                            } else if (decodeCode < 96) {
                                if (z5 == z4) {
                                    sb.append((char) (decodeCode - 64));
                                } else {
                                    sb.append((char) (decodeCode + 64));
                                }
                                z5 = false;
                                boolean z27 = z7;
                                c2 = c3;
                                z = z27;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z3 = false;
                                }
                                switch (decodeCode) {
                                    case 96:
                                    case 97:
                                        boolean z28 = z7;
                                        c2 = c3;
                                        z = z28;
                                        break;
                                    case 98:
                                        z8 = true;
                                        boolean z29 = z7;
                                        c2 = 'd';
                                        z = z29;
                                        break;
                                    case 99:
                                        boolean z30 = z7;
                                        c2 = 'c';
                                        z = z30;
                                        break;
                                    case 100:
                                        boolean z31 = z7;
                                        c2 = 'd';
                                        z = z31;
                                        break;
                                    case 101:
                                        if (!z4 && z5) {
                                            z4 = true;
                                            z5 = false;
                                            boolean z32 = z7;
                                            c2 = c3;
                                            z = z32;
                                            break;
                                        } else if (z4 && z5) {
                                            z4 = false;
                                            z5 = false;
                                            boolean z33 = z7;
                                            c2 = c3;
                                            z = z33;
                                            break;
                                        } else {
                                            z5 = true;
                                            boolean z34 = z7;
                                            c2 = c3;
                                            z = z34;
                                            break;
                                        }
                                    case 102:
                                        if (z2) {
                                            if (sb.length() == 0) {
                                                sb.append("]C1");
                                                boolean z35 = z7;
                                                c2 = c3;
                                                z = z35;
                                                break;
                                            } else {
                                                sb.append((char) 29);
                                                boolean z36 = z7;
                                                c2 = c3;
                                                z = z36;
                                                break;
                                            }
                                        }
                                        boolean z37 = z7;
                                        c2 = c3;
                                        z = z37;
                                        break;
                                    case 103:
                                    case 104:
                                    case 105:
                                    default:
                                        boolean z372 = z7;
                                        c2 = c3;
                                        z = z372;
                                        break;
                                    case 106:
                                        z7 = true;
                                        boolean z3722 = z7;
                                        c2 = c3;
                                        z = z3722;
                                        break;
                                }
                            }
                    }
                    if (z6) {
                        c2 = c2 == 'e' ? 'd' : 'e';
                    }
                    i5 = i4;
                    z6 = z8;
                    i4 = i10;
                    i9 = i8;
                    i8 = decodeCode;
                    boolean z38 = z;
                    c3 = c2;
                    z7 = z38;
            }
        }
        int i12 = i4 - i5;
        int nextUnset = bitArray.getNextUnset(i4);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i5) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        if ((i7 - (i6 * i9)) % 103 != i9) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z3) {
            if (c3 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f = (findStartPattern[1] + findStartPattern[0]) / 2.0f;
        float f2 = i5 + (i12 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i13 = 0; i13 < size; i13++) {
            bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
        }
        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, i), new ResultPoint(f2, i)}, BarcodeFormat.CODE_128);
    }
}
