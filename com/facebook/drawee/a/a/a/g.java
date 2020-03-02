package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    @Nullable
    private b lJZ;
    private final h lKA = new h();
    @Nullable
    private c lKB;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lKC;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lKD;
    @Nullable
    private com.facebook.imagepipeline.h.b lKE;
    @Nullable
    private List<f> lKF;
    private final com.facebook.drawee.a.a.d lKy;
    private final com.facebook.common.time.b lKz;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lKz = bVar;
        this.lKy = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dlP();
            if (this.lJZ != null) {
                this.lKy.a(this.lJZ);
            }
            if (this.lKD != null) {
                this.lKy.a(this.lKD);
            }
            if (this.lKE != null) {
                this.lKy.a(this.lKE);
                return;
            }
            return;
        }
        if (this.lJZ != null) {
            this.lKy.b(this.lJZ);
        }
        if (this.lKD != null) {
            this.lKy.b(this.lKD);
        }
        if (this.lKE != null) {
            this.lKy.b(this.lKE);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lKF == null) {
                this.lKF = new LinkedList();
            }
            this.lKF.add(fVar);
        }
    }

    public void dlN() {
        if (this.lKF != null) {
            this.lKF.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Hy(i);
        if (this.mEnabled && this.lKF != null && !this.lKF.isEmpty()) {
            if (i == 3) {
                dlO();
            }
            e dlR = hVar.dlR();
            for (f fVar : this.lKF) {
                fVar.a(dlR, i);
            }
        }
    }

    private void dlO() {
        com.facebook.drawee.d.b hierarchy = this.lKy.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lKA.HA(bounds.width());
            this.lKA.HB(bounds.height());
        }
    }

    private void dlP() {
        if (this.lKD == null) {
            this.lKD = new com.facebook.drawee.a.a.a.a.a(this.lKz, this.lKA, this);
        }
        if (this.lKC == null) {
            this.lKC = new com.facebook.drawee.a.a.a.a.c(this.lKz, this.lKA);
        }
        if (this.lJZ == null) {
            this.lJZ = new com.facebook.drawee.a.a.a.a.b(this.lKA, this);
        }
        if (this.lKB == null) {
            this.lKB = new c(this.lKy.getId(), this.lJZ);
        } else {
            this.lKB.init(this.lKy.getId());
        }
        if (this.lKE == null) {
            this.lKE = new com.facebook.imagepipeline.h.b(this.lKC, this.lKB);
        }
    }

    public void reset() {
        dlN();
        setEnabled(false);
        this.lKA.reset();
    }
}
