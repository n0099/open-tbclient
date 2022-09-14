package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
/* loaded from: classes8.dex */
public final class i extends p {
    public int aku;
    public int akv;
    public int alQ;
    public int alR;
    public int alS;
    public int alT;
    public int alU;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            yN();
        }
    }

    private void bs(int i) {
        this.akv = i;
    }

    private void bt(int i) {
        this.aku = i;
    }

    private void bu(int i) {
        this.alQ = i;
    }

    private void bv(int i) {
        this.alR = i;
    }

    private void bw(int i) {
        this.alS = 0;
    }

    private void bx(int i) {
        this.alT = 0;
    }

    private void by(int i) {
        this.alU = 0;
    }

    private int yJ() {
        return this.alQ;
    }

    private int yK() {
        return this.alR;
    }

    private int yL() {
        return this.alU;
    }

    private void yN() {
        bs(this.akJ.akv);
        bt(this.akJ.aku);
        bu(this.akJ.akN);
        int i = this.akJ.akP ? 4 : 0;
        if (this.akJ.akR) {
            i++;
        }
        if (!this.akJ.akQ) {
            i += 2;
        }
        bv(i);
        bw(0);
        bx(0);
        by(0);
    }

    private void yP() {
        if (this.akv <= 0 || this.aku <= 0 || this.alS != 0 || this.alT != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.alQ;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.alU;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.alR;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (this.alQ == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i4 = this.alQ;
            if (i4 != 8 && i4 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private int yp() {
        return this.aku;
    }

    private int yq() {
        return this.akv;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream yF = dVar.yF();
        this.akv = com.kwad.sdk.pngencrypt.n.g(yF);
        this.aku = com.kwad.sdk.pngencrypt.n.g(yF);
        this.alQ = com.kwad.sdk.pngencrypt.n.f(yF);
        this.alR = com.kwad.sdk.pngencrypt.n.f(yF);
        this.alS = com.kwad.sdk.pngencrypt.n.f(yF);
        this.alT = com.kwad.sdk.pngencrypt.n.f(yF);
        this.alU = com.kwad.sdk.pngencrypt.n.f(yF);
    }

    public final boolean yM() {
        return yL() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k yO() {
        yP();
        return new com.kwad.sdk.pngencrypt.k(yq(), yp(), yJ(), (yK() & 4) != 0, yK() == 0 || yK() == 4, (yK() & 1) != 0);
    }
}
