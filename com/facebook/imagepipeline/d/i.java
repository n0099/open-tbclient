package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int ipz;
    private final boolean iqK;
    private final boolean iqL;
    private final com.facebook.common.internal.i<Boolean> iqM;
    private final q iqN;
    private final b.a iqO;
    private final boolean iqP;
    private final com.facebook.common.g.b iqQ;
    private final boolean iqR;
    private final boolean iqS;

    private i(a aVar, h.a aVar2) {
        this.ipz = aVar.ipz;
        this.iqK = aVar.iqK;
        this.iqL = aVar.iqL;
        if (aVar.iqM == null) {
            this.iqM = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bXK */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.iqM = aVar.iqM;
        }
        this.iqN = aVar.iqN;
        this.iqO = aVar.iqO;
        this.iqP = aVar.iqP;
        this.iqQ = aVar.iqQ;
        this.iqR = aVar.iqR;
        this.iqS = aVar.iqS;
    }

    public boolean bXN() {
        return this.iqL;
    }

    public int bXO() {
        return this.ipz;
    }

    public boolean bXP() {
        return this.iqM.get().booleanValue();
    }

    @Nullable
    public q bXQ() {
        return this.iqN;
    }

    public boolean bXR() {
        return this.iqS;
    }

    public boolean bXS() {
        return this.iqK;
    }

    public boolean bXT() {
        return this.iqP;
    }

    public b.a bXU() {
        return this.iqO;
    }

    public com.facebook.common.g.b bXV() {
        return this.iqQ;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q iqN;
        private b.a iqO;
        private com.facebook.common.g.b iqQ;
        private final h.a iqU;
        private int ipz = 0;
        private boolean iqK = false;
        private boolean iqL = false;
        private com.facebook.common.internal.i<Boolean> iqM = null;
        private boolean iqP = false;
        private boolean iqR = false;
        private boolean iqS = false;

        public a(h.a aVar) {
            this.iqU = aVar;
        }

        public i bXW() {
            return new i(this, this.iqU);
        }
    }
}
