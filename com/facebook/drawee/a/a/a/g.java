package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    @Nullable
    private b nwK;
    private final com.facebook.drawee.a.a.d nxj;
    private final com.facebook.common.time.b nxk;
    private final h nxl = new h();
    @Nullable
    private c nxm;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c nxn;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a nxo;
    @Nullable
    private com.facebook.imagepipeline.h.b nxp;
    @Nullable
    private List<f> nxq;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.nxk = bVar;
        this.nxj = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dTL();
            if (this.nwK != null) {
                this.nxj.a(this.nwK);
            }
            if (this.nxo != null) {
                this.nxj.a(this.nxo);
            }
            if (this.nxp != null) {
                this.nxj.a(this.nxp);
                return;
            }
            return;
        }
        if (this.nwK != null) {
            this.nxj.b(this.nwK);
        }
        if (this.nxo != null) {
            this.nxj.b(this.nxo);
        }
        if (this.nxp != null) {
            this.nxj.b(this.nxp);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.nxq == null) {
                this.nxq = new LinkedList();
            }
            this.nxq.add(fVar);
        }
    }

    public void dTJ() {
        if (this.nxq != null) {
            this.nxq.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.LE(i);
        if (this.mEnabled && this.nxq != null && !this.nxq.isEmpty()) {
            if (i == 3) {
                dTK();
            }
            e dTN = hVar.dTN();
            for (f fVar : this.nxq) {
                fVar.a(dTN, i);
            }
        }
    }

    private void dTK() {
        com.facebook.drawee.d.b hierarchy = this.nxj.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.nxl.LG(bounds.width());
            this.nxl.LH(bounds.height());
        }
    }

    private void dTL() {
        if (this.nxo == null) {
            this.nxo = new com.facebook.drawee.a.a.a.a.a(this.nxk, this.nxl, this);
        }
        if (this.nxn == null) {
            this.nxn = new com.facebook.drawee.a.a.a.a.c(this.nxk, this.nxl);
        }
        if (this.nwK == null) {
            this.nwK = new com.facebook.drawee.a.a.a.a.b(this.nxl, this);
        }
        if (this.nxm == null) {
            this.nxm = new c(this.nxj.getId(), this.nwK);
        } else {
            this.nxm.init(this.nxj.getId());
        }
        if (this.nxp == null) {
            this.nxp = new com.facebook.imagepipeline.h.b(this.nxn, this.nxm);
        }
    }

    public void reset() {
        dTJ();
        setEnabled(false);
        this.nxl.reset();
    }
}
