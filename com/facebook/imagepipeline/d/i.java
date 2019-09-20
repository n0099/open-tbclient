package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int kju;
    private final boolean kkF;
    private final boolean kkG;
    private final com.facebook.common.internal.i<Boolean> kkH;
    private final q kkI;
    private final b.a kkJ;
    private final boolean kkK;
    private final com.facebook.common.g.b kkL;
    private final boolean kkM;
    private final boolean kkN;

    private i(a aVar, h.a aVar2) {
        this.kju = aVar.kju;
        this.kkF = aVar.kkF;
        this.kkG = aVar.kkG;
        if (aVar.kkH == null) {
            this.kkH = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cJI */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.kkH = aVar.kkH;
        }
        this.kkI = aVar.kkI;
        this.kkJ = aVar.kkJ;
        this.kkK = aVar.kkK;
        this.kkL = aVar.kkL;
        this.kkM = aVar.kkM;
        this.kkN = aVar.kkN;
    }

    public boolean cJL() {
        return this.kkG;
    }

    public int cJM() {
        return this.kju;
    }

    public boolean cJN() {
        return this.kkH.get().booleanValue();
    }

    @Nullable
    public q cJO() {
        return this.kkI;
    }

    public boolean cJP() {
        return this.kkN;
    }

    public boolean cJQ() {
        return this.kkF;
    }

    public boolean cJR() {
        return this.kkK;
    }

    public b.a cJS() {
        return this.kkJ;
    }

    public com.facebook.common.g.b cJT() {
        return this.kkL;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q kkI;
        private b.a kkJ;
        private com.facebook.common.g.b kkL;
        private final h.a kkP;
        private int kju = 0;
        private boolean kkF = false;
        private boolean kkG = false;
        private com.facebook.common.internal.i<Boolean> kkH = null;
        private boolean kkK = false;
        private boolean kkM = false;
        private boolean kkN = false;

        public a(h.a aVar) {
            this.kkP = aVar;
        }

        public i cJU() {
            return new i(this, this.kkP);
        }
    }
}
