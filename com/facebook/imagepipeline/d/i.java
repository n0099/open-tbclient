package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jGy;
    private final boolean jHJ;
    private final boolean jHK;
    private final com.facebook.common.internal.i<Boolean> jHL;
    private final q jHM;
    private final b.a jHN;
    private final boolean jHO;
    private final com.facebook.common.g.b jHP;
    private final boolean jHQ;
    private final boolean jHR;

    private i(a aVar, h.a aVar2) {
        this.jGy = aVar.jGy;
        this.jHJ = aVar.jHJ;
        this.jHK = aVar.jHK;
        if (aVar.jHL == null) {
            this.jHL = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cxG */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jHL = aVar.jHL;
        }
        this.jHM = aVar.jHM;
        this.jHN = aVar.jHN;
        this.jHO = aVar.jHO;
        this.jHP = aVar.jHP;
        this.jHQ = aVar.jHQ;
        this.jHR = aVar.jHR;
    }

    public boolean cxJ() {
        return this.jHK;
    }

    public int cxK() {
        return this.jGy;
    }

    public boolean cxL() {
        return this.jHL.get().booleanValue();
    }

    @Nullable
    public q cxM() {
        return this.jHM;
    }

    public boolean cxN() {
        return this.jHR;
    }

    public boolean cxO() {
        return this.jHJ;
    }

    public boolean cxP() {
        return this.jHO;
    }

    public b.a cxQ() {
        return this.jHN;
    }

    public com.facebook.common.g.b cxR() {
        return this.jHP;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jHM;
        private b.a jHN;
        private com.facebook.common.g.b jHP;
        private final h.a jHT;
        private int jGy = 0;
        private boolean jHJ = false;
        private boolean jHK = false;
        private com.facebook.common.internal.i<Boolean> jHL = null;
        private boolean jHO = false;
        private boolean jHQ = false;
        private boolean jHR = false;

        public a(h.a aVar) {
            this.jHT = aVar;
        }

        public i cxS() {
            return new i(this, this.jHT);
        }
    }
}
