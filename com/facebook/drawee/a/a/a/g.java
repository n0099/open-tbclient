package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class g extends com.facebook.imagepipeline.h.a {
    private boolean mEnabled;
    @Nullable
    private b oMP;
    private final com.facebook.drawee.a.a.d oNo;
    private final com.facebook.common.time.b oNp;
    private final h oNq = new h();
    @Nullable
    private c oNr;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c oNs;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a oNt;
    @Nullable
    private com.facebook.imagepipeline.h.b oNu;
    @Nullable
    private List<f> oNv;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.oNp = bVar;
        this.oNo = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            elj();
            if (this.oMP != null) {
                this.oNo.a(this.oMP);
            }
            if (this.oNt != null) {
                this.oNo.a(this.oNt);
            }
            if (this.oNu != null) {
                this.oNo.a(this.oNu);
                return;
            }
            return;
        }
        if (this.oMP != null) {
            this.oNo.b(this.oMP);
        }
        if (this.oNt != null) {
            this.oNo.b(this.oNt);
        }
        if (this.oNu != null) {
            this.oNo.b(this.oNu);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.oNv == null) {
                this.oNv = new LinkedList();
            }
            this.oNv.add(fVar);
        }
    }

    public void elh() {
        if (this.oNv != null) {
            this.oNv.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ow(i);
        if (this.mEnabled && this.oNv != null && !this.oNv.isEmpty()) {
            if (i == 3) {
                eli();
            }
            e ell = hVar.ell();
            for (f fVar : this.oNv) {
                fVar.a(ell, i);
            }
        }
    }

    private void eli() {
        com.facebook.drawee.d.b hierarchy = this.oNo.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.oNq.Oy(bounds.width());
            this.oNq.Oz(bounds.height());
        }
    }

    private void elj() {
        if (this.oNt == null) {
            this.oNt = new com.facebook.drawee.a.a.a.a.a(this.oNp, this.oNq, this);
        }
        if (this.oNs == null) {
            this.oNs = new com.facebook.drawee.a.a.a.a.c(this.oNp, this.oNq);
        }
        if (this.oMP == null) {
            this.oMP = new com.facebook.drawee.a.a.a.a.b(this.oNq, this);
        }
        if (this.oNr == null) {
            this.oNr = new c(this.oNo.getId(), this.oMP);
        } else {
            this.oNr.init(this.oNo.getId());
        }
        if (this.oNu == null) {
            this.oNu = new com.facebook.imagepipeline.h.b(this.oNs, this.oNr);
        }
    }

    public void reset() {
        elh();
        setEnabled(false);
        this.oNq.reset();
    }
}
