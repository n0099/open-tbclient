package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class a implements aj<com.facebook.imagepipeline.f.e> {
    private final aj<com.facebook.imagepipeline.f.e> pNT;

    public a(aj<com.facebook.imagepipeline.f.e> ajVar) {
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        this.pNT.a(new C1070a(kVar), akVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C1070a extends n<com.facebook.imagepipeline.f.e, com.facebook.imagepipeline.f.e> {
        private C1070a(k<com.facebook.imagepipeline.f.e> kVar) {
            super(kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void e(com.facebook.imagepipeline.f.e eVar, int i) {
            if (eVar == null) {
                ezL().f(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.f.e.d(eVar)) {
                eVar.eyH();
            }
            ezL().f(eVar, i);
        }
    }
}
