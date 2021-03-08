package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d pDB;
    private final com.facebook.common.time.b pDC;
    private final h pDD = new h();
    @Nullable
    private c pDE;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pDF;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pDG;
    @Nullable
    private com.facebook.imagepipeline.g.b pDH;
    @Nullable
    private List<f> pDI;
    @Nullable
    private b pDc;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pDC = bVar;
        this.pDB = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            etW();
            if (this.pDc != null) {
                this.pDB.a(this.pDc);
            }
            if (this.pDG != null) {
                this.pDB.a(this.pDG);
            }
            if (this.pDH != null) {
                this.pDB.a(this.pDH);
                return;
            }
            return;
        }
        if (this.pDc != null) {
            this.pDB.b(this.pDc);
        }
        if (this.pDG != null) {
            this.pDB.b(this.pDG);
        }
        if (this.pDH != null) {
            this.pDB.b(this.pDH);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pDI == null) {
                this.pDI = new LinkedList();
            }
            this.pDI.add(fVar);
        }
    }

    public void etU() {
        if (this.pDI != null) {
            this.pDI.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Pe(i);
        if (this.mEnabled && this.pDI != null && !this.pDI.isEmpty()) {
            if (i == 3) {
                etV();
            }
            e etY = hVar.etY();
            for (f fVar : this.pDI) {
                fVar.a(etY, i);
            }
        }
    }

    private void etV() {
        com.facebook.drawee.d.b hierarchy = this.pDB.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pDD.Pg(bounds.width());
            this.pDD.Ph(bounds.height());
        }
    }

    private void etW() {
        if (this.pDG == null) {
            this.pDG = new com.facebook.drawee.a.a.a.a.a(this.pDC, this.pDD, this);
        }
        if (this.pDF == null) {
            this.pDF = new com.facebook.drawee.a.a.a.a.c(this.pDC, this.pDD);
        }
        if (this.pDc == null) {
            this.pDc = new com.facebook.drawee.a.a.a.a.b(this.pDD, this);
        }
        if (this.pDE == null) {
            this.pDE = new c(this.pDB.getId(), this.pDc);
        } else {
            this.pDE.init(this.pDB.getId());
        }
        if (this.pDH == null) {
            this.pDH = new com.facebook.imagepipeline.g.b(this.pDF, this.pDE);
        }
    }

    public void reset() {
        etU();
        setEnabled(false);
        this.pDD.reset();
    }
}
