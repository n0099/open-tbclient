package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class f extends h {
    public f(com.facebook.imagepipeline.b.p<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> pVar, com.facebook.imagepipeline.b.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> ajVar) {
        super(pVar, fVar, ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, com.facebook.cache.common.b bVar, boolean z) {
        return kVar;
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected String ewG() {
        return "BitmapMemoryCacheGetProducer";
    }
}
