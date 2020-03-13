package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class u {
    public static Uri fs(String str, String str2) {
        return Uri.parse(ft(str, str2));
    }

    public static String ft(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] Qy = Qy(str2);
        if (Qy[0] != -1) {
            sb.append(str2);
            a(sb, Qy[1], Qy[2]);
            return sb.toString();
        }
        int[] Qy2 = Qy(str);
        if (Qy[3] == 0) {
            return sb.append((CharSequence) str, 0, Qy2[3]).append(str2).toString();
        }
        if (Qy[2] == 0) {
            return sb.append((CharSequence) str, 0, Qy2[2]).append(str2).toString();
        }
        if (Qy[1] != 0) {
            int i = Qy2[0] + 1;
            sb.append((CharSequence) str, 0, i).append(str2);
            return a(sb, Qy[1] + i, i + Qy[2]);
        } else if (str2.charAt(Qy[1]) == '/') {
            sb.append((CharSequence) str, 0, Qy2[1]).append(str2);
            return a(sb, Qy2[1], Qy[2] + Qy2[1]);
        } else if (Qy2[0] + 2 < Qy2[1] && Qy2[1] == Qy2[2]) {
            sb.append((CharSequence) str, 0, Qy2[1]).append('/').append(str2);
            return a(sb, Qy2[1], Qy[2] + Qy2[1] + 1);
        } else {
            int lastIndexOf = str.lastIndexOf(47, Qy2[2] - 1);
            int i2 = lastIndexOf == -1 ? Qy2[1] : lastIndexOf + 1;
            sb.append((CharSequence) str, 0, i2).append(str2);
            return a(sb, Qy2[1], i2 + Qy[2]);
        }
    }

    private static String a(StringBuilder sb, int i, int i2) {
        int i3;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i4 = i;
        int i5 = i;
        int i6 = i2;
        while (i4 <= i6) {
            if (i4 == i6) {
                i3 = i4;
            } else if (sb.charAt(i4) == '/') {
                i3 = i4 + 1;
            } else {
                i4++;
            }
            if (i4 == i5 + 1 && sb.charAt(i5) == '.') {
                sb.delete(i5, i3);
                i6 -= i3 - i5;
            } else if (i4 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i5 + 1) == '.') {
                i5 = sb.lastIndexOf("/", i5 - 2) + 1;
                int i7 = i5 > i ? i5 : i;
                sb.delete(i7, i3);
                i6 -= i3 - i7;
            } else {
                i5 = i4 + 1;
            }
            int i8 = i5;
            i5 = i5;
            i4 = i8;
        }
        return sb.toString();
    }

    private static int[] Qy(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        if (indexOf4 + 2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(indexOf4 + 2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }
}
