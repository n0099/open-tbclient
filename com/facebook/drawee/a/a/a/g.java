package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d mSY;
    private final com.facebook.common.time.b mSZ;
    @Nullable
    private b mSx;
    private final h mTa = new h();
    @Nullable
    private c mTb;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c mTc;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a mTd;
    @Nullable
    private com.facebook.imagepipeline.h.b mTe;
    @Nullable
    private List<f> mTf;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.mSZ = bVar;
        this.mSY = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dDD();
            if (this.mSx != null) {
                this.mSY.a(this.mSx);
            }
            if (this.mTd != null) {
                this.mSY.a(this.mTd);
            }
            if (this.mTe != null) {
                this.mSY.a(this.mTe);
                return;
            }
            return;
        }
        if (this.mSx != null) {
            this.mSY.b(this.mSx);
        }
        if (this.mTd != null) {
            this.mSY.b(this.mTd);
        }
        if (this.mTe != null) {
            this.mSY.b(this.mTe);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.mTf == null) {
                this.mTf = new LinkedList();
            }
            this.mTf.add(fVar);
        }
    }

    public void dDB() {
        if (this.mTf != null) {
            this.mTf.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Iv(i);
        if (this.mEnabled && this.mTf != null && !this.mTf.isEmpty()) {
            if (i == 3) {
                dDC();
            }
            e dDF = hVar.dDF();
            for (f fVar : this.mTf) {
                fVar.a(dDF, i);
            }
        }
    }

    private void dDC() {
        com.facebook.drawee.d.b hierarchy = this.mSY.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mTa.Ix(bounds.width());
            this.mTa.Iy(bounds.height());
        }
    }

    private void dDD() {
        if (this.mTd == null) {
            this.mTd = new com.facebook.drawee.a.a.a.a.a(this.mSZ, this.mTa, this);
        }
        if (this.mTc == null) {
            this.mTc = new com.facebook.drawee.a.a.a.a.c(this.mSZ, this.mTa);
        }
        if (this.mSx == null) {
            this.mSx = new com.facebook.drawee.a.a.a.a.b(this.mTa, this);
        }
        if (this.mTb == null) {
            this.mTb = new c(this.mSY.getId(), this.mSx);
        } else {
            this.mTb.init(this.mSY.getId());
        }
        if (this.mTe == null) {
            this.mTe = new com.facebook.imagepipeline.h.b(this.mTc, this.mTb);
        }
    }

    public void reset() {
        dDB();
        setEnabled(false);
        this.mTa.reset();
    }
}
