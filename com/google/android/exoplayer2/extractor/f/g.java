package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class g implements h {
    private int mbr;
    private final List<w.a> mio;
    private final com.google.android.exoplayer2.extractor.m[] mip;
    private boolean miq;
    private int mir;
    private long mis;

    public g(List<w.a> list) {
        this.mio = list;
        this.mip = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cwy() {
        this.miq = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mip.length) {
                w.a aVar = this.mio.get(i2);
                dVar.dte();
                com.google.android.exoplayer2.extractor.m dJ = gVar.dJ(dVar.dtf(), 3);
                dJ.h(Format.a(dVar.dtg(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mky), aVar.language, (DrmInitData) null));
                this.mip[i2] = dJ;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void m(long j, boolean z) {
        if (z) {
            this.miq = true;
            this.mis = j;
            this.mbr = 0;
            this.mir = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dsO() {
        if (this.miq) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mip) {
                mVar.a(this.mis, 1, this.mbr, 0, null);
            }
            this.miq = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.miq) {
            if (this.mir != 2 || j(lVar, 32)) {
                if (this.mir != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dwV = lVar.dwV();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mip) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dwV);
                    }
                    this.mbr += dwV;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dwV() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.miq = false;
        }
        this.mir--;
        return this.miq;
    }
}
