package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pDd;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pDd = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pDd.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewP().exH() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final ak pBs;
        private final int pDe;
        private final com.facebook.imagepipeline.common.d pwJ;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pBs = akVar;
            this.pDe = i;
            this.pwJ = this.pBs.ewP().exH();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (PP(i) || ax.a(eVar, this.pwJ))) {
                exc().g(eVar, i);
            } else if (PO(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pDe + 1, exc(), this.pBs)) {
                    exc().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.pDe + 1, exc(), this.pBs)) {
                exc().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.ewP().exH());
        if (a2 == -1) {
            return false;
        }
        this.pDd[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pDd.length) {
            if (!this.pDd[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
