package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes15.dex */
public class i {
    private final boolean plZ;
    private final com.facebook.common.internal.j<Boolean> plz;
    private final b.a pma;
    private final boolean pmb;
    private final com.facebook.common.g.b pmc;
    private final boolean pmd;
    private final boolean pme;
    private final int pmf;
    private final int pmg;
    private boolean pmh;
    private final boolean pmi;
    private final c pmj;

    /* loaded from: classes15.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.plZ = aVar.plZ;
        this.pma = aVar.pma;
        this.pmb = aVar.pmb;
        this.pmc = aVar.pmc;
        this.pmd = aVar.pmd;
        this.pme = aVar.pme;
        this.pmf = aVar.pmf;
        this.pmg = aVar.pmg;
        this.pmh = aVar.pmh;
        this.pmi = aVar.pmi;
        if (aVar.pmj == null) {
            this.pmj = new b();
        } else {
            this.pmj = aVar.pmj;
        }
        this.plz = aVar.plz;
    }

    public boolean eul() {
        return this.pmd;
    }

    public boolean eum() {
        return this.plZ;
    }

    public boolean eun() {
        return this.pmb;
    }

    public b.a euo() {
        return this.pma;
    }

    public com.facebook.common.g.b eup() {
        return this.pmc;
    }

    public boolean euq() {
        return this.pme;
    }

    public int eur() {
        return this.pmf;
    }

    public int eus() {
        return this.pmg;
    }

    public boolean eut() {
        return this.pmi;
    }

    public c euu() {
        return this.pmj;
    }

    public boolean euv() {
        return this.pmh;
    }

    public com.facebook.common.internal.j<Boolean> euw() {
        return this.plz;
    }

    /* loaded from: classes15.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> plz;
        private b.a pma;
        private com.facebook.common.g.b pmc;
        private c pmj;
        private final h.a pmk;
        private boolean plZ = false;
        private boolean pmb = false;
        private boolean pmd = false;
        private boolean pme = false;
        private int pmf = 0;
        private int pmg = 0;
        public boolean pmh = false;
        private boolean pmi = false;

        public a(h.a aVar) {
            this.pmk = aVar;
        }

        public i eux() {
            return new i(this);
        }
    }

    /* loaded from: classes15.dex */
    public static class b implements c {
        @Override // com.facebook.imagepipeline.c.i.c
        public l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4) {
            return new l(context, aVar, bVar, dVar, z, z2, z3, eVar, gVar, pVar, pVar2, eVar2, eVar3, fVar, fVar2, i, i2, z4);
        }
    }
}
