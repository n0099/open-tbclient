package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class a implements aj<com.facebook.imagepipeline.g.e> {
    private final aj<com.facebook.imagepipeline.g.e> lUs;

    public a(aj<com.facebook.imagepipeline.g.e> ajVar) {
        this.lUs = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        this.lUs.c(new C0659a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0659a extends n<com.facebook.imagepipeline.g.e, com.facebook.imagepipeline.g.e> {
        private C0659a(k<com.facebook.imagepipeline.g.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void f(com.facebook.imagepipeline.g.e eVar, int i) {
            if (eVar == null) {
                dqv().g(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.g.e.d(eVar)) {
                eVar.dpn();
            }
            dqv().g(eVar, i);
        }
    }
}
