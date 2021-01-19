package com.facebook.drawee.a.a.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class g extends com.facebook.imagepipeline.g.a {
    private boolean mEnabled;
    private final com.facebook.drawee.a.a.d pqN;
    private final com.facebook.common.time.b pqO;
    private final h pqP = new h();
    @Nullable
    private c pqQ;
    @Nullable
    private com.facebook.drawee.a.a.a.a.c pqR;
    @Nullable
    private com.facebook.drawee.a.a.a.a.a pqS;
    @Nullable
    private com.facebook.imagepipeline.g.b pqT;
    @Nullable
    private List<f> pqU;
    @Nullable
    private b pqo;

    public g(com.facebook.common.time.b bVar, com.facebook.drawee.a.a.d dVar) {
        this.pqO = bVar;
        this.pqN = dVar;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
        if (z) {
            erm();
            if (this.pqo != null) {
                this.pqN.a(this.pqo);
            }
            if (this.pqS != null) {
                this.pqN.a(this.pqS);
            }
            if (this.pqT != null) {
                this.pqN.a(this.pqT);
                return;
            }
            return;
        }
        if (this.pqo != null) {
            this.pqN.b(this.pqo);
        }
        if (this.pqS != null) {
            this.pqN.b(this.pqS);
        }
        if (this.pqT != null) {
            this.pqN.b(this.pqT);
        }
    }

    public void b(@Nullable f fVar) {
        if (fVar != null) {
            if (this.pqU == null) {
                this.pqU = new LinkedList();
            }
            this.pqU.add(fVar);
        }
    }

    public void erk() {
        if (this.pqU != null) {
            this.pqU.clear();
        }
    }

    public void a(h hVar, int i) {
        hVar.OE(i);
        if (this.mEnabled && this.pqU != null && !this.pqU.isEmpty()) {
            if (i == 3) {
                erl();
            }
            e ero = hVar.ero();
            for (f fVar : this.pqU) {
                fVar.a(ero, i);
            }
        }
    }

    private void erl() {
        com.facebook.drawee.d.b hierarchy = this.pqN.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.pqP.OG(bounds.width());
            this.pqP.OH(bounds.height());
        }
    }

    private void erm() {
        if (this.pqS == null) {
            this.pqS = new com.facebook.drawee.a.a.a.a.a(this.pqO, this.pqP, this);
        }
        if (this.pqR == null) {
            this.pqR = new com.facebook.drawee.a.a.a.a.c(this.pqO, this.pqP);
        }
        if (this.pqo == null) {
            this.pqo = new com.facebook.drawee.a.a.a.a.b(this.pqP, this);
        }
        if (this.pqQ == null) {
            this.pqQ = new c(this.pqN.getId(), this.pqo);
        } else {
            this.pqQ.init(this.pqN.getId());
        }
        if (this.pqT == null) {
            this.pqT = new com.facebook.imagepipeline.g.b(this.pqR, this.pqQ);
        }
    }

    public void reset() {
        erk();
        setEnabled(false);
        this.pqP.reset();
    }
}
