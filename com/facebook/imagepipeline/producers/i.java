package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class i implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> klh;
    private final ai<com.facebook.imagepipeline.f.d> kli;

    public i(ai<com.facebook.imagepipeline.f.d> aiVar, ai<com.facebook.imagepipeline.f.d> aiVar2) {
        this.klh = aiVar;
        this.kli = aiVar2;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.klh.a(new a(jVar, ajVar), ajVar);
    }

    /* loaded from: classes2.dex */
    private class a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private aj klj;

        private a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
            super(jVar);
            this.klj = ajVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.d dVar, boolean z) {
            ImageRequest cIH = this.klj.cIH();
            boolean a = av.a(dVar, cIH.cJx());
            if (dVar != null && (a || cIH.cJB())) {
                cIU().f(dVar, z && a);
            }
            if (z && !a) {
                com.facebook.imagepipeline.f.d.e(dVar);
                i.this.kli.a(cIU(), this.klj);
            }
        }

        @Override // com.facebook.imagepipeline.producers.m, com.facebook.imagepipeline.producers.b
        protected void z(Throwable th) {
            i.this.kli.a(cIU(), this.klj);
        }
    }
}
