package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final boolean lSE;
    private final b.a lSF;
    private final boolean lSG;
    private final com.facebook.common.g.b lSH;
    private final boolean lSI;
    private final boolean lSJ;
    private final int lSK;
    private final int lSL;
    private boolean lSM;
    private final boolean lSN;
    private final c lSO;
    private final com.facebook.common.internal.j<Boolean> lSe;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lSE = aVar.lSE;
        this.lSF = aVar.lSF;
        this.lSG = aVar.lSG;
        this.lSH = aVar.lSH;
        this.lSI = aVar.lSI;
        this.lSJ = aVar.lSJ;
        this.lSK = aVar.lSK;
        this.lSL = aVar.lSL;
        this.lSM = aVar.lSM;
        this.lSN = aVar.lSN;
        if (aVar.lSO == null) {
            this.lSO = new b();
        } else {
            this.lSO = aVar.lSO;
        }
        this.lSe = aVar.lSe;
    }

    public boolean dpj() {
        return this.lSI;
    }

    public boolean dpk() {
        return this.lSE;
    }

    public boolean dpl() {
        return this.lSG;
    }

    public b.a dpm() {
        return this.lSF;
    }

    public com.facebook.common.g.b dpn() {
        return this.lSH;
    }

    public boolean dpo() {
        return this.lSJ;
    }

    public int dpp() {
        return this.lSK;
    }

    public int dpq() {
        return this.lSL;
    }

    public boolean dpr() {
        return this.lSN;
    }

    public c dps() {
        return this.lSO;
    }

    public boolean dpt() {
        return this.lSM;
    }

    public com.facebook.common.internal.j<Boolean> dpu() {
        return this.lSe;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private b.a lSF;
        private com.facebook.common.g.b lSH;
        private c lSO;
        private final h.a lSP;
        public com.facebook.common.internal.j<Boolean> lSe;
        private boolean lSE = false;
        private boolean lSG = false;
        private boolean lSI = false;
        private boolean lSJ = false;
        private int lSK = 0;
        private int lSL = 0;
        public boolean lSM = false;
        private boolean lSN = false;

        public a(h.a aVar) {
            this.lSP = aVar;
        }

        public i dpv() {
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
