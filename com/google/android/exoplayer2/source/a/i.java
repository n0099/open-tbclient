package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i extends a {
    private volatile boolean mtN;
    private final long muH;
    private final int mvD;
    private final d mvE;
    private volatile int mvF;
    private volatile boolean mvG;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mvD = i3;
        this.muH = j3;
        this.mvE = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dxo() {
        return this.mvH + this.mvD;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dxp() {
        return this.mvG;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dxj() {
        return this.mvF;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mtN = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwR() {
        return this.mtN;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gG = this.dataSpec.gG(this.mvF);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mfN, gG.mHH, this.mfN.a(gG));
            if (this.mvF == 0) {
                b dxh = dxh();
                dxh.gl(this.muH);
                this.mvE.a(dxh);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mvE.mtR;
            int i = 0;
            while (i == 0 && !this.mtN) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mvF = (int) (bVar.getPosition() - this.dataSpec.mHH);
            v.a(this.mfN);
            this.mvG = true;
        } catch (Throwable th) {
            v.a(this.mfN);
            throw th;
        }
    }
}
