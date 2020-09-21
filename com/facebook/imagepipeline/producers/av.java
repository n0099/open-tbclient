package com.facebook.imagepipeline.producers;
/* loaded from: classes25.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nJX;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nJX = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dG(0, this.nJX.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dZv().eap() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d nDz;
        private final ak nIn;
        private final int nJY;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.nIn = akVar;
            this.nJY = i;
            this.nDz = this.nIn.dZv().eap();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (MR(i) || ax.a(eVar, this.nDz))) {
                dZH().h(eVar, i);
            } else if (MQ(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nJY + 1, dZH(), this.nIn)) {
                    dZH().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.nJY + 1, dZH(), this.nIn)) {
                dZH().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dZv().eap());
        if (a2 == -1) {
            return false;
        }
        this.nJX[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nJX.length) {
            if (!this.nJX[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
