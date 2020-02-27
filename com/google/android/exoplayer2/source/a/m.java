package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class m extends a {
    private final int lXW;
    private volatile boolean mrS;
    private volatile int mtM;
    private volatile boolean mtN;
    private final Format mtr;

    public m(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, Format format2) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.lXW = i3;
        this.mtr = format2;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwP() {
        return this.mtN;
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
        try {
            long a = this.mdU.a(this.dataSpec.gF(this.mtM));
            if (a != -1) {
                a += this.mtM;
            }
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdU, this.mtM, a);
            b dwH = dwH();
            dwH.gk(0L);
            com.google.android.exoplayer2.extractor.m dK = dwH.dK(0, this.lXW);
            dK.h(this.mtr);
            for (int i = 0; i != -1; i = dK.a(bVar, Integer.MAX_VALUE, true)) {
                this.mtM = i + this.mtM;
            }
            dK.a(this.mti, 1, this.mtM, 0, null);
            v.a(this.mdU);
            this.mtN = true;
        } catch (Throwable th) {
            v.a(this.mdU);
            throw th;
        }
    }
}
