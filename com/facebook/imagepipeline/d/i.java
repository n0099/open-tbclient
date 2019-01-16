package com.facebook.imagepipeline.d;

import com.facebook.common.g.b;
import com.facebook.imagepipeline.c.q;
import com.facebook.imagepipeline.d.h;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class i {
    private final int iqG;
    private final boolean irR;
    private final boolean irS;
    private final com.facebook.common.internal.i<Boolean> irT;
    private final q irU;
    private final b.a irV;
    private final boolean irW;
    private final com.facebook.common.g.b irX;
    private final boolean irY;
    private final boolean irZ;

    private i(a aVar, h.a aVar2) {
        this.iqG = aVar.iqG;
        this.irR = aVar.irR;
        this.irS = aVar.irS;
        if (aVar.irT == null) {
            this.irT = new com.facebook.common.internal.i<Boolean>() { // from class: com.facebook.imagepipeline.d.i.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.internal.i
                /* renamed from: bYs */
                public Boolean get() {
                    return Boolean.FALSE;
                }
            };
        } else {
            this.irT = aVar.irT;
        }
        this.irU = aVar.irU;
        this.irV = aVar.irV;
        this.irW = aVar.irW;
        this.irX = aVar.irX;
        this.irY = aVar.irY;
        this.irZ = aVar.irZ;
    }

    public boolean bYv() {
        return this.irS;
    }

    public int bYw() {
        return this.iqG;
    }

    public boolean bYx() {
        return this.irT.get().booleanValue();
    }

    @Nullable
    public q bYy() {
        return this.irU;
    }

    public boolean bYz() {
        return this.irZ;
    }

    public boolean bYA() {
        return this.irR;
    }

    public boolean bYB() {
        return this.irW;
    }

    public b.a bYC() {
        return this.irV;
    }

    public com.facebook.common.g.b bYD() {
        return this.irX;
    }

    /* loaded from: classes2.dex */
    public static class a {
        private q irU;
        private b.a irV;
        private com.facebook.common.g.b irX;
        private final h.a isb;
        private int iqG = 0;
        private boolean irR = false;
        private boolean irS = false;
        private com.facebook.common.internal.i<Boolean> irT = null;
        private boolean irW = false;
        private boolean irY = false;
        private boolean irZ = false;

        public a(h.a aVar) {
            this.isb = aVar;
        }

        public i bYE() {
            return new i(this, this.isb);
        }
    }
}
