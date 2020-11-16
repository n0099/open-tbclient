package com.facebook.imagepipeline.d;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.c.p;
import com.facebook.imagepipeline.d.h;
/* loaded from: classes15.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> oWK;
    private final boolean oXk;
    private final b.a oXl;
    private final boolean oXm;
    private final com.facebook.common.g.b oXn;
    private final boolean oXo;
    private final boolean oXp;
    private final int oXq;
    private final int oXr;
    private boolean oXs;
    private final boolean oXt;
    private final c oXu;

    /* loaded from: classes15.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.oXk = aVar.oXk;
        this.oXl = aVar.oXl;
        this.oXm = aVar.oXm;
        this.oXn = aVar.oXn;
        this.oXo = aVar.oXo;
        this.oXp = aVar.oXp;
        this.oXq = aVar.oXq;
        this.oXr = aVar.oXr;
        this.oXs = aVar.oXs;
        this.oXt = aVar.oXt;
        if (aVar.oXu == null) {
            this.oXu = new b();
        } else {
            this.oXu = aVar.oXu;
        }
        this.oWK = aVar.oWK;
    }

    public boolean eoG() {
        return this.oXo;
    }

    public boolean eoH() {
        return this.oXk;
    }

    public boolean eoI() {
        return this.oXm;
    }

    public b.a eoJ() {
        return this.oXl;
    }

    public com.facebook.common.g.b eoK() {
        return this.oXn;
    }

    public boolean eoL() {
        return this.oXp;
    }

    public int eoM() {
        return this.oXq;
    }

    public int eoN() {
        return this.oXr;
    }

    public boolean eoO() {
        return this.oXt;
    }

    public c eoP() {
        return this.oXu;
    }

    public boolean eoQ() {
        return this.oXs;
    }

    public com.facebook.common.internal.j<Boolean> eoR() {
        return this.oWK;
    }

    /* loaded from: classes15.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> oWK;
        private b.a oXl;
        private com.facebook.common.g.b oXn;
        private c oXu;
        private final h.a oXv;
        private boolean oXk = false;
        private boolean oXm = false;
        private boolean oXo = false;
        private boolean oXp = false;
        private int oXq = 0;
        private int oXr = 0;
        public boolean oXs = false;
        private boolean oXt = false;

        public a(h.a aVar) {
            this.oXv = aVar;
        }

        public i eoS() {
            return new i(this);
        }
    }

    /* loaded from: classes15.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.d.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.c.e eVar2, com.facebook.imagepipeline.c.e eVar3, com.facebook.imagepipeline.c.f fVar, com.facebook.imagepipeline.b.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
