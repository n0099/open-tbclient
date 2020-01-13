package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private final com.facebook.drawee.a.a.d lJK;
    private final com.facebook.common.time.b lJL;
    private final h lJM = new h();
    @Nullable
    private c lJN;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lJO;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lJP;
    @Nullable
    private com.facebook.imagepipeline.h.b lJQ;
    @Nullable
    private List<f> lJR;
    @Nullable
    private b lJl;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lJL = bVar;
        this.lJK = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dky();
            if (this.lJl != null) {
                this.lJK.a(this.lJl);
            }
            if (this.lJP != null) {
                this.lJK.a(this.lJP);
            }
            if (this.lJQ != null) {
                this.lJK.a(this.lJQ);
                return;
            }
            return;
        }
        if (this.lJl != null) {
            this.lJK.b(this.lJl);
        }
        if (this.lJP != null) {
            this.lJK.b(this.lJP);
        }
        if (this.lJQ != null) {
            this.lJK.b(this.lJQ);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lJR == null) {
                this.lJR = new LinkedList();
            }
            this.lJR.add(fVar);
        }
    }

    public void dkw() {
        if (this.lJR != null) {
            this.lJR.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ht(i);
        if (this.mEnabled && this.lJR != null && !this.lJR.isEmpty()) {
            if (i == 3) {
                dkx();
            }
            e dkA = hVar.dkA();
            for (f fVar : this.lJR) {
                fVar.a(dkA, i);
            }
        }
    }

    private void dkx() {
        com.facebook.drawee.d.b hierarchy = this.lJK.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lJM.Hv(bounds.width());
            this.lJM.Hw(bounds.height());
        }
    }

    private void dky() {
        if (this.lJP == null) {
            this.lJP = new com.facebook.drawee.a.a.a.a.a(this.lJL, this.lJM, this);
        }
        if (this.lJO == null) {
            this.lJO = new com.facebook.drawee.a.a.a.a.c(this.lJL, this.lJM);
        }
        if (this.lJl == null) {
            this.lJl = new com.facebook.drawee.a.a.a.a.b(this.lJM, this);
        }
        if (this.lJN == null) {
            this.lJN = new c(this.lJK.getId(), this.lJl);
        } else {
            this.lJN.init(this.lJK.getId());
        }
        if (this.lJQ == null) {
            this.lJQ = new com.facebook.imagepipeline.h.b(this.lJO, this.lJN);
        }
    }

    public void reset() {
        dkw();
        setEnabled(false);
        this.lJM.reset();
    }
}
