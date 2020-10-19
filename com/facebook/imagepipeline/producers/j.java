package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes18.dex */
public class j implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> nXC;
    private final aj<com.facebook.imagepipeline.g.e> nXD;

    public j(aj<com.facebook.imagepipeline.g.e> ajVar, aj<com.facebook.imagepipeline.g.e> ajVar2) {
        this.nXC = ajVar;
        this.nXD = ajVar2;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.nXC.c(new a(kVar, akVar), akVar);
    }

    /* loaded from: classes18.dex */
    private class a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private ak nXE;

        private a(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
            super(kVar);
            this.nXE = akVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            ImageRequest edg = this.nXE.edg();
            boolean Nw = Nw(i);
            boolean a2 = ax.a(eVar, edg.eea());
            if (eVar != null && (a2 || edg.eee())) {
                if (Nw && a2) {
                    eds().h(eVar, i);
                } else {
                    eds().h(eVar, dM(i, 1));
                }
            }
            if (Nw && !a2) {
                com.facebook.imagepipeline.g.e.e(eVar);
                j.this.nXD.c(eds(), this.nXE);
            }
        }

        @Override // com.facebook.imagepipeline.producers.n, com.facebook.imagepipeline.producers.b
        protected void D(Throwable th) {
            j.this.nXD.c(eds(), this.nXE);
        }
    }
}
