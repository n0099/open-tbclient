package com.google.zxing.maxicode.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
final class DecodedBitStreamParser {
    private static final char ECI = 65530;
    private static final char FS = 28;
    private static final char GS = 29;
    private static final char LATCHA = 65527;
    private static final char LATCHB = 65528;
    private static final char LOCK = 65529;
    private static final char NS = 65531;
    private static final char PAD = 65532;
    private static final char RS = 30;
    private static final String[] SETS = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};
    private static final char SHIFTA = 65520;
    private static final char SHIFTB = 65521;
    private static final char SHIFTC = 65522;
    private static final char SHIFTD = 65523;
    private static final char SHIFTE = 65524;
    private static final char THREESHIFTA = 65526;
    private static final char TWOSHIFTA = 65525;

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DecoderResult decode(byte[] bArr, int i) {
        String postCode3;
        StringBuilder sb = new StringBuilder(144);
        switch (i) {
            case 2:
            case 3:
                if (i == 2) {
                    postCode3 = new DecimalFormat("0000000000".substring(0, getPostCode2Length(bArr))).format(getPostCode2(bArr));
                } else {
                    postCode3 = getPostCode3(bArr);
                }
                DecimalFormat decimalFormat = new DecimalFormat("000");
                String format = decimalFormat.format(getCountry(bArr));
                String format2 = decimalFormat.format(getServiceClass(bArr));
                sb.append(getMessage(bArr, 10, 84));
                if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                    sb.insert(9, postCode3 + GS + format + GS + format2 + GS);
                    break;
                } else {
                    sb.insert(0, postCode3 + GS + format + GS + format2 + GS);
                    break;
                }
            case 4:
                sb.append(getMessage(bArr, 1, 93));
                break;
            case 5:
                sb.append(getMessage(bArr, 1, 77));
                break;
        }
        return new DecoderResult(bArr, sb.toString(), null, String.valueOf(i));
    }

    private static int getBit(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int getInt(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr2.length) {
                i = (getBit(bArr2[i2], bArr) << ((bArr2.length - i2) - 1)) + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }

    private static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 1, 2});
    }

    private static String getPostCode3(byte[] bArr) {
        return String.valueOf(new char[]{SETS[0].charAt(getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32})), SETS[0].charAt(getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26})), SETS[0].charAt(getInt(bArr, new byte[]{27, 28, 29, 30, 19, 20})), SETS[0].charAt(getInt(bArr, new byte[]{21, 22, 23, 24, 13, 14})), SETS[0].charAt(getInt(bArr, new byte[]{15, 16, 17, 18, 7, 8})), SETS[0].charAt(getInt(bArr, new byte[]{9, 10, Constants.GZIP_CAST_TYPE, 12, 1, 2}))});
    }

    private static String getMessage(byte[] bArr, int i, int i2) {
        int i3;
        StringBuilder sb = new StringBuilder();
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        while (i4 < i + i2) {
            char charAt = SETS[i6].charAt(bArr[i4]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i3 = charAt - SHIFTA;
                    i5 = i6;
                    i7 = 1;
                    break;
                case 65525:
                    i7 = 2;
                    i5 = i6;
                    i3 = 0;
                    break;
                case 65526:
                    i7 = 3;
                    i5 = i6;
                    i3 = 0;
                    break;
                case 65527:
                    i3 = 0;
                    i7 = -1;
                    break;
                case 65528:
                    i3 = 1;
                    i7 = -1;
                    break;
                case 65529:
                    i3 = i6;
                    i7 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    i3 = i6;
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = i8 + 1;
                    int i10 = i9 + 1;
                    int i11 = (bArr[i8] << 24) + (bArr[i9] << 18) + (bArr[i10] << 12);
                    int i12 = i10 + 1;
                    int i13 = (bArr[i12] << 6) + i11;
                    i4 = i12 + 1;
                    sb.append(new DecimalFormat("000000000").format(bArr[i4] + i13));
                    i3 = i6;
                    break;
            }
            int i14 = i7 - 1;
            if (i7 == 0) {
                i3 = i5;
            }
            i4++;
            i6 = i3;
            i7 = i14;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
