package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final boolean lSC;
    private final b.a lSD;
    private final boolean lSE;
    private final com.facebook.common.g.b lSF;
    private final boolean lSG;
    private final boolean lSH;
    private final int lSI;
    private final int lSJ;
    private boolean lSK;
    private final boolean lSL;
    private final c lSM;
    private final com.facebook.common.internal.j<Boolean> lSc;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lSC = aVar.lSC;
        this.lSD = aVar.lSD;
        this.lSE = aVar.lSE;
        this.lSF = aVar.lSF;
        this.lSG = aVar.lSG;
        this.lSH = aVar.lSH;
        this.lSI = aVar.lSI;
        this.lSJ = aVar.lSJ;
        this.lSK = aVar.lSK;
        this.lSL = aVar.lSL;
        if (aVar.lSM == null) {
            this.lSM = new b();
        } else {
            this.lSM = aVar.lSM;
        }
        this.lSc = aVar.lSc;
    }

    public boolean dph() {
        return this.lSG;
    }

    public boolean dpi() {
        return this.lSC;
    }

    public boolean dpj() {
        return this.lSE;
    }

    public b.a dpk() {
        return this.lSD;
    }

    public com.facebook.common.g.b dpl() {
        return this.lSF;
    }

    public boolean dpm() {
        return this.lSH;
    }

    public int dpn() {
        return this.lSI;
    }

    public int dpo() {
        return this.lSJ;
    }

    public boolean dpp() {
        return this.lSL;
    }

    public c dpq() {
        return this.lSM;
    }

    public boolean dpr() {
        return this.lSK;
    }

    public com.facebook.common.internal.j<Boolean> dps() {
        return this.lSc;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private b.a lSD;
        private com.facebook.common.g.b lSF;
        private c lSM;
        private final h.a lSN;
        public com.facebook.common.internal.j<Boolean> lSc;
        private boolean lSC = false;
        private boolean lSE = false;
        private boolean lSG = false;
        private boolean lSH = false;
        private int lSI = 0;
        private int lSJ = 0;
        public boolean lSK = false;
        private boolean lSL = false;

        public a(h.a aVar) {
            this.lSN = aVar;
        }

        public i dpt() {
            return new i(this);
        }
    }

    /* loaded from: classes12.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
