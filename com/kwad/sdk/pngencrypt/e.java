package com.kwad.sdk.pngencrypt;
/* loaded from: classes10.dex */
public final class e {
    public final k aJi;
    public int aJk;
    public int aJl;
    public int aJm;
    public int aJn;
    public int aJo;
    public int aJp;
    public int aJq;
    public int aJr;
    public boolean aJw;
    public int aJj = 0;
    public int aJs = -1;
    public int aJt = -1;
    public int aJu = 0;
    public int aJv = 0;

    public e(k kVar) {
        this.aJw = false;
        this.aJi = kVar;
        this.aJw = false;
        di(1);
        dh(0);
    }

    private void dh(int i) {
        this.aJs = i;
        int i2 = (i * this.aJm) + this.aJo;
        this.aJt = i2;
        if (i2 >= 0 && i2 < this.aJi.aJk) {
            return;
        }
        throw new PngjException("bad row - this should not happen");
    }

    private int Iu() {
        return It();
    }

    public final boolean Io() {
        int i;
        while (true) {
            this.aJu++;
            int i2 = this.aJk;
            if (i2 != 0 && (i = this.aJs) < i2 - 1) {
                dh(i + 1);
                break;
            }
            int i3 = this.aJj;
            if (i3 == 7) {
                this.aJw = true;
                return false;
            }
            di(i3 + 1);
            if (this.aJk == 0) {
                this.aJu--;
            } else {
                dh(0);
                break;
            }
        }
        return true;
    }

    public final int Ip() {
        return this.aJs;
    }

    public final int Iq() {
        return this.aJt;
    }

    public final int Ir() {
        return this.aJj;
    }

    public final int Is() {
        return this.aJk;
    }

    public final int It() {
        return this.aJl;
    }

    public final int Iv() {
        return ((this.aJi.aJJ * Iu()) + 7) / 8;
    }

    private void di(int i) {
        int i2;
        int i3;
        if (this.aJj == i) {
            return;
        }
        this.aJj = i;
        byte[] dj = dj(i);
        this.aJn = dj[0];
        byte b = dj[1];
        this.aJm = b;
        this.aJp = dj[2];
        byte b2 = dj[3];
        this.aJo = b2;
        int i4 = this.aJi.aJk;
        if (i4 > b2) {
            i2 = (((i4 + b) - 1) - b2) / b;
        } else {
            i2 = 0;
        }
        this.aJk = i2;
        int i5 = this.aJi.aJl;
        int i6 = this.aJp;
        if (i5 > i6) {
            int i7 = this.aJn;
            i3 = (((i5 + i7) - 1) - i6) / i7;
        } else {
            i3 = 0;
        }
        this.aJl = i3;
        if (i3 == 0) {
            this.aJk = 0;
        }
        int i8 = this.aJn;
        int i9 = this.aJi.aJE;
        this.aJr = i8 * i9;
        this.aJq = this.aJp * i9;
    }

    public static byte[] dj(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }
}
