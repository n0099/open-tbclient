package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    @Nullable
    private b lJX;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lKA;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lKB;
    @Nullable
    private com.facebook.imagepipeline.h.b lKC;
    @Nullable
    private List<f> lKD;
    private final com.facebook.drawee.a.a.d lKw;
    private final com.facebook.common.time.b lKx;
    private final h lKy = new h();
    @Nullable
    private c lKz;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lKx = bVar;
        this.lKw = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dlN();
            if (this.lJX != null) {
                this.lKw.a(this.lJX);
            }
            if (this.lKB != null) {
                this.lKw.a(this.lKB);
            }
            if (this.lKC != null) {
                this.lKw.a(this.lKC);
                return;
            }
            return;
        }
        if (this.lJX != null) {
            this.lKw.b(this.lJX);
        }
        if (this.lKB != null) {
            this.lKw.b(this.lKB);
        }
        if (this.lKC != null) {
            this.lKw.b(this.lKC);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lKD == null) {
                this.lKD = new LinkedList();
            }
            this.lKD.add(fVar);
        }
    }

    public void dlL() {
        if (this.lKD != null) {
            this.lKD.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Hy(i);
        if (this.mEnabled && this.lKD != null && !this.lKD.isEmpty()) {
            if (i == 3) {
                dlM();
            }
            e dlP = hVar.dlP();
            for (f fVar : this.lKD) {
                fVar.a(dlP, i);
            }
        }
    }

    private void dlM() {
        com.facebook.drawee.d.b hierarchy = this.lKw.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lKy.HA(bounds.width());
            this.lKy.HB(bounds.height());
        }
    }

    private void dlN() {
        if (this.lKB == null) {
            this.lKB = new com.facebook.drawee.a.a.a.a.a(this.lKx, this.lKy, this);
        }
        if (this.lKA == null) {
            this.lKA = new com.facebook.drawee.a.a.a.a.c(this.lKx, this.lKy);
        }
        if (this.lJX == null) {
            this.lJX = new com.facebook.drawee.a.a.a.a.b(this.lKy, this);
        }
        if (this.lKz == null) {
            this.lKz = new c(this.lKw.getId(), this.lJX);
        } else {
            this.lKz.init(this.lKw.getId());
        }
        if (this.lKC == null) {
            this.lKC = new com.facebook.imagepipeline.h.b(this.lKA, this.lKz);
        }
    }

    public void reset() {
        dlL();
        setEnabled(false);
        this.lKy.reset();
    }
}
