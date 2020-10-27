package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] oQG;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.oQG = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dP(0, this.oQG.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.enf().enZ() == null) {
            kVar.h(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.h(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d oKk;
        private final ak oOW;
        private final int oQH;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.oOW = akVar;
            this.oQH = i;
            this.oKk = this.oOW.enf().enZ();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (Po(i) || ax.a(eVar, this.oKk))) {
                enr().h(eVar, i);
            } else if (Pn(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.oQH + 1, enr(), this.oOW)) {
                    enr().h(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            if (!av.this.a(this.oQH + 1, enr(), this.oOW)) {
                enr().E(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.enf().enZ());
        if (a2 == -1) {
            return false;
        }
        this.oQG[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.oQG.length) {
            if (!this.oQG[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
