package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements h {
    private int mhK;
    private final List<w.a> moH;
    private final com.google.android.exoplayer2.extractor.m[] moI;
    private boolean moJ;
    private int moK;
    private long moL;

    public g(List<w.a> list) {
        this.moH = list;
        this.moI = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void czx() {
        this.moJ = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.moI.length) {
                w.a aVar = this.moH.get(i2);
                dVar.dwc();
                com.google.android.exoplayer2.extractor.m dL = gVar.dL(dVar.dwd(), 3);
                dL.h(Format.a(dVar.dwe(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mqR), aVar.language, (DrmInitData) null));
                this.moI[i2] = dL;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void p(long j, boolean z) {
        if (z) {
            this.moJ = true;
            this.moL = j;
            this.mhK = 0;
            this.moK = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvN() {
        if (this.moJ) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.moI) {
                mVar.a(this.moL, 1, this.mhK, 0, null);
            }
            this.moJ = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.moJ) {
            if (this.moK != 2 || j(lVar, 32)) {
                if (this.moK != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dzR = lVar.dzR();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.moI) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dzR);
                    }
                    this.mhK += dzR;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dzR() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.moJ = false;
        }
        this.moK--;
        return this.moJ;
    }
}
