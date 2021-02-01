package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes5.dex */
public class g extends ad<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final com.facebook.imagepipeline.b.f pIp;

    public g(com.facebook.imagepipeline.b.f fVar, aj ajVar) {
        super(ajVar);
        this.pIp = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: a */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> b(ak akVar) {
        return Pair.create(this.pIp.a(akVar.ezh(), akVar.etV()), akVar.ezj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.ad
    /* renamed from: b */
    public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> g(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
        return com.facebook.common.references.a.b(aVar);
    }
}
