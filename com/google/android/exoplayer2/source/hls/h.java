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
    private static final AtomicInteger mvU = new AtomicInteger();
    private final s mjp;
    private final boolean mkC;
    private volatile boolean mrS;
    private final com.google.android.exoplayer2.extractor.e mrW;
    private int mtM;
    private volatile boolean mtN;
    public final int mvV;
    public final a.C0681a mvW;
    private final com.google.android.exoplayer2.upstream.e mvX;
    private final com.google.android.exoplayer2.upstream.g mvY;
    private final boolean mvZ;
    private final boolean mwa;
    private final boolean mwb;
    private final boolean mwc;
    private final com.google.android.exoplayer2.metadata.id3.a mwd;
    private final com.google.android.exoplayer2.util.l mwe;
    private l mwf;
    private int mwg;
    private boolean mwh;
    private boolean mwi;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0681a c0681a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0681a.lZw, i, obj, j, j2, i2);
        this.mvV = i3;
        this.mvY = gVar2;
        this.mvW = c0681a;
        this.mvZ = z;
        this.mjp = sVar;
        this.mkC = this.mdU instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mwa = hVar.mvW != c0681a;
            eVar2 = (hVar.mvV != i3 || this.mwa) ? null : hVar.mrW;
        } else {
            this.mwa = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.mtf, list, drmInitData, sVar);
        this.mrW = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mwb = ((Boolean) a.second).booleanValue();
        this.mwc = this.mrW == eVar2;
        this.mwi = this.mwc && gVar2 != null;
        if (this.mwb) {
            this.mwd = hVar != null ? hVar.mwd : new com.google.android.exoplayer2.metadata.id3.a();
            this.mwe = hVar != null ? hVar.mwe : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mwd = null;
            this.mwe = null;
        }
        this.mvX = eVar;
        this.uid = mvU.getAndIncrement();
    }

    public void a(l lVar) {
        this.mwf = lVar;
        lVar.ad(this.uid, this.mwa);
        if (!this.mwc) {
            this.mrW.a(lVar);
        }
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
        dxk();
        if (!this.mrS) {
            dxl();
        }
    }

    private void dxk() throws IOException, InterruptedException {
        if (!this.mwi && this.mvY != null) {
            com.google.android.exoplayer2.upstream.g gF = this.mvY.gF(this.mwg);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mvX, gF.mFO, this.mvX.a(gF));
                int i = 0;
                while (i == 0 && !this.mrS) {
                    i = this.mrW.a(bVar, null);
                }
                this.mwg = (int) (bVar.getPosition() - this.mvY.mFO);
                v.a(this.mdU);
                this.mwi = true;
            } catch (Throwable th) {
                v.a(this.mdU);
                throw th;
            }
        }
    }

    private void dxl() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gF;
        int i = 0;
        if (this.mkC) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mtM != 0;
            gF = gVar;
        } else {
            z = false;
            gF = this.dataSpec.gF(this.mtM);
        }
        if (!this.mvZ) {
            this.mjp.dzQ();
        } else if (this.mjp.dzN() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.mjp.gH(this.mti);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdU, gF.mFO, this.mdU.a(gF));
            if (this.mwb && !this.mwh) {
                long E = E(bVar);
                this.mwh = true;
                this.mwf.gk(E != -9223372036854775807L ? this.mjp.gI(E) : this.mti);
            }
            if (z) {
                bVar.Jv(this.mtM);
            }
            while (i == 0 && !this.mrS) {
                i = this.mrW.a(bVar, null);
            }
            this.mtM = (int) (bVar.getPosition() - this.dataSpec.mFO);
            v.a(this.mdU);
            this.mtN = true;
        } catch (Throwable th) {
            v.a(this.mdU);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata z;
        fVar.duP();
        if (fVar.e(this.mwe.data, 0, 10, true)) {
            this.mwe.reset(10);
            if (this.mwe.dzv() != com.google.android.exoplayer2.metadata.id3.a.mmp) {
                return -9223372036854775807L;
            }
            this.mwe.skipBytes(3);
            int dzB = this.mwe.dzB();
            int i = dzB + 10;
            if (i > this.mwe.capacity()) {
                byte[] bArr = this.mwe.data;
                this.mwe.reset(i);
                System.arraycopy(bArr, 0, this.mwe.data, 0, 10);
            }
            if (fVar.e(this.mwe.data, 10, dzB, true) && (z = this.mwd.z(this.mwe.data, dzB)) != null) {
                int length = z.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Kf = z.Kf(i2);
                    if (Kf instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Kf;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mwe.data, 0, 8);
                            this.mwe.reset(8);
                            return this.mwe.readLong();
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
