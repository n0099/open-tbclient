package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class a implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> mzI;

    public a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.mzI = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.mzI.c(new C0788a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static class C0788a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private C0788a(k<com.facebook.imagepipeline.g.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar == null) {
                dBI().h(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.g.e.d(eVar)) {
                eVar.dAB();
            }
            dBI().h(eVar, i);
        }
    }
}
