package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes4.dex */
public class i extends a {
    private volatile boolean mns;
    private final long mom;
    private final int mpj;
    private final d mpk;
    private volatile int mpl;
    private volatile boolean mpm;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mpj = i3;
        this.mom = j3;
        this.mpk = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dur() {
        return this.mpn + this.mpj;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dus() {
        return this.mpm;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dum() {
        return this.mpl;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.mns = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dtU() {
        return this.mns;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gC = this.dataSpec.gC(this.mpl);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.lZr, gC.mBl, this.lZr.a(gC));
            if (this.mpl == 0) {
                b duk = duk();
                duk.gh(this.mom);
                this.mpk.a(duk);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mpk.mnw;
            int i = 0;
            while (i == 0 && !this.mns) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mpl = (int) (bVar.getPosition() - this.dataSpec.mBl);
            v.a(this.lZr);
            this.mpm = true;
        } catch (Throwable th) {
            v.a(this.lZr);
            throw th;
        }
    }
}
