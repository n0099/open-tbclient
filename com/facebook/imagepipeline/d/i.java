package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes4.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> naY;
    private final boolean nbA;
    private final com.facebook.common.g.b nbB;
    private final boolean nbC;
    private final boolean nbD;
    private final int nbE;
    private final int nbF;
    private boolean nbG;
    private final boolean nbH;
    private final c nbI;
    private final boolean nby;
    private final b.a nbz;

    /* loaded from: classes4.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nby = aVar.nby;
        this.nbz = aVar.nbz;
        this.nbA = aVar.nbA;
        this.nbB = aVar.nbB;
        this.nbC = aVar.nbC;
        this.nbD = aVar.nbD;
        this.nbE = aVar.nbE;
        this.nbF = aVar.nbF;
        this.nbG = aVar.nbG;
        this.nbH = aVar.nbH;
        if (aVar.nbI == null) {
            this.nbI = new b();
        } else {
            this.nbI = aVar.nbI;
        }
        this.naY = aVar.naY;
    }

    public boolean dHc() {
        return this.nbC;
    }

    public boolean dHd() {
        return this.nby;
    }

    public boolean dHe() {
        return this.nbA;
    }

    public b.a dHf() {
        return this.nbz;
    }

    public com.facebook.common.g.b dHg() {
        return this.nbB;
    }

    public boolean dHh() {
        return this.nbD;
    }

    public int dHi() {
        return this.nbE;
    }

    public int dHj() {
        return this.nbF;
    }

    public boolean dHk() {
        return this.nbH;
    }

    public c dHl() {
        return this.nbI;
    }

    public boolean dHm() {
        return this.nbG;
    }

    public com.facebook.common.internal.j<Boolean> dHn() {
        return this.naY;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> naY;
        private com.facebook.common.g.b nbB;
        private c nbI;
        private final h.a nbJ;
        private b.a nbz;
        private boolean nby = false;
        private boolean nbA = false;
        private boolean nbC = false;
        private boolean nbD = false;
        private int nbE = 0;
        private int nbF = 0;
        public boolean nbG = false;
        private boolean nbH = false;

        public a(h.a aVar) {
            this.nbJ = aVar;
        }

        public i dHo() {
            return new i(this);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
