package d.a.o0.a.f;

import com.android.internal.http.multipart.Part;
/* loaded from: classes5.dex */
public final class e {
    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c2 : charArray) {
            String binaryString = Integer.toBinaryString(c2);
            while (binaryString.length() < 8) {
                binaryString = "0" + binaryString;
            }
            sb.append(binaryString);
        }
        while (sb.length() % 6 != 0) {
            sb.append("0");
        }
        String valueOf = String.valueOf(sb);
        int length = valueOf.length() / 6;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            int parseInt = Integer.parseInt(valueOf.substring(0, 6), 2);
            valueOf = valueOf.substring(6);
            cArr[i2] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(parseInt);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(cArr));
        if (str.length() % 3 == 1) {
            sb2.append("==");
        } else if (str.length() % 3 == 2) {
            sb2.append("=");
        }
        for (int i3 = 76; i3 < sb2.length(); i3 += 76) {
            sb2.insert(i3, Part.CRLF);
        }
        sb2.append(Part.CRLF);
        return String.valueOf(sb2);
    }
}
