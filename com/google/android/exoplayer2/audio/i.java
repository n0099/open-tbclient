package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class i {
    private final int mbP;
    private final int mbQ;
    private final float mbR;
    private final int mbS;
    private final int mbT;
    private final int mbU;
    private final short[] mbV;
    private int mbW;
    private short[] mbX;
    private int mbY;
    private short[] mbZ;
    private int mca;
    private short[] mcb;
    private int mce;
    private int mcf;
    private int mcg;
    private int mch;
    private int mcj;
    private int mck;
    private int mcl;
    private final float pitch;
    private final float speed;
    private int mcc = 0;
    private int mcd = 0;
    private int mci = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.mbP = i;
        this.mbQ = i2;
        this.mbS = i / 400;
        this.mbT = i / 65;
        this.mbU = this.mbT * 2;
        this.mbV = new short[this.mbU];
        this.mbW = this.mbU;
        this.mbX = new short[this.mbU * i2];
        this.mbY = this.mbU;
        this.mbZ = new short[this.mbU * i2];
        this.mca = this.mbU;
        this.mcb = new short[this.mbU * i2];
        this.speed = f;
        this.pitch = f2;
        this.mbR = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.mbQ;
        Jd(remaining);
        shortBuffer.get(this.mbX, this.mce * this.mbQ, ((this.mbQ * remaining) * 2) / 2);
        this.mce = remaining + this.mce;
        dtd();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.mbQ, this.mcf);
        shortBuffer.put(this.mbZ, 0, this.mbQ * min);
        this.mcf -= min;
        System.arraycopy(this.mbZ, min * this.mbQ, this.mbZ, 0, this.mcf * this.mbQ);
    }

    public void dsB() {
        int i = this.mce;
        int i2 = this.mcf + ((int) ((((i / (this.speed / this.pitch)) + this.mcg) / (this.mbR * this.pitch)) + 0.5f));
        Jd((this.mbU * 2) + i);
        for (int i3 = 0; i3 < this.mbU * 2 * this.mbQ; i3++) {
            this.mbX[(this.mbQ * i) + i3] = 0;
        }
        this.mce += this.mbU * 2;
        dtd();
        if (this.mcf > i2) {
            this.mcf = i2;
        }
        this.mce = 0;
        this.mch = 0;
        this.mcg = 0;
    }

    public int dtc() {
        return this.mcf;
    }

    private void Jc(int i) {
        if (this.mcf + i > this.mbY) {
            this.mbY += (this.mbY / 2) + i;
            this.mbZ = Arrays.copyOf(this.mbZ, this.mbY * this.mbQ);
        }
    }

    private void Jd(int i) {
        if (this.mce + i > this.mbW) {
            this.mbW += (this.mbW / 2) + i;
            this.mbX = Arrays.copyOf(this.mbX, this.mbW * this.mbQ);
        }
    }

    private void Je(int i) {
        int i2 = this.mce - i;
        System.arraycopy(this.mbX, this.mbQ * i, this.mbX, 0, this.mbQ * i2);
        this.mce = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jc(i2);
        System.arraycopy(sArr, this.mbQ * i, this.mbZ, this.mcf * this.mbQ, this.mbQ * i2);
        this.mcf += i2;
    }

    private int Jf(int i) {
        int min = Math.min(this.mbU, this.mch);
        a(this.mbX, i, min);
        this.mch -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mbU / i2;
        int i4 = this.mbQ * i2;
        int i5 = i * this.mbQ;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mbV[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.mbQ;
        int i8 = i2;
        int i9 = 0;
        int i10 = 0;
        while (i8 <= i3) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i8) {
                int abs = Math.abs(sArr[i7 + i11] - sArr[(i7 + i8) + i11]) + i12;
                i11++;
                i12 = abs;
            }
            if (i12 * i10 < i6 * i8) {
                i6 = i12;
                i10 = i8;
            }
            if (i12 * i5 > i9 * i8) {
                i4 = i8;
            } else {
                i12 = i9;
                i4 = i5;
            }
            i8++;
            i5 = i4;
            i9 = i12;
        }
        this.mck = i6 / i10;
        this.mcl = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.mci == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.mcj * 3) {
                return false;
            }
        } else if (i <= this.mcj) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.mbP > 4000 ? this.mbP / 4000 : 1;
        if (this.mbQ == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mbS, this.mbT);
        } else {
            b(sArr, i, i3);
            int a = a(this.mbV, 0, this.mbS / i3, this.mbT / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mbS ? this.mbS : i5;
                int i8 = i6 > this.mbT ? this.mbT : i6;
                if (this.mbQ == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mbV, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.mck, this.mcl, z) ? this.mci : i2;
        this.mcj = this.mck;
        this.mci = i2;
        return i9;
    }

    private void Jg(int i) {
        int i2 = this.mcf - i;
        if (this.mcg + i2 > this.mca) {
            this.mca += (this.mca / 2) + i2;
            this.mcb = Arrays.copyOf(this.mcb, this.mca * this.mbQ);
        }
        System.arraycopy(this.mbZ, this.mbQ * i, this.mcb, this.mcg * this.mbQ, this.mbQ * i2);
        this.mcf = i;
        this.mcg = i2 + this.mcg;
    }

    private void Jh(int i) {
        if (i != 0) {
            System.arraycopy(this.mcb, this.mbQ * i, this.mcb, 0, (this.mcg - i) * this.mbQ);
            this.mcg -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.mbQ + i];
        int i4 = (this.mcc + 1) * i3;
        int i5 = i4 - (this.mcd * i2);
        int i6 = i4 - (this.mcc * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.mcf != i) {
            int i2 = this.mbP;
            int i3 = (int) (this.mbP / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jg(i);
            for (int i4 = 0; i4 < this.mcg - 1; i4++) {
                while ((this.mcc + 1) * i3 > this.mcd * i2) {
                    Jc(1);
                    for (int i5 = 0; i5 < this.mbQ; i5++) {
                        this.mbZ[(this.mcf * this.mbQ) + i5] = b(this.mcb, (this.mbQ * i4) + i5, i2, i3);
                    }
                    this.mcd++;
                    this.mcf++;
                }
                this.mcc++;
                if (this.mcc == i2) {
                    this.mcc = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.mcd == i3);
                    this.mcd = 0;
                }
            }
            Jh(this.mcg - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.mch = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jc(i3);
        a(i3, this.mbQ, this.mbZ, this.mcf, sArr, i, sArr, i + i2);
        this.mcf += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.mch = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jc(i2 + i3);
        System.arraycopy(sArr, this.mbQ * i, this.mbZ, this.mcf * this.mbQ, this.mbQ * i2);
        a(i3, this.mbQ, this.mbZ, this.mcf + i2, sArr, i + i2, sArr, i);
        this.mcf += i2 + i3;
        return i3;
    }

    private void bw(float f) {
        if (this.mce >= this.mbU) {
            int i = this.mce;
            int i2 = 0;
            do {
                if (this.mch > 0) {
                    i2 += Jf(i2);
                } else {
                    int a = a(this.mbX, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.mbX, i2, f, a);
                    } else {
                        i2 += b(this.mbX, i2, f, a);
                    }
                }
            } while (this.mbU + i2 <= i);
            Je(i2);
        }
    }

    private void dtd() {
        int i = this.mcf;
        float f = this.speed / this.pitch;
        float f2 = this.mbR * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bw(f);
        } else {
            a(this.mbX, 0, this.mce);
            this.mce = 0;
        }
        if (f2 != 1.0f) {
            b(f2, i);
        }
    }

    private static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
