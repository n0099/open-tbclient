package com.google.zxing.oned;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes9.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    public static final int CODE_CODE_B = 100;
    public static final int CODE_CODE_C = 99;
    public static final int CODE_FNC_1 = 102;
    public static final int CODE_FNC_2 = 97;
    public static final int CODE_FNC_3 = 96;
    public static final int CODE_FNC_4_B = 100;
    public static final int CODE_START_B = 104;
    public static final int CODE_START_C = 105;
    public static final int CODE_STOP = 106;
    public static final char ESCAPE_FNC_1 = 241;
    public static final char ESCAPE_FNC_2 = 242;
    public static final char ESCAPE_FNC_3 = 243;
    public static final char ESCAPE_FNC_4 = 244;

    /* loaded from: classes9.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2 = findCType(charSequence, i);
        if (findCType2 != CType.UNCODABLE && findCType2 != CType.ONE_DIGIT) {
            if (i2 == 99) {
                return i2;
            }
            if (i2 == 100) {
                if (findCType2 == CType.FNC_1) {
                    return i2;
                }
                CType findCType3 = findCType(charSequence, i + 2);
                if (findCType3 != CType.UNCODABLE && findCType3 != CType.ONE_DIGIT) {
                    if (findCType3 == CType.FNC_1) {
                        if (findCType(charSequence, i + 3) != CType.TWO_DIGITS) {
                            return 100;
                        }
                        return 99;
                    }
                    int i3 = i + 4;
                    while (true) {
                        findCType = findCType(charSequence, i3);
                        if (findCType != CType.TWO_DIGITS) {
                            break;
                        }
                        i3 += 2;
                    }
                    if (findCType == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                }
                return i2;
            }
            if (findCType2 == CType.FNC_1) {
                findCType2 = findCType(charSequence, i + 1);
            }
            if (findCType2 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    public static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt >= '0' && charAt <= '9') {
            int i2 = i + 1;
            if (i2 >= length) {
                return CType.ONE_DIGIT;
            }
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 >= '0' && charAt2 <= '9') {
                return CType.TWO_DIGITS;
            }
            return CType.ONE_DIGIT;
        }
        return CType.UNCODABLE;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                        case 242:
                        case 243:
                        case GDiffPatcher.COPY_UBYTE_UBYTE /* 244 */:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int chooseCode = chooseCode(str, i3, i5);
                int i7 = 100;
                if (chooseCode == i5) {
                    switch (str.charAt(i3)) {
                        case MatroskaExtractor.ID_CUE_CLUSTER_POSITION /* 241 */:
                            i7 = 102;
                            break;
                        case 242:
                            i7 = 97;
                            break;
                        case 243:
                            i7 = 96;
                            break;
                        case GDiffPatcher.COPY_UBYTE_UBYTE /* 244 */:
                            break;
                        default:
                            if (i5 != 100) {
                                i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                                i3++;
                                break;
                            } else {
                                i7 = str.charAt(i3) - ' ';
                                break;
                            }
                    }
                    i3++;
                } else {
                    if (i5 == 0) {
                        if (chooseCode == 100) {
                            i7 = 104;
                        } else {
                            i7 = 105;
                        }
                    } else {
                        i7 = chooseCode;
                    }
                    i5 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i7]);
                i4 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i4 % 103]);
            arrayList.add(Code128Reader.CODE_PATTERNS[106]);
            int i8 = 0;
            for (int[] iArr : arrayList) {
                for (int i9 : iArr) {
                    i8 += i9;
                }
            }
            boolean[] zArr = new boolean[i8];
            for (int[] iArr2 : arrayList) {
                i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr2, true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
