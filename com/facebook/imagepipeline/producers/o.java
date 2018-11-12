package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.l iiQ;
    private final ai<com.facebook.imagepipeline.f.d> iit;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.iit = aiVar;
        this.iiQ = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.bWN().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
            return;
        }
        if (ajVar.bWL().bXG()) {
            jVar = new a(jVar, ajVar, this.iiQ);
        }
        this.iit.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj iiE;
        private final com.facebook.imagepipeline.c.l iiQ;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.iiE = ajVar;
            this.iiQ = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.iiQ.a(dVar, this.iiE.bWL(), this.iiE.bSo());
            }
            bWY().e(dVar, z);
        }
    }
}
