package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int imo;
    private final boolean inA;
    private final boolean inB;
    private final com.facebook.common.internal.i<Boolean> inC;
    private final q inD;
    private final b.a inE;
    private final boolean inF;
    private final com.facebook.common.g.b inG;
    private final boolean inH;
    private final boolean inI;

    private i(a aVar, h.a aVar2) {
        this.imo = aVar.imo;
        this.inA = aVar.inA;
        this.inB = aVar.inB;
        if (aVar.inC == null) {
            this.inC = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bWT */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.inC = aVar.inC;
        }
        this.inD = aVar.inD;
        this.inE = aVar.inE;
        this.inF = aVar.inF;
        this.inG = aVar.inG;
        this.inH = aVar.inH;
        this.inI = aVar.inI;
    }

    public boolean bWW() {
        return this.inB;
    }

    public int bWX() {
        return this.imo;
    }

    public boolean bWY() {
        return this.inC.get().booleanValue();
    }

    @Nullable
    public q bWZ() {
        return this.inD;
    }

    public boolean bXa() {
        return this.inI;
    }

    public boolean bXb() {
        return this.inA;
    }

    public boolean bXc() {
        return this.inF;
    }

    public b.a bXd() {
        return this.inE;
    }

    public com.facebook.common.g.b bXe() {
        return this.inG;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q inD;
        private b.a inE;
        private com.facebook.common.g.b inG;
        private final h.a inK;
        private int imo = 0;
        private boolean inA = false;
        private boolean inB = false;
        private com.facebook.common.internal.i<Boolean> inC = null;
        private boolean inF = false;
        private boolean inH = false;
        private boolean inI = false;

        public a(h.a aVar) {
            this.inK = aVar;
        }

        public i bXf() {
            return new i(this, this.inK);
        }
    }
}
