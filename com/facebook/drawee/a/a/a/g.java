package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    @Nullable
    private b nmK;
    private final com.facebook.drawee.a.a.d nnj;
    private final com.facebook.common.time.b nnk;
    private final h nnl = new h();
    @Nullable
    private c nnm;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c nnn;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a nno;
    @Nullable
    private com.facebook.imagepipeline.h.b nnp;
    @Nullable
    private List<f> nnq;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.nnk = bVar;
        this.nnj = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dPN();
            if (this.nmK != null) {
                this.nnj.a(this.nmK);
            }
            if (this.nno != null) {
                this.nnj.a(this.nno);
            }
            if (this.nnp != null) {
                this.nnj.a(this.nnp);
                return;
            }
            return;
        }
        if (this.nmK != null) {
            this.nnj.b(this.nmK);
        }
        if (this.nno != null) {
            this.nnj.b(this.nno);
        }
        if (this.nnp != null) {
            this.nnj.b(this.nnp);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.nnq == null) {
                this.nnq = new LinkedList();
            }
            this.nnq.add(fVar);
        }
    }

    public void dPL() {
        if (this.nnq != null) {
            this.nnq.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.KZ(i);
        if (this.mEnabled && this.nnq != null && !this.nnq.isEmpty()) {
            if (i == 3) {
                dPM();
            }
            e dPP = hVar.dPP();
            for (f fVar : this.nnq) {
                fVar.a(dPP, i);
            }
        }
    }

    private void dPM() {
        com.facebook.drawee.d.b hierarchy = this.nnj.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.nnl.Lb(bounds.width());
            this.nnl.Lc(bounds.height());
        }
    }

    private void dPN() {
        if (this.nno == null) {
            this.nno = new com.facebook.drawee.a.a.a.a.a(this.nnk, this.nnl, this);
        }
        if (this.nnn == null) {
            this.nnn = new com.facebook.drawee.a.a.a.a.c(this.nnk, this.nnl);
        }
        if (this.nmK == null) {
            this.nmK = new com.facebook.drawee.a.a.a.a.b(this.nnl, this);
        }
        if (this.nnm == null) {
            this.nnm = new c(this.nnj.getId(), this.nmK);
        } else {
            this.nnm.init(this.nnj.getId());
        }
        if (this.nnp == null) {
            this.nnp = new com.facebook.imagepipeline.h.b(this.nnn, this.nnm);
        }
    }

    public void reset() {
        dPL();
        setEnabled(false);
        this.nnl.reset();
    }
}
