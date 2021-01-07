package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes3.dex */
public class r extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.imagepipeline.f.e> {
    private final com.facebook.imagepipeline.b.f pCH;

    public r(com.facebook.imagepipeline.b.f fVar, aj ajVar) {
        super(ajVar);
        this.pCH = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(ak akVar) {
        return Pair.create(this.pCH.c(akVar.eAH(), akVar.evw()), akVar.eAJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.imagepipeline.f.e h(com.facebook.imagepipeline.f.e eVar) {
        return com.facebook.imagepipeline.f.e.b(eVar);
    }
}
