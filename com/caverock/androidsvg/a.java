package com.caverock.androidsvg;
/* loaded from: classes10.dex */
public class a {
    boolean lCp;
    int pos;
    long value;

    public a(boolean z, long j, int i) {
        this.lCp = z;
        this.value = j;
        this.pos = i;
    }

    public int dgX() {
        return this.pos;
    }

    public int value() {
        return (int) this.value;
    }

    public static a A(String str, int i, int i2) {
        long j = 0;
        if (i >= i2) {
            return null;
        }
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                j = (j * 16) + (charAt - '0');
            } else if (charAt >= 'A' && charAt <= 'F') {
                j = (j * 16) + (charAt - 'A') + 10;
            } else if (charAt < 'a' || charAt > 'f') {
                break;
            } else {
                j = (j * 16) + (charAt - 'a') + 10;
            }
            if (j > 4294967295L) {
                return null;
            }
            i3++;
        }
        if (i3 != i) {
            return new a(false, j, i3);
        }
        return null;
    }
}
