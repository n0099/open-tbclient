package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes2.dex */
public class q extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.imagepipeline.f.d> {
    private final com.facebook.imagepipeline.c.f jYJ;

    public q(com.facebook.imagepipeline.c.f fVar, ai aiVar) {
        super(aiVar);
        this.jYJ = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(aj ajVar) {
        return Pair.create(this.jYJ.c(ajVar.cHx(), ajVar.cCT()), ajVar.cHz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.imagepipeline.f.d f(com.facebook.imagepipeline.f.d dVar) {
        return com.facebook.imagepipeline.f.d.b(dVar);
    }
}
