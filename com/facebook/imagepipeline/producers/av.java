package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] oZZ;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.oZZ = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dS(0, this.oZZ.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqV().erP() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d oTD;
        private final ak oYp;
        private final int paa;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.oYp = akVar;
            this.paa = i;
            this.oTD = this.oYp.eqV().erP();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (PJ(i) || ax.a(eVar, this.oTD))) {
                erh().h(eVar, i);
            } else if (PI(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.paa + 1, erh(), this.oYp)) {
                    erh().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.paa + 1, erh(), this.oYp)) {
                erh().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.eqV().erP());
        if (a2 == -1) {
            return false;
        }
        this.oZZ[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.oZZ.length) {
            if (!this.oZZ[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
