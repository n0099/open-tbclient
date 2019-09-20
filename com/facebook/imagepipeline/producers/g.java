package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class g extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.f kjt;

    public g(com.facebook.imagepipeline.c.f fVar, ai aiVar) {
        super(aiVar);
        this.kjt = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(aj ajVar) {
        return Pair.create(this.kjt.a(ajVar.cLK(), ajVar.cHd()), ajVar.cLM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> f(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        return com.facebook.common.references.a.b(aVar);
    }
}
