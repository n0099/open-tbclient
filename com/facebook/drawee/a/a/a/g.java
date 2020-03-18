package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class g extends com.facebook.imagepipeline.h.a {
    @Nullable
    private b lLQ;
    private final com.facebook.drawee.a.a.d lMp;
    private final com.facebook.common.time.b lMq;
    private final h lMr = new h();
    @Nullable
    private c lMs;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c lMt;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a lMu;
    @Nullable
    private com.facebook.imagepipeline.h.b lMv;
    @Nullable
    private List<f> lMw;
    private boolean mEnabled;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.lMq = bVar;
        this.lMp = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            dmn();
            if (this.lLQ != null) {
                this.lMp.a(this.lLQ);
            }
            if (this.lMu != null) {
                this.lMp.a(this.lMu);
            }
            if (this.lMv != null) {
                this.lMp.a(this.lMv);
                return;
            }
            return;
        }
        if (this.lLQ != null) {
            this.lMp.b(this.lLQ);
        }
        if (this.lMu != null) {
            this.lMp.b(this.lMu);
        }
        if (this.lMv != null) {
            this.lMp.b(this.lMv);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.lMw == null) {
                this.lMw = new LinkedList();
            }
            this.lMw.add(fVar);
        }
    }

    public void dml() {
        if (this.lMw != null) {
            this.lMw.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.HE(i);
        if (this.mEnabled && this.lMw != null && !this.lMw.isEmpty()) {
            if (i == 3) {
                dmm();
            }
            e dmp = hVar.dmp();
            for (f fVar : this.lMw) {
                fVar.a(dmp, i);
            }
        }
    }

    private void dmm() {
        com.facebook.drawee.d.b hierarchy = this.lMp.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.lMr.HG(bounds.width());
            this.lMr.HH(bounds.height());
        }
    }

    private void dmn() {
        if (this.lMu == null) {
            this.lMu = new com.facebook.drawee.a.a.a.a.a(this.lMq, this.lMr, this);
        }
        if (this.lMt == null) {
            this.lMt = new com.facebook.drawee.a.a.a.a.c(this.lMq, this.lMr);
        }
        if (this.lLQ == null) {
            this.lLQ = new com.facebook.drawee.a.a.a.a.b(this.lMr, this);
        }
        if (this.lMs == null) {
            this.lMs = new c(this.lMp.getId(), this.lLQ);
        } else {
            this.lMs.init(this.lMp.getId());
        }
        if (this.lMv == null) {
            this.lMv = new com.facebook.imagepipeline.h.b(this.lMt, this.lMs);
        }
    }

    public void reset() {
        dml();
        setEnabled(false);
        this.lMr.reset();
    }
}
