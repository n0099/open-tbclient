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
/* loaded from: classes4.dex */
public final class h extends com.google.android.exoplayer2.source.a.l {
    private static final AtomicInteger mru = new AtomicInteger();
    private final s meN;
    private final boolean mga;
    private volatile boolean mns;
    private final com.google.android.exoplayer2.extractor.e mnw;
    private int mpl;
    private volatile boolean mpm;
    private final boolean mrA;
    private final boolean mrB;
    private final boolean mrC;
    private final com.google.android.exoplayer2.metadata.id3.a mrD;
    private final com.google.android.exoplayer2.util.l mrE;
    private l mrF;
    private int mrG;
    private boolean mrH;
    private boolean mrI;
    public final int mrv;
    public final a.C0667a mrw;
    private final com.google.android.exoplayer2.upstream.e mrx;
    private final com.google.android.exoplayer2.upstream.g mry;
    private final boolean mrz;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0667a c0667a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0667a.lUU, i, obj, j, j2, i2);
        this.mrv = i3;
        this.mry = gVar2;
        this.mrw = c0667a;
        this.mrz = z;
        this.meN = sVar;
        this.mga = this.lZr instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mrA = hVar.mrw != c0667a;
            eVar2 = (hVar.mrv != i3 || this.mrA) ? null : hVar.mnw;
        } else {
            this.mrA = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.moF, list, drmInitData, sVar);
        this.mnw = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mrB = ((Boolean) a.second).booleanValue();
        this.mrC = this.mnw == eVar2;
        this.mrI = this.mrC && gVar2 != null;
        if (this.mrB) {
            this.mrD = hVar != null ? hVar.mrD : new com.google.android.exoplayer2.metadata.id3.a();
            this.mrE = hVar != null ? hVar.mrE : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mrD = null;
            this.mrE = null;
        }
        this.mrx = eVar;
        this.uid = mru.getAndIncrement();
    }

    public void a(l lVar) {
        this.mrF = lVar;
        lVar.ae(this.uid, this.mrA);
        if (!this.mrC) {
            this.mnw.a(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dus() {
        return this.mpm;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dum() {
        return this.mpl;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mns = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dtU() {
        return this.mns;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        duN();
        if (!this.mns) {
            duO();
        }
    }

    private void duN() throws IOException, InterruptedException {
        if (!this.mrI && this.mry != null) {
            com.google.android.exoplayer2.upstream.g gC = this.mry.gC(this.mrG);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mrx, gC.mBl, this.mrx.a(gC));
                int i = 0;
                while (i == 0 && !this.mns) {
                    i = this.mnw.a(bVar, null);
                }
                this.mrG = (int) (bVar.getPosition() - this.mry.mBl);
                v.a(this.lZr);
                this.mrI = true;
            } catch (Throwable th) {
                v.a(this.lZr);
                throw th;
            }
        }
    }

    private void duO() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gC;
        int i = 0;
        if (this.mga) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mpl != 0;
            gC = gVar;
        } else {
            z = false;
            gC = this.dataSpec.gC(this.mpl);
        }
        if (!this.mrz) {
            this.meN.dxu();
        } else if (this.meN.dxr() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.meN.gE(this.moI);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.lZr, gC.mBl, this.lZr.a(gC));
            if (this.mrB && !this.mrH) {
                long E = E(bVar);
                this.mrH = true;
                this.mrF.gh(E != -9223372036854775807L ? this.meN.gF(E) : this.moI);
            }
            if (z) {
                bVar.Jh(this.mpl);
            }
            while (i == 0 && !this.mns) {
                i = this.mnw.a(bVar, null);
            }
            this.mpl = (int) (bVar.getPosition() - this.dataSpec.mBl);
            v.a(this.lZr);
            this.mpm = true;
        } catch (Throwable th) {
            v.a(this.lZr);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata x;
        fVar.dsq();
        if (fVar.e(this.mrE.data, 0, 10, true)) {
            this.mrE.reset(10);
            if (this.mrE.dwZ() != com.google.android.exoplayer2.metadata.id3.a.mhO) {
                return -9223372036854775807L;
            }
            this.mrE.skipBytes(3);
            int dxf = this.mrE.dxf();
            int i = dxf + 10;
            if (i > this.mrE.capacity()) {
                byte[] bArr = this.mrE.data;
                this.mrE.reset(i);
                System.arraycopy(bArr, 0, this.mrE.data, 0, 10);
            }
            if (fVar.e(this.mrE.data, 10, dxf, true) && (x = this.mrD.x(this.mrE.data, dxf)) != null) {
                int length = x.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry JR = x.JR(i2);
                    if (JR instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) JR;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mrE.data, 0, 8);
                            this.mrE.reset(8);
                            return this.mrE.readLong();
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
