package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes12.dex */
public class g extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final com.facebook.imagepipeline.c.f mSN;

    public g(com.facebook.imagepipeline.c.f fVar, aj ajVar) {
        super(ajVar);
        this.mSN = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(ak akVar) {
        return Pair.create(this.mSN.a(akVar.dGc(), akVar.dAH()), akVar.dGe());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> g(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
        return com.facebook.common.references.a.b(aVar);
    }
}
