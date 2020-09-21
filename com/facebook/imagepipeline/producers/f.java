package com.facebook.imagepipeline.producers;
/* loaded from: classes25.dex */
public class f extends h {
    public f(com.facebook.imagepipeline.c.p<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> pVar, com.facebook.imagepipeline.c.f fVar, aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> ajVar) {
        super(pVar, fVar, ajVar);
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, com.facebook.cache.common.b bVar, boolean z) {
        return kVar;
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected String dZF() {
        return "BitmapMemoryCacheGetProducer";
    }
}
