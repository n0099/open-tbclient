package com.facebook.drawee.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.internal.ImmutableList;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mKc;
    private final g mKd;
    @Nullable
    private com.facebook.drawee.a.a.a.b mKq;
    private final com.facebook.imagepipeline.d.g mKr;
    @Nullable
    private com.facebook.drawee.a.a.a.f mKs;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mKr = gVar2;
        this.mKd = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: Q */
    public e R(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bc(null);
        }
        return (e) super.bc(ImageRequestBuilder.ac(uri).a(com.facebook.imagepipeline.common.e.dDb()).dHb());
    }

    public e QH(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bc(ImageRequest.QU(str)) : R(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dAg */
    public d dAi() {
        d dAk;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dAI = dAI();
            String dAL = dAL();
            if (dAI instanceof d) {
                dAk = (d) dAI;
            } else {
                dAk = this.mKd.dAk();
            }
            dAk.a(a(dAk, dAL), dAL, dAh(), dAD(), this.mKc, this.mKq);
            dAk.a(this.mKs);
            return dAk;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dAh() {
        ImageRequest dAE = dAE();
        com.facebook.imagepipeline.c.f dDn = this.mKr.dDn();
        if (dDn == null || dAE == null) {
            return null;
        }
        if (dAE.dGY() != null) {
            return dDn.b(dAE, dAD());
        }
        return dDn.a(dAE, dAD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mKr.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dAc();
        }
        return null;
    }

    public static ImageRequest.RequestLevel a(AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        switch (cacheLevel) {
            case FULL_FETCH:
                return ImageRequest.RequestLevel.FULL_FETCH;
            case DISK_CACHE:
                return ImageRequest.RequestLevel.DISK_CACHE;
            case BITMAP_MEMORY_CACHE:
                return ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
            default:
                throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public e c(Uri uri, Map<String, String> map) {
        return (e) super.bc(ImageRequestBuilder.ac(uri).y(map).dHb());
    }
}
