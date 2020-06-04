package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d moQ;
    private final com.facebook.common.time.b moR;
    private final h moS = new h();
    @Nullable
    private c moT;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c moU;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a moV;
    @Nullable
    private com.facebook.imagepipeline.h.b moW;
    @Nullable
    private List<f> moX;
    @Nullable
    private b mor;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.moR = bVar;
        this.moQ = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dvK();
            if (this.mor != null) {
                this.moQ.a(this.mor);
            }
            if (this.moV != null) {
                this.moQ.a(this.moV);
            }
            if (this.moW != null) {
                this.moQ.a(this.moW);
                return;
            }
            return;
        }
        if (this.mor != null) {
            this.moQ.b(this.mor);
        }
        if (this.moV != null) {
            this.moQ.b(this.moV);
        }
        if (this.moW != null) {
            this.moQ.b(this.moW);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.moX == null) {
                this.moX = new LinkedList();
            }
            this.moX.add(fVar);
        }
    }

    public void dvI() {
        if (this.moX != null) {
            this.moX.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.GT(i);
        if (this.mEnabled && this.moX != null && !this.moX.isEmpty()) {
            if (i == 3) {
                dvJ();
            }
            e dvM = hVar.dvM();
            for (f fVar : this.moX) {
                fVar.a(dvM, i);
            }
        }
    }

    private void dvJ() {
        com.facebook.drawee.d.b hierarchy = this.moQ.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.moS.GV(bounds.width());
            this.moS.GW(bounds.height());
        }
    }

    private void dvK() {
        if (this.moV == null) {
            this.moV = new com.facebook.drawee.a.a.a.a.a(this.moR, this.moS, this);
        }
        if (this.moU == null) {
            this.moU = new com.facebook.drawee.a.a.a.a.c(this.moR, this.moS);
        }
        if (this.mor == null) {
            this.mor = new com.facebook.drawee.a.a.a.a.b(this.moS, this);
        }
        if (this.moT == null) {
            this.moT = new c(this.moQ.getId(), this.mor);
        } else {
            this.moT.init(this.moQ.getId());
        }
        if (this.moW == null) {
            this.moW = new com.facebook.imagepipeline.h.b(this.moU, this.moT);
        }
    }

    public void reset() {
        dvI();
        setEnabled(false);
        this.moS.reset();
    }
}
