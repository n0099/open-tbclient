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
    private static final AtomicInteger mwh = new AtomicInteger();
    private final s mjC;
    private final boolean mkP;
    private volatile boolean msf;
    private final com.google.android.exoplayer2.extractor.e msk;
    private int mtZ;
    private volatile boolean mua;
    public final int mwi;
    public final a.C0681a mwj;
    private final com.google.android.exoplayer2.upstream.e mwk;
    private final com.google.android.exoplayer2.upstream.g mwl;
    private final boolean mwm;
    private final boolean mwn;
    private final boolean mwo;
    private final boolean mwp;
    private final com.google.android.exoplayer2.metadata.id3.a mwq;
    private final com.google.android.exoplayer2.util.l mwr;
    private l mws;
    private int mwt;
    private boolean mwu;
    private boolean mwv;
    public final int uid;

    public h(f fVar, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, com.google.android.exoplayer2.upstream.g gVar2, a.C0681a c0681a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, s sVar, h hVar, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(a(eVar, bArr, bArr2), gVar, c0681a.lZJ, i, obj, j, j2, i2);
        this.mwi = i3;
        this.mwl = gVar2;
        this.mwj = c0681a;
        this.mwm = z;
        this.mjC = sVar;
        this.mkP = this.meh instanceof a;
        com.google.android.exoplayer2.extractor.e eVar2 = null;
        if (hVar != null) {
            this.mwn = hVar.mwj != c0681a;
            eVar2 = (hVar.mwi != i3 || this.mwn) ? null : hVar.msk;
        } else {
            this.mwn = false;
        }
        Pair<com.google.android.exoplayer2.extractor.e, Boolean> a = fVar.a(eVar2, gVar.uri, this.mts, list, drmInitData, sVar);
        this.msk = (com.google.android.exoplayer2.extractor.e) a.first;
        this.mwo = ((Boolean) a.second).booleanValue();
        this.mwp = this.msk == eVar2;
        this.mwv = this.mwp && gVar2 != null;
        if (this.mwo) {
            this.mwq = hVar != null ? hVar.mwq : new com.google.android.exoplayer2.metadata.id3.a();
            this.mwr = hVar != null ? hVar.mwr : new com.google.android.exoplayer2.util.l(10);
        } else {
            this.mwq = null;
            this.mwr = null;
        }
        this.mwk = eVar;
        this.uid = mwh.getAndIncrement();
    }

    public void a(l lVar) {
        this.mws = lVar;
        lVar.ad(this.uid, this.mwn);
        if (!this.mwp) {
            this.msk.a(lVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.a.l
    public boolean dwS() {
        return this.mua;
    }

    @Override // com.google.android.exoplayer2.source.a.c
    public long dwM() {
        return this.mtZ;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void cancelLoad() {
        this.msf = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public boolean dwu() {
        return this.msf;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.c
    public void load() throws IOException, InterruptedException {
        dxn();
        if (!this.msf) {
            dxo();
        }
    }

    private void dxn() throws IOException, InterruptedException {
        if (!this.mwv && this.mwl != null) {
            com.google.android.exoplayer2.upstream.g gF = this.mwl.gF(this.mwt);
            try {
                com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.mwk, gF.mGb, this.mwk.a(gF));
                int i = 0;
                while (i == 0 && !this.msf) {
                    i = this.msk.a(bVar, null);
                }
                this.mwt = (int) (bVar.getPosition() - this.mwl.mGb);
                v.a(this.meh);
                this.mwv = true;
            } catch (Throwable th) {
                v.a(this.meh);
                throw th;
            }
        }
    }

    private void dxo() throws IOException, InterruptedException {
        boolean z;
        com.google.android.exoplayer2.upstream.g gF;
        int i = 0;
        if (this.mkP) {
            com.google.android.exoplayer2.upstream.g gVar = this.dataSpec;
            z = this.mtZ != 0;
            gF = gVar;
        } else {
            z = false;
            gF = this.dataSpec.gF(this.mtZ);
        }
        if (!this.mwm) {
            this.mjC.dzT();
        } else if (this.mjC.dzQ() == Format.OFFSET_SAMPLE_RELATIVE) {
            this.mjC.gH(this.mtv);
        }
        try {
            com.google.android.exoplayer2.extractor.b bVar = new com.google.android.exoplayer2.extractor.b(this.meh, gF.mGb, this.meh.a(gF));
            if (this.mwo && !this.mwu) {
                long E = E(bVar);
                this.mwu = true;
                this.mws.gk(E != -9223372036854775807L ? this.mjC.gI(E) : this.mtv);
            }
            if (z) {
                bVar.Jv(this.mtZ);
            }
            while (i == 0 && !this.msf) {
                i = this.msk.a(bVar, null);
            }
            this.mtZ = (int) (bVar.getPosition() - this.dataSpec.mGb);
            v.a(this.meh);
            this.mua = true;
        } catch (Throwable th) {
            v.a(this.meh);
            throw th;
        }
    }

    private long E(com.google.android.exoplayer2.extractor.f fVar) throws IOException, InterruptedException {
        Metadata z;
        fVar.duS();
        if (fVar.e(this.mwr.data, 0, 10, true)) {
            this.mwr.reset(10);
            if (this.mwr.dzy() != com.google.android.exoplayer2.metadata.id3.a.mmC) {
                return -9223372036854775807L;
            }
            this.mwr.skipBytes(3);
            int dzE = this.mwr.dzE();
            int i = dzE + 10;
            if (i > this.mwr.capacity()) {
                byte[] bArr = this.mwr.data;
                this.mwr.reset(i);
                System.arraycopy(bArr, 0, this.mwr.data, 0, 10);
            }
            if (fVar.e(this.mwr.data, 10, dzE, true) && (z = this.mwq.z(this.mwr.data, dzE)) != null) {
                int length = z.length();
                for (int i2 = 0; i2 < length; i2++) {
                    Metadata.Entry Kf = z.Kf(i2);
                    if (Kf instanceof PrivFrame) {
                        PrivFrame privFrame = (PrivFrame) Kf;
                        if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                            System.arraycopy(privFrame.privateData, 0, this.mwr.data, 0, 8);
                            this.mwr.reset(8);
                            return this.mwr.readLong();
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
