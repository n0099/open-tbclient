package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class m extends a {
    private final int lZP;
    private volatile boolean mtN;
    private volatile int mvF;
    private volatile boolean mvG;
    private final Format mvl;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lZP = i3;
        this.mvl = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dxp() {
        return this.mvG;
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
        try {
            long a = this.mfN.a(this.dataSpec.gG(this.mvF));
            if (a != -1) {
                a += this.mvF;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mfN, this.mvF, a);
            b dxh = dxh();
            dxh.gl(0L);
            com.google.android.exoplayer2.extractor.m dL = dxh.dL(0, this.lZP);
            dL.h(this.mvl);
            for (int i = 0; i != -1; i = dL.a(bVar, Integer.MAX_VALUE, true)) {
                this.mvF = i + this.mvF;
            }
            dL.a(this.mvc, 1, this.mvF, 0, null);
            v.a(this.mfN);
            this.mvG = true;
        } catch (Throwable th) {
            v.a(this.mfN);
            throw th;
        }
    }
}
