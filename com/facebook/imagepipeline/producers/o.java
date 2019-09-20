package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> kmM;
    private final com.facebook.imagepipeline.c.l knj;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.kmM = aiVar;
        this.knj = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cLM().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
            return;
        }
        if (ajVar.cLK().cMF()) {
            jVar = new a(jVar, ajVar, this.knj);
        }
        this.kmM.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj kmX;
        private final com.facebook.imagepipeline.c.l knj;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.kmX = ajVar;
            this.knj = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.knj.a(dVar, this.kmX.cLK(), this.kmX.cHd());
            }
            cLX().e(dVar, z);
        }
    }
}
