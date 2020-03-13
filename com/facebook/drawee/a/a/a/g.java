package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private final com.facebook.drawee.a.a.d lKJ;
    private final com.facebook.common.time.b lKK;
    private final h lKL = new h();
    @Nullable
    private c lKM;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lKN;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lKO;
    @Nullable
    private com.facebook.imagepipeline.h.b lKP;
    @Nullable
    private List<f> lKQ;
    @Nullable
    private b lKk;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lKK = bVar;
        this.lKJ = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dlQ();
            if (this.lKk != null) {
                this.lKJ.a(this.lKk);
            }
            if (this.lKO != null) {
                this.lKJ.a(this.lKO);
            }
            if (this.lKP != null) {
                this.lKJ.a(this.lKP);
                return;
            }
            return;
        }
        if (this.lKk != null) {
            this.lKJ.b(this.lKk);
        }
        if (this.lKO != null) {
            this.lKJ.b(this.lKO);
        }
        if (this.lKP != null) {
            this.lKJ.b(this.lKP);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lKQ == null) {
                this.lKQ = new LinkedList();
            }
            this.lKQ.add(fVar);
        }
    }

    public void dlO() {
        if (this.lKQ != null) {
            this.lKQ.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Hy(i);
        if (this.mEnabled && this.lKQ != null && !this.lKQ.isEmpty()) {
            if (i == 3) {
                dlP();
            }
            e dlS = hVar.dlS();
            for (f fVar : this.lKQ) {
                fVar.a(dlS, i);
            }
        }
    }

    private void dlP() {
        com.facebook.drawee.d.b hierarchy = this.lKJ.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lKL.HA(bounds.width());
            this.lKL.HB(bounds.height());
        }
    }

    private void dlQ() {
        if (this.lKO == null) {
            this.lKO = new com.facebook.drawee.a.a.a.a.a(this.lKK, this.lKL, this);
        }
        if (this.lKN == null) {
            this.lKN = new com.facebook.drawee.a.a.a.a.c(this.lKK, this.lKL);
        }
        if (this.lKk == null) {
            this.lKk = new com.facebook.drawee.a.a.a.a.b(this.lKL, this);
        }
        if (this.lKM == null) {
            this.lKM = new c(this.lKJ.getId(), this.lKk);
        } else {
            this.lKM.init(this.lKJ.getId());
        }
        if (this.lKP == null) {
            this.lKP = new com.facebook.imagepipeline.h.b(this.lKN, this.lKM);
        }
    }

    public void reset() {
        dlO();
        setEnabled(false);
        this.lKL.reset();
    }
}
