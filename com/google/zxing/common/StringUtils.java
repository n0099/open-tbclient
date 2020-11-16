package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes15.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
    }

    private StringUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        if (map != null && map.containsKey(DecodeHintType.CHARACTER_SET)) {
            return map.get(DecodeHintType.CHARACTER_SET).toString();
        }
        int length = bArr.length;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        boolean z7 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        int i20 = 0;
        while (true) {
            i = i9;
            if (i20 >= length || !(z4 || z5 || z6)) {
                break;
            }
            int i21 = bArr[i20] & 255;
            if (z6) {
                if (i > 0) {
                    if ((i21 & 128) != 0) {
                        i9 = i - 1;
                        z = z6;
                    }
                    i9 = i;
                    z = false;
                } else if ((i21 & 128) != 0) {
                    if ((i21 & 64) != 0) {
                        i9 = i + 1;
                        if ((i21 & 32) == 0) {
                            i10++;
                            z = z6;
                        } else {
                            i9++;
                            if ((i21 & 16) == 0) {
                                i11++;
                                z = z6;
                            } else {
                                i = i9 + 1;
                                if ((i21 & 8) == 0) {
                                    i12++;
                                    i9 = i;
                                    z = z6;
                                }
                            }
                        }
                    }
                    i9 = i;
                    z = false;
                }
                if (z4) {
                    if (i21 > 127 && i21 < 160) {
                        i2 = i19;
                        z2 = false;
                    } else if (i21 > 159 && (i21 < 192 || i21 == 215 || i21 == 247)) {
                        i2 = i19 + 1;
                        z2 = z4;
                    }
                    if (!z5) {
                        i3 = i18;
                        i4 = i17;
                        i5 = i16;
                        i6 = i15;
                        i7 = i14;
                        i8 = i13;
                        z3 = z5;
                    } else if (i13 > 0) {
                        if (i21 < 64 || i21 == 127 || i21 > 252) {
                            int i22 = i18;
                            i4 = i17;
                            i5 = i16;
                            i6 = i15;
                            i7 = i14;
                            i8 = i13;
                            z3 = false;
                            i3 = i22;
                        } else {
                            int i23 = i13 - 1;
                            z3 = z5;
                            int i24 = i17;
                            i5 = i16;
                            i6 = i15;
                            i7 = i14;
                            i8 = i23;
                            i3 = i18;
                            i4 = i24;
                        }
                    } else if (i21 == 128 || i21 == 160 || i21 > 239) {
                        int i25 = i18;
                        i4 = i17;
                        i5 = i16;
                        i6 = i15;
                        i7 = i14;
                        i8 = i13;
                        z3 = false;
                        i3 = i25;
                    } else if (i21 > 160 && i21 < 224) {
                        int i26 = i14 + 1;
                        int i27 = i15 + 1;
                        if (i27 > i17) {
                            i5 = 0;
                            i7 = i26;
                            i6 = i27;
                            i8 = i13;
                            z3 = z5;
                            int i28 = i18;
                            i4 = i27;
                            i3 = i28;
                        } else {
                            i7 = i26;
                            i8 = i13;
                            z3 = z5;
                            i3 = i18;
                            i4 = i17;
                            i5 = 0;
                            i6 = i27;
                        }
                    } else if (i21 > 127) {
                        int i29 = i13 + 1;
                        i3 = i16 + 1;
                        if (i3 > i18) {
                            i4 = i17;
                            i6 = 0;
                            i5 = i3;
                            i7 = i14;
                            i8 = i29;
                            z3 = z5;
                        } else {
                            i6 = 0;
                            i7 = i14;
                            i8 = i29;
                            z3 = z5;
                            int i30 = i17;
                            i5 = i3;
                            i3 = i18;
                            i4 = i30;
                        }
                    } else {
                        i6 = 0;
                        i7 = i14;
                        i8 = i13;
                        z3 = z5;
                        int i31 = i18;
                        i4 = i17;
                        i5 = 0;
                        i3 = i31;
                    }
                    i20++;
                    z4 = z2;
                    z5 = z3;
                    i19 = i2;
                    i13 = i8;
                    z6 = z;
                    i14 = i7;
                    i15 = i6;
                    i16 = i5;
                    i17 = i4;
                    i18 = i3;
                }
                i2 = i19;
                z2 = z4;
                if (!z5) {
                }
                i20++;
                z4 = z2;
                z5 = z3;
                i19 = i2;
                i13 = i8;
                z6 = z;
                i14 = i7;
                i15 = i6;
                i16 = i5;
                i17 = i4;
                i18 = i3;
            }
            i9 = i;
            z = z6;
            if (z4) {
            }
            i2 = i19;
            z2 = z4;
            if (!z5) {
            }
            i20++;
            z4 = z2;
            z5 = z3;
            i19 = i2;
            i13 = i8;
            z6 = z;
            i14 = i7;
            i15 = i6;
            i16 = i5;
            i17 = i4;
            i18 = i3;
        }
        boolean z8 = (!z6 || i <= 0) ? z6 : false;
        if (z5 && i13 > 0) {
            z5 = false;
        }
        if (z8 && (z7 || i10 + i11 + i12 > 0)) {
            return UTF8;
        }
        if (z5 && (ASSUME_SHIFT_JIS || i17 >= 3 || i18 >= 3)) {
            return SHIFT_JIS;
        }
        if (z4 && z5) {
            return (!(i17 == 2 && i14 == 2) && i19 * 10 < length) ? ISO88591 : SHIFT_JIS;
        } else if (z4) {
            return ISO88591;
        } else {
            if (z5) {
                return SHIFT_JIS;
            }
            if (z8) {
                return UTF8;
            }
            return PLATFORM_DEFAULT_ENCODING;
        }
    }
}
