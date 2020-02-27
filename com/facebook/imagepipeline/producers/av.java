package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lWW;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lWW = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dt(0, this.lWW.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.drv().dsq() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lQy;
        private final ak lVm;
        private final int lWX;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lVm = akVar;
            this.lWX = i;
            this.lQy = this.lVm.drv().dsq();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (IK(i) || ax.a(eVar, this.lQy))) {
                drH().g(eVar, i);
            } else if (IJ(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lWX + 1, drH(), this.lVm)) {
                    drH().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.lWX + 1, drH(), this.lVm)) {
                drH().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.drv().dsq());
        if (a2 == -1) {
            return false;
        }
        this.lWW[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lWW.length) {
            if (!this.lWW[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
