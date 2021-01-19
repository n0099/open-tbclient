package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pDe;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pDe = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pDe.length);
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
        private final ak pBt;
        private final int pDf;
        private final com.facebook.imagepipeline.common.d pwK;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pBt = akVar;
            this.pDf = i;
            this.pwK = this.pBt.ewP().exH();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (PP(i) || ax.a(eVar, this.pwK))) {
                exc().g(eVar, i);
            } else if (PO(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pDf + 1, exc(), this.pBt)) {
                    exc().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.pDf + 1, exc(), this.pBt)) {
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
        this.pDe[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pDe.length) {
            if (!this.pDe[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
