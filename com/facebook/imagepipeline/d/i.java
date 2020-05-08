package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> mbM;
    private final boolean mcm;
    private final b.a mcn;
    private final boolean mco;
    private final com.facebook.common.g.b mcp;
    private final boolean mcq;
    private final boolean mcr;
    private final int mcs;
    private final int mct;
    private boolean mcu;
    private final boolean mcv;
    private final c mcw;

    /* loaded from: classes12.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.mcm = aVar.mcm;
        this.mcn = aVar.mcn;
        this.mco = aVar.mco;
        this.mcp = aVar.mcp;
        this.mcq = aVar.mcq;
        this.mcr = aVar.mcr;
        this.mcs = aVar.mcs;
        this.mct = aVar.mct;
        this.mcu = aVar.mcu;
        this.mcv = aVar.mcv;
        if (aVar.mcw == null) {
            this.mcw = new b();
        } else {
            this.mcw = aVar.mcw;
        }
        this.mbM = aVar.mbM;
    }

    public boolean drC() {
        return this.mcq;
    }

    public boolean drD() {
        return this.mcm;
    }

    public boolean drE() {
        return this.mco;
    }

    public b.a drF() {
        return this.mcn;
    }

    public com.facebook.common.g.b drG() {
        return this.mcp;
    }

    public boolean drH() {
        return this.mcr;
    }

    public int drI() {
        return this.mcs;
    }

    public int drJ() {
        return this.mct;
    }

    public boolean drK() {
        return this.mcv;
    }

    public c drL() {
        return this.mcw;
    }

    public boolean drM() {
        return this.mcu;
    }

    public com.facebook.common.internal.j<Boolean> drN() {
        return this.mbM;
    }

    /* loaded from: classes12.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> mbM;
        private b.a mcn;
        private com.facebook.common.g.b mcp;
        private c mcw;
        private final h.a mcx;
        private boolean mcm = false;
        private boolean mco = false;
        private boolean mcq = false;
        private boolean mcr = false;
        private int mcs = 0;
        private int mct = 0;
        public boolean mcu = false;
        private boolean mcv = false;

        public a(h.a aVar) {
            this.mcx = aVar;
        }

        public i drO() {
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
