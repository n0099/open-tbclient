package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes5.dex */
public class i {
    private final boolean pBE;
    private final b.a pBF;
    private final boolean pBG;
    private final com.facebook.common.g.b pBH;
    private final boolean pBI;
    private final boolean pBJ;
    private final int pBK;
    private final int pBL;
    private boolean pBM;
    private final boolean pBN;
    private final c pBO;
    private final com.facebook.common.internal.j<Boolean> pBe;

    /* loaded from: classes5.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pBE = aVar.pBE;
        this.pBF = aVar.pBF;
        this.pBG = aVar.pBG;
        this.pBH = aVar.pBH;
        this.pBI = aVar.pBI;
        this.pBJ = aVar.pBJ;
        this.pBK = aVar.pBK;
        this.pBL = aVar.pBL;
        this.pBM = aVar.pBM;
        this.pBN = aVar.pBN;
        if (aVar.pBO == null) {
            this.pBO = new b();
        } else {
            this.pBO = aVar.pBO;
        }
        this.pBe = aVar.pBe;
    }

    public boolean exV() {
        return this.pBI;
    }

    public boolean exW() {
        return this.pBE;
    }

    public boolean exX() {
        return this.pBG;
    }

    public b.a exY() {
        return this.pBF;
    }

    public com.facebook.common.g.b exZ() {
        return this.pBH;
    }

    public boolean eya() {
        return this.pBJ;
    }

    public int eyb() {
        return this.pBK;
    }

    public int eyc() {
        return this.pBL;
    }

    public boolean eyd() {
        return this.pBN;
    }

    public c eye() {
        return this.pBO;
    }

    public boolean eyf() {
        return this.pBM;
    }

    public com.facebook.common.internal.j<Boolean> eyg() {
        return this.pBe;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private b.a pBF;
        private com.facebook.common.g.b pBH;
        private c pBO;
        private final h.a pBP;
        public com.facebook.common.internal.j<Boolean> pBe;
        private boolean pBE = false;
        private boolean pBG = false;
        private boolean pBI = false;
        private boolean pBJ = false;
        private int pBK = 0;
        private int pBL = 0;
        public boolean pBM = false;
        private boolean pBN = false;

        public a(h.a aVar) {
            this.pBP = aVar;
        }

        public i eyh() {
            return new i(this);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.c.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
