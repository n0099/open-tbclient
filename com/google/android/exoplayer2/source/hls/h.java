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
/* loaded from: classes5.dex */
public final class h extends com.google.android.exoplayer2.source.a.l {
    private static final AtomicInteger mvj = new AtomicInteger();
    private final s miE;
    private final boolean mjR;
    private volatile boolean mrh;
    private final com.google.android.exoplayer2.extractor.e mrl;
    private int mta;
    private volatile boolean mtb;
    public final int mvk;
    public final a.C0673a mvl;
    private final com.google.android.exoplayer2.upstream.e mvm;
    private final com.google.android.exoplayer2.upstream.g mvn;
    private final boolean mvo;
    private final boolean mvp;
    private final boolean mvq;
    private final boolean mvr;
    private final com.google.android.exoplayer2.metadata.id3.a mvs;
    private final com.google.android.exoplayer2.util.l mvt;
    private l mvu;
    private int mvv;
    private boolean mvw;
    private boolean mvx;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0673a c0673a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0673a.lYL, i, obj, j, j2, i2);
        this.mvk = i3;
        this.mvn = gVar2;
        this.mvl = c0673a;
        this.mvo = z;
        this.miE = sVar;
        this.mjR = this.mdj instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mvp = hVar.mvl != c0673a;
            eVar2 = (hVar.mvk != i3 || this.mvp) ? null : hVar.mrl;
        } else {
            this.mvp = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.msu, list, drmInitData, sVar);
        this.mrl = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mvq = ((Boolean) a.second).booleanValue();
        this.mvr = this.mrl == eVar2;
        this.mvx = this.mvr && gVar2 != null;
        if (this.mvq) {
            this.mvs = hVar != null ? hVar.mvs : new com.google.android.exoplayer2.metadata.id3.a();
            this.mvt = hVar != null ? hVar.mvt : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mvs = null;
            this.mvt = null;
        }
        this.mvm = eVar;
        this.uid = mvj.getAndIncrement();
    }

    public void a(l lVar) {
        this.mvu = lVar;
        lVar.ae(this.uid, this.mvp);
        if (!this.mvr) {
            this.mrl.a(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvD() {
        return this.mtb;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dvx() {
        return this.mta;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrh = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dvf() {
        return this.mrh;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        dvY();
        if (!this.mrh) {
            dvZ();
        }
    }

    private void dvY() throws IOException, InterruptedException {
        if (!this.mvx && this.mvn != null) {
            com.google.android.exoplayer2.upstream.g gH = this.mvn.gH(this.mvv);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mvm, gH.mFc, this.mvm.a(gH));
                int i = 0;
                while (i == 0 && !this.mrh) {
                    i = this.mrl.a(bVar, null);
                }
                this.mvv = (int) (bVar.getPosition() - this.mvn.mFc);
                v.a(this.mdj);
                this.mvx = true;
            } catch (Throwable th) {
                v.a(this.mdj);
                throw th;
            }
        }
    }

    private void dvZ() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gH;
        int i = 0;
        if (this.mjR) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mta != 0;
            gH = gVar;
        } else {
            z = false;
            gH = this.dataSpec.gH(this.mta);
        }
        if (!this.mvo) {
            this.miE.dyE();
        } else if (this.miE.dyB() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.miE.gJ(this.msx);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdj, gH.mFc, this.mdj.a(gH));
            if (this.mvq && !this.mvw) {
                long E = E(bVar);
                this.mvw = true;
                this.mvu.gm(E != -9223372036854775807L ? this.miE.gK(E) : this.msx);
            }
            if (z) {
                bVar.Jq(this.mta);
            }
            while (i == 0 && !this.mrh) {
                i = this.mrl.a(bVar, null);
            }
            this.mta = (int) (bVar.getPosition() - this.dataSpec.mFc);
            v.a(this.mdj);
            this.mtb = true;
        } catch (Throwable th) {
            v.a(this.mdj);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata x;
        fVar.dtC();
        if (fVar.e(this.mvt.data, 0, 10, true)) {
            this.mvt.reset(10);
            if (this.mvt.dyj() != com.google.android.exoplayer2.metadata.id3.a.mlE) {
                return -9223372036854775807L;
            }
            this.mvt.skipBytes(3);
            int dyp = this.mvt.dyp();
            int i = dyp + 10;
            if (i > this.mvt.capacity()) {
                byte[] bArr = this.mvt.data;
                this.mvt.reset(i);
                System.arraycopy(bArr, 0, this.mvt.data, 0, 10);
            }
            if (fVar.e(this.mvt.data, 10, dyp, true) && (x = this.mvs.x(this.mvt.data, dyp)) != null) {
                int length = x.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Ka = x.Ka(i2);
                    if (Ka instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Ka;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mvt.data, 0, 8);
                            this.mvt.reset(8);
                            return this.mvt.readLong();
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
