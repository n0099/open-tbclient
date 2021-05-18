package com.ta.utdid2.a.a;
/* loaded from: classes7.dex */
public class e {

    /* loaded from: classes7.dex */
    public static class a {
        public int[] state;
        public int x;
        public int y;

        public a() {
            this.state = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        a a2;
        if (bArr == null || (a2 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a2);
    }

    public static a a(String str) {
        if (str != null) {
            a aVar = new a();
            for (int i2 = 0; i2 < 256; i2++) {
                aVar.state[i2] = i2;
            }
            aVar.x = 0;
            aVar.y = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                try {
                    i4 = ((str.charAt(i3) + aVar.state[i5]) + i4) % 256;
                    int i6 = aVar.state[i5];
                    aVar.state[i5] = aVar.state[i4];
                    aVar.state[i4] = i6;
                    i3 = (i3 + 1) % str.length();
                } catch (Exception unused) {
                    return null;
                }
            }
            return aVar;
        }
        return null;
    }

    public static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i2 = aVar.x;
        int i3 = aVar.y;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i2 = (i2 + 1) % 256;
            int[] iArr = aVar.state;
            i3 = (iArr[i2] + i3) % 256;
            int i5 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i5;
            bArr[i4] = (byte) (iArr[(iArr[i2] + iArr[i3]) % 256] ^ bArr[i4]);
        }
        aVar.x = i2;
        aVar.y = i3;
        return bArr;
    }
}
