package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class j implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pOe;
    private final aj<com.facebook.imagepipeline.f.e> pOf;

    public j(aj<com.facebook.imagepipeline.f.e> ajVar, aj<com.facebook.imagepipeline.f.e> ajVar2) {
        this.pOe = ajVar;
        this.pOf = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pOe.a(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes5.dex */
    private class a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private ak pOg;

        private a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
            super(kVar);
            this.pOg = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            ImageRequest ezy = this.pOg.ezy();
            boolean Qo = Qo(i);
            boolean a2 = ax.a(eVar, ezy.eAq());
            if (eVar != null && (a2 || ezy.eAu())) {
                if (Qo && a2) {
                    ezL().f(eVar, i);
                } else {
                    ezL().f(eVar, ec(i, 1));
                }
            }
            if (Qo && !a2) {
                com.facebook.imagepipeline.f.e.e(eVar);
                j.this.pOf.a(ezL(), this.pOg);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void B(Throwable th) {
            j.this.pOf.a(ezL(), this.pOg);
        }
    }
}
