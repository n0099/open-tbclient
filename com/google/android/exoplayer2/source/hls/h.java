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
    private static final AtomicInteger mxN = new AtomicInteger();
    private final s mli;
    private final boolean mmv;
    private volatile boolean mtN;
    private final com.google.android.exoplayer2.extractor.e mtR;
    private int mvF;
    private volatile boolean mvG;
    public final int mxO;
    public final a.C0682a mxP;
    private final com.google.android.exoplayer2.upstream.e mxQ;
    private final com.google.android.exoplayer2.upstream.g mxR;
    private final boolean mxS;
    private final boolean mxT;
    private final boolean mxU;
    private final boolean mxV;
    private final com.google.android.exoplayer2.metadata.id3.a mxW;
    private final com.google.android.exoplayer2.util.l mxX;
    private l mxY;
    private int mxZ;
    private boolean mya;
    private boolean myb;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0682a c0682a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0682a.mbs, i, obj, j, j2, i2);
        this.mxO = i3;
        this.mxR = gVar2;
        this.mxP = c0682a;
        this.mxS = z;
        this.mli = sVar;
        this.mmv = this.mfN instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mxT = hVar.mxP != c0682a;
            eVar2 = (hVar.mxO != i3 || this.mxT) ? null : hVar.mtR;
        } else {
            this.mxT = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.muZ, list, drmInitData, sVar);
        this.mtR = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mxU = ((Boolean) a.second).booleanValue();
        this.mxV = this.mtR == eVar2;
        this.myb = this.mxV && gVar2 != null;
        if (this.mxU) {
            this.mxW = hVar != null ? hVar.mxW : new com.google.android.exoplayer2.metadata.id3.a();
            this.mxX = hVar != null ? hVar.mxX : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mxW = null;
            this.mxX = null;
        }
        this.mxQ = eVar;
        this.uid = mxN.getAndIncrement();
    }

    public void a(l lVar) {
        this.mxY = lVar;
        lVar.ad(this.uid, this.mxT);
        if (!this.mxV) {
            this.mtR.a(lVar);
        }
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
        dxK();
        if (!this.mtN) {
            dxL();
        }
    }

    private void dxK() throws IOException, InterruptedException {
        if (!this.myb && this.mxR != null) {
            com.google.android.exoplayer2.upstream.g gG = this.mxR.gG(this.mxZ);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mxQ, gG.mHH, this.mxQ.a(gG));
                int i = 0;
                while (i == 0 && !this.mtN) {
                    i = this.mtR.a(bVar, null);
                }
                this.mxZ = (int) (bVar.getPosition() - this.mxR.mHH);
                v.a(this.mfN);
                this.myb = true;
            } catch (Throwable th) {
                v.a(this.mfN);
                throw th;
            }
        }
    }

    private void dxL() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gG;
        int i = 0;
        if (this.mmv) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mvF != 0;
            gG = gVar;
        } else {
            z = false;
            gG = this.dataSpec.gG(this.mvF);
        }
        if (!this.mxS) {
            this.mli.dAq();
        } else if (this.mli.dAn() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.mli.gI(this.mvc);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mfN, gG.mHH, this.mfN.a(gG));
            if (this.mxU && !this.mya) {
                long E = E(bVar);
                this.mya = true;
                this.mxY.gl(E != -9223372036854775807L ? this.mli.gJ(E) : this.mvc);
            }
            if (z) {
                bVar.JB(this.mvF);
            }
            while (i == 0 && !this.mtN) {
                i = this.mtR.a(bVar, null);
            }
            this.mvF = (int) (bVar.getPosition() - this.dataSpec.mHH);
            v.a(this.mfN);
            this.mvG = true;
        } catch (Throwable th) {
            v.a(this.mfN);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata z;
        fVar.dvp();
        if (fVar.e(this.mxX.data, 0, 10, true)) {
            this.mxX.reset(10);
            if (this.mxX.dzV() != com.google.android.exoplayer2.metadata.id3.a.moi) {
                return -9223372036854775807L;
            }
            this.mxX.skipBytes(3);
            int dAb = this.mxX.dAb();
            int i = dAb + 10;
            if (i > this.mxX.capacity()) {
                byte[] bArr = this.mxX.data;
                this.mxX.reset(i);
                System.arraycopy(bArr, 0, this.mxX.data, 0, 10);
            }
            if (fVar.e(this.mxX.data, 10, dAb, true) && (z = this.mxW.z(this.mxX.data, dAb)) != null) {
                int length = z.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Kl = z.Kl(i2);
                    if (Kl instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Kl;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mxX.data, 0, 8);
                            this.mxX.reset(8);
                            return this.mxX.readLong();
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
