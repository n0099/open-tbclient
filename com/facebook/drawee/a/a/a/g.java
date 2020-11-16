package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d oOS;
    private final com.facebook.common.time.b oOT;
    private final h oOU = new h();
    @Nullable
    private c oOV;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c oOW;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a oOX;
    @Nullable
    private com.facebook.imagepipeline.h.b oOY;
    @Nullable
    private List<f> oOZ;
    @Nullable
    private b oOt;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.oOT = bVar;
        this.oOS = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            elh();
            if (this.oOt != null) {
                this.oOS.a(this.oOt);
            }
            if (this.oOX != null) {
                this.oOS.a(this.oOX);
            }
            if (this.oOY != null) {
                this.oOS.a(this.oOY);
                return;
            }
            return;
        }
        if (this.oOt != null) {
            this.oOS.b(this.oOt);
        }
        if (this.oOX != null) {
            this.oOS.b(this.oOX);
        }
        if (this.oOY != null) {
            this.oOS.b(this.oOY);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.oOZ == null) {
                this.oOZ = new LinkedList();
            }
            this.oOZ.add(fVar);
        }
    }

    public void elf() {
        if (this.oOZ != null) {
            this.oOZ.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.OZ(i);
        if (this.mEnabled && this.oOZ != null && !this.oOZ.isEmpty()) {
            if (i == 3) {
                elg();
            }
            e elj = hVar.elj();
            for (f fVar : this.oOZ) {
                fVar.a(elj, i);
            }
        }
    }

    private void elg() {
        com.facebook.drawee.d.b hierarchy = this.oOS.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.oOU.Pb(bounds.width());
            this.oOU.Pc(bounds.height());
        }
    }

    private void elh() {
        if (this.oOX == null) {
            this.oOX = new com.facebook.drawee.a.a.a.a.a(this.oOT, this.oOU, this);
        }
        if (this.oOW == null) {
            this.oOW = new com.facebook.drawee.a.a.a.a.c(this.oOT, this.oOU);
        }
        if (this.oOt == null) {
            this.oOt = new com.facebook.drawee.a.a.a.a.b(this.oOU, this);
        }
        if (this.oOV == null) {
            this.oOV = new c(this.oOS.getId(), this.oOt);
        } else {
            this.oOV.init(this.oOS.getId());
        }
        if (this.oOY == null) {
            this.oOY = new com.facebook.imagepipeline.h.b(this.oOW, this.oOV);
        }
    }

    public void reset() {
        elf();
        setEnabled(false);
        this.oOU.reset();
    }
}
