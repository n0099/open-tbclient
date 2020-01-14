package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private final com.facebook.drawee.a.a.d lJP;
    private final com.facebook.common.time.b lJQ;
    private final h lJR = new h();
    @Nullable
    private c lJS;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lJT;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lJU;
    @Nullable
    private com.facebook.imagepipeline.h.b lJV;
    @Nullable
    private List<f> lJW;
    @Nullable
    private b lJq;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lJQ = bVar;
        this.lJP = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dkA();
            if (this.lJq != null) {
                this.lJP.a(this.lJq);
            }
            if (this.lJU != null) {
                this.lJP.a(this.lJU);
            }
            if (this.lJV != null) {
                this.lJP.a(this.lJV);
                return;
            }
            return;
        }
        if (this.lJq != null) {
            this.lJP.b(this.lJq);
        }
        if (this.lJU != null) {
            this.lJP.b(this.lJU);
        }
        if (this.lJV != null) {
            this.lJP.b(this.lJV);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lJW == null) {
                this.lJW = new LinkedList();
            }
            this.lJW.add(fVar);
        }
    }

    public void dky() {
        if (this.lJW != null) {
            this.lJW.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ht(i);
        if (this.mEnabled && this.lJW != null && !this.lJW.isEmpty()) {
            if (i == 3) {
                dkz();
            }
            e dkC = hVar.dkC();
            for (f fVar : this.lJW) {
                fVar.a(dkC, i);
            }
        }
    }

    private void dkz() {
        com.facebook.drawee.d.b hierarchy = this.lJP.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lJR.Hv(bounds.width());
            this.lJR.Hw(bounds.height());
        }
    }

    private void dkA() {
        if (this.lJU == null) {
            this.lJU = new com.facebook.drawee.a.a.a.a.a(this.lJQ, this.lJR, this);
        }
        if (this.lJT == null) {
            this.lJT = new com.facebook.drawee.a.a.a.a.c(this.lJQ, this.lJR);
        }
        if (this.lJq == null) {
            this.lJq = new com.facebook.drawee.a.a.a.a.b(this.lJR, this);
        }
        if (this.lJS == null) {
            this.lJS = new c(this.lJP.getId(), this.lJq);
        } else {
            this.lJS.init(this.lJP.getId());
        }
        if (this.lJV == null) {
            this.lJV = new com.facebook.imagepipeline.h.b(this.lJT, this.lJS);
        }
    }

    public void reset() {
        dky();
        setEnabled(false);
        this.lJR.reset();
    }
}
