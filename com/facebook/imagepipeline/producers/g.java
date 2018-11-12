package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class g extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> {
    private final com.facebook.imagepipeline.c.f ifc;

    public g(com.facebook.imagepipeline.c.f fVar, ai aiVar) {
        super(aiVar);
        this.ifc = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(aj ajVar) {
        return Pair.create(this.ifc.a(ajVar.bWL(), ajVar.bSo()), ajVar.bWN());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.b> e(com.facebook.common.references.a<com.facebook.imagepipeline.f.b> aVar) {
        return com.facebook.common.references.a.b(aVar);
    }
}
