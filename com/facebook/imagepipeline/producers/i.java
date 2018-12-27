package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class i implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> isY;
    private final ai<com.facebook.imagepipeline.f.d> isZ;

    public i(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        this.isY = aiVar;
        this.isZ = aiVar2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.isY.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private aj ita;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.ita = ajVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            ImageRequest bZH = this.ita.bZH();
            boolean a = au.a(dVar, bZH.cax());
            if (dVar != null && (a || bZH.caB())) {
                bZU().e(dVar, z && a);
            }
            if (z && !a) {
                com.facebook.imagepipeline.f.d.e(dVar);
                i.this.isZ.a(bZU(), this.ita);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void A(Throwable th) {
            i.this.isZ.a(bZU(), this.ita);
        }
    }
}
