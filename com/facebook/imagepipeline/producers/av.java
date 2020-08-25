package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nzI;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nzI = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dC(0, this.nzI.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dVo().dWi() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d ntj;
        private final ak nxY;
        private final int nzJ;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.nxY = akVar;
            this.nzJ = i;
            this.ntj = this.nxY.dVo().dWi();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Mm(i) || ax.a(eVar, this.ntj))) {
                dVA().h(eVar, i);
            } else if (Ml(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nzJ + 1, dVA(), this.nxY)) {
                    dVA().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.nzJ + 1, dVA(), this.nxY)) {
                dVA().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dVo().dWi());
        if (a2 == -1) {
            return false;
        }
        this.nzI[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nzI.length) {
            if (!this.nzI[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
