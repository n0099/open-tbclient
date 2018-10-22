package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int idr;
    private final boolean ieE;
    private final boolean ieF;
    private final com.facebook.common.internal.i<Boolean> ieG;
    private final q ieH;
    private final b.a ieI;
    private final boolean ieJ;
    private final com.facebook.common.g.b ieK;
    private final boolean ieL;
    private final boolean ieM;

    private i(a aVar, h.a aVar2) {
        this.idr = aVar.idr;
        this.ieE = aVar.ieE;
        this.ieF = aVar.ieF;
        if (aVar.ieG == null) {
            this.ieG = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bVt */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.ieG = aVar.ieG;
        }
        this.ieH = aVar.ieH;
        this.ieI = aVar.ieI;
        this.ieJ = aVar.ieJ;
        this.ieK = aVar.ieK;
        this.ieL = aVar.ieL;
        this.ieM = aVar.ieM;
    }

    public boolean bVw() {
        return this.ieF;
    }

    public int bVx() {
        return this.idr;
    }

    public boolean bVy() {
        return this.ieG.get().booleanValue();
    }

    @Nullable
    public q bVz() {
        return this.ieH;
    }

    public boolean bVA() {
        return this.ieM;
    }

    public boolean bVB() {
        return this.ieE;
    }

    public boolean bVC() {
        return this.ieJ;
    }

    public b.a bVD() {
        return this.ieI;
    }

    public com.facebook.common.g.b bVE() {
        return this.ieK;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q ieH;
        private b.a ieI;
        private com.facebook.common.g.b ieK;
        private final h.a ieO;
        private int idr = 0;
        private boolean ieE = false;
        private boolean ieF = false;
        private com.facebook.common.internal.i<Boolean> ieG = null;
        private boolean ieJ = false;
        private boolean ieL = false;
        private boolean ieM = false;

        public a(h.a aVar) {
            this.ieO = aVar;
        }

        public i bVF() {
            return new i(this, this.ieO);
        }
    }
}
