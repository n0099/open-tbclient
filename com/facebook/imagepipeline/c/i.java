package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes5.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> pKY;
    private final boolean pLA;
    private final com.facebook.common.g.b pLB;
    private final boolean pLC;
    private final boolean pLD;
    private final int pLE;
    private final int pLF;
    private boolean pLG;
    private final boolean pLH;
    private final c pLI;
    private final boolean pLy;
    private final b.a pLz;

    /* loaded from: classes5.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pLy = aVar.pLy;
        this.pLz = aVar.pLz;
        this.pLA = aVar.pLA;
        this.pLB = aVar.pLB;
        this.pLC = aVar.pLC;
        this.pLD = aVar.pLD;
        this.pLE = aVar.pLE;
        this.pLF = aVar.pLF;
        this.pLG = aVar.pLG;
        this.pLH = aVar.pLH;
        if (aVar.pLI == null) {
            this.pLI = new b();
        } else {
            this.pLI = aVar.pLI;
        }
        this.pKY = aVar.pKY;
    }

    public boolean exp() {
        return this.pLC;
    }

    public boolean exq() {
        return this.pLy;
    }

    public boolean exr() {
        return this.pLA;
    }

    public b.a exs() {
        return this.pLz;
    }

    public com.facebook.common.g.b ext() {
        return this.pLB;
    }

    public boolean exu() {
        return this.pLD;
    }

    public int exv() {
        return this.pLE;
    }

    public int exw() {
        return this.pLF;
    }

    public boolean exx() {
        return this.pLH;
    }

    public c exy() {
        return this.pLI;
    }

    public boolean exz() {
        return this.pLG;
    }

    public com.facebook.common.internal.j<Boolean> exA() {
        return this.pKY;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> pKY;
        private com.facebook.common.g.b pLB;
        private c pLI;
        private final h.a pLJ;
        private b.a pLz;
        private boolean pLy = false;
        private boolean pLA = false;
        private boolean pLC = false;
        private boolean pLD = false;
        private int pLE = 0;
        private int pLF = 0;
        public boolean pLG = false;
        private boolean pLH = false;

        public a(h.a aVar) {
            this.pLJ = aVar;
        }

        public i exB() {
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
