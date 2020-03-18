package com.caverock.androidsvg;
/* loaded from: classes12.dex */
public class b {
    static long lET = 922337203685477580L;
    private static final float[] lEU = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
    private static final float[] lEV = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};
    int pos;

    public int diN() {
        return this.pos;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00eb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float B(String str, int i, int i2) {
        int i3;
        char charAt;
        boolean z;
        boolean z2;
        char charAt2;
        boolean z3 = false;
        long j = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z4 = false;
        int i7 = 0;
        this.pos = i;
        if (this.pos >= i2) {
            return Float.NaN;
        }
        switch (str.charAt(this.pos)) {
            case '+':
                this.pos++;
                break;
            case '-':
                z3 = true;
                this.pos++;
                break;
        }
        int i8 = this.pos;
        while (this.pos < i2) {
            char charAt3 = str.charAt(this.pos);
            if (charAt3 == '0') {
                if (i4 == 0) {
                    i5++;
                } else {
                    i6++;
                }
            } else if (charAt3 >= '1' && charAt3 <= '9') {
                int i9 = i4 + i6;
                while (i6 > 0) {
                    if (j > lET) {
                        return Float.NaN;
                    }
                    j *= 10;
                    i6--;
                }
                if (j > lET) {
                    return Float.NaN;
                }
                j = (j * 10) + (charAt3 - '0');
                i4 = i9 + 1;
                if (j < 0) {
                    return Float.NaN;
                }
            } else {
                if (charAt3 == '.' && !z4) {
                    i7 = this.pos - i8;
                    z4 = true;
                }
                if (!z4 && this.pos == i7 + 1) {
                    return Float.NaN;
                }
                if (i4 == 0) {
                    if (i5 == 0) {
                        return Float.NaN;
                    }
                    i4 = 1;
                }
                if (z4) {
                    i6 = (i7 - i5) - i4;
                }
                if (this.pos < i2 && ((charAt = str.charAt(this.pos)) == 'E' || charAt == 'e')) {
                    boolean z5 = false;
                    this.pos++;
                    if (this.pos != i2) {
                        return Float.NaN;
                    }
                    switch (str.charAt(this.pos)) {
                        case '+':
                            this.pos++;
                            z = z5;
                            z2 = false;
                            break;
                        case ',':
                        case '.':
                        case '/':
                        default:
                            this.pos--;
                            z = false;
                            z2 = true;
                            break;
                        case '-':
                            z5 = true;
                            this.pos++;
                            z = z5;
                            z2 = false;
                            break;
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            z = false;
                            z2 = false;
                            break;
                    }
                    if (!z2) {
                        int i10 = this.pos;
                        int i11 = 0;
                        while (this.pos < i2 && (charAt2 = str.charAt(this.pos)) >= '0' && charAt2 <= '9') {
                            if (i11 > lET) {
                                return Float.NaN;
                            }
                            i11 = (i11 * 10) + (charAt2 - '0');
                            this.pos++;
                        }
                        if (this.pos == i10) {
                            return Float.NaN;
                        }
                        if (z) {
                            i3 = i6 - i11;
                        } else {
                            i3 = i6 + i11;
                        }
                        if (i3 + i4 <= 39 || i3 + i4 < -44) {
                            return Float.NaN;
                        }
                        float f = (float) j;
                        if (j != 0) {
                            if (i3 > 0) {
                                f *= lEU[i3];
                            } else if (i3 < 0) {
                                if (i3 < -38) {
                                    f = (float) (f * 1.0E-20d);
                                    i3 += 20;
                                }
                                f *= lEV[-i3];
                            }
                        }
                        return z3 ? -f : f;
                    }
                }
                i3 = i6;
                if (i3 + i4 <= 39) {
                }
                return Float.NaN;
            }
            this.pos++;
        }
        if (!z4) {
        }
        if (i4 == 0) {
        }
        if (z4) {
        }
        if (this.pos < i2) {
            boolean z52 = false;
            this.pos++;
            if (this.pos != i2) {
            }
        }
        i3 = i6;
        if (i3 + i4 <= 39) {
        }
        return Float.NaN;
    }
}
