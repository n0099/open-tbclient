package com.google.zxing.oned;

import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int chooseCode(CharSequence charSequence, int i2, int i3) {
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i2);
        if (findCType3 != CType.UNCODABLE && findCType3 != CType.ONE_DIGIT) {
            if (i3 == 99) {
                return i3;
            }
            if (i3 == 100) {
                if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i2 + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                    return i3;
                }
                if (findCType == CType.FNC_1) {
                    return findCType(charSequence, i2 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i4 = i2 + 4;
                while (true) {
                    findCType2 = findCType(charSequence, i4);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i4 += 2;
                }
                return findCType2 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i2 + 1);
            }
            if (findCType3 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    public static CType findCType(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i3);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case BaseActivity.DIALOG_PROMPT /* 241 */:
                        case BaseActivity.DIALOG_LOADING /* 242 */:
                        case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK /* 243 */:
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
            int i6 = 0;
            int i7 = 1;
            while (i4 < length) {
                int chooseCode = chooseCode(str, i4, i6);
                int i8 = 100;
                if (chooseCode == i6) {
                    switch (str.charAt(i4)) {
                        case BaseActivity.DIALOG_PROMPT /* 241 */:
                            i8 = 102;
                            break;
                        case BaseActivity.DIALOG_LOADING /* 242 */:
                            i8 = 97;
                            break;
                        case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK /* 243 */:
                            i8 = 96;
                            break;
                        case 244:
                            break;
                        default:
                            if (i6 != 100) {
                                i8 = Integer.parseInt(str.substring(i4, i4 + 2));
                                i4++;
                                break;
                            } else {
                                i8 = str.charAt(i4) - ' ';
                                break;
                            }
                    }
                    i4++;
                } else {
                    i8 = i6 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                    i6 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i8]);
                i5 += i8 * i7;
                if (i4 != 0) {
                    i7++;
                }
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i5 % 103]);
            arrayList.add(Code128Reader.CODE_PATTERNS[106]);
            int i9 = 0;
            for (int[] iArr : arrayList) {
                for (int i10 : iArr) {
                    i9 += i10;
                }
            }
            boolean[] zArr = new boolean[i9];
            for (int[] iArr2 : arrayList) {
                i2 += OneDimensionalCodeWriter.appendPattern(zArr, i2, iArr2, true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
