package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class as implements ai<com.facebook.imagepipeline.f.d> {
    private final at<com.facebook.imagepipeline.f.d>[] iiC;

    public as(at<com.facebook.imagepipeline.f.d>... atVarArr) {
        this.iiC = (at[]) com.facebook.common.internal.g.checkNotNull(atVarArr);
        com.facebook.common.internal.g.cb(0, this.iiC.length);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.bXq().bYg() == null) {
            jVar.e(null, true);
        } else if (!a(0, jVar, ajVar)) {
            jVar.e(null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.common.c ico;
        private final aj igT;
        private final int iiD;

        public a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, int i) {
            super(jVar);
            this.igT = ajVar;
            this.iiD = i;
            this.ico = this.igT.bXq().bYg();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && (!z || au.a(dVar, this.ico))) {
                bXD().e(dVar, z);
            } else if (z) {
                com.facebook.imagepipeline.f.d.e(dVar);
                if (!as.this.a(this.iiD + 1, bXD(), this.igT)) {
                    bXD().e(null, true);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            if (!as.this.a(this.iiD + 1, bXD(), this.igT)) {
                bXD().B(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        int a2 = a(i, ajVar.bXq().bYg());
        if (a2 == -1) {
            return false;
        }
        this.iiC[a2].a(new a(jVar, ajVar, a2), ajVar);
        return true;
    }

    private int a(int i, com.facebook.imagepipeline.common.c cVar) {
        while (i < this.iiC.length) {
            if (!this.iiC[i].a(cVar)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }
}
