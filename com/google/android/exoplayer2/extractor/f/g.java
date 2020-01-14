package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class g implements h {
    private int mfl;
    private final List<w.a> mmh;
    private final com.google.android.exoplayer2.extractor.m[] mmi;
    private boolean mmj;
    private int mmk;
    private long mml;

    public g(List<w.a> list) {
        this.mmh = list;
        this.mmi = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cxH() {
        this.mmj = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mmi.length) {
                w.a aVar = this.mmh.get(i2);
                dVar.dur();
                com.google.android.exoplayer2.extractor.m dH = gVar.dH(dVar.dus(), 3);
                dH.h(Format.a(dVar.dut(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mos), aVar.language, (DrmInitData) null));
                this.mmi[i2] = dH;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.mmj = true;
            this.mml = j;
            this.mfl = 0;
            this.mmk = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void duc() {
        if (this.mmj) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mmi) {
                mVar.a(this.mml, 1, this.mfl, 0, null);
            }
            this.mmj = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.mmj) {
            if (this.mmk != 2 || j(lVar, 32)) {
                if (this.mmk != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dyh = lVar.dyh();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mmi) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dyh);
                    }
                    this.mfl += dyh;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dyh() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.mmj = false;
        }
        this.mmk--;
        return this.mmj;
    }
}
