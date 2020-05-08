package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] mgE;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.mgE = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.de(0, this.mgE.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dtQ().duK() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d maf;
        private final ak meU;
        private final int mgF;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.meU = akVar;
            this.mgF = i;
            this.maf = this.meU.dtQ().duK();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Hs(i) || ax.a(eVar, this.maf))) {
                duc().h(eVar, i);
            } else if (Hr(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.mgF + 1, duc(), this.meU)) {
                    duc().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (!av.this.a(this.mgF + 1, duc(), this.meU)) {
                duc().G(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dtQ().duK());
        if (a2 == -1) {
            return false;
        }
        this.mgE[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.mgE.length) {
            if (!this.mgE[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
