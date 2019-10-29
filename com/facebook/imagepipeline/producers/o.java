package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class o implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> kkY;
    private final com.facebook.imagepipeline.c.l klv;

    public o(ai<com.facebook.imagepipeline.f.d> aiVar, com.facebook.imagepipeline.c.l lVar) {
        this.kkY = aiVar;
        this.klv = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        c(jVar, ajVar);
    }

    private void c(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        if (ajVar.cIJ().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            jVar.f(null, true);
            return;
        }
        if (ajVar.cIH().cJC()) {
            jVar = new a(jVar, ajVar, this.klv);
        }
        this.kkY.a(jVar, ajVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private final aj klj;
        private final com.facebook.imagepipeline.c.l klv;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar, com.facebook.imagepipeline.c.l lVar) {
            super(jVar);
            this.klj = ajVar;
            this.klv = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar != null && z) {
                this.klv.a(dVar, this.klj.cIH(), this.klj.cEb());
            }
            cIU().f(dVar, z);
        }
    }
}
