package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;
/* loaded from: classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:132:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        int i;
        if (map != null && map.containsKey(DecodeHintType.CHARACTER_SET)) {
            return map.get(DecodeHintType.CHARACTER_SET).toString();
        }
        int length = bArr.length;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z4 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        int i13 = 0;
        while (i13 < length && (z || z2 || z3)) {
            int i14 = bArr[i13] & 255;
            if (z3) {
                if (i2 > 0) {
                    if ((i14 & 128) != 0) {
                        i = i2 - 1;
                    }
                    z3 = false;
                    i = i2;
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) != 0) {
                        i = i2 + 1;
                        if ((i14 & 32) == 0) {
                            i3++;
                        } else {
                            i++;
                            if ((i14 & 16) == 0) {
                                i4++;
                            } else {
                                i2 = i + 1;
                                if ((i14 & 8) == 0) {
                                    i5++;
                                    i = i2;
                                }
                            }
                        }
                    }
                    z3 = false;
                    i = i2;
                }
                if (z) {
                    if (i14 > 127 && i14 < 160) {
                        z = false;
                    } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                        i12++;
                    }
                }
                if (z2) {
                    if (i6 > 0) {
                        if (i14 < 64 || i14 == 127 || i14 > 252) {
                            z2 = false;
                        } else {
                            i6--;
                        }
                    } else if (i14 == 128 || i14 == 160 || i14 > 239) {
                        z2 = false;
                    } else if (i14 > 160 && i14 < 224) {
                        i7++;
                        i9 = 0;
                        int i15 = i8 + 1;
                        if (i15 > i10) {
                            i10 = i15;
                            i8 = i15;
                        } else {
                            i8 = i15;
                        }
                    } else if (i14 > 127) {
                        i6++;
                        i8 = 0;
                        int i16 = i9 + 1;
                        if (i16 > i11) {
                            i11 = i16;
                            i9 = i16;
                        } else {
                            i9 = i16;
                        }
                    } else {
                        i8 = 0;
                        i9 = 0;
                    }
                }
                i13++;
                i2 = i;
            }
            i = i2;
            if (z) {
            }
            if (z2) {
            }
            i13++;
            i2 = i;
        }
        boolean z5 = (!z3 || i2 <= 0) ? z3 : false;
        if (z2 && i6 > 0) {
            z2 = false;
        }
        if (z5 && (z4 || i3 + i4 + i5 > 0)) {
            return UTF8;
        }
        if (z2 && (ASSUME_SHIFT_JIS || i10 >= 3 || i11 >= 3)) {
            return SHIFT_JIS;
        }
        if (z && z2) {
            return (!(i10 == 2 && i7 == 2) && i12 * 10 < length) ? ISO88591 : SHIFT_JIS;
        } else if (z) {
            return ISO88591;
        } else {
            if (z2) {
                return SHIFT_JIS;
            }
            if (z5) {
                return UTF8;
            }
            return PLATFORM_DEFAULT_ENCODING;
        }
    }
}
