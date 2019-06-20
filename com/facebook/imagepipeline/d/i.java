package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int jYK;
    private final boolean jZV;
    private final boolean jZW;
    private final com.facebook.common.internal.i<Boolean> jZX;
    private final q jZY;
    private final b.a jZZ;
    private final boolean kaa;
    private final com.facebook.common.g.b kab;
    private final boolean kac;
    private final boolean kad;

    private i(a aVar, h.a aVar2) {
        this.jYK = aVar.jYK;
        this.jZV = aVar.jZV;
        this.jZW = aVar.jZW;
        if (aVar.jZX == null) {
            this.jZX = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: cFw */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.jZX = aVar.jZX;
        }
        this.jZY = aVar.jZY;
        this.jZZ = aVar.jZZ;
        this.kaa = aVar.kaa;
        this.kab = aVar.kab;
        this.kac = aVar.kac;
        this.kad = aVar.kad;
    }

    public boolean cFz() {
        return this.jZW;
    }

    public int cFA() {
        return this.jYK;
    }

    public boolean cFB() {
        return this.jZX.get().booleanValue();
    }

    @Nullable
    public q cFC() {
        return this.jZY;
    }

    public boolean cFD() {
        return this.kad;
    }

    public boolean cFE() {
        return this.jZV;
    }

    public boolean cFF() {
        return this.kaa;
    }

    public b.a cFG() {
        return this.jZZ;
    }

    public com.facebook.common.g.b cFH() {
        return this.kab;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q jZY;
        private b.a jZZ;
        private com.facebook.common.g.b kab;
        private final h.a kaf;
        private int jYK = 0;
        private boolean jZV = false;
        private boolean jZW = false;
        private com.facebook.common.internal.i<Boolean> jZX = null;
        private boolean kaa = false;
        private boolean kac = false;
        private boolean kad = false;

        public a(h.a aVar) {
            this.kaf = aVar;
        }

        public i cFI() {
            return new i(this, this.kaf);
        }
    }
}
