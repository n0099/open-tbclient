package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d pAW;
    private final com.facebook.common.time.b pAX;
    private final h pAY = new h();
    @Nullable
    private c pAZ;
    @Nullable
    private b pAx;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pBa;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pBb;
    @Nullable
    private com.facebook.imagepipeline.g.b pBc;
    @Nullable
    private List<f> pBd;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pAX = bVar;
        this.pAW = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            etF();
            if (this.pAx != null) {
                this.pAW.a(this.pAx);
            }
            if (this.pBb != null) {
                this.pAW.a(this.pBb);
            }
            if (this.pBc != null) {
                this.pAW.a(this.pBc);
                return;
            }
            return;
        }
        if (this.pAx != null) {
            this.pAW.b(this.pAx);
        }
        if (this.pBb != null) {
            this.pAW.b(this.pBb);
        }
        if (this.pBc != null) {
            this.pAW.b(this.pBc);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pBd == null) {
                this.pBd = new LinkedList();
            }
            this.pBd.add(fVar);
        }
    }

    public void etD() {
        if (this.pBd != null) {
            this.pBd.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.OZ(i);
        if (this.mEnabled && this.pBd != null && !this.pBd.isEmpty()) {
            if (i == 3) {
                etE();
            }
            e etH = hVar.etH();
            for (f fVar : this.pBd) {
                fVar.a(etH, i);
            }
        }
    }

    private void etE() {
        com.facebook.drawee.d.b hierarchy = this.pAW.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pAY.Pb(bounds.width());
            this.pAY.Pc(bounds.height());
        }
    }

    private void etF() {
        if (this.pBb == null) {
            this.pBb = new com.facebook.drawee.a.a.a.a.a(this.pAX, this.pAY, this);
        }
        if (this.pBa == null) {
            this.pBa = new com.facebook.drawee.a.a.a.a.c(this.pAX, this.pAY);
        }
        if (this.pAx == null) {
            this.pAx = new com.facebook.drawee.a.a.a.a.b(this.pAY, this);
        }
        if (this.pAZ == null) {
            this.pAZ = new c(this.pAW.getId(), this.pAx);
        } else {
            this.pAZ.init(this.pAW.getId());
        }
        if (this.pBc == null) {
            this.pBc = new com.facebook.imagepipeline.g.b(this.pBa, this.pAZ);
        }
    }

    public void reset() {
        etD();
        setEnabled(false);
        this.pAY.reset();
    }
}
