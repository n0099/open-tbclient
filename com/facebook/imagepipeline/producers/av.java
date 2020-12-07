package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pqw;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pqw = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pqw.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.ewv().exn() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pjW;
        private final ak poK;
        private final int pqx;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.poK = akVar;
            this.pqx = i;
            this.pjW = this.poK.ewv().exn();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Ri(i) || ax.a(eVar, this.pjW))) {
                ewI().h(eVar, i);
            } else if (Rh(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pqx + 1, ewI(), this.poK)) {
                    ewI().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.pqx + 1, ewI(), this.poK)) {
                ewI().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.ewv().exn());
        if (a2 == -1) {
            return false;
        }
        this.pqw[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pqw.length) {
            if (!this.pqw[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
