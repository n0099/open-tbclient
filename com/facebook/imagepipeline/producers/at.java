package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class at implements ai<com.facebook.imagepipeline.f.d> {
    private final au<com.facebook.imagepipeline.f.d>[] klf;

    public at(au<com.facebook.imagepipeline.f.d>... auVarArr) {
        this.klf = (au[]) com.facebook.common.internal.g.checkNotNull(auVarArr);
        com.facebook.common.internal.g.cL(0, this.klf.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cKB().cLr() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c keO;
        private final aj kju;
        private final int klg;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.kju = ajVar;
            this.klg = i;
            this.keO = this.kju.cKB().cLr();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || av.a(dVar, this.keO))) {
                cKO().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!at.this.a(this.klg + 1, cKO(), this.kju)) {
                    cKO().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (!at.this.a(this.klg + 1, cKO(), this.kju)) {
                cKO().B(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.cKB().cLr());
        if (a2 == -1) {
            return false;
        }
        this.klf[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.klf.length) {
            if (!this.klf[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
