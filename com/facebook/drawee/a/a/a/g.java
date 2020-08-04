package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    @Nullable
    private b mSz;
    private final com.facebook.drawee.a.a.d mTa;
    private final com.facebook.common.time.b mTb;
    private final h mTc = new h();
    @Nullable
    private c mTd;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c mTe;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a mTf;
    @Nullable
    private com.facebook.imagepipeline.h.b mTg;
    @Nullable
    private List<f> mTh;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.mTb = bVar;
        this.mTa = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dDE();
            if (this.mSz != null) {
                this.mTa.a(this.mSz);
            }
            if (this.mTf != null) {
                this.mTa.a(this.mTf);
            }
            if (this.mTg != null) {
                this.mTa.a(this.mTg);
                return;
            }
            return;
        }
        if (this.mSz != null) {
            this.mTa.b(this.mSz);
        }
        if (this.mTf != null) {
            this.mTa.b(this.mTf);
        }
        if (this.mTg != null) {
            this.mTa.b(this.mTg);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.mTh == null) {
                this.mTh = new LinkedList();
            }
            this.mTh.add(fVar);
        }
    }

    public void dDC() {
        if (this.mTh != null) {
            this.mTh.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Iv(i);
        if (this.mEnabled && this.mTh != null && !this.mTh.isEmpty()) {
            if (i == 3) {
                dDD();
            }
            e dDG = hVar.dDG();
            for (f fVar : this.mTh) {
                fVar.a(dDG, i);
            }
        }
    }

    private void dDD() {
        com.facebook.drawee.d.b hierarchy = this.mTa.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mTc.Ix(bounds.width());
            this.mTc.Iy(bounds.height());
        }
    }

    private void dDE() {
        if (this.mTf == null) {
            this.mTf = new com.facebook.drawee.a.a.a.a.a(this.mTb, this.mTc, this);
        }
        if (this.mTe == null) {
            this.mTe = new com.facebook.drawee.a.a.a.a.c(this.mTb, this.mTc);
        }
        if (this.mSz == null) {
            this.mSz = new com.facebook.drawee.a.a.a.a.b(this.mTc, this);
        }
        if (this.mTd == null) {
            this.mTd = new c(this.mTa.getId(), this.mSz);
        } else {
            this.mTd.init(this.mTa.getId());
        }
        if (this.mTg == null) {
            this.mTg = new com.facebook.imagepipeline.h.b(this.mTe, this.mTd);
        }
    }

    public void reset() {
        dDC();
        setEnabled(false);
        this.mTc.reset();
    }
}
