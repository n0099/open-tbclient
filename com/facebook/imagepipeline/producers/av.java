package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nZo;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nZo = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dG(0, this.nZo.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.edg().eea() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d nSS;
        private final ak nXE;
        private final int nZp;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.nXE = akVar;
            this.nZp = i;
            this.nSS = this.nXE.edg().eea();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Nx(i) || ax.a(eVar, this.nSS))) {
                eds().h(eVar, i);
            } else if (Nw(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nZp + 1, eds(), this.nXE)) {
                    eds().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.nZp + 1, eds(), this.nXE)) {
                eds().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.edg().eea());
        if (a2 == -1) {
            return false;
        }
        this.nZo[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nZo.length) {
            if (!this.nZo[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
