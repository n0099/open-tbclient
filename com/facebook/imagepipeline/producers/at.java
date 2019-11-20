package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class at implements ai<com.facebook.imagepipeline.f.d> {
    private final au<com.facebook.imagepipeline.f.d>[] kmd;

    public at(au<com.facebook.imagepipeline.f.d>... auVarArr) {
        this.kmd = (au[]) com.facebook.common.internal.g.checkNotNull(auVarArr);
        com.facebook.common.internal.g.cB(0, this.kmd.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cIF().cJv() == null) {
            jVar.f(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.f(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c kfL;
        private final aj kks;
        private final int kme;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.kks = ajVar;
            this.kme = i;
            this.kfL = this.kks.cIF().cJv();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || av.a(dVar, this.kfL))) {
                cIS().f(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!at.this.a(this.kme + 1, cIS(), this.kks)) {
                    cIS().f(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (!at.this.a(this.kme + 1, cIS(), this.kks)) {
                cIS().B(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.cIF().cJv());
        if (a2 == -1) {
            return false;
        }
        this.kmd[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.kmd.length) {
            if (!this.kmd[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
