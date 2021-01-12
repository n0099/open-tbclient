package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class a implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pBf;

    public a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pBf = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pBf.a(new C1049a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C1049a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private C1049a(k<com.facebook.imagepipeline.f.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar == null) {
                exc().g(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.f.e.d(eVar)) {
                eVar.evX();
            }
            exc().g(eVar, i);
        }
    }
}
