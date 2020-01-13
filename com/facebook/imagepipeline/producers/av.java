package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class av implements aj<com.facebook.imagepipeline.g.e> {
    private final aw<com.facebook.imagepipeline.g.e>[] lWk;

    public av(aw<com.facebook.imagepipeline.g.e>... awVarArr) {
        this.lWk = (aw[]) com.facebook.common.internal.g.checkNotNull(awVarArr);
        com.facebook.common.internal.g.dq(0, this.lWk.length);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        if (akVar.dqh().drc() == null) {
            kVar.g(null, 1);
        } else if (!a(0, kVar, akVar)) {
            kVar.g(null, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private final com.facebook.imagepipeline.common.d lPM;
        private final ak lUA;
        private final int lWl;

        public a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar, int i) {
            super(kVar);
            this.lUA = akVar;
            this.lWl = i;
            this.lPM = this.lUA.dqh().drc();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar != null && (IF(i) || ax.a(eVar, this.lPM))) {
                dqt().g(eVar, i);
            } else if (IE(i)) {
                com.facebook.imagepipeline.g.e.e(eVar);
                if (!av.this.a(this.lWl + 1, dqt(), this.lUA)) {
                    dqt().g(null, 1);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void C(Throwable th) {
            if (!av.this.a(this.lWl + 1, dqt(), this.lUA)) {
                dqt().D(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        int a2 = a(i, akVar.dqh().drc());
        if (a2 == -1) {
            return false;
        }
        this.lWk[a2].c(new a(kVar, akVar, a2), akVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.d dVar) {
        while (i < this.lWk.length) {
            if (!this.lWk[i].a(dVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
