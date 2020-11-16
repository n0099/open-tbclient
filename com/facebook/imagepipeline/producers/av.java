package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] pbE;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.pbE = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dT(0, this.pbE.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.eqT().erN() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d oVg;
        private final ak oZS;
        private final int pbF;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.oZS = akVar;
            this.pbF = i;
            this.oVg = this.oZS.eqT().erN();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Qm(i) || ax.a(eVar, this.oVg))) {
                erf().h(eVar, i);
            } else if (Ql(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.pbF + 1, erf(), this.oZS)) {
                    erf().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.pbF + 1, erf(), this.oZS)) {
                erf().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.eqT().erN());
        if (a2 == -1) {
            return false;
        }
        this.pbE[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pbE.length) {
            if (!this.pbE[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
