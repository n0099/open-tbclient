package com.google.zxing.maxicode.decoder;

import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.google.zxing.common.DecoderResult;
import io.flutter.plugin.common.StandardMessageCodec;
import java.text.DecimalFormat;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes6.dex */
public final class DecodedBitStreamParser {
    public static final char ECI = 65530;
    public static final char FS = 28;
    public static final char GS = 29;
    public static final char LATCHA = 65527;
    public static final char LATCHB = 65528;
    public static final char LOCK = 65529;
    public static final char NS = 65531;
    public static final char PAD = 65532;
    public static final char RS = 30;
    public static final String[] SETS = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};
    public static final char SHIFTA = 65520;
    public static final char SHIFTB = 65521;
    public static final char SHIFTC = 65522;
    public static final char SHIFTD = 65523;
    public static final char SHIFTE = 65524;
    public static final char THREESHIFTA = 65526;
    public static final char TWOSHIFTA = 65525;

    public static DecoderResult decode(byte[] bArr, int i2) {
        String postCode3;
        StringBuilder sb = new StringBuilder(144);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
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
            } else {
                sb.insert(0, postCode3 + GS + format + GS + format2 + GS);
            }
        } else if (i2 == 4) {
            sb.append(getMessage(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(getMessage(bArr, 1, 77));
        }
        return new DecoderResult(bArr, sb.toString(), null, String.valueOf(i2));
    }

    public static int getBit(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    public static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{53, 54, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 37, 38});
    }

    public static int getInt(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                i2 += getBit(bArr2[i3], bArr) << ((bArr2.length - i3) - 1);
            }
            return i2;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getMessage(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        StringBuilder sb = new StringBuilder();
        int i8 = i2;
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        while (i8 < i2 + i3) {
            char charAt = SETS[i9].charAt(bArr[i8]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i11 = i9;
                    i9 = charAt - SHIFTA;
                    i10 = 1;
                    break;
                case 65525:
                    i10 = 2;
                    i11 = i9;
                    i9 = 0;
                    break;
                case 65526:
                    i10 = 3;
                    i11 = i9;
                    i9 = 0;
                    break;
                case 65527:
                    i9 = 0;
                    i10 = -1;
                    break;
                case 65528:
                    i9 = 1;
                    i10 = -1;
                    break;
                case 65529:
                    i10 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    i8 = i8 + 1 + 1 + 1 + 1 + 1;
                    sb.append(new DecimalFormat("000000000").format((bArr[i4] << 24) + (bArr[i5] << 18) + (bArr[i6] << StandardMessageCodec.LIST) + (bArr[i7] << 6) + bArr[i8]));
                    break;
            }
            int i12 = i10 - 1;
            if (i10 == 0) {
                i9 = i11;
            }
            i8++;
            i10 = i12;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 1, 2});
    }

    public static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    public static String getPostCode3(byte[] bArr) {
        return String.valueOf(new char[]{SETS[0].charAt(getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32})), SETS[0].charAt(getInt(bArr, new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 25, 26})), SETS[0].charAt(getInt(bArr, new byte[]{27, 28, 29, 30, 19, 20})), SETS[0].charAt(getInt(bArr, new byte[]{21, 22, 23, 24, 13, 14})), SETS[0].charAt(getInt(bArr, new byte[]{15, 16, 17, 18, 7, 8})), SETS[0].charAt(getInt(bArr, new byte[]{9, 10, 11, StandardMessageCodec.LIST, 1, 2}))});
    }

    public static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
