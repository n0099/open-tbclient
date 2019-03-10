package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> jJY;
    private final com.facebook.imagepipeline.c.l jKv;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.jJY = aiVar;
        this.jKv = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.czG().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
            return;
        }
        if (ajVar.czE().cAz()) {
            jVar = new a(jVar, ajVar, this.jKv);
        }
        this.jJY.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj jKj;
        private final com.facebook.imagepipeline.c.l jKv;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.jKj = ajVar;
            this.jKv = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.jKv.a(dVar, this.jKj.czE(), this.jKj.cva());
            }
            czR().e(dVar, z);
        }
    }
}
