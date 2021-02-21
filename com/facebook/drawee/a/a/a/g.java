package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    @Nullable
    private b pAX;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pBA;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pBB;
    @Nullable
    private com.facebook.imagepipeline.g.b pBC;
    @Nullable
    private List<f> pBD;
    private final com.facebook.drawee.a.a.d pBw;
    private final com.facebook.common.time.b pBx;
    private final h pBy = new h();
    @Nullable
    private c pBz;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pBx = bVar;
        this.pBw = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            etN();
            if (this.pAX != null) {
                this.pBw.a(this.pAX);
            }
            if (this.pBB != null) {
                this.pBw.a(this.pBB);
            }
            if (this.pBC != null) {
                this.pBw.a(this.pBC);
                return;
            }
            return;
        }
        if (this.pAX != null) {
            this.pBw.b(this.pAX);
        }
        if (this.pBB != null) {
            this.pBw.b(this.pBB);
        }
        if (this.pBC != null) {
            this.pBw.b(this.pBC);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pBD == null) {
                this.pBD = new LinkedList();
            }
            this.pBD.add(fVar);
        }
    }

    public void etL() {
        if (this.pBD != null) {
            this.pBD.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Pa(i);
        if (this.mEnabled && this.pBD != null && !this.pBD.isEmpty()) {
            if (i == 3) {
                etM();
            }
            e etP = hVar.etP();
            for (f fVar : this.pBD) {
                fVar.a(etP, i);
            }
        }
    }

    private void etM() {
        com.facebook.drawee.d.b hierarchy = this.pBw.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pBy.Pc(bounds.width());
            this.pBy.Pd(bounds.height());
        }
    }

    private void etN() {
        if (this.pBB == null) {
            this.pBB = new com.facebook.drawee.a.a.a.a.a(this.pBx, this.pBy, this);
        }
        if (this.pBA == null) {
            this.pBA = new com.facebook.drawee.a.a.a.a.c(this.pBx, this.pBy);
        }
        if (this.pAX == null) {
            this.pAX = new com.facebook.drawee.a.a.a.a.b(this.pBy, this);
        }
        if (this.pBz == null) {
            this.pBz = new c(this.pBw.getId(), this.pAX);
        } else {
            this.pBz.init(this.pBw.getId());
        }
        if (this.pBC == null) {
            this.pBC = new com.facebook.imagepipeline.g.b(this.pBA, this.pBz);
        }
    }

    public void reset() {
        etL();
        setEnabled(false);
        this.pBy.reset();
    }
}
