package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    @Nullable
    private b pdA;
    private final com.facebook.drawee.a.a.d pdZ;
    private final com.facebook.common.time.b pea;
    private final h peb = new h();
    @Nullable
    private c pec;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c ped;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pee;
    @Nullable
    private com.facebook.imagepipeline.g.b pef;
    @Nullable
    private List<f> peg;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pea = bVar;
        this.pdZ = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            eqW();
            if (this.pdA != null) {
                this.pdZ.a(this.pdA);
            }
            if (this.pee != null) {
                this.pdZ.a(this.pee);
            }
            if (this.pef != null) {
                this.pdZ.a(this.pef);
                return;
            }
            return;
        }
        if (this.pdA != null) {
            this.pdZ.b(this.pdA);
        }
        if (this.pee != null) {
            this.pdZ.b(this.pee);
        }
        if (this.pef != null) {
            this.pdZ.b(this.pef);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.peg == null) {
                this.peg = new LinkedList();
            }
            this.peg.add(fVar);
        }
    }

    public void eqU() {
        if (this.peg != null) {
            this.peg.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.PX(i);
        if (this.mEnabled && this.peg != null && !this.peg.isEmpty()) {
            if (i == 3) {
                eqV();
            }
            e eqY = hVar.eqY();
            for (f fVar : this.peg) {
                fVar.a(eqY, i);
            }
        }
    }

    private void eqV() {
        com.facebook.drawee.d.b hierarchy = this.pdZ.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.peb.PZ(bounds.width());
            this.peb.Qa(bounds.height());
        }
    }

    private void eqW() {
        if (this.pee == null) {
            this.pee = new com.facebook.drawee.a.a.a.a.a(this.pea, this.peb, this);
        }
        if (this.ped == null) {
            this.ped = new com.facebook.drawee.a.a.a.a.c(this.pea, this.peb);
        }
        if (this.pdA == null) {
            this.pdA = new com.facebook.drawee.a.a.a.a.b(this.peb, this);
        }
        if (this.pec == null) {
            this.pec = new c(this.pdZ.getId(), this.pdA);
        } else {
            this.pec.init(this.pdZ.getId());
        }
        if (this.pef == null) {
            this.pef = new com.facebook.imagepipeline.g.b(this.ped, this.pec);
        }
    }

    public void reset() {
        eqU();
        setEnabled(false);
        this.peb.reset();
    }
}
