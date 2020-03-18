package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lYP;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lYP = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.du(0, this.lYP.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drV().dsQ() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lSr;
        private final ak lXf;
        private final int lYQ;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lXf = akVar;
            this.lYQ = i;
            this.lSr = this.lXf.drV().dsQ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (IQ(i) || ax.a(eVar, this.lSr))) {
                dsh().g(eVar, i);
            } else if (IP(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lYQ + 1, dsh(), this.lXf)) {
                    dsh().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.lYQ + 1, dsh(), this.lXf)) {
                dsh().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.drV().dsQ());
        if (a2 == -1) {
            return false;
        }
        this.lYP[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lYP.length) {
            if (!this.lYP[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
