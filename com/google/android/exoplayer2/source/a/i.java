package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i extends a {
    private volatile boolean mrU;
    private final long msP;
    private final int mtM;
    private final d mtN;
    private volatile int mtO;
    private volatile boolean mtP;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mtM = i3;
        this.msP = j3;
        this.mtN = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dwQ() {
        return this.mtQ + this.mtM;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwR() {
        return this.mtP;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dwL() {
        return this.mtO;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mrU = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwt() {
        return this.mrU;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtO);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdW, gF.mFQ, this.mdW.a(gF));
            if (this.mtO == 0) {
                b dwJ = dwJ();
                dwJ.gk(this.msP);
                this.mtN.a(dwJ);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtN.mrY;
            int i = 0;
            while (i == 0 && !this.mrU) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtO = (int) (bVar.getPosition() - this.dataSpec.mFQ);
            v.a(this.mdW);
            this.mtP = true;
        } catch (Throwable th) {
            v.a(this.mdW);
            throw th;
        }
    }
}
