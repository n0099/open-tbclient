package com.facebook.imagepipeline.c;

import android.content.Context;
import com.facebook.common.g.b;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.b.p;
import com.facebook.imagepipeline.c.h;
/* loaded from: classes15.dex */
public class i {
    private final com.facebook.common.internal.j<Boolean> plB;
    private final boolean pmb;
    private final b.a pmc;
    private final boolean pmd;
    private final com.facebook.common.g.b pme;
    private final boolean pmf;
    private final boolean pmg;
    private final int pmh;
    private final int pmi;
    private boolean pmj;
    private final boolean pmk;
    private final c pml;

    /* loaded from: classes15.dex */
    public interface c {
        l a(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, e eVar, com.facebook.common.memory.g gVar, p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, p<com.facebook.cache.common.b, PooledByteBuffer> pVar2, com.facebook.imagepipeline.b.e eVar2, com.facebook.imagepipeline.b.e eVar3, com.facebook.imagepipeline.b.f fVar, com.facebook.imagepipeline.a.f fVar2, int i, int i2, boolean z4);
    }

    private i(a aVar) {
        this.pmb = aVar.pmb;
        this.pmc = aVar.pmc;
        this.pmd = aVar.pmd;
        this.pme = aVar.pme;
        this.pmf = aVar.pmf;
        this.pmg = aVar.pmg;
        this.pmh = aVar.pmh;
        this.pmi = aVar.pmi;
        this.pmj = aVar.pmj;
        this.pmk = aVar.pmk;
        if (aVar.pml == null) {
            this.pml = new b();
        } else {
            this.pml = aVar.pml;
        }
        this.plB = aVar.plB;
    }

    public boolean eum() {
        return this.pmf;
    }

    public boolean eun() {
        return this.pmb;
    }

    public boolean euo() {
        return this.pmd;
    }

    public b.a eup() {
        return this.pmc;
    }

    public com.facebook.common.g.b euq() {
        return this.pme;
    }

    public boolean eur() {
        return this.pmg;
    }

    public int eus() {
        return this.pmh;
    }

    public int eut() {
        return this.pmi;
    }

    public boolean euu() {
        return this.pmk;
    }

    public c euv() {
        return this.pml;
    }

    public boolean euw() {
        return this.pmj;
    }

    public com.facebook.common.internal.j<Boolean> eux() {
        return this.plB;
    }

    /* loaded from: classes15.dex */
    public static class a {
        public com.facebook.common.internal.j<Boolean> plB;
        private b.a pmc;
        private com.facebook.common.g.b pme;
        private c pml;
        private final h.a pmm;
        private boolean pmb = false;
        private boolean pmd = false;
        private boolean pmf = false;
        private boolean pmg = false;
        private int pmh = 0;
        private int pmi = 0;
        public boolean pmj = false;
        private boolean pmk = false;

        public a(h.a aVar) {
            this.pmm = aVar;
        }

        public i euy() {
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
