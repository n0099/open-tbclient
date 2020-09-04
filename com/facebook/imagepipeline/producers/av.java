package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] nAa;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.nAa = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dC(0, this.nAa.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dVx().dWr() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final int nAb;
        private final com.facebook.imagepipeline.common.d ntB;
        private final ak nyq;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.nyq = akVar;
            this.nAb = i;
            this.ntB = this.nyq.dVx().dWr();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Mm(i) || ax.a(eVar, this.ntB))) {
                dVJ().h(eVar, i);
            } else if (Ml(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.nAb + 1, dVJ(), this.nyq)) {
                    dVJ().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.nAb + 1, dVJ(), this.nyq)) {
                dVJ().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dVx().dWr());
        if (a2 == -1) {
            return false;
        }
        this.nAa[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.nAa.length) {
            if (!this.nAa[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
