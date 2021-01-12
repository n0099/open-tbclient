package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes3.dex */
public class i {
    private final boolean pyK;
    private final b.a pyL;
    private final boolean pyM;
    private final com.facebook.common.g.b pyN;
    private final boolean pyO;
    private final boolean pyP;
    private final int pyQ;
    private final int pyR;
    private boolean pyS;
    private final boolean pyT;
    private final c pyU;
    private final com.facebook.common.internal.j<Boolean> pyk;

    /* loaded from: classes3.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pyK = aVar.pyK;
        this.pyL = aVar.pyL;
        this.pyM = aVar.pyM;
        this.pyN = aVar.pyN;
        this.pyO = aVar.pyO;
        this.pyP = aVar.pyP;
        this.pyQ = aVar.pyQ;
        this.pyR = aVar.pyR;
        this.pyS = aVar.pyS;
        this.pyT = aVar.pyT;
        if (aVar.pyU == null) {
            this.pyU = new b();
        } else {
            this.pyU = aVar.pyU;
        }
        this.pyk = aVar.pyk;
    }

    public boolean euF() {
        return this.pyO;
    }

    public boolean euG() {
        return this.pyK;
    }

    public boolean euH() {
        return this.pyM;
    }

    public b.a euI() {
        return this.pyL;
    }

    public com.facebook.common.g.b euJ() {
        return this.pyN;
    }

    public boolean euK() {
        return this.pyP;
    }

    public int euL() {
        return this.pyQ;
    }

    public int euM() {
        return this.pyR;
    }

    public boolean euN() {
        return this.pyT;
    }

    public c euO() {
        return this.pyU;
    }

    public boolean euP() {
        return this.pyS;
    }

    public com.facebook.common.internal.j<Boolean> euQ() {
        return this.pyk;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private b.a pyL;
        private com.facebook.common.g.b pyN;
        private c pyU;
        private final h.a pyV;
        public com.facebook.common.internal.j<Boolean> pyk;
        private boolean pyK = false;
        private boolean pyM = false;
        private boolean pyO = false;
        private boolean pyP = false;
        private int pyQ = 0;
        private int pyR = 0;
        public boolean pyS = false;
        private boolean pyT = false;

        public a(h.a aVar) {
            this.pyV = aVar;
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
