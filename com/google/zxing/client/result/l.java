package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class l extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public k b(com.google.zxing.h hVar) {
        String c;
        if (hVar.c() != BarcodeFormat.RSS_EXPANDED || (c = c(hVar)) == null) {
            return null;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < c.length()) {
            String a2 = a(i, c);
            if (a2 == null) {
                return null;
            }
            int length = i + a2.length() + 2;
            String b = b(length, c);
            i = length + b.length();
            if ("00".equals(a2)) {
                str2 = b;
            } else if ("01".equals(a2)) {
                str = b;
            } else if ("10".equals(a2)) {
                str3 = b;
            } else if ("11".equals(a2)) {
                str4 = b;
            } else if ("13".equals(a2)) {
                str5 = b;
            } else if ("15".equals(a2)) {
                str6 = b;
            } else if ("17".equals(a2)) {
                str7 = b;
            } else if ("3100".equals(a2) || "3101".equals(a2) || "3102".equals(a2) || "3103".equals(a2) || "3104".equals(a2) || "3105".equals(a2) || "3106".equals(a2) || "3107".equals(a2) || "3108".equals(a2) || "3109".equals(a2)) {
                str9 = "KG";
                str10 = a2.substring(3);
                str8 = b;
            } else if ("3200".equals(a2) || "3201".equals(a2) || "3202".equals(a2) || "3203".equals(a2) || "3204".equals(a2) || "3205".equals(a2) || "3206".equals(a2) || "3207".equals(a2) || "3208".equals(a2) || "3209".equals(a2)) {
                str9 = "LB";
                str10 = a2.substring(3);
                str8 = b;
            } else if ("3920".equals(a2) || "3921".equals(a2) || "3922".equals(a2) || "3923".equals(a2)) {
                str12 = a2.substring(3);
                str11 = b;
            } else if ("3930".equals(a2) || "3931".equals(a2) || "3932".equals(a2) || "3933".equals(a2)) {
                if (b.length() < 4) {
                    return null;
                }
                str11 = b.substring(3);
                str13 = b.substring(0, 3);
                str12 = a2.substring(3);
            } else {
                hashMap.put(a2, b);
            }
        }
        return new k(c, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, hashMap);
    }

    private static String a(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String b(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (a(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
