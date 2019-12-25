package com.facebook.imagepipeline.producers;
/* loaded from: classes9.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lSw;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lSw = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.ds(0, this.lSw.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.doX().dpP() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lMb;
        private final ak lQM;
        private final int lSx;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lQM = akVar;
            this.lSx = i;
            this.lMb = this.lQM.doX().dpP();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Iw(i) || ax.a(eVar, this.lMb))) {
                dpj().g(eVar, i);
            } else if (Iv(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lSx + 1, dpj(), this.lQM)) {
                    dpj().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.lSx + 1, dpj(), this.lQM)) {
                dpj().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.doX().dpP());
        if (a2 == -1) {
            return false;
        }
        this.lSw[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lSw.length) {
            if (!this.lSw[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
