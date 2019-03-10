package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jGG;
    private final boolean jHR;
    private final boolean jHS;
    private final com.facebook.common.internal.i<Boolean> jHT;
    private final q jHU;
    private final b.a jHV;
    private final boolean jHW;
    private final com.facebook.common.g.b jHX;
    private final boolean jHY;
    private final boolean jHZ;

    private i(a aVar, h.a aVar2) {
        this.jGG = aVar.jGG;
        this.jHR = aVar.jHR;
        this.jHS = aVar.jHS;
        if (aVar.jHT == null) {
            this.jHT = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cxD */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jHT = aVar.jHT;
        }
        this.jHU = aVar.jHU;
        this.jHV = aVar.jHV;
        this.jHW = aVar.jHW;
        this.jHX = aVar.jHX;
        this.jHY = aVar.jHY;
        this.jHZ = aVar.jHZ;
    }

    public boolean cxG() {
        return this.jHS;
    }

    public int cxH() {
        return this.jGG;
    }

    public boolean cxI() {
        return this.jHT.get().booleanValue();
    }

    @Nullable
    public q cxJ() {
        return this.jHU;
    }

    public boolean cxK() {
        return this.jHZ;
    }

    public boolean cxL() {
        return this.jHR;
    }

    public boolean cxM() {
        return this.jHW;
    }

    public b.a cxN() {
        return this.jHV;
    }

    public com.facebook.common.g.b cxO() {
        return this.jHX;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jHU;
        private b.a jHV;
        private com.facebook.common.g.b jHX;
        private final h.a jIb;
        private int jGG = 0;
        private boolean jHR = false;
        private boolean jHS = false;
        private com.facebook.common.internal.i<Boolean> jHT = null;
        private boolean jHW = false;
        private boolean jHY = false;
        private boolean jHZ = false;

        public a(h.a aVar) {
            this.jIb = aVar;
        }

        public i cxP() {
            return new i(this, this.jIb);
        }
    }
}
