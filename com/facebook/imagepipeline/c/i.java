package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes5.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> pIT;
    private final int pJA;
    private boolean pJB;
    private final boolean pJC;
    private final c pJD;
    private final boolean pJt;
    private final b.a pJu;
    private final boolean pJv;
    private final com.facebook.common.g.b pJw;
    private final boolean pJx;
    private final boolean pJy;
    private final int pJz;

    /* loaded from: classes5.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pJt = aVar.pJt;
        this.pJu = aVar.pJu;
        this.pJv = aVar.pJv;
        this.pJw = aVar.pJw;
        this.pJx = aVar.pJx;
        this.pJy = aVar.pJy;
        this.pJz = aVar.pJz;
        this.pJA = aVar.pJA;
        this.pJB = aVar.pJB;
        this.pJC = aVar.pJC;
        if (aVar.pJD == null) {
            this.pJD = new b();
        } else {
            this.pJD = aVar.pJD;
        }
        this.pIT = aVar.pIT;
    }

    public boolean exg() {
        return this.pJx;
    }

    public boolean exh() {
        return this.pJt;
    }

    public boolean exi() {
        return this.pJv;
    }

    public b.a exj() {
        return this.pJu;
    }

    public com.facebook.common.g.b exk() {
        return this.pJw;
    }

    public boolean exl() {
        return this.pJy;
    }

    public int exm() {
        return this.pJz;
    }

    public int exn() {
        return this.pJA;
    }

    public boolean exo() {
        return this.pJC;
    }

    public c exp() {
        return this.pJD;
    }

    public boolean exq() {
        return this.pJB;
    }

    public com.facebook.common.internal.j<Boolean> exr() {
        return this.pIT;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> pIT;
        private c pJD;
        private final h.a pJE;
        private b.a pJu;
        private com.facebook.common.g.b pJw;
        private boolean pJt = false;
        private boolean pJv = false;
        private boolean pJx = false;
        private boolean pJy = false;
        private int pJz = 0;
        private int pJA = 0;
        public boolean pJB = false;
        private boolean pJC = false;

        public a(h.a aVar) {
            this.pJE = aVar;
        }

        public i exs() {
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
