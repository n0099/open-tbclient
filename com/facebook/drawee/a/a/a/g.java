package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class g extends com.facebook.imagepipeline.h.a {
    @Nullable
    private b lFN;
    private final com.facebook.drawee.a.a.d lGm;
    private final com.facebook.common.time.b lGn;
    private final h lGo = new h();
    @Nullable
    private c lGp;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lGq;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lGr;
    @Nullable
    private com.facebook.imagepipeline.h.b lGs;
    @Nullable
    private List<f> lGt;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lGn = bVar;
        this.lGm = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            djx();
            if (this.lFN != null) {
                this.lGm.a(this.lFN);
            }
            if (this.lGr != null) {
                this.lGm.a(this.lGr);
            }
            if (this.lGs != null) {
                this.lGm.a(this.lGs);
                return;
            }
            return;
        }
        if (this.lFN != null) {
            this.lGm.b(this.lFN);
        }
        if (this.lGr != null) {
            this.lGm.b(this.lGr);
        }
        if (this.lGs != null) {
            this.lGm.b(this.lGs);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lGt == null) {
                this.lGt = new LinkedList();
            }
            this.lGt.add(fVar);
        }
    }

    public void djv() {
        if (this.lGt != null) {
            this.lGt.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ho(i);
        if (this.mEnabled && this.lGt != null && !this.lGt.isEmpty()) {
            if (i == 3) {
                djw();
            }
            e djz = hVar.djz();
            for (f fVar : this.lGt) {
                fVar.a(djz, i);
            }
        }
    }

    private void djw() {
        com.facebook.drawee.d.b hierarchy = this.lGm.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lGo.Hq(bounds.width());
            this.lGo.Hr(bounds.height());
        }
    }

    private void djx() {
        if (this.lGr == null) {
            this.lGr = new com.facebook.drawee.a.a.a.a.a(this.lGn, this.lGo, this);
        }
        if (this.lGq == null) {
            this.lGq = new com.facebook.drawee.a.a.a.a.c(this.lGn, this.lGo);
        }
        if (this.lFN == null) {
            this.lFN = new com.facebook.drawee.a.a.a.a.b(this.lGo, this);
        }
        if (this.lGp == null) {
            this.lGp = new c(this.lGm.getId(), this.lFN);
        } else {
            this.lGp.init(this.lGm.getId());
        }
        if (this.lGs == null) {
            this.lGs = new com.facebook.imagepipeline.h.b(this.lGq, this.lGp);
        }
    }

    public void reset() {
        djv();
        setEnabled(false);
        this.lGo.reset();
    }
}
