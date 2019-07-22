package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int kfQ;
    private final boolean khb;
    private final boolean khc;
    private final com.facebook.common.internal.i<Boolean> khd;
    private final q khe;
    private final b.a khf;
    private final boolean khg;
    private final com.facebook.common.g.b khh;
    private final boolean khi;
    private final boolean khj;

    private i(a aVar, h.a aVar2) {
        this.kfQ = aVar.kfQ;
        this.khb = aVar.khb;
        this.khc = aVar.khc;
        if (aVar.khd == null) {
            this.khd = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cIz */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.khd = aVar.khd;
        }
        this.khe = aVar.khe;
        this.khf = aVar.khf;
        this.khg = aVar.khg;
        this.khh = aVar.khh;
        this.khi = aVar.khi;
        this.khj = aVar.khj;
    }

    public boolean cIC() {
        return this.khc;
    }

    public int cID() {
        return this.kfQ;
    }

    public boolean cIE() {
        return this.khd.get().booleanValue();
    }

    @Nullable
    public q cIF() {
        return this.khe;
    }

    public boolean cIG() {
        return this.khj;
    }

    public boolean cIH() {
        return this.khb;
    }

    public boolean cII() {
        return this.khg;
    }

    public b.a cIJ() {
        return this.khf;
    }

    public com.facebook.common.g.b cIK() {
        return this.khh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q khe;
        private b.a khf;
        private com.facebook.common.g.b khh;
        private final h.a khl;
        private int kfQ = 0;
        private boolean khb = false;
        private boolean khc = false;
        private com.facebook.common.internal.i<Boolean> khd = null;
        private boolean khg = false;
        private boolean khi = false;
        private boolean khj = false;

        public a(h.a aVar) {
            this.khl = aVar;
        }

        public i cIL() {
            return new i(this, this.khl);
        }
    }
}
