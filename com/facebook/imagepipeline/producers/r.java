package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class r extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.imagepipeline.g.e> {
    private final com.facebook.imagepipeline.c.f naU;

    public r(com.facebook.imagepipeline.c.f fVar, aj ajVar) {
        super(ajVar);
        this.naU = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(ak akVar) {
        return Pair.create(this.naU.c(akVar.dJp(), akVar.dDU()), akVar.dJr());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.imagepipeline.g.e g(com.facebook.imagepipeline.g.e eVar) {
        return com.facebook.imagepipeline.g.e.b(eVar);
    }
}
