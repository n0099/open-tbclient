package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class i {
    private final int mcC;
    private final int mcD;
    private final float mcE;
    private final int mcF;
    private final int mcG;
    private final int mcH;
    private final short[] mcI;
    private int mcJ;
    private short[] mcK;
    private int mcL;
    private short[] mcM;
    private int mcN;
    private short[] mcO;
    private int mcR;
    private int mcS;
    private int mcT;
    private int mcU;
    private int mcW;
    private int mcX;
    private int mcY;
    private final float pitch;
    private final float speed;
    private int mcP = 0;
    private int mcQ = 0;
    private int mcV = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.mcC = i;
        this.mcD = i2;
        this.mcF = i / 400;
        this.mcG = i / 65;
        this.mcH = this.mcG * 2;
        this.mcI = new short[this.mcH];
        this.mcJ = this.mcH;
        this.mcK = new short[this.mcH * i2];
        this.mcL = this.mcH;
        this.mcM = new short[this.mcH * i2];
        this.mcN = this.mcH;
        this.mcO = new short[this.mcH * i2];
        this.speed = f;
        this.pitch = f2;
        this.mcE = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.mcD;
        Ji(remaining);
        shortBuffer.get(this.mcK, this.mcR * this.mcD, ((this.mcD * remaining) * 2) / 2);
        this.mcR = remaining + this.mcR;
        dus();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.mcD, this.mcS);
        shortBuffer.put(this.mcM, 0, this.mcD * min);
        this.mcS -= min;
        System.arraycopy(this.mcM, min * this.mcD, this.mcM, 0, this.mcS * this.mcD);
    }

    public void dtQ() {
        int i = this.mcR;
        int i2 = this.mcS + ((int) ((((i / (this.speed / this.pitch)) + this.mcT) / (this.mcE * this.pitch)) + 0.5f));
        Ji((this.mcH * 2) + i);
        for (int i3 = 0; i3 < this.mcH * 2 * this.mcD; i3++) {
            this.mcK[(this.mcD * i) + i3] = 0;
        }
        this.mcR += this.mcH * 2;
        dus();
        if (this.mcS > i2) {
            this.mcS = i2;
        }
        this.mcR = 0;
        this.mcU = 0;
        this.mcT = 0;
    }

    public int dur() {
        return this.mcS;
    }

    private void Jh(int i) {
        if (this.mcS + i > this.mcL) {
            this.mcL += (this.mcL / 2) + i;
            this.mcM = Arrays.copyOf(this.mcM, this.mcL * this.mcD);
        }
    }

    private void Ji(int i) {
        if (this.mcR + i > this.mcJ) {
            this.mcJ += (this.mcJ / 2) + i;
            this.mcK = Arrays.copyOf(this.mcK, this.mcJ * this.mcD);
        }
    }

    private void Jj(int i) {
        int i2 = this.mcR - i;
        System.arraycopy(this.mcK, this.mcD * i, this.mcK, 0, this.mcD * i2);
        this.mcR = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jh(i2);
        System.arraycopy(sArr, this.mcD * i, this.mcM, this.mcS * this.mcD, this.mcD * i2);
        this.mcS += i2;
    }

    private int Jk(int i) {
        int min = Math.min(this.mcH, this.mcU);
        a(this.mcK, i, min);
        this.mcU -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mcH / i2;
        int i4 = this.mcD * i2;
        int i5 = i * this.mcD;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mcI[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.mcD;
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
        this.mcX = i6 / i10;
        this.mcY = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.mcV == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.mcW * 3) {
                return false;
            }
        } else if (i <= this.mcW) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.mcC > 4000 ? this.mcC / 4000 : 1;
        if (this.mcD == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mcF, this.mcG);
        } else {
            b(sArr, i, i3);
            int a = a(this.mcI, 0, this.mcF / i3, this.mcG / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mcF ? this.mcF : i5;
                int i8 = i6 > this.mcG ? this.mcG : i6;
                if (this.mcD == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mcI, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.mcX, this.mcY, z) ? this.mcV : i2;
        this.mcW = this.mcX;
        this.mcV = i2;
        return i9;
    }

    private void Jl(int i) {
        int i2 = this.mcS - i;
        if (this.mcT + i2 > this.mcN) {
            this.mcN += (this.mcN / 2) + i2;
            this.mcO = Arrays.copyOf(this.mcO, this.mcN * this.mcD);
        }
        System.arraycopy(this.mcM, this.mcD * i, this.mcO, this.mcT * this.mcD, this.mcD * i2);
        this.mcS = i;
        this.mcT = i2 + this.mcT;
    }

    private void Jm(int i) {
        if (i != 0) {
            System.arraycopy(this.mcO, this.mcD * i, this.mcO, 0, (this.mcT - i) * this.mcD);
            this.mcT -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.mcD + i];
        int i4 = (this.mcP + 1) * i3;
        int i5 = i4 - (this.mcQ * i2);
        int i6 = i4 - (this.mcP * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.mcS != i) {
            int i2 = this.mcC;
            int i3 = (int) (this.mcC / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jl(i);
            for (int i4 = 0; i4 < this.mcT - 1; i4++) {
                while ((this.mcP + 1) * i3 > this.mcQ * i2) {
                    Jh(1);
                    for (int i5 = 0; i5 < this.mcD; i5++) {
                        this.mcM[(this.mcS * this.mcD) + i5] = b(this.mcO, (this.mcD * i4) + i5, i2, i3);
                    }
                    this.mcQ++;
                    this.mcS++;
                }
                this.mcP++;
                if (this.mcP == i2) {
                    this.mcP = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.mcQ == i3);
                    this.mcQ = 0;
                }
            }
            Jm(this.mcT - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.mcU = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jh(i3);
        a(i3, this.mcD, this.mcM, this.mcS, sArr, i, sArr, i + i2);
        this.mcS += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.mcU = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jh(i2 + i3);
        System.arraycopy(sArr, this.mcD * i, this.mcM, this.mcS * this.mcD, this.mcD * i2);
        a(i3, this.mcD, this.mcM, this.mcS + i2, sArr, i + i2, sArr, i);
        this.mcS += i2 + i3;
        return i3;
    }

    private void bv(float f) {
        if (this.mcR >= this.mcH) {
            int i = this.mcR;
            int i2 = 0;
            do {
                if (this.mcU > 0) {
                    i2 += Jk(i2);
                } else {
                    int a = a(this.mcK, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.mcK, i2, f, a);
                    } else {
                        i2 += b(this.mcK, i2, f, a);
                    }
                }
            } while (this.mcH + i2 <= i);
            Jj(i2);
        }
    }

    private void dus() {
        int i = this.mcS;
        float f = this.speed / this.pitch;
        float f2 = this.mcE * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bv(f);
        } else {
            a(this.mcK, 0, this.mcR);
            this.mcR = 0;
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
