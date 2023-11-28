package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes10.dex */
public final class i extends p {
    public int aJk;
    public int aJl;
    public int aKF;
    public int aKG;
    public int aKH;
    public int aKI;
    public int aKJ;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            IQ();
        }
    }

    private void dr(int i) {
        this.aJl = i;
    }

    private void ds(int i) {
        this.aJk = i;
    }

    private void dt(int i) {
        this.aKF = i;
    }

    private void du(int i) {
        this.aKG = i;
    }

    private void dv(int i) {
        this.aKH = 0;
    }

    private void dw(int i) {
        this.aKI = 0;
    }

    private void dx(int i) {
        this.aKJ = 0;
    }

    private int IM() {
        return this.aKF;
    }

    private int IN() {
        return this.aKG;
    }

    private int IO() {
        return this.aKJ;
    }

    private int Is() {
        return this.aJk;
    }

    private int It() {
        return this.aJl;
    }

    public final boolean IP() {
        if (IO() == 1) {
            return true;
        }
        return false;
    }

    private void IQ() {
        int i;
        dr(this.aJz.aJl);
        ds(this.aJz.aJk);
        dt(this.aJz.aJD);
        if (this.aJz.aJF) {
            i = 4;
        } else {
            i = 0;
        }
        if (this.aJz.aJH) {
            i++;
        }
        if (!this.aJz.aJG) {
            i += 2;
        }
        du(i);
        dv(0);
        dw(0);
        dx(0);
    }

    public final com.kwad.sdk.pngencrypt.k IR() {
        boolean z;
        boolean z2;
        boolean z3;
        IS();
        if ((IN() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((IN() & 1) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (IN() != 0 && IN() != 4) {
            z3 = false;
        } else {
            z3 = true;
        }
        return new com.kwad.sdk.pngencrypt.k(It(), Is(), IM(), z, z3, z2);
    }

    private void IS() {
        if (this.aJl > 0 && this.aJk > 0 && this.aKH == 0 && this.aKI == 0) {
            int i = this.aKF;
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
            int i2 = this.aKJ;
            if (i2 >= 0 && i2 <= 1) {
                int i3 = this.aKG;
                if (i3 != 0) {
                    if (i3 != 6 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new PngjException("bad IHDR: invalid colormodel");
                            }
                        } else if (this.aKF == 16) {
                            throw new PngjException("bad IHDR: bitdepth invalid");
                        } else {
                            return;
                        }
                    }
                    int i4 = this.aKF;
                    if (i4 != 8 && i4 != 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                }
                return;
            }
            throw new PngjException("bad IHDR: interlace invalid");
        }
        throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 13) {
            ByteArrayInputStream II = dVar.II();
            this.aJl = com.kwad.sdk.pngencrypt.n.f(II);
            this.aJk = com.kwad.sdk.pngencrypt.n.f(II);
            this.aKF = com.kwad.sdk.pngencrypt.n.e(II);
            this.aKG = com.kwad.sdk.pngencrypt.n.e(II);
            this.aKH = com.kwad.sdk.pngencrypt.n.e(II);
            this.aKI = com.kwad.sdk.pngencrypt.n.e(II);
            this.aKJ = com.kwad.sdk.pngencrypt.n.e(II);
            return;
        }
        throw new PngjException("Bad IDHR len " + dVar.len);
    }
}
