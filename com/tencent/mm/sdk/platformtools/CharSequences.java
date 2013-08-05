package com.tencent.mm.sdk.platformtools;
/* loaded from: classes.dex */
public class CharSequences {
    static void a(int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 > i3) {
            throw new IndexOutOfBoundsException();
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static int compareToIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = length < length2 ? length : length2;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            char lowerCase = Character.toLowerCase(charSequence.charAt(i3));
            int i5 = i + 1;
            int lowerCase2 = lowerCase - Character.toLowerCase(charSequence2.charAt(i));
            if (lowerCase2 != 0) {
                return lowerCase2;
            }
            i = i5;
            i3 = i4;
        }
        return length - length2;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence forAsciiBytes(final byte[] bArr) {
        return new CharSequence() { // from class: com.tencent.mm.sdk.platformtools.CharSequences.1
            @Override // java.lang.CharSequence
            public final char charAt(int i) {
                return (char) bArr[i];
            }

            @Override // java.lang.CharSequence
            public final int length() {
                return bArr.length;
            }

            @Override // java.lang.CharSequence
            public final CharSequence subSequence(int i, int i2) {
                return CharSequences.forAsciiBytes(bArr, i, i2);
            }

            @Override // java.lang.CharSequence
            public final String toString() {
                return new String(bArr);
            }
        };
    }

    public static CharSequence forAsciiBytes(final byte[] bArr, final int i, final int i2) {
        a(i, i2, bArr.length);
        return new CharSequence() { // from class: com.tencent.mm.sdk.platformtools.CharSequences.2
            @Override // java.lang.CharSequence
            public final char charAt(int i3) {
                return (char) bArr[i + i3];
            }

            @Override // java.lang.CharSequence
            public final int length() {
                return i2 - i;
            }

            @Override // java.lang.CharSequence
            public final CharSequence subSequence(int i3, int i4) {
                int i5 = i3 - i;
                int i6 = i4 - i;
                CharSequences.a(i5, i6, length());
                return CharSequences.forAsciiBytes(bArr, i5, i6);
            }

            @Override // java.lang.CharSequence
            public final String toString() {
                return new String(bArr, i, length());
            }
        };
    }
}
