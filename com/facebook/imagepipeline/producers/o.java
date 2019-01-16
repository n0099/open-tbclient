package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> itW;
    private final com.facebook.imagepipeline.c.l iut;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.itW = aiVar;
        this.iut = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.car().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
            return;
        }
        if (ajVar.cap().cbk()) {
            jVar = new a(jVar, ajVar, this.iut);
        }
        this.itW.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj iuh;
        private final com.facebook.imagepipeline.c.l iut;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.iuh = ajVar;
            this.iut = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.iut.a(dVar, this.iuh.cap(), this.iuh.bVS());
            }
            caC().e(dVar, z);
        }
    }
}
