package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d mKP;
    private final com.facebook.common.time.b mKQ;
    private final h mKR = new h();
    @Nullable
    private c mKS;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c mKT;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a mKU;
    @Nullable
    private com.facebook.imagepipeline.h.b mKV;
    @Nullable
    private List<f> mKW;
    @Nullable
    private b mKq;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.mKQ = bVar;
        this.mKP = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dAn();
            if (this.mKq != null) {
                this.mKP.a(this.mKq);
            }
            if (this.mKU != null) {
                this.mKP.a(this.mKU);
            }
            if (this.mKV != null) {
                this.mKP.a(this.mKV);
                return;
            }
            return;
        }
        if (this.mKq != null) {
            this.mKP.b(this.mKq);
        }
        if (this.mKU != null) {
            this.mKP.b(this.mKU);
        }
        if (this.mKV != null) {
            this.mKP.b(this.mKV);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.mKW == null) {
                this.mKW = new LinkedList();
            }
            this.mKW.add(fVar);
        }
    }

    public void dAl() {
        if (this.mKW != null) {
            this.mKW.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ia(i);
        if (this.mEnabled && this.mKW != null && !this.mKW.isEmpty()) {
            if (i == 3) {
                dAm();
            }
            e dAp = hVar.dAp();
            for (f fVar : this.mKW) {
                fVar.a(dAp, i);
            }
        }
    }

    private void dAm() {
        com.facebook.drawee.d.b hierarchy = this.mKP.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mKR.Ic(bounds.width());
            this.mKR.Id(bounds.height());
        }
    }

    private void dAn() {
        if (this.mKU == null) {
            this.mKU = new com.facebook.drawee.a.a.a.a.a(this.mKQ, this.mKR, this);
        }
        if (this.mKT == null) {
            this.mKT = new com.facebook.drawee.a.a.a.a.c(this.mKQ, this.mKR);
        }
        if (this.mKq == null) {
            this.mKq = new com.facebook.drawee.a.a.a.a.b(this.mKR, this);
        }
        if (this.mKS == null) {
            this.mKS = new c(this.mKP.getId(), this.mKq);
        } else {
            this.mKS.init(this.mKP.getId());
        }
        if (this.mKV == null) {
            this.mKV = new com.facebook.imagepipeline.h.b(this.mKT, this.mKS);
        }
    }

    public void reset() {
        dAl();
        setEnabled(false);
        this.mKR.reset();
    }
}
