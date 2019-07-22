package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class f extends h {
    public f(com.facebook.imagepipeline.c.t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, com.facebook.imagepipeline.c.f fVar, ai<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> aiVar) {
        super(tVar, fVar, aiVar);
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(j<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> jVar, com.facebook.cache.common.b bVar) {
        return jVar;
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected String cKM() {
        return "BitmapMemoryCacheGetProducer";
    }
}
