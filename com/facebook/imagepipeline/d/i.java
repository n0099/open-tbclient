package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int kgO;
    private final boolean khZ;
    private final boolean kia;
    private final com.facebook.common.internal.i<Boolean> kib;
    private final q kic;
    private final b.a kie;
    private final boolean kif;
    private final com.facebook.common.g.b kig;
    private final boolean kih;
    private final boolean kii;

    private i(a aVar, h.a aVar2) {
        this.kgO = aVar.kgO;
        this.khZ = aVar.khZ;
        this.kia = aVar.kia;
        if (aVar.kib == null) {
            this.kib = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cGD */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.kib = aVar.kib;
        }
        this.kic = aVar.kic;
        this.kie = aVar.kie;
        this.kif = aVar.kif;
        this.kig = aVar.kig;
        this.kih = aVar.kih;
        this.kii = aVar.kii;
    }

    public boolean cGG() {
        return this.kia;
    }

    public int cGH() {
        return this.kgO;
    }

    public boolean cGI() {
        return this.kib.get().booleanValue();
    }

    @Nullable
    public q cGJ() {
        return this.kic;
    }

    public boolean cGK() {
        return this.kii;
    }

    public boolean cGL() {
        return this.khZ;
    }

    public boolean cGM() {
        return this.kif;
    }

    public b.a cGN() {
        return this.kie;
    }

    public com.facebook.common.g.b cGO() {
        return this.kig;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q kic;
        private b.a kie;
        private com.facebook.common.g.b kig;
        private final h.a kik;
        private int kgO = 0;
        private boolean khZ = false;
        private boolean kia = false;
        private com.facebook.common.internal.i<Boolean> kib = null;
        private boolean kif = false;
        private boolean kih = false;
        private boolean kii = false;

        public a(h.a aVar) {
            this.kik = aVar;
        }

        public i cGP() {
            return new i(this, this.kik);
        }
    }
}
