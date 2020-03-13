package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class i {
    private final int mcN;
    private final int mcO;
    private final float mcP;
    private final int mcQ;
    private final int mcR;
    private final int mcS;
    private final short[] mcT;
    private int mcU;
    private short[] mcV;
    private int mcW;
    private short[] mcX;
    private int mcY;
    private short[] mcZ;
    private int mdc;
    private int mdd;
    private int mde;
    private int mdf;
    private int mdh;
    private int mdi;
    private int mdj;
    private final float pitch;
    private final float speed;
    private int mda = 0;
    private int mdb = 0;
    private int mdg = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.mcN = i;
        this.mcO = i2;
        this.mcQ = i / 400;
        this.mcR = i / 65;
        this.mcS = this.mcR * 2;
        this.mcT = new short[this.mcS];
        this.mcU = this.mcS;
        this.mcV = new short[this.mcS * i2];
        this.mcW = this.mcS;
        this.mcX = new short[this.mcS * i2];
        this.mcY = this.mcS;
        this.mcZ = new short[this.mcS * i2];
        this.speed = f;
        this.pitch = f2;
        this.mcP = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.mcO;
        Ji(remaining);
        shortBuffer.get(this.mcV, this.mdc * this.mcO, ((this.mcO * remaining) * 2) / 2);
        this.mdc = remaining + this.mdc;
        dut();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.mcO, this.mdd);
        shortBuffer.put(this.mcX, 0, this.mcO * min);
        this.mdd -= min;
        System.arraycopy(this.mcX, min * this.mcO, this.mcX, 0, this.mdd * this.mcO);
    }

    public void dtR() {
        int i = this.mdc;
        int i2 = this.mdd + ((int) ((((i / (this.speed / this.pitch)) + this.mde) / (this.mcP * this.pitch)) + 0.5f));
        Ji((this.mcS * 2) + i);
        for (int i3 = 0; i3 < this.mcS * 2 * this.mcO; i3++) {
            this.mcV[(this.mcO * i) + i3] = 0;
        }
        this.mdc += this.mcS * 2;
        dut();
        if (this.mdd > i2) {
            this.mdd = i2;
        }
        this.mdc = 0;
        this.mdf = 0;
        this.mde = 0;
    }

    public int dus() {
        return this.mdd;
    }

    private void Jh(int i) {
        if (this.mdd + i > this.mcW) {
            this.mcW += (this.mcW / 2) + i;
            this.mcX = Arrays.copyOf(this.mcX, this.mcW * this.mcO);
        }
    }

    private void Ji(int i) {
        if (this.mdc + i > this.mcU) {
            this.mcU += (this.mcU / 2) + i;
            this.mcV = Arrays.copyOf(this.mcV, this.mcU * this.mcO);
        }
    }

    private void Jj(int i) {
        int i2 = this.mdc - i;
        System.arraycopy(this.mcV, this.mcO * i, this.mcV, 0, this.mcO * i2);
        this.mdc = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jh(i2);
        System.arraycopy(sArr, this.mcO * i, this.mcX, this.mdd * this.mcO, this.mcO * i2);
        this.mdd += i2;
    }

    private int Jk(int i) {
        int min = Math.min(this.mcS, this.mdf);
        a(this.mcV, i, min);
        this.mdf -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mcS / i2;
        int i4 = this.mcO * i2;
        int i5 = i * this.mcO;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mcT[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.mcO;
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
        this.mdi = i6 / i10;
        this.mdj = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.mdg == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.mdh * 3) {
                return false;
            }
        } else if (i <= this.mdh) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.mcN > 4000 ? this.mcN / 4000 : 1;
        if (this.mcO == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mcQ, this.mcR);
        } else {
            b(sArr, i, i3);
            int a = a(this.mcT, 0, this.mcQ / i3, this.mcR / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mcQ ? this.mcQ : i5;
                int i8 = i6 > this.mcR ? this.mcR : i6;
                if (this.mcO == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mcT, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.mdi, this.mdj, z) ? this.mdg : i2;
        this.mdh = this.mdi;
        this.mdg = i2;
        return i9;
    }

    private void Jl(int i) {
        int i2 = this.mdd - i;
        if (this.mde + i2 > this.mcY) {
            this.mcY += (this.mcY / 2) + i2;
            this.mcZ = Arrays.copyOf(this.mcZ, this.mcY * this.mcO);
        }
        System.arraycopy(this.mcX, this.mcO * i, this.mcZ, this.mde * this.mcO, this.mcO * i2);
        this.mdd = i;
        this.mde = i2 + this.mde;
    }

    private void Jm(int i) {
        if (i != 0) {
            System.arraycopy(this.mcZ, this.mcO * i, this.mcZ, 0, (this.mde - i) * this.mcO);
            this.mde -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.mcO + i];
        int i4 = (this.mda + 1) * i3;
        int i5 = i4 - (this.mdb * i2);
        int i6 = i4 - (this.mda * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.mdd != i) {
            int i2 = this.mcN;
            int i3 = (int) (this.mcN / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jl(i);
            for (int i4 = 0; i4 < this.mde - 1; i4++) {
                while ((this.mda + 1) * i3 > this.mdb * i2) {
                    Jh(1);
                    for (int i5 = 0; i5 < this.mcO; i5++) {
                        this.mcX[(this.mdd * this.mcO) + i5] = b(this.mcZ, (this.mcO * i4) + i5, i2, i3);
                    }
                    this.mdb++;
                    this.mdd++;
                }
                this.mda++;
                if (this.mda == i2) {
                    this.mda = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.mdb == i3);
                    this.mdb = 0;
                }
            }
            Jm(this.mde - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.mdf = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jh(i3);
        a(i3, this.mcO, this.mcX, this.mdd, sArr, i, sArr, i + i2);
        this.mdd += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.mdf = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jh(i2 + i3);
        System.arraycopy(sArr, this.mcO * i, this.mcX, this.mdd * this.mcO, this.mcO * i2);
        a(i3, this.mcO, this.mcX, this.mdd + i2, sArr, i + i2, sArr, i);
        this.mdd += i2 + i3;
        return i3;
    }

    private void bv(float f) {
        if (this.mdc >= this.mcS) {
            int i = this.mdc;
            int i2 = 0;
            do {
                if (this.mdf > 0) {
                    i2 += Jk(i2);
                } else {
                    int a = a(this.mcV, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.mcV, i2, f, a);
                    } else {
                        i2 += b(this.mcV, i2, f, a);
                    }
                }
            } while (this.mcS + i2 <= i);
            Jj(i2);
        }
    }

    private void dut() {
        int i = this.mdd;
        float f = this.speed / this.pitch;
        float f2 = this.mcP * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bv(f);
        } else {
            a(this.mcV, 0, this.mdc);
            this.mdc = 0;
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
