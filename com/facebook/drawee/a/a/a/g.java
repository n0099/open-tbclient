package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d nmR;
    private final com.facebook.common.time.b nmS;
    private final h nmT = new h();
    @Nullable
    private c nmU;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c nmV;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a nmW;
    @Nullable
    private com.facebook.imagepipeline.h.b nmX;
    @Nullable
    private List<f> nmY;
    @Nullable
    private b nms;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.nmS = bVar;
        this.nmR = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dPE();
            if (this.nms != null) {
                this.nmR.a(this.nms);
            }
            if (this.nmW != null) {
                this.nmR.a(this.nmW);
            }
            if (this.nmX != null) {
                this.nmR.a(this.nmX);
                return;
            }
            return;
        }
        if (this.nms != null) {
            this.nmR.b(this.nms);
        }
        if (this.nmW != null) {
            this.nmR.b(this.nmW);
        }
        if (this.nmX != null) {
            this.nmR.b(this.nmX);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.nmY == null) {
                this.nmY = new LinkedList();
            }
            this.nmY.add(fVar);
        }
    }

    public void dPC() {
        if (this.nmY != null) {
            this.nmY.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.KZ(i);
        if (this.mEnabled && this.nmY != null && !this.nmY.isEmpty()) {
            if (i == 3) {
                dPD();
            }
            e dPG = hVar.dPG();
            for (f fVar : this.nmY) {
                fVar.a(dPG, i);
            }
        }
    }

    private void dPD() {
        com.facebook.drawee.d.b hierarchy = this.nmR.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.nmT.Lb(bounds.width());
            this.nmT.Lc(bounds.height());
        }
    }

    private void dPE() {
        if (this.nmW == null) {
            this.nmW = new com.facebook.drawee.a.a.a.a.a(this.nmS, this.nmT, this);
        }
        if (this.nmV == null) {
            this.nmV = new com.facebook.drawee.a.a.a.a.c(this.nmS, this.nmT);
        }
        if (this.nms == null) {
            this.nms = new com.facebook.drawee.a.a.a.a.b(this.nmT, this);
        }
        if (this.nmU == null) {
            this.nmU = new c(this.nmR.getId(), this.nms);
        } else {
            this.nmU.init(this.nmR.getId());
        }
        if (this.nmX == null) {
            this.nmX = new com.facebook.imagepipeline.h.b(this.nmV, this.nmU);
        }
    }

    public void reset() {
        dPC();
        setEnabled(false);
        this.nmT.reset();
    }
}
