package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class a implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> oYc;

    public a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.oYc = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.oYc.c(new C0981a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static class C0981a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private C0981a(k<com.facebook.imagepipeline.g.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar == null) {
                erh().h(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.g.e.d(eVar)) {
                eVar.eqa();
            }
            erh().h(eVar, i);
        }
    }
}
