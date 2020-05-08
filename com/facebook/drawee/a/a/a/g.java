package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private final com.facebook.drawee.a.a.d lTN;
    private final com.facebook.common.time.b lTO;
    private final h lTP = new h();
    @Nullable
    private c lTQ;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lTR;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lTS;
    @Nullable
    private com.facebook.imagepipeline.h.b lTT;
    @Nullable
    private List<f> lTU;
    @Nullable
    private b lTo;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lTO = bVar;
        this.lTN = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dod();
            if (this.lTo != null) {
                this.lTN.a(this.lTo);
            }
            if (this.lTS != null) {
                this.lTN.a(this.lTS);
            }
            if (this.lTT != null) {
                this.lTN.a(this.lTT);
                return;
            }
            return;
        }
        if (this.lTo != null) {
            this.lTN.b(this.lTo);
        }
        if (this.lTS != null) {
            this.lTN.b(this.lTS);
        }
        if (this.lTT != null) {
            this.lTN.b(this.lTT);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lTU == null) {
                this.lTU = new LinkedList();
            }
            this.lTU.add(fVar);
        }
    }

    public void dob() {
        if (this.lTU != null) {
            this.lTU.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Gf(i);
        if (this.mEnabled && this.lTU != null && !this.lTU.isEmpty()) {
            if (i == 3) {
                doc();
            }
            e dof = hVar.dof();
            for (f fVar : this.lTU) {
                fVar.a(dof, i);
            }
        }
    }

    private void doc() {
        com.facebook.drawee.d.b hierarchy = this.lTN.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lTP.Gh(bounds.width());
            this.lTP.Gi(bounds.height());
        }
    }

    private void dod() {
        if (this.lTS == null) {
            this.lTS = new com.facebook.drawee.a.a.a.a.a(this.lTO, this.lTP, this);
        }
        if (this.lTR == null) {
            this.lTR = new com.facebook.drawee.a.a.a.a.c(this.lTO, this.lTP);
        }
        if (this.lTo == null) {
            this.lTo = new com.facebook.drawee.a.a.a.a.b(this.lTP, this);
        }
        if (this.lTQ == null) {
            this.lTQ = new c(this.lTN.getId(), this.lTo);
        } else {
            this.lTQ.init(this.lTN.getId());
        }
        if (this.lTT == null) {
            this.lTT = new com.facebook.imagepipeline.h.b(this.lTR, this.lTQ);
        }
    }

    public void reset() {
        dob();
        setEnabled(false);
        this.lTP.reset();
    }
}
