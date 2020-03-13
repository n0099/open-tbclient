package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i extends a {
    private volatile boolean msf;
    private final int mtX;
    private final d mtY;
    private volatile int mtZ;
    private final long mta;
    private volatile boolean mua;

    public i(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, long j, long j2, int i2, int i3, long j3, d dVar) {
        super(eVar, gVar, format, i, obj, j, j2, i2);
        this.mtX = i3;
        this.mta = j3;
        this.mtY = dVar;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public int dwR() {
        return this.mub + this.mtX;
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwS() {
        return this.mua;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public final long dwM() {
        return this.mtZ;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void cancelLoad() {
        this.msf = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final boolean dwu() {
        return this.msf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public final void load() throws IOException, InterruptedException {
        com.google.android.exoplayer2.upstream.g gF = this.dataSpec.gF(this.mtZ);
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.meh, gF.mGb, this.meh.a(gF));
            if (this.mtZ == 0) {
                b dwK = dwK();
                dwK.gk(this.mta);
                this.mtY.a(dwK);
            }
            com.google.android.exoplayer2.extractor.e eVar = this.mtY.msk;
            int i = 0;
            while (i == 0 && !this.msf) {
                i = eVar.a(bVar, null);
            }
            com.google.android.exoplayer2.util.a.checkState(i != 1);
            this.mtZ = (int) (bVar.getPosition() - this.dataSpec.mGb);
            v.a(this.meh);
            this.mua = true;
        } catch (Throwable th) {
            v.a(this.meh);
            throw th;
        }
    }
}
