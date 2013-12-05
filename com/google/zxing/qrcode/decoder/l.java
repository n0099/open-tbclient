package com.google.zxing.qrcode.decoder;

import com.baidu.zeus.bouncycastle.DERTags;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.tencent.mm.sdk.contact.RContact;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2882a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7 A[LOOP:0: B:63:0x0019->B:62:0x00d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0033 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.google.zxing.common.c a(byte[] bArr, o oVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) {
        Mode forBits;
        boolean z;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        boolean z2 = false;
        CharacterSetECI characterSetECI = null;
        while (true) {
            try {
                if (bVar.a() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bVar.a(4));
                }
                if (forBits != Mode.TERMINATOR) {
                    if (forBits == Mode.FNC1_FIRST_POSITION || forBits == Mode.FNC1_SECOND_POSITION) {
                        z = true;
                    } else if (forBits == Mode.STRUCTURED_APPEND) {
                        if (bVar.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        bVar.a(16);
                        z = z2;
                    } else if (forBits == Mode.ECI) {
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(a(bVar));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (forBits == Mode.HANZI) {
                        int a2 = bVar.a(4);
                        int a3 = bVar.a(forBits.getCharacterCountBits(oVar));
                        if (a2 == 1) {
                            a(bVar, sb, a3);
                            z = z2;
                        }
                    } else {
                        int a4 = bVar.a(forBits.getCharacterCountBits(oVar));
                        if (forBits == Mode.NUMERIC) {
                            c(bVar, sb, a4);
                            z = z2;
                        } else if (forBits == Mode.ALPHANUMERIC) {
                            a(bVar, sb, a4, z2);
                            z = z2;
                        } else if (forBits == Mode.BYTE) {
                            a(bVar, sb, a4, characterSetECI, arrayList, map);
                            z = z2;
                        } else if (forBits == Mode.KANJI) {
                            b(bVar, sb, a4);
                            z = z2;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    }
                    if (forBits != Mode.TERMINATOR) {
                        String sb2 = sb.toString();
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        return new com.google.zxing.common.c(bArr, sb2, arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString());
                    }
                    z2 = z;
                }
                z = z2;
                if (forBits != Mode.TERMINATOR) {
                }
            } catch (IllegalArgumentException e) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void a(com.google.zxing.common.b bVar, StringBuilder sb, int i) {
        int i2;
        if (i * 13 > bVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i3 = 0;
        while (i > 0) {
            int a2 = bVar.a(13);
            int i4 = (a2 % 96) | ((a2 / 96) << 8);
            if (i4 < 959) {
                i2 = 41377;
            } else {
                i2 = 42657;
            }
            int i5 = i4 + i2;
            bArr[i3] = (byte) ((i5 >> 8) & Util.MASK_8BIT);
            bArr[i3 + 1] = (byte) (i5 & Util.MASK_8BIT);
            i--;
            i3 += 2;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void b(com.google.zxing.common.b bVar, StringBuilder sb, int i) {
        int i2;
        if (i * 13 > bVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i3 = 0;
        while (i > 0) {
            int a2 = bVar.a(13);
            int i4 = (a2 % 192) | ((a2 / 192) << 8);
            if (i4 < 7936) {
                i2 = 33088;
            } else {
                i2 = 49472;
            }
            int i5 = i4 + i2;
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i--;
            i3 += 2;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void a(com.google.zxing.common.b bVar, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        String name;
        if ((i << 3) > bVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bVar.a(8);
        }
        if (characterSetECI == null) {
            name = com.google.zxing.common.j.a(bArr, map);
        } else {
            name = characterSetECI.name();
        }
        try {
            sb.append(new String(bArr, name));
            collection.add(bArr);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char a(int i) {
        if (i >= f2882a.length) {
            throw FormatException.getFormatInstance();
        }
        return f2882a[i];
    }

    private static void a(com.google.zxing.common.b bVar, StringBuilder sb, int i, boolean z) {
        while (i > 1) {
            if (bVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int a2 = bVar.a(11);
            sb.append(a(a2 / 45));
            sb.append(a(a2 % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(bVar.a(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1 && sb.charAt(length + 1) == '%') {
                        sb.deleteCharAt(length + 1);
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static void c(com.google.zxing.common.b bVar, StringBuilder sb, int i) {
        while (i >= 3) {
            if (bVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int a2 = bVar.a(10);
            if (a2 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(a2 / 100));
            sb.append(a((a2 / 10) % 10));
            sb.append(a(a2 % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int a3 = bVar.a(7);
            if (a3 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(a3 / 10));
            sb.append(a(a3 % 10));
        } else if (i == 1) {
            if (bVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int a4 = bVar.a(4);
            if (a4 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(a(a4));
        }
    }

    private static int a(com.google.zxing.common.b bVar) {
        int a2 = bVar.a(8);
        if ((a2 & DERTags.TAGGED) == 0) {
            return a2 & RContact.MM_CONTACTFLAG_ALL;
        }
        if ((a2 & 192) == 128) {
            return ((a2 & 63) << 8) | bVar.a(8);
        } else if ((a2 & 224) == 192) {
            return ((a2 & 31) << 16) | bVar.a(16);
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
