package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h extends com.google.android.exoplayer2.source.a.l {
    private static final AtomicInteger mvW = new AtomicInteger();
    private final s mjr;
    private final boolean mkE;
    private volatile boolean mrU;
    private final com.google.android.exoplayer2.extractor.e mrY;
    private int mtO;
    private volatile boolean mtP;
    public final int mvX;
    public final a.C0681a mvY;
    private final com.google.android.exoplayer2.upstream.e mvZ;
    private final com.google.android.exoplayer2.upstream.g mwa;
    private final boolean mwb;
    private final boolean mwc;
    private final boolean mwd;
    private final boolean mwe;
    private final com.google.android.exoplayer2.metadata.id3.a mwf;
    private final com.google.android.exoplayer2.util.l mwg;
    private l mwh;
    private int mwi;
    private boolean mwj;
    private boolean mwk;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0681a c0681a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0681a.lZy, i, obj, j, j2, i2);
        this.mvX = i3;
        this.mwa = gVar2;
        this.mvY = c0681a;
        this.mwb = z;
        this.mjr = sVar;
        this.mkE = this.mdW instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mwc = hVar.mvY != c0681a;
            eVar2 = (hVar.mvX != i3 || this.mwc) ? null : hVar.mrY;
        } else {
            this.mwc = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.mth, list, drmInitData, sVar);
        this.mrY = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mwd = ((Boolean) a.second).booleanValue();
        this.mwe = this.mrY == eVar2;
        this.mwk = this.mwe && gVar2 != null;
        if (this.mwd) {
            this.mwf = hVar != null ? hVar.mwf : new com.google.android.exoplayer2.metadata.id3.a();
            this.mwg = hVar != null ? hVar.mwg : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mwf = null;
            this.mwg = null;
        }
        this.mvZ = eVar;
        this.uid = mvW.getAndIncrement();
    }

    public void a(l lVar) {
        this.mwh = lVar;
        lVar.ad(this.uid, this.mwc);
        if (!this.mwe) {
            this.mrY.a(lVar);
        }
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
        dxm();
        if (!this.mrU) {
            dxn();
        }
    }

    private void dxm() throws IOException, InterruptedException {
        if (!this.mwk && this.mwa != null) {
            com.google.android.exoplayer2.upstream.g gF = this.mwa.gF(this.mwi);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mvZ, gF.mFQ, this.mvZ.a(gF));
                int i = 0;
                while (i == 0 && !this.mrU) {
                    i = this.mrY.a(bVar, null);
                }
                this.mwi = (int) (bVar.getPosition() - this.mwa.mFQ);
                v.a(this.mdW);
                this.mwk = true;
            } catch (Throwable th) {
                v.a(this.mdW);
                throw th;
            }
        }
    }

    private void dxn() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gF;
        int i = 0;
        if (this.mkE) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mtO != 0;
            gF = gVar;
        } else {
            z = false;
            gF = this.dataSpec.gF(this.mtO);
        }
        if (!this.mwb) {
            this.mjr.dzS();
        } else if (this.mjr.dzP() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.mjr.gH(this.mtk);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdW, gF.mFQ, this.mdW.a(gF));
            if (this.mwd && !this.mwj) {
                long E = E(bVar);
                this.mwj = true;
                this.mwh.gk(E != -9223372036854775807L ? this.mjr.gI(E) : this.mtk);
            }
            if (z) {
                bVar.Jv(this.mtO);
            }
            while (i == 0 && !this.mrU) {
                i = this.mrY.a(bVar, null);
            }
            this.mtO = (int) (bVar.getPosition() - this.dataSpec.mFQ);
            v.a(this.mdW);
            this.mtP = true;
        } catch (Throwable th) {
            v.a(this.mdW);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata z;
        fVar.duR();
        if (fVar.e(this.mwg.data, 0, 10, true)) {
            this.mwg.reset(10);
            if (this.mwg.dzx() != com.google.android.exoplayer2.metadata.id3.a.mmr) {
                return -9223372036854775807L;
            }
            this.mwg.skipBytes(3);
            int dzD = this.mwg.dzD();
            int i = dzD + 10;
            if (i > this.mwg.capacity()) {
                byte[] bArr = this.mwg.data;
                this.mwg.reset(i);
                System.arraycopy(bArr, 0, this.mwg.data, 0, 10);
            }
            if (fVar.e(this.mwg.data, 10, dzD, true) && (z = this.mwf.z(this.mwg.data, dzD)) != null) {
                int length = z.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Kf = z.Kf(i2);
                    if (Kf instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Kf;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mwg.data, 0, 8);
                            this.mwg.reset(8);
                            return this.mwg.readLong();
                        }
                    }
                }
                return -9223372036854775807L;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    private static com.google.android.exoplayer2.upstream.e a(com.google.android.exoplayer2.upstream.e eVar, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            return new a(eVar, bArr, bArr2);
        }
        return eVar;
    }
}
