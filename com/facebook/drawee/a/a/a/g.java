package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d mKS;
    private final com.facebook.common.time.b mKT;
    private final h mKU = new h();
    @Nullable
    private c mKV;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c mKW;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a mKX;
    @Nullable
    private com.facebook.imagepipeline.h.b mKY;
    @Nullable
    private List<f> mKZ;
    @Nullable
    private b mKt;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.mKT = bVar;
        this.mKS = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dAr();
            if (this.mKt != null) {
                this.mKS.a(this.mKt);
            }
            if (this.mKX != null) {
                this.mKS.a(this.mKX);
            }
            if (this.mKY != null) {
                this.mKS.a(this.mKY);
                return;
            }
            return;
        }
        if (this.mKt != null) {
            this.mKS.b(this.mKt);
        }
        if (this.mKX != null) {
            this.mKS.b(this.mKX);
        }
        if (this.mKY != null) {
            this.mKS.b(this.mKY);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.mKZ == null) {
                this.mKZ = new LinkedList();
            }
            this.mKZ.add(fVar);
        }
    }

    public void dAp() {
        if (this.mKZ != null) {
            this.mKZ.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ia(i);
        if (this.mEnabled && this.mKZ != null && !this.mKZ.isEmpty()) {
            if (i == 3) {
                dAq();
            }
            e dAt = hVar.dAt();
            for (f fVar : this.mKZ) {
                fVar.a(dAt, i);
            }
        }
    }

    private void dAq() {
        com.facebook.drawee.d.b hierarchy = this.mKS.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mKU.Ic(bounds.width());
            this.mKU.Id(bounds.height());
        }
    }

    private void dAr() {
        if (this.mKX == null) {
            this.mKX = new com.facebook.drawee.a.a.a.a.a(this.mKT, this.mKU, this);
        }
        if (this.mKW == null) {
            this.mKW = new com.facebook.drawee.a.a.a.a.c(this.mKT, this.mKU);
        }
        if (this.mKt == null) {
            this.mKt = new com.facebook.drawee.a.a.a.a.b(this.mKU, this);
        }
        if (this.mKV == null) {
            this.mKV = new c(this.mKS.getId(), this.mKt);
        } else {
            this.mKV.init(this.mKS.getId());
        }
        if (this.mKY == null) {
            this.mKY = new com.facebook.imagepipeline.h.b(this.mKW, this.mKV);
        }
    }

    public void reset() {
        dAp();
        setEnabled(false);
        this.mKU.reset();
    }
}
