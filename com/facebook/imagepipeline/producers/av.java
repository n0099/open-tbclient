package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] mBG;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.mBG = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dj(0, this.mBG.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dBw().dCq() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final int mBH;
        private final com.facebook.imagepipeline.common.d mvj;
        private final ak mzV;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.mzV = akVar;
            this.mBH = i;
            this.mvj = this.mzV.dBw().dCq();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Ig(i) || ax.a(eVar, this.mvj))) {
                dBI().h(eVar, i);
            } else if (If(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.mBH + 1, dBI(), this.mzV)) {
                    dBI().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void F(Throwable th) {
            if (!av.this.a(this.mBH + 1, dBI(), this.mzV)) {
                dBI().G(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dBw().dCq());
        if (a2 == -1) {
            return false;
        }
        this.mBG[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.mBG.length) {
            if (!this.mBG[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
