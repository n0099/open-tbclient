package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements h {
    private int mfR;
    private final List<w.a> mmN;
    private final com.google.android.exoplayer2.extractor.m[] mmO;
    private boolean mmP;
    private int mmQ;
    private long mmR;

    public g(List<w.a> list) {
        this.mmN = list;
        this.mmO = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czb() {
        this.mmP = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mmO.length) {
                w.a aVar = this.mmN.get(i2);
                dVar.dvC();
                com.google.android.exoplayer2.extractor.m dK = gVar.dK(dVar.dvD(), 3);
                dK.h(Format.a(dVar.dvE(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.moY), aVar.language, (DrmInitData) null));
                this.mmO[i2] = dK;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mmP = true;
            this.mmR = j;
            this.mfR = 0;
            this.mmQ = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvn() {
        if (this.mmP) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mmO) {
                mVar.a(this.mmR, 1, this.mfR, 0, null);
            }
            this.mmP = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.mmP) {
            if (this.mmQ != 2 || j(lVar, 32)) {
                if (this.mmQ != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dzr = lVar.dzr();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mmO) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dzr);
                    }
                    this.mfR += dzr;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dzr() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.mmP = false;
        }
        this.mmQ--;
        return this.mmP;
    }
}
