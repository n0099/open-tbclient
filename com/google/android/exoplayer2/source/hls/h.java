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
    private static final AtomicInteger mvo = new AtomicInteger();
    private final s miJ;
    private final boolean mjW;
    private volatile boolean mrm;
    private final com.google.android.exoplayer2.extractor.e mrq;
    private int mtf;
    private volatile boolean mtg;
    private int mvA;
    private boolean mvB;
    private boolean mvC;
    public final int mvp;
    public final a.C0673a mvq;
    private final com.google.android.exoplayer2.upstream.e mvr;
    private final com.google.android.exoplayer2.upstream.g mvs;
    private final boolean mvt;
    private final boolean mvu;
    private final boolean mvv;
    private final boolean mvw;
    private final com.google.android.exoplayer2.metadata.id3.a mvx;
    private final com.google.android.exoplayer2.util.l mvy;
    private l mvz;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0673a c0673a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0673a.lYQ, i, obj, j, j2, i2);
        this.mvp = i3;
        this.mvs = gVar2;
        this.mvq = c0673a;
        this.mvt = z;
        this.miJ = sVar;
        this.mjW = this.mdo instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mvu = hVar.mvq != c0673a;
            eVar2 = (hVar.mvp != i3 || this.mvu) ? null : hVar.mrq;
        } else {
            this.mvu = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.msz, list, drmInitData, sVar);
        this.mrq = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mvv = ((Boolean) a.second).booleanValue();
        this.mvw = this.mrq == eVar2;
        this.mvC = this.mvw && gVar2 != null;
        if (this.mvv) {
            this.mvx = hVar != null ? hVar.mvx : new com.google.android.exoplayer2.metadata.id3.a();
            this.mvy = hVar != null ? hVar.mvy : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mvx = null;
            this.mvy = null;
        }
        this.mvr = eVar;
        this.uid = mvo.getAndIncrement();
    }

    public void a(l lVar) {
        this.mvz = lVar;
        lVar.ae(this.uid, this.mvu);
        if (!this.mvw) {
            this.mrq.a(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dvF() {
        return this.mtg;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dvz() {
        return this.mtf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.mrm = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dvh() {
        return this.mrm;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        dwa();
        if (!this.mrm) {
            dwb();
        }
    }

    private void dwa() throws IOException, InterruptedException {
        if (!this.mvC && this.mvs != null) {
            com.google.android.exoplayer2.upstream.g gH = this.mvs.gH(this.mvA);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mvr, gH.mFi, this.mvr.a(gH));
                int i = 0;
                while (i == 0 && !this.mrm) {
                    i = this.mrq.a(bVar, null);
                }
                this.mvA = (int) (bVar.getPosition() - this.mvs.mFi);
                v.a(this.mdo);
                this.mvC = true;
            } catch (Throwable th) {
                v.a(this.mdo);
                throw th;
            }
        }
    }

    private void dwb() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gH;
        int i = 0;
        if (this.mjW) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mtf != 0;
            gH = gVar;
        } else {
            z = false;
            gH = this.dataSpec.gH(this.mtf);
        }
        if (!this.mvt) {
            this.miJ.dyG();
        } else if (this.miJ.dyD() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.miJ.gJ(this.msC);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mdo, gH.mFi, this.mdo.a(gH));
            if (this.mvv && !this.mvB) {
                long E = E(bVar);
                this.mvB = true;
                this.mvz.gm(E != -9223372036854775807L ? this.miJ.gK(E) : this.msC);
            }
            if (z) {
                bVar.Jq(this.mtf);
            }
            while (i == 0 && !this.mrm) {
                i = this.mrq.a(bVar, null);
            }
            this.mtf = (int) (bVar.getPosition() - this.dataSpec.mFi);
            v.a(this.mdo);
            this.mtg = true;
        } catch (Throwable th) {
            v.a(this.mdo);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata x;
        fVar.dtE();
        if (fVar.e(this.mvy.data, 0, 10, true)) {
            this.mvy.reset(10);
            if (this.mvy.dyl() != com.google.android.exoplayer2.metadata.id3.a.mlJ) {
                return -9223372036854775807L;
            }
            this.mvy.skipBytes(3);
            int dyr = this.mvy.dyr();
            int i = dyr + 10;
            if (i > this.mvy.capacity()) {
                byte[] bArr = this.mvy.data;
                this.mvy.reset(i);
                System.arraycopy(bArr, 0, this.mvy.data, 0, 10);
            }
            if (fVar.e(this.mvy.data, 10, dyr, true) && (x = this.mvx.x(this.mvy.data, dyr)) != null) {
                int length = x.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Ka = x.Ka(i2);
                    if (Ka instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Ka;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mvy.data, 0, 8);
                            this.mvy.reset(8);
                            return this.mvy.readLong();
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
