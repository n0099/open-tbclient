package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i extends a {
    private volatile boolean mrS;
    private final long msN;
    private final int mtK;
    private final d mtL;
    private volatile int mtM;
    private volatile boolean mtN;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mtK = i3;
        this.msN = j3;
        this.mtL = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dwO() {
        return this.mtO + this.mtK;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwP() {
        return this.mtN;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dwJ() {
        return this.mtM;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mrS = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwr() {
        return this.mrS;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtM);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdU, gF.mFO, this.mdU.a(gF));
            if (this.mtM == 0) {
                b dwH = dwH();
                dwH.gk(this.msN);
                this.mtL.a(dwH);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtL.mrW;
            int i = 0;
            while (i == 0 && !this.mrS) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtM = (int) (bVar.getPosition() - this.dataSpec.mFO);
            v.a(this.mdU);
            this.mtN = true;
        } catch (Throwable th) {
            v.a(this.mdU);
            throw th;
        }
    }
}
