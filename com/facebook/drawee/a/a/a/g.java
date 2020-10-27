package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d oDV;
    private final com.facebook.common.time.b oDW;
    private final h oDX = new h();
    @Nullable
    private c oDY;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c oDZ;
    @Nullable
    private b oDw;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a oEa;
    @Nullable
    private com.facebook.imagepipeline.h.b oEb;
    @Nullable
    private List<f> oEc;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.oDW = bVar;
        this.oDV = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            ehu();
            if (this.oDw != null) {
                this.oDV.a(this.oDw);
            }
            if (this.oEa != null) {
                this.oDV.a(this.oEa);
            }
            if (this.oEb != null) {
                this.oDV.a(this.oEb);
                return;
            }
            return;
        }
        if (this.oDw != null) {
            this.oDV.b(this.oDw);
        }
        if (this.oEa != null) {
            this.oDV.b(this.oEa);
        }
        if (this.oEb != null) {
            this.oDV.b(this.oEb);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.oEc == null) {
                this.oEc = new LinkedList();
            }
            this.oEc.add(fVar);
        }
    }

    public void ehs() {
        if (this.oEc != null) {
            this.oEc.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ob(i);
        if (this.mEnabled && this.oEc != null && !this.oEc.isEmpty()) {
            if (i == 3) {
                eht();
            }
            e ehw = hVar.ehw();
            for (f fVar : this.oEc) {
                fVar.a(ehw, i);
            }
        }
    }

    private void eht() {
        com.facebook.drawee.d.b hierarchy = this.oDV.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.oDX.Od(bounds.width());
            this.oDX.Oe(bounds.height());
        }
    }

    private void ehu() {
        if (this.oEa == null) {
            this.oEa = new com.facebook.drawee.a.a.a.a.a(this.oDW, this.oDX, this);
        }
        if (this.oDZ == null) {
            this.oDZ = new com.facebook.drawee.a.a.a.a.c(this.oDW, this.oDX);
        }
        if (this.oDw == null) {
            this.oDw = new com.facebook.drawee.a.a.a.a.b(this.oDX, this);
        }
        if (this.oDY == null) {
            this.oDY = new c(this.oDV.getId(), this.oDw);
        } else {
            this.oDY.init(this.oDV.getId());
        }
        if (this.oEb == null) {
            this.oEb = new com.facebook.imagepipeline.h.b(this.oDZ, this.oDY);
        }
    }

    public void reset() {
        ehs();
        setEnabled(false);
        this.oDX.reset();
    }
}
