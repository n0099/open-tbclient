package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class k extends c {
    private volatile boolean mtN;
    private final d mvE;
    private volatile int mvF;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mvE = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dxj() {
        return this.mvF;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mtN = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwR() {
        return this.mtN;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gG = this.dataSpec.gG(this.mvF);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mfN, gG.mHH, this.mfN.a(gG));
            if (this.mvF == 0) {
                this.mvE.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mvE.mtR;
            int i = 0;
            while (i == 0 && !this.mtN) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mvF = (int) (bVar.getPosition() - this.dataSpec.mHH);
        } finally {
            v.a(this.mfN);
        }
    }
}
