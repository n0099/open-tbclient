package com.google.android.exoplayer2.audio;

import java.nio.ShortBuffer;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class i {
    private final int lXX;
    private final int lXY;
    private final float lXZ;
    private final int lYa;
    private final int lYb;
    private final int lYc;
    private final short[] lYd;
    private int lYe;
    private short[] lYf;
    private int lYg;
    private short[] lYh;
    private int lYi;
    private short[] lYj;
    private int lYm;
    private int lYn;
    private int lYo;
    private int lYp;
    private int lYr;
    private int lYs;
    private int lYt;
    private final float pitch;
    private final float speed;
    private int lYk = 0;
    private int lYl = 0;
    private int lYq = 0;

    public i(int i, int i2, float f, float f2, int i3) {
        this.lXX = i;
        this.lXY = i2;
        this.lYa = i / 400;
        this.lYb = i / 65;
        this.lYc = this.lYb * 2;
        this.lYd = new short[this.lYc];
        this.lYe = this.lYc;
        this.lYf = new short[this.lYc * i2];
        this.lYg = this.lYc;
        this.lYh = new short[this.lYc * i2];
        this.lYi = this.lYc;
        this.lYj = new short[this.lYc * i2];
        this.speed = f;
        this.pitch = f2;
        this.lXZ = i / i3;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining() / this.lXY;
        IU(remaining);
        shortBuffer.get(this.lYf, this.lYm * this.lXY, ((this.lXY * remaining) * 2) / 2);
        this.lYm = remaining + this.lYm;
        drR();
    }

    public void c(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.lXY, this.lYn);
        shortBuffer.put(this.lYh, 0, this.lXY * min);
        this.lYn -= min;
        System.arraycopy(this.lYh, min * this.lXY, this.lYh, 0, this.lYn * this.lXY);
    }

    public void drp() {
        int i = this.lYm;
        int i2 = this.lYn + ((int) ((((i / (this.speed / this.pitch)) + this.lYo) / (this.lXZ * this.pitch)) + 0.5f));
        IU((this.lYc * 2) + i);
        for (int i3 = 0; i3 < this.lYc * 2 * this.lXY; i3++) {
            this.lYf[(this.lXY * i) + i3] = 0;
        }
        this.lYm += this.lYc * 2;
        drR();
        if (this.lYn > i2) {
            this.lYn = i2;
        }
        this.lYm = 0;
        this.lYp = 0;
        this.lYo = 0;
    }

    public int drQ() {
        return this.lYn;
    }

    private void IT(int i) {
        if (this.lYn + i > this.lYg) {
            this.lYg += (this.lYg / 2) + i;
            this.lYh = Arrays.copyOf(this.lYh, this.lYg * this.lXY);
        }
    }

    private void IU(int i) {
        if (this.lYm + i > this.lYe) {
            this.lYe += (this.lYe / 2) + i;
            this.lYf = Arrays.copyOf(this.lYf, this.lYe * this.lXY);
        }
    }

    private void IV(int i) {
        int i2 = this.lYm - i;
        System.arraycopy(this.lYf, this.lXY * i, this.lYf, 0, this.lXY * i2);
        this.lYm = i2;
    }

    private void a(short[] sArr, int i, int i2) {
        IT(i2);
        System.arraycopy(sArr, this.lXY * i, this.lYh, this.lYn * this.lXY, this.lXY * i2);
        this.lYn += i2;
    }

    private int IW(int i) {
        int min = Math.min(this.lYc, this.lYp);
        a(this.lYf, i, min);
        this.lYp -= min;
        return min;
    }

    private void b(short[] sArr, int i, int i2) {
        int i3 = this.lYc / i2;
        int i4 = this.lXY * i2;
        int i5 = i * this.lXY;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 += sArr[(i6 * i4) + i5 + i8];
            }
            this.lYd[i6] = (short) (i7 / i4);
        }
    }

    private int a(short[] sArr, int i, int i2, int i3) {
        int i4;
        int i5 = 255;
        int i6 = 1;
        int i7 = i * this.lXY;
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
        this.lYs = i6 / i10;
        this.lYt = i9 / i5;
        return i10;
    }

    private boolean r(int i, int i2, boolean z) {
        if (i == 0 || this.lYq == 0) {
            return false;
        }
        if (z) {
            if (i2 > i * 3 || i * 2 <= this.lYr * 3) {
                return false;
            }
        } else if (i <= this.lYr) {
            return false;
        }
        return true;
    }

    private int a(short[] sArr, int i, boolean z) {
        int i2;
        int i3 = this.lXX > 4000 ? this.lXX / 4000 : 1;
        if (this.lXY == 1 && i3 == 1) {
            i2 = a(sArr, i, this.lYa, this.lYb);
        } else {
            b(sArr, i, i3);
            int a = a(this.lYd, 0, this.lYa / i3, this.lYb / i3);
            if (i3 != 1) {
                int i4 = a * i3;
                int i5 = i4 - (i3 * 4);
                int i6 = i4 + (i3 * 4);
                int i7 = i5 < this.lYa ? this.lYa : i5;
                int i8 = i6 > this.lYb ? this.lYb : i6;
                if (this.lXY == 1) {
                    i2 = a(sArr, i, i7, i8);
                } else {
                    b(sArr, i, 1);
                    i2 = a(this.lYd, 0, i7, i8);
                }
            } else {
                i2 = a;
            }
        }
        int i9 = r(this.lYs, this.lYt, z) ? this.lYq : i2;
        this.lYr = this.lYs;
        this.lYq = i2;
        return i9;
    }

    private void IX(int i) {
        int i2 = this.lYn - i;
        if (this.lYo + i2 > this.lYi) {
            this.lYi += (this.lYi / 2) + i2;
            this.lYj = Arrays.copyOf(this.lYj, this.lYi * this.lXY);
        }
        System.arraycopy(this.lYh, this.lXY * i, this.lYj, this.lYo * this.lXY, this.lXY * i2);
        this.lYn = i;
        this.lYo = i2 + this.lYo;
    }

    private void IY(int i) {
        if (i != 0) {
            System.arraycopy(this.lYj, this.lXY * i, this.lYj, 0, (this.lYo - i) * this.lXY);
            this.lYo -= i;
        }
    }

    private short b(short[] sArr, int i, int i2, int i3) {
        short s = sArr[i];
        short s2 = sArr[this.lXY + i];
        int i4 = (this.lYk + 1) * i3;
        int i5 = i4 - (this.lYl * i2);
        int i6 = i4 - (this.lYk * i3);
        return (short) (((s * i5) + (s2 * (i6 - i5))) / i6);
    }

    private void b(float f, int i) {
        if (this.lYn != i) {
            int i2 = this.lXX;
            int i3 = (int) (this.lXX / f);
            while (true) {
                if (i3 <= 16384 && i2 <= 16384) {
                    break;
                }
                i2 /= 2;
                i3 /= 2;
            }
            IX(i);
            for (int i4 = 0; i4 < this.lYo - 1; i4++) {
                while ((this.lYk + 1) * i3 > this.lYl * i2) {
                    IT(1);
                    for (int i5 = 0; i5 < this.lXY; i5++) {
                        this.lYh[(this.lYn * this.lXY) + i5] = b(this.lYj, (this.lXY * i4) + i5, i2, i3);
                    }
                    this.lYl++;
                    this.lYn++;
                }
                this.lYk++;
                if (this.lYk == i2) {
                    this.lYk = 0;
                    com.google.android.exoplayer2.util.a.checkState(this.lYl == i3);
                    this.lYl = 0;
                }
            }
            IY(this.lYo - 1);
        }
    }

    private int a(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f >= 2.0f) {
            i3 = (int) (i2 / (f - 1.0f));
        } else {
            this.lYp = (int) ((i2 * (2.0f - f)) / (f - 1.0f));
            i3 = i2;
        }
        IT(i3);
        a(i3, this.lXY, this.lYh, this.lYn, sArr, i, sArr, i + i2);
        this.lYn += i3;
        return i3;
    }

    private int b(short[] sArr, int i, float f, int i2) {
        int i3;
        if (f < 0.5f) {
            i3 = (int) ((i2 * f) / (1.0f - f));
        } else {
            this.lYp = (int) ((i2 * ((2.0f * f) - 1.0f)) / (1.0f - f));
            i3 = i2;
        }
        IT(i2 + i3);
        System.arraycopy(sArr, this.lXY * i, this.lYh, this.lYn * this.lXY, this.lXY * i2);
        a(i3, this.lXY, this.lYh, this.lYn + i2, sArr, i + i2, sArr, i);
        this.lYn += i2 + i3;
        return i3;
    }

    private void bw(float f) {
        if (this.lYm >= this.lYc) {
            int i = this.lYm;
            int i2 = 0;
            do {
                if (this.lYp > 0) {
                    i2 += IW(i2);
                } else {
                    int a = a(this.lYf, i2, true);
                    if (f > 1.0d) {
                        i2 += a + a(this.lYf, i2, f, a);
                    } else {
                        i2 += b(this.lYf, i2, f, a);
                    }
                }
            } while (this.lYc + i2 <= i);
            IV(i2);
        }
    }

    private void drR() {
        int i = this.lYn;
        float f = this.speed / this.pitch;
        float f2 = this.lXZ * this.pitch;
        if (f > 1.00001d || f < 0.99999d) {
            bw(f);
        } else {
            a(this.lYf, 0, this.lYm);
            this.lYm = 0;
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
