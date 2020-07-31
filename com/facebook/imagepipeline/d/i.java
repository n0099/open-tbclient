package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes4.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> naW;
    private final boolean nbA;
    private final boolean nbB;
    private final int nbC;
    private final int nbD;
    private boolean nbE;
    private final boolean nbF;
    private final c nbG;
    private final boolean nbw;
    private final b.a nbx;
    private final boolean nby;
    private final com.facebook.common.g.b nbz;

    /* loaded from: classes4.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nbw = aVar.nbw;
        this.nbx = aVar.nbx;
        this.nby = aVar.nby;
        this.nbz = aVar.nbz;
        this.nbA = aVar.nbA;
        this.nbB = aVar.nbB;
        this.nbC = aVar.nbC;
        this.nbD = aVar.nbD;
        this.nbE = aVar.nbE;
        this.nbF = aVar.nbF;
        if (aVar.nbG == null) {
            this.nbG = new b();
        } else {
            this.nbG = aVar.nbG;
        }
        this.naW = aVar.naW;
    }

    public boolean dHb() {
        return this.nbA;
    }

    public boolean dHc() {
        return this.nbw;
    }

    public boolean dHd() {
        return this.nby;
    }

    public b.a dHe() {
        return this.nbx;
    }

    public com.facebook.common.g.b dHf() {
        return this.nbz;
    }

    public boolean dHg() {
        return this.nbB;
    }

    public int dHh() {
        return this.nbC;
    }

    public int dHi() {
        return this.nbD;
    }

    public boolean dHj() {
        return this.nbF;
    }

    public c dHk() {
        return this.nbG;
    }

    public boolean dHl() {
        return this.nbE;
    }

    public com.facebook.common.internal.j<Boolean> dHm() {
        return this.naW;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> naW;
        private c nbG;
        private final h.a nbH;
        private b.a nbx;
        private com.facebook.common.g.b nbz;
        private boolean nbw = false;
        private boolean nby = false;
        private boolean nbA = false;
        private boolean nbB = false;
        private int nbC = 0;
        private int nbD = 0;
        public boolean nbE = false;
        private boolean nbF = false;

        public a(h.a aVar) {
            this.nbH = aVar;
        }

        public i dHn() {
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
