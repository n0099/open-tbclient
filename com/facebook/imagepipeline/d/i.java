package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int kgW;
    private final boolean kii;
    private final boolean kij;
    private final com.facebook.common.internal.i<Boolean> kik;
    private final q kil;
    private final b.a kim;
    private final boolean kin;
    private final com.facebook.common.g.b kio;
    private final boolean kip;
    private final boolean kiq;

    private i(a aVar, h.a aVar2) {
        this.kgW = aVar.kgW;
        this.kii = aVar.kii;
        this.kij = aVar.kij;
        if (aVar.kik == null) {
            this.kik = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cIU */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.kik = aVar.kik;
        }
        this.kil = aVar.kil;
        this.kim = aVar.kim;
        this.kin = aVar.kin;
        this.kio = aVar.kio;
        this.kip = aVar.kip;
        this.kiq = aVar.kiq;
    }

    public boolean cIX() {
        return this.kij;
    }

    public int cIY() {
        return this.kgW;
    }

    public boolean cIZ() {
        return this.kik.get().booleanValue();
    }

    @Nullable
    public q cJa() {
        return this.kil;
    }

    public boolean cJb() {
        return this.kiq;
    }

    public boolean cJc() {
        return this.kii;
    }

    public boolean cJd() {
        return this.kin;
    }

    public b.a cJe() {
        return this.kim;
    }

    public com.facebook.common.g.b cJf() {
        return this.kio;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q kil;
        private b.a kim;
        private com.facebook.common.g.b kio;
        private final h.a kis;
        private int kgW = 0;
        private boolean kii = false;
        private boolean kij = false;
        private com.facebook.common.internal.i<Boolean> kik = null;
        private boolean kin = false;
        private boolean kip = false;
        private boolean kiq = false;

        public a(h.a aVar) {
            this.kis = aVar;
        }

        public i cJg() {
            return new i(this, this.kis);
        }
    }
}
