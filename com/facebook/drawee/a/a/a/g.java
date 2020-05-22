package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d mnF;
    private final com.facebook.common.time.b mnG;
    private final h mnH = new h();
    @Nullable
    private c mnI;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c mnJ;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a mnK;
    @Nullable
    private com.facebook.imagepipeline.h.b mnL;
    @Nullable
    private List<f> mnM;
    @Nullable
    private b mng;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.mnG = bVar;
        this.mnF = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dvw();
            if (this.mng != null) {
                this.mnF.a(this.mng);
            }
            if (this.mnK != null) {
                this.mnF.a(this.mnK);
            }
            if (this.mnL != null) {
                this.mnF.a(this.mnL);
                return;
            }
            return;
        }
        if (this.mng != null) {
            this.mnF.b(this.mng);
        }
        if (this.mnK != null) {
            this.mnF.b(this.mnK);
        }
        if (this.mnL != null) {
            this.mnF.b(this.mnL);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.mnM == null) {
                this.mnM = new LinkedList();
            }
            this.mnM.add(fVar);
        }
    }

    public void dvu() {
        if (this.mnM != null) {
            this.mnM.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.GR(i);
        if (this.mEnabled && this.mnM != null && !this.mnM.isEmpty()) {
            if (i == 3) {
                dvv();
            }
            e dvy = hVar.dvy();
            for (f fVar : this.mnM) {
                fVar.a(dvy, i);
            }
        }
    }

    private void dvv() {
        com.facebook.drawee.d.b hierarchy = this.mnF.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mnH.GT(bounds.width());
            this.mnH.GU(bounds.height());
        }
    }

    private void dvw() {
        if (this.mnK == null) {
            this.mnK = new com.facebook.drawee.a.a.a.a.a(this.mnG, this.mnH, this);
        }
        if (this.mnJ == null) {
            this.mnJ = new com.facebook.drawee.a.a.a.a.c(this.mnG, this.mnH);
        }
        if (this.mng == null) {
            this.mng = new com.facebook.drawee.a.a.a.a.b(this.mnH, this);
        }
        if (this.mnI == null) {
            this.mnI = new c(this.mnF.getId(), this.mng);
        } else {
            this.mnI.init(this.mnF.getId());
        }
        if (this.mnL == null) {
            this.mnL = new com.facebook.imagepipeline.h.b(this.mnJ, this.mnI);
        }
    }

    public void reset() {
        dvu();
        setEnabled(false);
        this.mnH.reset();
    }
}
