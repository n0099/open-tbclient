package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lXj;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lXj = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dt(0, this.lXj.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dry().dst() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lQL;
        private final ak lVz;
        private final int lXk;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lVz = akVar;
            this.lXk = i;
            this.lQL = this.lVz.dry().dst();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (IK(i) || ax.a(eVar, this.lQL))) {
                drK().g(eVar, i);
            } else if (IJ(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lXk + 1, drK(), this.lVz)) {
                    drK().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.lXk + 1, drK(), this.lVz)) {
                drK().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dry().dst());
        if (a2 == -1) {
            return false;
        }
        this.lXj[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lXj.length) {
            if (!this.lXj[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
