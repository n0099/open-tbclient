package okio;
/* loaded from: classes7.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i, int i2) {
        int i3;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        long j = 0;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                j++;
                i3 = i + 1;
            } else if (charAt < 2048) {
                j += 2;
                i3 = i + 1;
            } else if (charAt < 55296 || charAt > 57343) {
                j += 3;
                i3 = i + 1;
            } else {
                char charAt2 = i + 1 < i2 ? str.charAt(i + 1) : (char) 0;
                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                    j++;
                    i3 = i + 1;
                } else {
                    j += 4;
                    i3 = i + 2;
                }
            }
            i = i3;
        }
        return j;
    }
}
