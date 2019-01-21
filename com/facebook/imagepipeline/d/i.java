package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int iqH;
    private final boolean irS;
    private final boolean irT;
    private final com.facebook.common.internal.i<Boolean> irU;
    private final q irV;
    private final b.a irW;
    private final boolean irX;
    private final com.facebook.common.g.b irY;
    private final boolean irZ;
    private final boolean isa;

    private i(a aVar, h.a aVar2) {
        this.iqH = aVar.iqH;
        this.irS = aVar.irS;
        this.irT = aVar.irT;
        if (aVar.irU == null) {
            this.irU = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bYs */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.irU = aVar.irU;
        }
        this.irV = aVar.irV;
        this.irW = aVar.irW;
        this.irX = aVar.irX;
        this.irY = aVar.irY;
        this.irZ = aVar.irZ;
        this.isa = aVar.isa;
    }

    public boolean bYv() {
        return this.irT;
    }

    public int bYw() {
        return this.iqH;
    }

    public boolean bYx() {
        return this.irU.get().booleanValue();
    }

    @Nullable
    public q bYy() {
        return this.irV;
    }

    public boolean bYz() {
        return this.isa;
    }

    public boolean bYA() {
        return this.irS;
    }

    public boolean bYB() {
        return this.irX;
    }

    public b.a bYC() {
        return this.irW;
    }

    public com.facebook.common.g.b bYD() {
        return this.irY;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q irV;
        private b.a irW;
        private com.facebook.common.g.b irY;
        private final h.a isc;
        private int iqH = 0;
        private boolean irS = false;
        private boolean irT = false;
        private com.facebook.common.internal.i<Boolean> irU = null;
        private boolean irX = false;
        private boolean irZ = false;
        private boolean isa = false;

        public a(h.a aVar) {
            this.isc = aVar;
        }

        public i bYE() {
            return new i(this, this.isc);
        }
    }
}
