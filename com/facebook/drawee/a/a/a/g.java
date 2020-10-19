package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d nMC;
    private final com.facebook.common.time.b nMD;
    private final h nME = new h();
    @Nullable
    private c nMF;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c nMG;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a nMH;
    @Nullable
    private com.facebook.imagepipeline.h.b nMI;
    @Nullable
    private List<f> nMJ;
    @Nullable
    private b nMd;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.nMD = bVar;
        this.nMC = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dXw();
            if (this.nMd != null) {
                this.nMC.a(this.nMd);
            }
            if (this.nMH != null) {
                this.nMC.a(this.nMH);
            }
            if (this.nMI != null) {
                this.nMC.a(this.nMI);
                return;
            }
            return;
        }
        if (this.nMd != null) {
            this.nMC.b(this.nMd);
        }
        if (this.nMH != null) {
            this.nMC.b(this.nMH);
        }
        if (this.nMI != null) {
            this.nMC.b(this.nMI);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.nMJ == null) {
                this.nMJ = new LinkedList();
            }
            this.nMJ.add(fVar);
        }
    }

    public void dXu() {
        if (this.nMJ != null) {
            this.nMJ.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Mk(i);
        if (this.mEnabled && this.nMJ != null && !this.nMJ.isEmpty()) {
            if (i == 3) {
                dXv();
            }
            e dXy = hVar.dXy();
            for (f fVar : this.nMJ) {
                fVar.a(dXy, i);
            }
        }
    }

    private void dXv() {
        com.facebook.drawee.d.b hierarchy = this.nMC.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.nME.Mm(bounds.width());
            this.nME.Mn(bounds.height());
        }
    }

    private void dXw() {
        if (this.nMH == null) {
            this.nMH = new com.facebook.drawee.a.a.a.a.a(this.nMD, this.nME, this);
        }
        if (this.nMG == null) {
            this.nMG = new com.facebook.drawee.a.a.a.a.c(this.nMD, this.nME);
        }
        if (this.nMd == null) {
            this.nMd = new com.facebook.drawee.a.a.a.a.b(this.nME, this);
        }
        if (this.nMF == null) {
            this.nMF = new c(this.nMC.getId(), this.nMd);
        } else {
            this.nMF.init(this.nMC.getId());
        }
        if (this.nMI == null) {
            this.nMI = new com.facebook.imagepipeline.h.b(this.nMG, this.nMF);
        }
    }

    public void reset() {
        dXu();
        setEnabled(false);
        this.nME.reset();
    }
}
