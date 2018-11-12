package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int ifd;
    private final boolean igo;
    private final boolean igp;
    private final com.facebook.common.internal.i<Boolean> igq;
    private final q igr;
    private final b.a igs;
    private final boolean igt;
    private final com.facebook.common.g.b igu;
    private final boolean igv;
    private final boolean igw;

    private i(a aVar, h.a aVar2) {
        this.ifd = aVar.ifd;
        this.igo = aVar.igo;
        this.igp = aVar.igp;
        if (aVar.igq == null) {
            this.igq = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bUO */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.igq = aVar.igq;
        }
        this.igr = aVar.igr;
        this.igs = aVar.igs;
        this.igt = aVar.igt;
        this.igu = aVar.igu;
        this.igv = aVar.igv;
        this.igw = aVar.igw;
    }

    public boolean bUR() {
        return this.igp;
    }

    public int bUS() {
        return this.ifd;
    }

    public boolean bUT() {
        return this.igq.get().booleanValue();
    }

    @Nullable
    public q bUU() {
        return this.igr;
    }

    public boolean bUV() {
        return this.igw;
    }

    public boolean bUW() {
        return this.igo;
    }

    public boolean bUX() {
        return this.igt;
    }

    public b.a bUY() {
        return this.igs;
    }

    public com.facebook.common.g.b bUZ() {
        return this.igu;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q igr;
        private b.a igs;
        private com.facebook.common.g.b igu;
        private final h.a igy;
        private int ifd = 0;
        private boolean igo = false;
        private boolean igp = false;
        private com.facebook.common.internal.i<Boolean> igq = null;
        private boolean igt = false;
        private boolean igv = false;
        private boolean igw = false;

        public a(h.a aVar) {
            this.igy = aVar;
        }

        public i bVa() {
            return new i(this, this.igy);
        }
    }
}
