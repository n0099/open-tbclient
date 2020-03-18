package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class i {
    private int meA;
    private short[] meB;
    private int meC;
    private short[] meD;
    private int meE;
    private short[] meF;
    private int meI;
    private int meJ;
    private int meK;
    private int meL;
    private int meN;
    private int meO;
    private int meP;
    private final int met;
    private final int meu;
    private final float mev;
    private final int mew;
    private final int mex;
    private final int mey;
    private final short[] mez;
    private final float pitch;
    private final float speed;
    private int meG = 0;
    private int meH = 0;
    private int meM = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.met = i;
        this.meu = i2;
        this.mew = i / 400;
        this.mex = i / 65;
        this.mey = this.mex * 2;
        this.mez = new short[this.mey];
        this.meA = this.mey;
        this.meB = new short[this.mey * i2];
        this.meC = this.mey;
        this.meD = new short[this.mey * i2];
        this.meE = this.mey;
        this.meF = new short[this.mey * i2];
        this.speed = f;
        this.pitch = f2;
        this.mev = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.meu;
        Jo(remaining);
        shortBuffer.get(this.meB, this.meI * this.meu, ((this.meu * remaining) * 2) / 2);
        this.meI = remaining + this.meI;
        duQ();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.meu, this.meJ);
        shortBuffer.put(this.meD, 0, this.meu * min);
        this.meJ -= min;
        System.arraycopy(this.meD, min * this.meu, this.meD, 0, this.meJ * this.meu);
    }

    public void duo() {
        int i = this.meI;
        int i2 = this.meJ + ((int) ((((i / (this.speed / this.pitch)) + this.meK) / (this.mev * this.pitch)) + 0.5f));
        Jo((this.mey * 2) + i);
        for (int i3 = 0; i3 < this.mey * 2 * this.meu; i3++) {
            this.meB[(this.meu * i) + i3] = 0;
        }
        this.meI += this.mey * 2;
        duQ();
        if (this.meJ > i2) {
            this.meJ = i2;
        }
        this.meI = 0;
        this.meL = 0;
        this.meK = 0;
    }

    public int duP() {
        return this.meJ;
    }

    private void Jn(int i) {
        if (this.meJ + i > this.meC) {
            this.meC += (this.meC / 2) + i;
            this.meD = Arrays.copyOf(this.meD, this.meC * this.meu);
        }
    }

    private void Jo(int i) {
        if (this.meI + i > this.meA) {
            this.meA += (this.meA / 2) + i;
            this.meB = Arrays.copyOf(this.meB, this.meA * this.meu);
        }
    }

    private void Jp(int i) {
        int i2 = this.meI - i;
        System.arraycopy(this.meB, this.meu * i, this.meB, 0, this.meu * i2);
        this.meI = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jn(i2);
        System.arraycopy(sArr, this.meu * i, this.meD, this.meJ * this.meu, this.meu * i2);
        this.meJ += i2;
    }

    private int Jq(int i) {
        int min = Math.min(this.mey, this.meL);
        a(this.meB, i, min);
        this.meL -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mey / i2;
        int i4 = this.meu * i2;
        int i5 = i * this.meu;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mez[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.meu;
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
        this.meO = i6 / i10;
        this.meP = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.meM == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.meN * 3) {
                return false;
            }
        } else if (i <= this.meN) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.met > 4000 ? this.met / 4000 : 1;
        if (this.meu == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mew, this.mex);
        } else {
            b(sArr, i, i3);
            int a = a(this.mez, 0, this.mew / i3, this.mex / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mew ? this.mew : i5;
                int i8 = i6 > this.mex ? this.mex : i6;
                if (this.meu == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mez, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.meO, this.meP, z) ? this.meM : i2;
        this.meN = this.meO;
        this.meM = i2;
        return i9;
    }

    private void Jr(int i) {
        int i2 = this.meJ - i;
        if (this.meK + i2 > this.meE) {
            this.meE += (this.meE / 2) + i2;
            this.meF = Arrays.copyOf(this.meF, this.meE * this.meu);
        }
        System.arraycopy(this.meD, this.meu * i, this.meF, this.meK * this.meu, this.meu * i2);
        this.meJ = i;
        this.meK = i2 + this.meK;
    }

    private void Js(int i) {
        if (i != 0) {
            System.arraycopy(this.meF, this.meu * i, this.meF, 0, (this.meK - i) * this.meu);
            this.meK -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.meu + i];
        int i4 = (this.meG + 1) * i3;
        int i5 = i4 - (this.meH * i2);
        int i6 = i4 - (this.meG * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.meJ != i) {
            int i2 = this.met;
            int i3 = (int) (this.met / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jr(i);
            for (int i4 = 0; i4 < this.meK - 1; i4++) {
                while ((this.meG + 1) * i3 > this.meH * i2) {
                    Jn(1);
                    for (int i5 = 0; i5 < this.meu; i5++) {
                        this.meD[(this.meJ * this.meu) + i5] = b(this.meF, (this.meu * i4) + i5, i2, i3);
                    }
                    this.meH++;
                    this.meJ++;
                }
                this.meG++;
                if (this.meG == i2) {
                    this.meG = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.meH == i3);
                    this.meH = 0;
                }
            }
            Js(this.meK - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.meL = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jn(i3);
        a(i3, this.meu, this.meD, this.meJ, sArr, i, sArr, i + i2);
        this.meJ += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.meL = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jn(i2 + i3);
        System.arraycopy(sArr, this.meu * i, this.meD, this.meJ * this.meu, this.meu * i2);
        a(i3, this.meu, this.meD, this.meJ + i2, sArr, i + i2, sArr, i);
        this.meJ += i2 + i3;
        return i3;
    }

    private void bv(float f) {
        if (this.meI >= this.mey) {
            int i = this.meI;
            int i2 = 0;
            do {
                if (this.meL > 0) {
                    i2 += Jq(i2);
                } else {
                    int a = a(this.meB, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.meB, i2, f, a);
                    } else {
                        i2 += b(this.meB, i2, f, a);
                    }
                }
            } while (this.mey + i2 <= i);
            Jp(i2);
        }
    }

    private void duQ() {
        int i = this.meJ;
        float f = this.speed / this.pitch;
        float f2 = this.mev * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bv(f);
        } else {
            a(this.meB, 0, this.meI);
            this.meI = 0;
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
