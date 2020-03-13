package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final boolean lSP;
    private final b.a lSQ;
    private final boolean lSR;
    private final com.facebook.common.g.b lSS;
    private final boolean lST;
    private final boolean lSU;
    private final int lSV;
    private final int lSW;
    private boolean lSX;
    private final boolean lSY;
    private final c lSZ;
    private final com.facebook.common.internal.j<Boolean> lSp;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lSP = aVar.lSP;
        this.lSQ = aVar.lSQ;
        this.lSR = aVar.lSR;
        this.lSS = aVar.lSS;
        this.lST = aVar.lST;
        this.lSU = aVar.lSU;
        this.lSV = aVar.lSV;
        this.lSW = aVar.lSW;
        this.lSX = aVar.lSX;
        this.lSY = aVar.lSY;
        if (aVar.lSZ == null) {
            this.lSZ = new b();
        } else {
            this.lSZ = aVar.lSZ;
        }
        this.lSp = aVar.lSp;
    }

    public boolean dpk() {
        return this.lST;
    }

    public boolean dpl() {
        return this.lSP;
    }

    public boolean dpm() {
        return this.lSR;
    }

    public b.a dpn() {
        return this.lSQ;
    }

    public com.facebook.common.g.b dpo() {
        return this.lSS;
    }

    public boolean dpp() {
        return this.lSU;
    }

    public int dpq() {
        return this.lSV;
    }

    public int dpr() {
        return this.lSW;
    }

    public boolean dps() {
        return this.lSY;
    }

    public c dpt() {
        return this.lSZ;
    }

    public boolean dpu() {
        return this.lSX;
    }

    public com.facebook.common.internal.j<Boolean> dpv() {
        return this.lSp;
    }

    /* loaded from: classes12.dex */
    public static class a {
        private b.a lSQ;
        private com.facebook.common.g.b lSS;
        private c lSZ;
        public com.facebook.common.internal.j<Boolean> lSp;
        private final h.a lTa;
        private boolean lSP = false;
        private boolean lSR = false;
        private boolean lST = false;
        private boolean lSU = false;
        private int lSV = 0;
        private int lSW = 0;
        public boolean lSX = false;
        private boolean lSY = false;

        public a(h.a aVar) {
            this.lTa = aVar;
        }

        public i dpw() {
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
