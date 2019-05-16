package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jYG;
    private final boolean jZR;
    private final boolean jZS;
    private final com.facebook.common.internal.i<Boolean> jZT;
    private final q jZU;
    private final b.a jZV;
    private final boolean jZW;
    private final com.facebook.common.g.b jZX;
    private final boolean jZY;
    private final boolean jZZ;

    private i(a aVar, h.a aVar2) {
        this.jYG = aVar.jYG;
        this.jZR = aVar.jZR;
        this.jZS = aVar.jZS;
        if (aVar.jZT == null) {
            this.jZT = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cFv */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jZT = aVar.jZT;
        }
        this.jZU = aVar.jZU;
        this.jZV = aVar.jZV;
        this.jZW = aVar.jZW;
        this.jZX = aVar.jZX;
        this.jZY = aVar.jZY;
        this.jZZ = aVar.jZZ;
    }

    public boolean cFy() {
        return this.jZS;
    }

    public int cFz() {
        return this.jYG;
    }

    public boolean cFA() {
        return this.jZT.get().booleanValue();
    }

    @Nullable
    public q cFB() {
        return this.jZU;
    }

    public boolean cFC() {
        return this.jZZ;
    }

    public boolean cFD() {
        return this.jZR;
    }

    public boolean cFE() {
        return this.jZW;
    }

    public b.a cFF() {
        return this.jZV;
    }

    public com.facebook.common.g.b cFG() {
        return this.jZX;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jZU;
        private b.a jZV;
        private com.facebook.common.g.b jZX;
        private final h.a kab;
        private int jYG = 0;
        private boolean jZR = false;
        private boolean jZS = false;
        private com.facebook.common.internal.i<Boolean> jZT = null;
        private boolean jZW = false;
        private boolean jZY = false;
        private boolean jZZ = false;

        public a(h.a aVar) {
            this.kab = aVar;
        }

        public i cFH() {
            return new i(this, this.kab);
        }
    }
}
