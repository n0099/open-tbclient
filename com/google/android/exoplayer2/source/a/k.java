package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class k extends c {
    private volatile boolean mrS;
    private final d mtL;
    private volatile int mtM;

    public k(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, d dVar) {
        super(eVar, gVar, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.mtL = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dwJ() {
        return this.mtM;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrS = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwr() {
        return this.mrS;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtM);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdU, gF.mFO, this.mdU.a(gF));
            if (this.mtM == 0) {
                this.mtL.a((d.b) null);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtL.mrW;
            int i = 0;
            while (i == 0 && !this.mrS) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtM = (int) (bVar.getPosition() - this.dataSpec.mFO);
        } finally {
            v.a(this.mdU);
        }
    }
}
