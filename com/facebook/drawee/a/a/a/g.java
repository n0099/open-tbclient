package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    @Nullable
    private b puI;
    private final com.facebook.drawee.a.a.d pvh;
    private final com.facebook.common.time.b pvi;
    private final h pvj = new h();
    @Nullable
    private c pvk;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pvl;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pvm;
    @Nullable
    private com.facebook.imagepipeline.g.b pvn;
    @Nullable
    private List<f> pvo;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pvi = bVar;
        this.pvh = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            euZ();
            if (this.puI != null) {
                this.pvh.a(this.puI);
            }
            if (this.pvm != null) {
                this.pvh.a(this.pvm);
            }
            if (this.pvn != null) {
                this.pvh.a(this.pvn);
                return;
            }
            return;
        }
        if (this.puI != null) {
            this.pvh.b(this.puI);
        }
        if (this.pvm != null) {
            this.pvh.b(this.pvm);
        }
        if (this.pvn != null) {
            this.pvh.b(this.pvn);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pvo == null) {
                this.pvo = new LinkedList();
            }
            this.pvo.add(fVar);
        }
    }

    public void euX() {
        if (this.pvo != null) {
            this.pvo.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.Qg(i);
        if (this.mEnabled && this.pvo != null && !this.pvo.isEmpty()) {
            if (i == 3) {
                euY();
            }
            e evb = hVar.evb();
            for (f fVar : this.pvo) {
                fVar.a(evb, i);
            }
        }
    }

    private void euY() {
        com.facebook.drawee.d.b hierarchy = this.pvh.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pvj.Qi(bounds.width());
            this.pvj.Qj(bounds.height());
        }
    }

    private void euZ() {
        if (this.pvm == null) {
            this.pvm = new com.facebook.drawee.a.a.a.a.a(this.pvi, this.pvj, this);
        }
        if (this.pvl == null) {
            this.pvl = new com.facebook.drawee.a.a.a.a.c(this.pvi, this.pvj);
        }
        if (this.puI == null) {
            this.puI = new com.facebook.drawee.a.a.a.a.b(this.pvj, this);
        }
        if (this.pvk == null) {
            this.pvk = new c(this.pvh.getId(), this.puI);
        } else {
            this.pvk.init(this.pvh.getId());
        }
        if (this.pvn == null) {
            this.pvn = new com.facebook.imagepipeline.g.b(this.pvl, this.pvk);
        }
    }

    public void reset() {
        euX();
        setEnabled(false);
        this.pvj.reset();
    }
}
