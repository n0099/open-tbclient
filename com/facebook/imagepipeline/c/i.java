package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes3.dex */
public class i {
    private final boolean pyL;
    private final b.a pyM;
    private final boolean pyN;
    private final com.facebook.common.g.b pyO;
    private final boolean pyP;
    private final boolean pyQ;
    private final int pyR;
    private final int pyS;
    private boolean pyT;
    private final boolean pyU;
    private final c pyV;
    private final com.facebook.common.internal.j<Boolean> pyl;

    /* loaded from: classes3.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pyL = aVar.pyL;
        this.pyM = aVar.pyM;
        this.pyN = aVar.pyN;
        this.pyO = aVar.pyO;
        this.pyP = aVar.pyP;
        this.pyQ = aVar.pyQ;
        this.pyR = aVar.pyR;
        this.pyS = aVar.pyS;
        this.pyT = aVar.pyT;
        this.pyU = aVar.pyU;
        if (aVar.pyV == null) {
            this.pyV = new b();
        } else {
            this.pyV = aVar.pyV;
        }
        this.pyl = aVar.pyl;
    }

    public boolean euF() {
        return this.pyP;
    }

    public boolean euG() {
        return this.pyL;
    }

    public boolean euH() {
        return this.pyN;
    }

    public b.a euI() {
        return this.pyM;
    }

    public com.facebook.common.g.b euJ() {
        return this.pyO;
    }

    public boolean euK() {
        return this.pyQ;
    }

    public int euL() {
        return this.pyR;
    }

    public int euM() {
        return this.pyS;
    }

    public boolean euN() {
        return this.pyU;
    }

    public c euO() {
        return this.pyV;
    }

    public boolean euP() {
        return this.pyT;
    }

    public com.facebook.common.internal.j<Boolean> euQ() {
        return this.pyl;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private b.a pyM;
        private com.facebook.common.g.b pyO;
        private c pyV;
        private final h.a pyW;
        public com.facebook.common.internal.j<Boolean> pyl;
        private boolean pyL = false;
        private boolean pyN = false;
        private boolean pyP = false;
        private boolean pyQ = false;
        private int pyR = 0;
        private int pyS = 0;
        public boolean pyT = false;
        private boolean pyU = false;

        public a(h.a aVar) {
            this.pyW = aVar;
        }

        public i euR() {
            return new i(this);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.c.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
