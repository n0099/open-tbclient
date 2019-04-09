package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class a implements ai<com.facebook.imagepipeline.f.d> {
    private final ai<com.facebook.imagepipeline.f.d> jJl;

    public a(ai<com.facebook.imagepipeline.f.d> aiVar) {
        this.jJl = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        this.jJl.a(new C0435a(jVar), ajVar);
    }

    /* renamed from: com.facebook.imagepipeline.producers.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0435a extends m<com.facebook.imagepipeline.f.d, com.facebook.imagepipeline.f.d> {
        private C0435a(j<com.facebook.imagepipeline.f.d> jVar) {
            super(jVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: a */
        public void d(com.facebook.imagepipeline.f.d dVar, boolean z) {
            if (dVar == null) {
                czN().e(null, z);
                return;
            }
            if (!com.facebook.imagepipeline.f.d.d(dVar)) {
                dVar.cyL();
            }
            czN().e(dVar, z);
        }
    }
}
