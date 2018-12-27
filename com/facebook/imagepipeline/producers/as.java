package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class as implements ai<com.facebook.imagepipeline.f.d> {
    private final at<com.facebook.imagepipeline.f.d>[] iuJ;

    public as(at<com.facebook.imagepipeline.f.d>... atVarArr) {
        this.iuJ = (at[]) com.facebook.common.internal.g.checkNotNull(atVarArr);
        com.facebook.common.internal.g.ce(0, this.iuJ.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.bZH().cax() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c ioy;
        private final aj ita;
        private final int iuK;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.ita = ajVar;
            this.iuK = i;
            this.ioy = this.ita.bZH().cax();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || au.a(dVar, this.ioy))) {
                bZU().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!as.this.a(this.iuK + 1, bZU(), this.ita)) {
                    bZU().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (!as.this.a(this.iuK + 1, bZU(), this.ita)) {
                bZU().B(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.bZH().cax());
        if (a2 == -1) {
            return false;
        }
        this.iuJ[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.iuJ.length) {
            if (!this.iuJ[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
