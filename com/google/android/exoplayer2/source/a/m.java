package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class m extends a {
    private final int lXY;
    private volatile boolean mrU;
    private volatile int mtO;
    private volatile boolean mtP;
    private final Format mtt;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lXY = i3;
        this.mtt = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwR() {
        return this.mtP;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dwL() {
        return this.mtO;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrU = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwt() {
        return this.mrU;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        try {
            long a = this.mdW.a(this.dataSpec.gF(this.mtO));
            if (a != -1) {
                a += this.mtO;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdW, this.mtO, a);
            b dwJ = dwJ();
            dwJ.gk(0L);
            com.google.android.exoplayer2.extractor.m dK = dwJ.dK(0, this.lXY);
            dK.h(this.mtt);
            for (int i = 0; i != -1; i = dK.a(bVar, Integer.MAX_VALUE, true)) {
                this.mtO = i + this.mtO;
            }
            dK.a(this.mtk, 1, this.mtO, 0, null);
            v.a(this.mdW);
            this.mtP = true;
        } catch (Throwable th) {
            v.a(this.mdW);
            throw th;
        }
    }
}
