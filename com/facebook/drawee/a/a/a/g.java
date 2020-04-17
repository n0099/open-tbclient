package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private final com.facebook.drawee.a.a.d lTJ;
    private final com.facebook.common.time.b lTK;
    private final h lTL = new h();
    @Nullable
    private c lTM;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lTN;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lTO;
    @Nullable
    private com.facebook.imagepipeline.h.b lTP;
    @Nullable
    private List<f> lTQ;
    @Nullable
    private b lTk;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lTK = bVar;
        this.lTJ = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dog();
            if (this.lTk != null) {
                this.lTJ.a(this.lTk);
            }
            if (this.lTO != null) {
                this.lTJ.a(this.lTO);
            }
            if (this.lTP != null) {
                this.lTJ.a(this.lTP);
                return;
            }
            return;
        }
        if (this.lTk != null) {
            this.lTJ.b(this.lTk);
        }
        if (this.lTO != null) {
            this.lTJ.b(this.lTO);
        }
        if (this.lTP != null) {
            this.lTJ.b(this.lTP);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lTQ == null) {
                this.lTQ = new LinkedList();
            }
            this.lTQ.add(fVar);
        }
    }

    public void doe() {
        if (this.lTQ != null) {
            this.lTQ.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Gf(i);
        if (this.mEnabled && this.lTQ != null && !this.lTQ.isEmpty()) {
            if (i == 3) {
                dof();
            }
            e doi = hVar.doi();
            for (f fVar : this.lTQ) {
                fVar.a(doi, i);
            }
        }
    }

    private void dof() {
        com.facebook.drawee.d.b hierarchy = this.lTJ.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lTL.Gh(bounds.width());
            this.lTL.Gi(bounds.height());
        }
    }

    private void dog() {
        if (this.lTO == null) {
            this.lTO = new com.facebook.drawee.a.a.a.a.a(this.lTK, this.lTL, this);
        }
        if (this.lTN == null) {
            this.lTN = new com.facebook.drawee.a.a.a.a.c(this.lTK, this.lTL);
        }
        if (this.lTk == null) {
            this.lTk = new com.facebook.drawee.a.a.a.a.b(this.lTL, this);
        }
        if (this.lTM == null) {
            this.lTM = new c(this.lTJ.getId(), this.lTk);
        } else {
            this.lTM.init(this.lTJ.getId());
        }
        if (this.lTP == null) {
            this.lTP = new com.facebook.imagepipeline.h.b(this.lTN, this.lTM);
        }
    }

    public void reset() {
        doe();
        setEnabled(false);
        this.lTL.reset();
    }
}
