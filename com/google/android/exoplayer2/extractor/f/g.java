package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements h {
    private int mfT;
    private final List<w.a> mmP;
    private final com.google.android.exoplayer2.extractor.m[] mmQ;
    private boolean mmR;
    private int mmS;
    private long mmT;

    public g(List<w.a> list) {
        this.mmP = list;
        this.mmQ = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czd() {
        this.mmR = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mmQ.length) {
                w.a aVar = this.mmP.get(i2);
                dVar.dvE();
                com.google.android.exoplayer2.extractor.m dK = gVar.dK(dVar.dvF(), 3);
                dK.h(Format.a(dVar.dvG(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mpa), aVar.language, (DrmInitData) null));
                this.mmQ[i2] = dK;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mmR = true;
            this.mmT = j;
            this.mfT = 0;
            this.mmS = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvp() {
        if (this.mmR) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mmQ) {
                mVar.a(this.mmT, 1, this.mfT, 0, null);
            }
            this.mmR = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.mmR) {
            if (this.mmS != 2 || j(lVar, 32)) {
                if (this.mmS != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dzt = lVar.dzt();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mmQ) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dzt);
                    }
                    this.mfT += dzt;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dzt() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.mmR = false;
        }
        this.mmS--;
        return this.mmR;
    }
}
