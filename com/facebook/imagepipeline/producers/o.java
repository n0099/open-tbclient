package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> igJ;
    private final com.facebook.imagepipeline.c.l ihg;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.igJ = aiVar;
        this.ihg = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.bXs().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.e(null, true);
            return;
        }
        if (ajVar.bXq().bYl()) {
            jVar = new a(jVar, ajVar, this.ihg);
        }
        this.igJ.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj igU;
        private final com.facebook.imagepipeline.c.l ihg;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.igU = ajVar;
            this.ihg = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.ihg.a(dVar, this.igU.bXq(), this.igU.bST());
            }
            bXD().e(dVar, z);
        }
    }
}
