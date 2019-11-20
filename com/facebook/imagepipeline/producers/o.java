package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.l kkE;
    private final ai<com.facebook.imagepipeline.f.d> kkh;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.kkh = aiVar;
        this.kkE = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cIH().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.f(null, true);
            return;
        }
        if (ajVar.cIF().cJA()) {
            jVar = new a(jVar, ajVar, this.kkE);
        }
        this.kkh.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final com.facebook.imagepipeline.c.l kkE;
        private final aj kks;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.kks = ajVar;
            this.kkE = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.kkE.a(dVar, this.kks.cIF(), this.kks.cDZ());
            }
            cIS().f(dVar, z);
        }
    }
}
