package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jYH;
    private final boolean jZS;
    private final boolean jZT;
    private final com.facebook.common.internal.i<Boolean> jZU;
    private final q jZV;
    private final b.a jZW;
    private final boolean jZX;
    private final com.facebook.common.g.b jZY;
    private final boolean jZZ;
    private final boolean kaa;

    private i(a aVar, h.a aVar2) {
        this.jYH = aVar.jYH;
        this.jZS = aVar.jZS;
        this.jZT = aVar.jZT;
        if (aVar.jZU == null) {
            this.jZU = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cFx */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jZU = aVar.jZU;
        }
        this.jZV = aVar.jZV;
        this.jZW = aVar.jZW;
        this.jZX = aVar.jZX;
        this.jZY = aVar.jZY;
        this.jZZ = aVar.jZZ;
        this.kaa = aVar.kaa;
    }

    public boolean cFA() {
        return this.jZT;
    }

    public int cFB() {
        return this.jYH;
    }

    public boolean cFC() {
        return this.jZU.get().booleanValue();
    }

    @Nullable
    public q cFD() {
        return this.jZV;
    }

    public boolean cFE() {
        return this.kaa;
    }

    public boolean cFF() {
        return this.jZS;
    }

    public boolean cFG() {
        return this.jZX;
    }

    public b.a cFH() {
        return this.jZW;
    }

    public com.facebook.common.g.b cFI() {
        return this.jZY;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jZV;
        private b.a jZW;
        private com.facebook.common.g.b jZY;
        private final h.a kac;
        private int jYH = 0;
        private boolean jZS = false;
        private boolean jZT = false;
        private com.facebook.common.internal.i<Boolean> jZU = null;
        private boolean jZX = false;
        private boolean jZZ = false;
        private boolean kaa = false;

        public a(h.a aVar) {
            this.kac = aVar;
        }

        public i cFJ() {
            return new i(this, this.kac);
        }
    }
}
