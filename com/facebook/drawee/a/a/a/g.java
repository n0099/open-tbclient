package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    @Nullable
    private b puP;
    private final com.facebook.drawee.a.a.d pvo;
    private final com.facebook.common.time.b pvp;
    private final h pvq = new h();
    @Nullable
    private c pvr;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pvs;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pvt;
    @Nullable
    private com.facebook.imagepipeline.g.b pvu;
    @Nullable
    private List<f> pvv;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pvp = bVar;
        this.pvo = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            evg();
            if (this.puP != null) {
                this.pvo.a(this.puP);
            }
            if (this.pvt != null) {
                this.pvo.a(this.pvt);
            }
            if (this.pvu != null) {
                this.pvo.a(this.pvu);
                return;
            }
            return;
        }
        if (this.puP != null) {
            this.pvo.b(this.puP);
        }
        if (this.pvt != null) {
            this.pvo.b(this.pvt);
        }
        if (this.pvu != null) {
            this.pvo.b(this.pvu);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pvv == null) {
                this.pvv = new LinkedList();
            }
            this.pvv.add(fVar);
        }
    }

    public void eve() {
        if (this.pvv != null) {
            this.pvv.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Ql(i);
        if (this.mEnabled && this.pvv != null && !this.pvv.isEmpty()) {
            if (i == 3) {
                evf();
            }
            e evi = hVar.evi();
            for (f fVar : this.pvv) {
                fVar.a(evi, i);
            }
        }
    }

    private void evf() {
        com.facebook.drawee.d.b hierarchy = this.pvo.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pvq.Qn(bounds.width());
            this.pvq.Qo(bounds.height());
        }
    }

    private void evg() {
        if (this.pvt == null) {
            this.pvt = new com.facebook.drawee.a.a.a.a.a(this.pvp, this.pvq, this);
        }
        if (this.pvs == null) {
            this.pvs = new com.facebook.drawee.a.a.a.a.c(this.pvp, this.pvq);
        }
        if (this.puP == null) {
            this.puP = new com.facebook.drawee.a.a.a.a.b(this.pvq, this);
        }
        if (this.pvr == null) {
            this.pvr = new c(this.pvo.getId(), this.puP);
        } else {
            this.pvr.init(this.pvo.getId());
        }
        if (this.pvu == null) {
            this.pvu = new com.facebook.imagepipeline.g.b(this.pvs, this.pvr);
        }
    }

    public void reset() {
        eve();
        setEnabled(false);
        this.pvq.reset();
    }
}
