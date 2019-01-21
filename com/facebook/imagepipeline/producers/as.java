package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class as implements ai<com.facebook.imagepipeline.f.d> {
    private final at<com.facebook.imagepipeline.f.d>[] ivR;

    public as(at<com.facebook.imagepipeline.f.d>... atVarArr) {
        this.ivR = (at[]) com.facebook.common.internal.g.checkNotNull(atVarArr);
        com.facebook.common.internal.g.ce(0, this.ivR.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cap().cbf() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c ipG;
        private final aj iui;
        private final int ivS;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.iui = ajVar;
            this.ivS = i;
            this.ipG = this.iui.cap().cbf();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || au.a(dVar, this.ipG))) {
                caC().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!as.this.a(this.ivS + 1, caC(), this.iui)) {
                    caC().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (!as.this.a(this.ivS + 1, caC(), this.iui)) {
                caC().B(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.cap().cbf());
        if (a2 == -1) {
            return false;
        }
        this.ivR[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.ivR.length) {
            if (!this.ivR[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
