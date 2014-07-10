package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;
/* loaded from: classes.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = System.getProperty("file.encoding");
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        boolean z;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        String str;
        if (map == null || (str = (String) map.get(DecodeHintType.CHARACTER_SET)) == null) {
            int length = bArr.length;
            boolean z3 = true;
            boolean z4 = true;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            boolean z5 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            boolean z6 = true;
            while (i15 < length && (z3 || z4 || z6)) {
                int i18 = bArr[i15] & 255;
                if (z6) {
                    if (i6 > 0) {
                        if ((i18 & 128) == 0) {
                            z = false;
                        } else {
                            i6--;
                            z = z6;
                        }
                    } else if ((i18 & 128) != 0) {
                        if ((i18 & 64) == 0) {
                            z = false;
                        } else {
                            i6++;
                            if ((i18 & 32) == 0) {
                                i7++;
                                z = z6;
                            } else {
                                i6++;
                                if ((i18 & 16) == 0) {
                                    i8++;
                                    z = z6;
                                } else {
                                    i6++;
                                    if ((i18 & 8) == 0) {
                                        i9++;
                                        z = z6;
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                    if (z3) {
                        if (i18 > 127 && i18 < 160) {
                            z3 = false;
                        } else if (i18 > 159 && (i18 < 192 || i18 == 215 || i18 == 247)) {
                            i14++;
                        }
                    }
                    if (z4) {
                        i = i12;
                        i2 = i11;
                        i3 = i10;
                        z2 = z4;
                        int i19 = i13;
                        i4 = i17;
                        i5 = i19;
                    } else if (i10 > 0) {
                        if (i18 < 64 || i18 == 127 || i18 > 252) {
                            int i20 = i13;
                            i4 = i17;
                            i5 = i20;
                            int i21 = i12;
                            i2 = i11;
                            i3 = i10;
                            z2 = false;
                            i = i21;
                        } else {
                            int i22 = i10 - 1;
                            z2 = z4;
                            int i23 = i17;
                            i5 = i13;
                            i4 = i23;
                            int i24 = i11;
                            i3 = i22;
                            i = i12;
                            i2 = i24;
                        }
                    } else if (i18 == 128 || i18 == 160 || i18 > 239) {
                        int i25 = i13;
                        i4 = i17;
                        i5 = i25;
                        int i26 = i12;
                        i2 = i11;
                        i3 = i10;
                        z2 = false;
                        i = i26;
                    } else if (i18 > 160 && i18 < 224) {
                        int i27 = i11 + 1;
                        i5 = i12 + 1;
                        if (i5 > i13) {
                            i4 = 0;
                            i2 = i27;
                            i = i5;
                            i3 = i10;
                            z2 = z4;
                        } else {
                            i2 = i27;
                            i3 = i10;
                            z2 = z4;
                            int i28 = i13;
                            i4 = 0;
                            i = i5;
                            i5 = i28;
                        }
                    } else if (i18 > 127) {
                        int i29 = i10 + 1;
                        i = 0;
                        int i30 = i17 + 1;
                        if (i30 > i16) {
                            i16 = i30;
                            z2 = z4;
                            i5 = i13;
                            i4 = i30;
                            i2 = i11;
                            i3 = i29;
                        } else {
                            z2 = z4;
                            i5 = i13;
                            i4 = i30;
                            i2 = i11;
                            i3 = i29;
                        }
                    } else {
                        i = 0;
                        i2 = i11;
                        i3 = i10;
                        z2 = z4;
                        i5 = i13;
                        i4 = 0;
                    }
                    i15++;
                    z4 = z2;
                    i10 = i3;
                    i11 = i2;
                    i12 = i;
                    z6 = z;
                    int i31 = i4;
                    i13 = i5;
                    i17 = i31;
                }
                z = z6;
                if (z3) {
                }
                if (z4) {
                }
                i15++;
                z4 = z2;
                i10 = i3;
                i11 = i2;
                i12 = i;
                z6 = z;
                int i312 = i4;
                i13 = i5;
                i17 = i312;
            }
            boolean z7 = (!z6 || i6 <= 0) ? z6 : false;
            if (z4 && i10 > 0) {
                z4 = false;
            }
            if (z7 && (z5 || i7 + i8 + i9 > 0)) {
                return UTF8;
            }
            if (z4 && (ASSUME_SHIFT_JIS || i13 >= 3 || i16 >= 3)) {
                return SHIFT_JIS;
            }
            if (z3 && z4) {
                return (!(i13 == 2 && i11 == 2) && i14 * 10 < length) ? ISO88591 : SHIFT_JIS;
            } else if (z3) {
                return ISO88591;
            } else {
                if (z4) {
                    return SHIFT_JIS;
                }
                if (z7) {
                    return UTF8;
                }
                return PLATFORM_DEFAULT_ENCODING;
            }
        }
        return str;
    }
}
