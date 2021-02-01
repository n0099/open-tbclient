package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes5.dex */
public class i {
    private final boolean pIT;
    private final b.a pIU;
    private final boolean pIV;
    private final com.facebook.common.g.b pIW;
    private final boolean pIX;
    private final boolean pIY;
    private final int pIZ;
    private final com.facebook.common.internal.j<Boolean> pIt;
    private final int pJa;
    private boolean pJb;
    private final boolean pJc;
    private final c pJd;

    /* loaded from: classes5.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pIT = aVar.pIT;
        this.pIU = aVar.pIU;
        this.pIV = aVar.pIV;
        this.pIW = aVar.pIW;
        this.pIX = aVar.pIX;
        this.pIY = aVar.pIY;
        this.pIZ = aVar.pIZ;
        this.pJa = aVar.pJa;
        this.pJb = aVar.pJb;
        this.pJc = aVar.pJc;
        if (aVar.pJd == null) {
            this.pJd = new b();
        } else {
            this.pJd = aVar.pJd;
        }
        this.pIt = aVar.pIt;
    }

    public boolean ewY() {
        return this.pIX;
    }

    public boolean ewZ() {
        return this.pIT;
    }

    public boolean exa() {
        return this.pIV;
    }

    public b.a exb() {
        return this.pIU;
    }

    public com.facebook.common.g.b exc() {
        return this.pIW;
    }

    public boolean exd() {
        return this.pIY;
    }

    public int exe() {
        return this.pIZ;
    }

    public int exf() {
        return this.pJa;
    }

    public boolean exg() {
        return this.pJc;
    }

    public c exh() {
        return this.pJd;
    }

    public boolean exi() {
        return this.pJb;
    }

    public com.facebook.common.internal.j<Boolean> exj() {
        return this.pIt;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private b.a pIU;
        private com.facebook.common.g.b pIW;
        public com.facebook.common.internal.j<Boolean> pIt;
        private c pJd;
        private final h.a pJe;
        private boolean pIT = false;
        private boolean pIV = false;
        private boolean pIX = false;
        private boolean pIY = false;
        private int pIZ = 0;
        private int pJa = 0;
        public boolean pJb = false;
        private boolean pJc = false;

        public a(h.a aVar) {
            this.pJe = aVar;
        }

        public i exk() {
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
