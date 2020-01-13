package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class g implements h {
    private int mfg;
    private final List<w.a> mmc;
    private final com.google.android.exoplayer2.extractor.m[] mmd;
    private boolean mme;
    private int mmf;
    private long mmg;

    public g(List<w.a> list) {
        this.mmc = list;
        this.mmd = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxF() {
        this.mme = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mmd.length) {
                w.a aVar = this.mmc.get(i2);
                dVar.dup();
                com.google.android.exoplayer2.extractor.m dH = gVar.dH(dVar.duq(), 3);
                dH.h(Format.a(dVar.dur(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mom), aVar.language, (DrmInitData) null));
                this.mmd[i2] = dH;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.mme = true;
            this.mmg = j;
            this.mfg = 0;
            this.mmf = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dua() {
        if (this.mme) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mmd) {
                mVar.a(this.mmg, 1, this.mfg, 0, null);
            }
            this.mme = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.mme) {
            if (this.mmf != 2 || j(lVar, 32)) {
                if (this.mmf != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dyf = lVar.dyf();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mmd) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dyf);
                    }
                    this.mfg += dyf;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dyf() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.mme = false;
        }
        this.mmf--;
        return this.mme;
    }
}
