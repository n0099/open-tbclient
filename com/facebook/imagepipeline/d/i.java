package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jGn;
    private final com.facebook.common.internal.i<Boolean> jHA;
    private final q jHB;
    private final b.a jHC;
    private final boolean jHD;
    private final com.facebook.common.g.b jHE;
    private final boolean jHF;
    private final boolean jHG;
    private final boolean jHy;
    private final boolean jHz;

    private i(a aVar, h.a aVar2) {
        this.jGn = aVar.jGn;
        this.jHy = aVar.jHy;
        this.jHz = aVar.jHz;
        if (aVar.jHA == null) {
            this.jHA = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cxt */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jHA = aVar.jHA;
        }
        this.jHB = aVar.jHB;
        this.jHC = aVar.jHC;
        this.jHD = aVar.jHD;
        this.jHE = aVar.jHE;
        this.jHF = aVar.jHF;
        this.jHG = aVar.jHG;
    }

    public boolean cxw() {
        return this.jHz;
    }

    public int cxx() {
        return this.jGn;
    }

    public boolean cxy() {
        return this.jHA.get().booleanValue();
    }

    @Nullable
    public q cxz() {
        return this.jHB;
    }

    public boolean cxA() {
        return this.jHG;
    }

    public boolean cxB() {
        return this.jHy;
    }

    public boolean cxC() {
        return this.jHD;
    }

    public b.a cxD() {
        return this.jHC;
    }

    public com.facebook.common.g.b cxE() {
        return this.jHE;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jHB;
        private b.a jHC;
        private com.facebook.common.g.b jHE;
        private final h.a jHI;
        private int jGn = 0;
        private boolean jHy = false;
        private boolean jHz = false;
        private com.facebook.common.internal.i<Boolean> jHA = null;
        private boolean jHD = false;
        private boolean jHF = false;
        private boolean jHG = false;

        public a(h.a aVar) {
            this.jHI = aVar;
        }

        public i cxF() {
            return new i(this, this.jHI);
        }
    }
}
