package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class at implements ai<com.facebook.imagepipeline.f.d> {
    private final au<com.facebook.imagepipeline.f.d>[] jLU;

    public at(au<com.facebook.imagepipeline.f.d>... auVarArr) {
        this.jLU = (au[]) com.facebook.common.internal.g.checkNotNull(auVarArr);
        com.facebook.common.internal.g.cz(0, this.jLU.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.czE().cAu() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c jFF;
        private final aj jKj;
        private final int jLV;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.jKj = ajVar;
            this.jLV = i;
            this.jFF = this.jKj.czE().cAu();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || av.a(dVar, this.jFF))) {
                czR().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!at.this.a(this.jLV + 1, czR(), this.jKj)) {
                    czR().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!at.this.a(this.jLV + 1, czR(), this.jKj)) {
                czR().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.czE().cAu());
        if (a2 == -1) {
            return false;
        }
        this.jLU[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.jLU.length) {
            if (!this.jLU[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
