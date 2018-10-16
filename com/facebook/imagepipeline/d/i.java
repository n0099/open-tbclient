package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int idq;
    private final boolean ieD;
    private final boolean ieE;
    private final com.facebook.common.internal.i<Boolean> ieF;
    private final q ieG;
    private final b.a ieH;
    private final boolean ieI;
    private final com.facebook.common.g.b ieJ;
    private final boolean ieK;
    private final boolean ieL;

    private i(a aVar, h.a aVar2) {
        this.idq = aVar.idq;
        this.ieD = aVar.ieD;
        this.ieE = aVar.ieE;
        if (aVar.ieF == null) {
            this.ieF = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bVt */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.ieF = aVar.ieF;
        }
        this.ieG = aVar.ieG;
        this.ieH = aVar.ieH;
        this.ieI = aVar.ieI;
        this.ieJ = aVar.ieJ;
        this.ieK = aVar.ieK;
        this.ieL = aVar.ieL;
    }

    public boolean bVw() {
        return this.ieE;
    }

    public int bVx() {
        return this.idq;
    }

    public boolean bVy() {
        return this.ieF.get().booleanValue();
    }

    @Nullable
    public q bVz() {
        return this.ieG;
    }

    public boolean bVA() {
        return this.ieL;
    }

    public boolean bVB() {
        return this.ieD;
    }

    public boolean bVC() {
        return this.ieI;
    }

    public b.a bVD() {
        return this.ieH;
    }

    public com.facebook.common.g.b bVE() {
        return this.ieJ;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q ieG;
        private b.a ieH;
        private com.facebook.common.g.b ieJ;
        private final h.a ieN;
        private int idq = 0;
        private boolean ieD = false;
        private boolean ieE = false;
        private com.facebook.common.internal.i<Boolean> ieF = null;
        private boolean ieI = false;
        private boolean ieK = false;
        private boolean ieL = false;

        public a(h.a aVar) {
            this.ieN = aVar;
        }

        public i bVF() {
            return new i(this, this.ieN);
        }
    }
}
