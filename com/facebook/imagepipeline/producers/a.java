package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class a implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> poz;

    public a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.poz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.poz.a(new C0999a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    private static class C0999a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private C0999a(k<com.facebook.imagepipeline.f.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void g(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar == null) {
                ewJ().h(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.f.e.d(eVar)) {
                eVar.evE();
            }
            ewJ().h(eVar, i);
        }
    }
}
