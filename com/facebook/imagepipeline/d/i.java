package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jFT;
    private final boolean jHe;
    private final boolean jHf;
    private final com.facebook.common.internal.i<Boolean> jHg;
    private final q jHh;
    private final b.a jHi;
    private final boolean jHj;
    private final com.facebook.common.g.b jHk;
    private final boolean jHl;
    private final boolean jHm;

    private i(a aVar, h.a aVar2) {
        this.jFT = aVar.jFT;
        this.jHe = aVar.jHe;
        this.jHf = aVar.jHf;
        if (aVar.jHg == null) {
            this.jHg = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cxz */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jHg = aVar.jHg;
        }
        this.jHh = aVar.jHh;
        this.jHi = aVar.jHi;
        this.jHj = aVar.jHj;
        this.jHk = aVar.jHk;
        this.jHl = aVar.jHl;
        this.jHm = aVar.jHm;
    }

    public boolean cxC() {
        return this.jHf;
    }

    public int cxD() {
        return this.jFT;
    }

    public boolean cxE() {
        return this.jHg.get().booleanValue();
    }

    @Nullable
    public q cxF() {
        return this.jHh;
    }

    public boolean cxG() {
        return this.jHm;
    }

    public boolean cxH() {
        return this.jHe;
    }

    public boolean cxI() {
        return this.jHj;
    }

    public b.a cxJ() {
        return this.jHi;
    }

    public com.facebook.common.g.b cxK() {
        return this.jHk;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jHh;
        private b.a jHi;
        private com.facebook.common.g.b jHk;
        private final h.a jHo;
        private int jFT = 0;
        private boolean jHe = false;
        private boolean jHf = false;
        private com.facebook.common.internal.i<Boolean> jHg = null;
        private boolean jHj = false;
        private boolean jHl = false;
        private boolean jHm = false;

        public a(h.a aVar) {
            this.jHo = aVar;
        }

        public i cxL() {
            return new i(this, this.jHo);
        }
    }
}
