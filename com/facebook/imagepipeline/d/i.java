package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes25.dex */
public class i {
    private final boolean nFD;
    private final b.a nFE;
    private final boolean nFF;
    private final com.facebook.common.g.b nFG;
    private final boolean nFH;
    private final boolean nFI;
    private final int nFJ;
    private final int nFK;
    private boolean nFL;
    private final boolean nFM;
    private final c nFN;
    private final com.facebook.common.internal.j<Boolean> nFd;

    /* loaded from: classes25.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.nFD = aVar.nFD;
        this.nFE = aVar.nFE;
        this.nFF = aVar.nFF;
        this.nFG = aVar.nFG;
        this.nFH = aVar.nFH;
        this.nFI = aVar.nFI;
        this.nFJ = aVar.nFJ;
        this.nFK = aVar.nFK;
        this.nFL = aVar.nFL;
        this.nFM = aVar.nFM;
        if (aVar.nFN == null) {
            this.nFN = new b();
        } else {
            this.nFN = aVar.nFN;
        }
        this.nFd = aVar.nFd;
    }

    public boolean dXi() {
        return this.nFH;
    }

    public boolean dXj() {
        return this.nFD;
    }

    public boolean dXk() {
        return this.nFF;
    }

    public b.a dXl() {
        return this.nFE;
    }

    public com.facebook.common.g.b dXm() {
        return this.nFG;
    }

    public boolean dXn() {
        return this.nFI;
    }

    public int dXo() {
        return this.nFJ;
    }

    public int dXp() {
        return this.nFK;
    }

    public boolean dXq() {
        return this.nFM;
    }

    public c dXr() {
        return this.nFN;
    }

    public boolean dXs() {
        return this.nFL;
    }

    public com.facebook.common.internal.j<Boolean> dXt() {
        return this.nFd;
    }

    /* loaded from: classes25.dex */
    public static class a {
        private b.a nFE;
        private com.facebook.common.g.b nFG;
        private c nFN;
        private final h.a nFO;
        public com.facebook.common.internal.j<Boolean> nFd;
        private boolean nFD = false;
        private boolean nFF = false;
        private boolean nFH = false;
        private boolean nFI = false;
        private int nFJ = 0;
        private int nFK = 0;
        public boolean nFL = false;
        private boolean nFM = false;

        public a(h.a aVar) {
            this.nFO = aVar;
        }

        public i dXu() {
            return new i(this);
        }
    }

    /* loaded from: classes25.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
