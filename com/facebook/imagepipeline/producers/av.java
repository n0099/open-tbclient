package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pNm;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pNm = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dV(0, this.pNm.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ezh().ezZ() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pGS;
        private final ak pLB;
        private final int pNn;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.pLB = akVar;
            this.pNn = i;
            this.pGS = this.pLB.ezh().ezZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Qk(i) || ax.a(eVar, this.pGS))) {
                ezu().g(eVar, i);
            } else if (Qj(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pNn + 1, ezu(), this.pLB)) {
                    ezu().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!av.this.a(this.pNn + 1, ezu(), this.pLB)) {
                ezu().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.ezh().ezZ());
        if (a2 == -1) {
            return false;
        }
        this.pNm[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pNm.length) {
            if (!this.pNm[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
