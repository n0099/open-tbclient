package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    @Nullable
    private b pdC;
    private final com.facebook.drawee.a.a.d peb;
    private final com.facebook.common.time.b pec;
    private final h ped = new h();
    @Nullable
    private c pee;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pef;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a peg;
    @Nullable
    private com.facebook.imagepipeline.g.b peh;
    @Nullable
    private List<f> pei;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pec = bVar;
        this.peb = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            eqX();
            if (this.pdC != null) {
                this.peb.a(this.pdC);
            }
            if (this.peg != null) {
                this.peb.a(this.peg);
            }
            if (this.peh != null) {
                this.peb.a(this.peh);
                return;
            }
            return;
        }
        if (this.pdC != null) {
            this.peb.b(this.pdC);
        }
        if (this.peg != null) {
            this.peb.b(this.peg);
        }
        if (this.peh != null) {
            this.peb.b(this.peh);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pei == null) {
                this.pei = new LinkedList();
            }
            this.pei.add(fVar);
        }
    }

    public void eqV() {
        if (this.pei != null) {
            this.pei.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.PX(i);
        if (this.mEnabled && this.pei != null && !this.pei.isEmpty()) {
            if (i == 3) {
                eqW();
            }
            e eqZ = hVar.eqZ();
            for (f fVar : this.pei) {
                fVar.a(eqZ, i);
            }
        }
    }

    private void eqW() {
        com.facebook.drawee.d.b hierarchy = this.peb.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.ped.PZ(bounds.width());
            this.ped.Qa(bounds.height());
        }
    }

    private void eqX() {
        if (this.peg == null) {
            this.peg = new com.facebook.drawee.a.a.a.a.a(this.pec, this.ped, this);
        }
        if (this.pef == null) {
            this.pef = new com.facebook.drawee.a.a.a.a.c(this.pec, this.ped);
        }
        if (this.pdC == null) {
            this.pdC = new com.facebook.drawee.a.a.a.a.b(this.ped, this);
        }
        if (this.pee == null) {
            this.pee = new c(this.peb.getId(), this.pdC);
        } else {
            this.pee.init(this.peb.getId());
        }
        if (this.peh == null) {
            this.peh = new com.facebook.imagepipeline.g.b(this.pef, this.pee);
        }
    }

    public void reset() {
        eqV();
        setEnabled(false);
        this.ped.reset();
    }
}
