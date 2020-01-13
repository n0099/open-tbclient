package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes10.dex */
public class i {
    private final boolean lRQ;
    private final b.a lRR;
    private final boolean lRS;
    private final com.facebook.common.g.b lRT;
    private final boolean lRU;
    private final boolean lRV;
    private final int lRW;
    private final int lRX;
    private boolean lRY;
    private final boolean lRZ;
    private final com.facebook.common.internal.j<Boolean> lRq;
    private final c lSa;

    /* loaded from: classes10.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.lRQ = aVar.lRQ;
        this.lRR = aVar.lRR;
        this.lRS = aVar.lRS;
        this.lRT = aVar.lRT;
        this.lRU = aVar.lRU;
        this.lRV = aVar.lRV;
        this.lRW = aVar.lRW;
        this.lRX = aVar.lRX;
        this.lRY = aVar.lRY;
        this.lRZ = aVar.lRZ;
        if (aVar.lSa == null) {
            this.lSa = new b();
        } else {
            this.lSa = aVar.lSa;
        }
        this.lRq = aVar.lRq;
    }

    public boolean dnT() {
        return this.lRU;
    }

    public boolean dnU() {
        return this.lRQ;
    }

    public boolean dnV() {
        return this.lRS;
    }

    public b.a dnW() {
        return this.lRR;
    }

    public com.facebook.common.g.b dnX() {
        return this.lRT;
    }

    public boolean dnY() {
        return this.lRV;
    }

    public int dnZ() {
        return this.lRW;
    }

    public int doa() {
        return this.lRX;
    }

    public boolean dob() {
        return this.lRZ;
    }

    public c doc() {
        return this.lSa;
    }

    public boolean dod() {
        return this.lRY;
    }

    public com.facebook.common.internal.j<Boolean> doe() {
        return this.lRq;
    }

    /* loaded from: classes10.dex */
    public static class a {
        private b.a lRR;
        private com.facebook.common.g.b lRT;
        public com.facebook.common.internal.j<Boolean> lRq;
        private c lSa;
        private final h.a lSb;
        private boolean lRQ = false;
        private boolean lRS = false;
        private boolean lRU = false;
        private boolean lRV = false;
        private int lRW = 0;
        private int lRX = 0;
        public boolean lRY = false;
        private boolean lRZ = false;

        public a(h.a aVar) {
            this.lSb = aVar;
        }

        public i dof() {
            return new i(this);
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
