package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class i {
    private final int mbU;
    private final int mbV;
    private final float mbW;
    private final int mbX;
    private final int mbY;
    private final int mbZ;
    private final short[] mca;
    private int mcb;
    private short[] mcc;
    private int mcd;
    private short[] mce;
    private int mcf;
    private short[] mcg;
    private int mcj;
    private int mck;
    private int mcl;
    private int mcm;
    private int mco;
    private int mcp;
    private int mcq;
    private final float pitch;
    private final float speed;
    private int mch = 0;
    private int mci = 0;
    private int mcn = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.mbU = i;
        this.mbV = i2;
        this.mbX = i / 400;
        this.mbY = i / 65;
        this.mbZ = this.mbY * 2;
        this.mca = new short[this.mbZ];
        this.mcb = this.mbZ;
        this.mcc = new short[this.mbZ * i2];
        this.mcd = this.mbZ;
        this.mce = new short[this.mbZ * i2];
        this.mcf = this.mbZ;
        this.mcg = new short[this.mbZ * i2];
        this.speed = f;
        this.pitch = f2;
        this.mbW = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.mbV;
        Jd(remaining);
        shortBuffer.get(this.mcc, this.mcj * this.mbV, ((this.mbV * remaining) * 2) / 2);
        this.mcj = remaining + this.mcj;
        dtf();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.mbV, this.mck);
        shortBuffer.put(this.mce, 0, this.mbV * min);
        this.mck -= min;
        System.arraycopy(this.mce, min * this.mbV, this.mce, 0, this.mck * this.mbV);
    }

    public void dsD() {
        int i = this.mcj;
        int i2 = this.mck + ((int) ((((i / (this.speed / this.pitch)) + this.mcl) / (this.mbW * this.pitch)) + 0.5f));
        Jd((this.mbZ * 2) + i);
        for (int i3 = 0; i3 < this.mbZ * 2 * this.mbV; i3++) {
            this.mcc[(this.mbV * i) + i3] = 0;
        }
        this.mcj += this.mbZ * 2;
        dtf();
        if (this.mck > i2) {
            this.mck = i2;
        }
        this.mcj = 0;
        this.mcm = 0;
        this.mcl = 0;
    }

    public int dte() {
        return this.mck;
    }

    private void Jc(int i) {
        if (this.mck + i > this.mcd) {
            this.mcd += (this.mcd / 2) + i;
            this.mce = Arrays.copyOf(this.mce, this.mcd * this.mbV);
        }
    }

    private void Jd(int i) {
        if (this.mcj + i > this.mcb) {
            this.mcb += (this.mcb / 2) + i;
            this.mcc = Arrays.copyOf(this.mcc, this.mcb * this.mbV);
        }
    }

    private void Je(int i) {
        int i2 = this.mcj - i;
        System.arraycopy(this.mcc, this.mbV * i, this.mcc, 0, this.mbV * i2);
        this.mcj = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        Jc(i2);
        System.arraycopy(sArr, this.mbV * i, this.mce, this.mck * this.mbV, this.mbV * i2);
        this.mck += i2;
    }

    private int Jf(int i) {
        int min = Math.min(this.mbZ, this.mcm);
        a(this.mcc, i, min);
        this.mcm -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.mbZ / i2;
        int i4 = this.mbV * i2;
        int i5 = i * this.mbV;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.mca[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.mbV;
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
        this.mcp = i6 / i10;
        this.mcq = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.mcn == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.mco * 3) {
                return false;
            }
        } else if (i <= this.mco) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.mbU > 4000 ? this.mbU / 4000 : 1;
        if (this.mbV == 1 && i3 == 1) {
            i2 = a(sArr, i, this.mbX, this.mbY);
        } else {
            b(sArr, i, i3);
            int a = a(this.mca, 0, this.mbX / i3, this.mbY / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.mbX ? this.mbX : i5;
                int i8 = i6 > this.mbY ? this.mbY : i6;
                if (this.mbV == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.mca, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.mcp, this.mcq, z) ? this.mcn : i2;
        this.mco = this.mcp;
        this.mcn = i2;
        return i9;
    }

    private void Jg(int i) {
        int i2 = this.mck - i;
        if (this.mcl + i2 > this.mcf) {
            this.mcf += (this.mcf / 2) + i2;
            this.mcg = Arrays.copyOf(this.mcg, this.mcf * this.mbV);
        }
        System.arraycopy(this.mce, this.mbV * i, this.mcg, this.mcl * this.mbV, this.mbV * i2);
        this.mck = i;
        this.mcl = i2 + this.mcl;
    }

    private void Jh(int i) {
        if (i != 0) {
            System.arraycopy(this.mcg, this.mbV * i, this.mcg, 0, (this.mcl - i) * this.mbV);
            this.mcl -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.mbV + i];
        int i4 = (this.mch + 1) * i3;
        int i5 = i4 - (this.mci * i2);
        int i6 = i4 - (this.mch * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.mck != i) {
            int i2 = this.mbU;
            int i3 = (int) (this.mbU / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            Jg(i);
            for (int i4 = 0; i4 < this.mcl - 1; i4++) {
                while ((this.mch + 1) * i3 > this.mci * i2) {
                    Jc(1);
                    for (int i5 = 0; i5 < this.mbV; i5++) {
                        this.mce[(this.mck * this.mbV) + i5] = b(this.mcg, (this.mbV * i4) + i5, i2, i3);
                    }
                    this.mci++;
                    this.mck++;
                }
                this.mch++;
                if (this.mch == i2) {
                    this.mch = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.mci == i3);
                    this.mci = 0;
                }
            }
            Jh(this.mcl - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.mcm = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        Jc(i3);
        a(i3, this.mbV, this.mce, this.mck, sArr, i, sArr, i + i2);
        this.mck += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.mcm = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        Jc(i2 + i3);
        System.arraycopy(sArr, this.mbV * i, this.mce, this.mck * this.mbV, this.mbV * i2);
        a(i3, this.mbV, this.mce, this.mck + i2, sArr, i + i2, sArr, i);
        this.mck += i2 + i3;
        return i3;
    }

    private void bw(float f) {
        if (this.mcj >= this.mbZ) {
            int i = this.mcj;
            int i2 = 0;
            do {
                if (this.mcm > 0) {
                    i2 += Jf(i2);
                } else {
                    int a = a(this.mcc, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.mcc, i2, f, a);
                    } else {
                        i2 += b(this.mcc, i2, f, a);
                    }
                }
            } while (this.mbZ + i2 <= i);
            Je(i2);
        }
    }

    private void dtf() {
        int i = this.mck;
        float f = this.speed / this.pitch;
        float f2 = this.mbW * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bw(f);
        } else {
            a(this.mcc, 0, this.mcj);
            this.mcj = 0;
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
