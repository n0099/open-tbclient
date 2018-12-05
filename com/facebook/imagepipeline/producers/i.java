package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class i implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> ipO;
    private final ai<com.facebook.imagepipeline.f.d> ipP;

    public i(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        this.ipO = aiVar;
        this.ipP = aiVar2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.ipO.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private aj ipQ;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ipQ = ajVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            ImageRequest bYR = this.ipQ.bYR();
            boolean a = au.a(dVar, bYR.bZH());
            if (dVar != null && (a || bYR.bZL())) {
                bZe().e(dVar, z && a);
            }
            if (z && !a) {
                com.facebook.imagepipeline.f.d.e(dVar);
                i.this.ipP.a(bZe(), this.ipQ);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            i.this.ipP.a(bZe(), this.ipQ);
        }
    }
}
