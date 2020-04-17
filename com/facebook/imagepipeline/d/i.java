package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mbI;
    private final boolean mci;
    private final b.a mcj;
    private final boolean mck;
    private final com.facebook.common.g.b mcl;
    private final boolean mcm;
    private final boolean mcn;
    private final int mco;
    private final int mcp;
    private boolean mcq;
    private final boolean mcr;
    private final c mcs;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mci = aVar.mci;
        this.mcj = aVar.mcj;
        this.mck = aVar.mck;
        this.mcl = aVar.mcl;
        this.mcm = aVar.mcm;
        this.mcn = aVar.mcn;
        this.mco = aVar.mco;
        this.mcp = aVar.mcp;
        this.mcq = aVar.mcq;
        this.mcr = aVar.mcr;
        if (aVar.mcs == null) {
            this.mcs = new b();
        } else {
            this.mcs = aVar.mcs;
        }
        this.mbI = aVar.mbI;
    }

    public boolean drF() {
        return this.mcm;
    }

    public boolean drG() {
        return this.mci;
    }

    public boolean drH() {
        return this.mck;
    }

    public b.a drI() {
        return this.mcj;
    }

    public com.facebook.common.g.b drJ() {
        return this.mcl;
    }

    public boolean drK() {
        return this.mcn;
    }

    public int drL() {
        return this.mco;
    }

    public int drM() {
        return this.mcp;
    }

    public boolean drN() {
        return this.mcr;
    }

    public c drO() {
        return this.mcs;
    }

    public boolean drP() {
        return this.mcq;
    }

    public com.facebook.common.internal.j<Boolean> drQ() {
        return this.mbI;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mbI;
        private b.a mcj;
        private com.facebook.common.g.b mcl;
        private c mcs;
        private final h.a mct;
        private boolean mci = false;
        private boolean mck = false;
        private boolean mcm = false;
        private boolean mcn = false;
        private int mco = 0;
        private int mcp = 0;
        public boolean mcq = false;
        private boolean mcr = false;

        public a(h.a aVar) {
            this.mct = aVar;
        }

        public i drR() {
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
