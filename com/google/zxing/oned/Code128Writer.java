package com.google.zxing.oned;

import com.baidu.fsg.base.activity.BaseActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes7.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat != BarcodeFormat.CODE_128) {
            throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
        }
        return super.encode(str, barcodeFormat, i, i2, map);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int i;
        int i2 = 0;
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case BaseActivity.DIALOG_PROMPT /* 241 */:
                    case BaseActivity.DIALOG_LOADING /* 242 */:
                    case 243:
                    case 244:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i4 < length) {
            int chooseCode = chooseCode(str, i4, i5);
            if (chooseCode == i5) {
                switch (str.charAt(i4)) {
                    case BaseActivity.DIALOG_PROMPT /* 241 */:
                        i = 102;
                        break;
                    case BaseActivity.DIALOG_LOADING /* 242 */:
                        i = 97;
                        break;
                    case 243:
                        i = 96;
                        break;
                    case 244:
                        i = 100;
                        break;
                    default:
                        if (i5 != 100) {
                            i = Integer.parseInt(str.substring(i4, i4 + 2));
                            i4++;
                            break;
                        } else {
                            i = str.charAt(i4) - ' ';
                            break;
                        }
                }
                i4++;
                chooseCode = i5;
            } else if (i5 != 0) {
                i = chooseCode;
            } else if (chooseCode == 100) {
                i = 104;
            } else {
                i = 105;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i]);
            int i8 = i7 + (i * i6);
            i6 = i4 != 0 ? i6 + 1 : i6;
            i7 = i8;
            i5 = chooseCode;
        }
        arrayList.add(Code128Reader.CODE_PATTERNS[i7 % 103]);
        arrayList.add(Code128Reader.CODE_PATTERNS[106]);
        int i9 = 0;
        for (int[] iArr : arrayList) {
            int length2 = iArr.length;
            int i10 = 0;
            while (i10 < length2) {
                int i11 = iArr[i10] + i9;
                i10++;
                i9 = i11;
            }
        }
        boolean[] zArr = new boolean[i9];
        for (int[] iArr2 : arrayList) {
            i2 += appendPattern(zArr, i2, iArr2, true);
        }
        return zArr;
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        if (i + 1 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i + 1);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i);
        if (findCType3 == CType.UNCODABLE || findCType3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (i2 != 99) {
            if (i2 == 100) {
                if (findCType3 != CType.FNC_1 && (findCType = findCType(charSequence, i + 2)) != CType.UNCODABLE && findCType != CType.ONE_DIGIT) {
                    if (findCType == CType.FNC_1) {
                        return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
                    }
                    int i3 = i + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i3);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i3 += 2;
                    }
                    return findCType2 == CType.ONE_DIGIT ? 100 : 99;
                }
                return i2;
            }
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i + 1);
            }
            return findCType3 == CType.TWO_DIGITS ? 99 : 100;
        }
        return i2;
    }
}
