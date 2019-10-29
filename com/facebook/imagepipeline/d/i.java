package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int khF;
    private final boolean kiR;
    private final boolean kiS;
    private final com.facebook.common.internal.i<Boolean> kiT;
    private final q kiU;
    private final b.a kiV;
    private final boolean kiW;
    private final com.facebook.common.g.b kiX;
    private final boolean kiY;
    private final boolean kiZ;

    private i(a aVar, h.a aVar2) {
        this.khF = aVar.khF;
        this.kiR = aVar.kiR;
        this.kiS = aVar.kiS;
        if (aVar.kiT == null) {
            this.kiT = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cGF */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.kiT = aVar.kiT;
        }
        this.kiU = aVar.kiU;
        this.kiV = aVar.kiV;
        this.kiW = aVar.kiW;
        this.kiX = aVar.kiX;
        this.kiY = aVar.kiY;
        this.kiZ = aVar.kiZ;
    }

    public boolean cGI() {
        return this.kiS;
    }

    public int cGJ() {
        return this.khF;
    }

    public boolean cGK() {
        return this.kiT.get().booleanValue();
    }

    @Nullable
    public q cGL() {
        return this.kiU;
    }

    public boolean cGM() {
        return this.kiZ;
    }

    public boolean cGN() {
        return this.kiR;
    }

    public boolean cGO() {
        return this.kiW;
    }

    public b.a cGP() {
        return this.kiV;
    }

    public com.facebook.common.g.b cGQ() {
        return this.kiX;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q kiU;
        private b.a kiV;
        private com.facebook.common.g.b kiX;
        private final h.a kjb;
        private int khF = 0;
        private boolean kiR = false;
        private boolean kiS = false;
        private com.facebook.common.internal.i<Boolean> kiT = null;
        private boolean kiW = false;
        private boolean kiY = false;
        private boolean kiZ = false;

        public a(h.a aVar) {
            this.kjb = aVar;
        }

        public i cGR() {
            return new i(this, this.kjb);
        }
    }
}
