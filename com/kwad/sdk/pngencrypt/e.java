package com.kwad.sdk.pngencrypt;
/* loaded from: classes10.dex */
public final class e {
    public int akA;
    public int akB;
    public boolean akG;
    public final k aks;
    public int aku;
    public int akv;
    public int akw;
    public int akx;
    public int aky;
    public int akz;
    public int akt = 0;
    public int akC = -1;
    public int akD = -1;
    public int akE = 0;
    public int akF = 0;

    public e(k kVar) {
        this.akG = false;
        this.aks = kVar;
        this.akG = false;
        bj(1);
        bi(0);
    }

    private void bi(int i) {
        this.akC = i;
        int i2 = (i * this.akw) + this.aky;
        this.akD = i2;
        if (i2 < 0 || i2 >= this.aks.aku) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    private void bj(int i) {
        int i2;
        if (this.akt == i) {
            return;
        }
        this.akt = i;
        byte[] bk = bk(i);
        this.akx = bk[0];
        byte b = bk[1];
        this.akw = b;
        this.akz = bk[2];
        byte b2 = bk[3];
        this.aky = b2;
        int i3 = this.aks.aku;
        this.aku = i3 > b2 ? (((i3 + b) - 1) - b2) / b : 0;
        int i4 = this.aks.akv;
        int i5 = this.akz;
        if (i4 > i5) {
            int i6 = this.akx;
            i2 = (((i4 + i6) - 1) - i5) / i6;
        } else {
            i2 = 0;
        }
        this.akv = i2;
        if (i2 == 0) {
            this.aku = 0;
        }
        int i7 = this.akx;
        int i8 = this.aks.akO;
        this.akB = i7 * i8;
        this.akA = this.akz * i8;
    }

    public static byte[] bk(int i) {
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

    private int yr() {
        return yq();
    }

    public final boolean yl() {
        int i;
        while (true) {
            this.akE++;
            int i2 = this.aku;
            if (i2 != 0 && (i = this.akC) < i2 - 1) {
                bi(i + 1);
                break;
            }
            int i3 = this.akt;
            if (i3 != 7) {
                bj(i3 + 1);
                if (this.aku != 0) {
                    bi(0);
                    break;
                }
                this.akE--;
            } else {
                this.akG = true;
                return false;
            }
        }
        return true;
    }

    public final int ym() {
        return this.akC;
    }

    public final int yn() {
        return this.akD;
    }

    public final int yo() {
        return this.akt;
    }

    public final int yp() {
        return this.aku;
    }

    public final int yq() {
        return this.akv;
    }

    public final int ys() {
        return ((this.aks.akT * yr()) + 7) / 8;
    }
}
