package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class i {
    private final int mcA;
    private final int mcB;
    private final float mcC;
    private final int mcD;
    private final int mcE;
    private final int mcF;
    private final short[] mcG;
    private int mcH;
    private short[] mcI;
    private int mcJ;
    private short[] mcK;
    private int mcL;
    private short[] mcM;
    private int mcP;
    private int mcQ;
    private int mcR;
    private int mcS;
    private int mcU;
    private int mcV;
    private int mcW;
    private final float pitch;
    private final float speed;
    private int mcN = 0;
    private int mcO = 0;
    private int mcT = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.mcA = i;
        this.mcB = i2;
        this.mcD = i / 400;
        this.mcE = i / 65;
        this.mcF = this.mcE * 2;
        this.mcG = new short[this.mcF];
        this.mcH = this.mcF;
        this.mcI = new short[this.mcF * i2];
        this.mcJ = this.mcF;
        this.mcK = new short[this.mcF * i2];
        this.mcL = this.mcF;
        this.mcM = new short[this.mcF * i2];
        this.speed = f;
        this.pitch = f2;
        this.mcC = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.mcB;
        Ji(remaining);
        shortBuffer.get(this.mcI, this.mcP * this.mcB, ((this.mcB * remaining) * 2) / 2);
        this.mcP = remaining + this.mcP;
        duq();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.mcB, this.mcQ);
        shortBuffer.put(this.mcK, 0, this.mcB * min);
        this.mcQ -= min;
        System.arraycopy(this.mcK, min * this.mcB, this.mcK, 0, this.mcQ * this.mcB);
    }

    public void dtO() {
        int i = this.mcP;
        int i2 = this.mcQ + ((int) ((((i / (this.speed / this.pitch)) + this.mcR) / (this.mcC * this.pitch)) + 0.5f));
        Ji((this.mcF * 2) + i);
        for (int i3 = 0; i3 < this.mcF * 2 * this.mcB; i3++) {
            this.mcI[(this.mcB * i) + i3] = 0;
        }
        this.mcP += this.mcF * 2;
        duq();
        if (this.mcQ > i2) {
            this.mcQ = i2;
        }
        this.mcP = 0;
        this.mcS = 0;
        this.mcR = 0;
    }

    public int dup() {
        return this.mcQ;
    }

    private void Jh(int i) {
        if (this.mcQ + i > this.mcJ) {
            this.mcJ += (this.mcJ / 2) + i;
            this.mcK = Arrays.copyOf(this.mcK, this.mcJ * this.mcB);
        }
    }

    private void Ji(int i) {
        if (this.mcP + i > this.mcH) {
            this.mcH += (this.mcH / 2) + i;
            this.mcI = Arrays.copyOf(this.mcI, this.mcH * this.mcB);
        }
    }

    private void Jj(int i) {
        int i2 = this.mcP - i;
        System.arraycopy(this.mcI, this.mcB * i, this.mcI, 0, this.mcB * i2);
        this.mcP = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jh(i2);
        System.arraycopy(sArr, this.mcB * i, this.mcK, this.mcQ * this.mcB, this.mcB * i2);
        this.mcQ += i2;
    }

    private int Jk(int i) {
        int min = Math.min(this.mcF, this.mcS);
        a(this.mcI, i, min);
        this.mcS -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mcF / i2;
        int i4 = this.mcB * i2;
        int i5 = i * this.mcB;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mcG[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.mcB;
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
        this.mcV = i6 / i10;
        this.mcW = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.mcT == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.mcU * 3) {
                return false;
            }
        } else if (i <= this.mcU) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.mcA > 4000 ? this.mcA / 4000 : 1;
        if (this.mcB == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mcD, this.mcE);
        } else {
            b(sArr, i, i3);
            int a = a(this.mcG, 0, this.mcD / i3, this.mcE / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mcD ? this.mcD : i5;
                int i8 = i6 > this.mcE ? this.mcE : i6;
                if (this.mcB == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mcG, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.mcV, this.mcW, z) ? this.mcT : i2;
        this.mcU = this.mcV;
        this.mcT = i2;
        return i9;
    }

    private void Jl(int i) {
        int i2 = this.mcQ - i;
        if (this.mcR + i2 > this.mcL) {
            this.mcL += (this.mcL / 2) + i2;
            this.mcM = Arrays.copyOf(this.mcM, this.mcL * this.mcB);
        }
        System.arraycopy(this.mcK, this.mcB * i, this.mcM, this.mcR * this.mcB, this.mcB * i2);
        this.mcQ = i;
        this.mcR = i2 + this.mcR;
    }

    private void Jm(int i) {
        if (i != 0) {
            System.arraycopy(this.mcM, this.mcB * i, this.mcM, 0, (this.mcR - i) * this.mcB);
            this.mcR -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.mcB + i];
        int i4 = (this.mcN + 1) * i3;
        int i5 = i4 - (this.mcO * i2);
        int i6 = i4 - (this.mcN * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.mcQ != i) {
            int i2 = this.mcA;
            int i3 = (int) (this.mcA / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jl(i);
            for (int i4 = 0; i4 < this.mcR - 1; i4++) {
                while ((this.mcN + 1) * i3 > this.mcO * i2) {
                    Jh(1);
                    for (int i5 = 0; i5 < this.mcB; i5++) {
                        this.mcK[(this.mcQ * this.mcB) + i5] = b(this.mcM, (this.mcB * i4) + i5, i2, i3);
                    }
                    this.mcO++;
                    this.mcQ++;
                }
                this.mcN++;
                if (this.mcN == i2) {
                    this.mcN = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.mcO == i3);
                    this.mcO = 0;
                }
            }
            Jm(this.mcR - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.mcS = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jh(i3);
        a(i3, this.mcB, this.mcK, this.mcQ, sArr, i, sArr, i + i2);
        this.mcQ += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.mcS = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jh(i2 + i3);
        System.arraycopy(sArr, this.mcB * i, this.mcK, this.mcQ * this.mcB, this.mcB * i2);
        a(i3, this.mcB, this.mcK, this.mcQ + i2, sArr, i + i2, sArr, i);
        this.mcQ += i2 + i3;
        return i3;
    }

    private void bv(float f) {
        if (this.mcP >= this.mcF) {
            int i = this.mcP;
            int i2 = 0;
            do {
                if (this.mcS > 0) {
                    i2 += Jk(i2);
                } else {
                    int a = a(this.mcI, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.mcI, i2, f, a);
                    } else {
                        i2 += b(this.mcI, i2, f, a);
                    }
                }
            } while (this.mcF + i2 <= i);
            Jj(i2);
        }
    }

    private void duq() {
        int i = this.mcQ;
        float f = this.speed / this.pitch;
        float f2 = this.mcC * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bv(f);
        } else {
            a(this.mcI, 0, this.mcP);
            this.mcP = 0;
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
