package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class av implements aj<com.facebook.imagepipeline.f.e> {
    private final aw<com.facebook.imagepipeline.f.e>[] pqy;

    public av(aw<com.facebook.imagepipeline.f.e>... awVarArr) {
        this.pqy = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dY(0, this.pqy.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        if (akVar.eww().exo() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private final com.facebook.imagepipeline.common.d pjY;
        private final ak poM;
        private final int pqz;

        public a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar, int i) {
            super(kVar);
            this.poM = akVar;
            this.pqz = i;
            this.pjY = this.poM.eww().exo();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar != null && (Ri(i) || ax.a(eVar, this.pjY))) {
                ewJ().h(eVar, i);
            } else if (Rh(i)) {
                com.facebook.imagepipeline.f.e.e(eVar);
                if (!av.this.a(this.pqz + 1, ewJ(), this.poM)) {
                    ewJ().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.pqz + 1, ewJ(), this.poM)) {
                ewJ().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        int a2 = a(i, akVar.eww().exo());
        if (a2 == -1) {
            return false;
        }
        this.pqy[a2].a(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.pqy.length) {
            if (!this.pqy[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
