package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jFS;
    private final boolean jHd;
    private final boolean jHe;
    private final com.facebook.common.internal.i<Boolean> jHf;
    private final q jHg;
    private final b.a jHh;
    private final boolean jHi;
    private final com.facebook.common.g.b jHj;
    private final boolean jHk;
    private final boolean jHl;

    private i(a aVar, h.a aVar2) {
        this.jFS = aVar.jFS;
        this.jHd = aVar.jHd;
        this.jHe = aVar.jHe;
        if (aVar.jHf == null) {
            this.jHf = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cxz */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jHf = aVar.jHf;
        }
        this.jHg = aVar.jHg;
        this.jHh = aVar.jHh;
        this.jHi = aVar.jHi;
        this.jHj = aVar.jHj;
        this.jHk = aVar.jHk;
        this.jHl = aVar.jHl;
    }

    public boolean cxC() {
        return this.jHe;
    }

    public int cxD() {
        return this.jFS;
    }

    public boolean cxE() {
        return this.jHf.get().booleanValue();
    }

    @Nullable
    public q cxF() {
        return this.jHg;
    }

    public boolean cxG() {
        return this.jHl;
    }

    public boolean cxH() {
        return this.jHd;
    }

    public boolean cxI() {
        return this.jHi;
    }

    public b.a cxJ() {
        return this.jHh;
    }

    public com.facebook.common.g.b cxK() {
        return this.jHj;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jHg;
        private b.a jHh;
        private com.facebook.common.g.b jHj;
        private final h.a jHn;
        private int jFS = 0;
        private boolean jHd = false;
        private boolean jHe = false;
        private com.facebook.common.internal.i<Boolean> jHf = null;
        private boolean jHi = false;
        private boolean jHk = false;
        private boolean jHl = false;

        public a(h.a aVar) {
            this.jHn = aVar;
        }

        public i cxL() {
            return new i(this, this.jHn);
        }
    }
}
