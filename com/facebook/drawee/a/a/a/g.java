package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d pqM;
    private final com.facebook.common.time.b pqN;
    private final h pqO = new h();
    @Nullable
    private c pqP;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pqQ;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pqR;
    @Nullable
    private com.facebook.imagepipeline.g.b pqS;
    @Nullable
    private List<f> pqT;
    @Nullable
    private b pqn;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pqN = bVar;
        this.pqM = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            erm();
            if (this.pqn != null) {
                this.pqM.a(this.pqn);
            }
            if (this.pqR != null) {
                this.pqM.a(this.pqR);
            }
            if (this.pqS != null) {
                this.pqM.a(this.pqS);
                return;
            }
            return;
        }
        if (this.pqn != null) {
            this.pqM.b(this.pqn);
        }
        if (this.pqR != null) {
            this.pqM.b(this.pqR);
        }
        if (this.pqS != null) {
            this.pqM.b(this.pqS);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pqT == null) {
                this.pqT = new LinkedList();
            }
            this.pqT.add(fVar);
        }
    }

    public void erk() {
        if (this.pqT != null) {
            this.pqT.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.OE(i);
        if (this.mEnabled && this.pqT != null && !this.pqT.isEmpty()) {
            if (i == 3) {
                erl();
            }
            e ero = hVar.ero();
            for (f fVar : this.pqT) {
                fVar.a(ero, i);
            }
        }
    }

    private void erl() {
        com.facebook.drawee.d.b hierarchy = this.pqM.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pqO.OG(bounds.width());
            this.pqO.OH(bounds.height());
        }
    }

    private void erm() {
        if (this.pqR == null) {
            this.pqR = new com.facebook.drawee.a.a.a.a.a(this.pqN, this.pqO, this);
        }
        if (this.pqQ == null) {
            this.pqQ = new com.facebook.drawee.a.a.a.a.c(this.pqN, this.pqO);
        }
        if (this.pqn == null) {
            this.pqn = new com.facebook.drawee.a.a.a.a.b(this.pqO, this);
        }
        if (this.pqP == null) {
            this.pqP = new c(this.pqM.getId(), this.pqn);
        } else {
            this.pqP.init(this.pqM.getId());
        }
        if (this.pqS == null) {
            this.pqS = new com.facebook.imagepipeline.g.b(this.pqQ, this.pqP);
        }
    }

    public void reset() {
        erk();
        setEnabled(false);
        this.pqO.reset();
    }
}
