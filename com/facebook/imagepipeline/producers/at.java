package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class at implements ai<com.facebook.imagepipeline.f.d> {
    private final au<com.facebook.imagepipeline.f.d>[] jLB;

    public at(au<com.facebook.imagepipeline.f.d>... auVarArr) {
        this.jLB = (au[]) com.facebook.common.internal.g.checkNotNull(auVarArr);
        com.facebook.common.internal.g.cz(0, this.jLB.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.czu().cAk() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c jFm;
        private final aj jJQ;
        private final int jLC;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.jJQ = ajVar;
            this.jLC = i;
            this.jFm = this.jJQ.czu().cAk();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || av.a(dVar, this.jFm))) {
                czH().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!at.this.a(this.jLC + 1, czH(), this.jJQ)) {
                    czH().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            if (!at.this.a(this.jLC + 1, czH(), this.jJQ)) {
                czH().C(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.czu().cAk());
        if (a2 == -1) {
            return false;
        }
        this.jLB[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.jLB.length) {
            if (!this.jLB[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
