package com.xiaomi.push;

import java.util.Random;
/* loaded from: classes7.dex */
public class gn {

    /* renamed from: a  reason: collision with other field name */
    public static final char[] f436a = "&quot;".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f41461b = "&apos;".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f41462c = "&amp;".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f41463d = "&lt;".toCharArray();

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f41464e = "&gt;".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public static Random f41460a = new Random();

    /* renamed from: f  reason: collision with root package name */
    public static char[] f41465f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(int i2) {
        if (i2 < 1) {
            return null;
        }
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = f41465f[f41460a.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            if (c2 <= '>') {
                if (c2 == '<') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f41463d);
                } else if (c2 == '>') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f41464e);
                } else if (c2 == '&') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    int i4 = i2 + 5;
                    if (length <= i4 || charArray[i2 + 1] != '#' || !Character.isDigit(charArray[i2 + 2]) || !Character.isDigit(charArray[i2 + 3]) || !Character.isDigit(charArray[i2 + 4]) || charArray[i4] != ';') {
                        i3 = i2 + 1;
                        sb.append(f41462c);
                    }
                } else if (c2 == '\"') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f436a);
                } else if (c2 == '\'') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f41461b);
                }
            }
            i2++;
        }
        if (i3 == 0) {
            return str;
        }
        if (i2 > i3) {
            sb.append(charArray, i3, i2 - i3);
        }
        return sb.toString();
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf);
        sb.append(charArray2);
        int i2 = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i2);
            if (indexOf2 <= 0) {
                sb.append(charArray, i2, charArray.length - i2);
                return sb.toString();
            }
            sb.append(charArray, i2, indexOf2 - i2);
            sb.append(charArray2);
            i2 = indexOf2 + length;
        }
    }

    public static String a(byte[] bArr) {
        return String.valueOf(bj.a(bArr));
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }
}
