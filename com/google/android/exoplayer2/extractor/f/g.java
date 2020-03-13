package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.f.w;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements h {
    private int mge;
    private final List<w.a> mna;
    private final com.google.android.exoplayer2.extractor.m[] mnb;
    private boolean mnc;
    private int mnd;
    private long mne;

    public g(List<w.a> list) {
        this.mna = list;
        this.mnb = new com.google.android.exoplayer2.extractor.m[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void cze() {
        this.mnc = false;
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void a(com.google.android.exoplayer2.extractor.g gVar, w.d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mnb.length) {
                w.a aVar = this.mna.get(i2);
                dVar.dvF();
                com.google.android.exoplayer2.extractor.m dK = gVar.dK(dVar.dvG(), 3);
                dK.h(Format.a(dVar.dvH(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.mpl), aVar.language, (DrmInitData) null));
                this.mnb[i2] = dK;
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void o(long j, boolean z) {
        if (z) {
            this.mnc = true;
            this.mne = j;
            this.mge = 0;
            this.mnd = 2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void dvq() {
        if (this.mnc) {
            for (com.google.android.exoplayer2.extractor.m mVar : this.mnb) {
                mVar.a(this.mne, 1, this.mge, 0, null);
            }
            this.mnc = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.f.h
    public void I(com.google.android.exoplayer2.util.l lVar) {
        com.google.android.exoplayer2.extractor.m[] mVarArr;
        if (this.mnc) {
            if (this.mnd != 2 || j(lVar, 32)) {
                if (this.mnd != 1 || j(lVar, 0)) {
                    int position = lVar.getPosition();
                    int dzu = lVar.dzu();
                    for (com.google.android.exoplayer2.extractor.m mVar : this.mnb) {
                        lVar.setPosition(position);
                        mVar.a(lVar, dzu);
                    }
                    this.mge += dzu;
                }
            }
        }
    }

    private boolean j(com.google.android.exoplayer2.util.l lVar, int i) {
        if (lVar.dzu() == 0) {
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.mnc = false;
        }
        this.mnd--;
        return this.mnc;
    }
}
