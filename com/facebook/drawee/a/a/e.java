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
    private ImmutableList<com.facebook.imagepipeline.f.a> mKf;
    private final g mKg;
    @Nullable
    private com.facebook.drawee.a.a.a.b mKt;
    private final com.facebook.imagepipeline.d.g mKu;
    @Nullable
    private com.facebook.drawee.a.a.a.f mKv;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mKu = gVar2;
        this.mKg = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: Q */
    public e R(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bc(null);
        }
        return (e) super.bc(ImageRequestBuilder.ac(uri).a(com.facebook.imagepipeline.common.e.dDf()).dHf());
    }

    public e QI(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bc(ImageRequest.QV(str)) : R(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dAk */
    public d dAm() {
        d dAo;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dAM = dAM();
            String dAP = dAP();
            if (dAM instanceof d) {
                dAo = (d) dAM;
            } else {
                dAo = this.mKg.dAo();
            }
            dAo.a(a(dAo, dAP), dAP, dAl(), dAH(), this.mKf, this.mKt);
            dAo.a(this.mKv);
            return dAo;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dAl() {
        ImageRequest dAI = dAI();
        com.facebook.imagepipeline.c.f dDr = this.mKu.dDr();
        if (dDr == null || dAI == null) {
            return null;
        }
        if (dAI.dHc() != null) {
            return dDr.b(dAI, dAH());
        }
        return dDr.a(dAI, dAH());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mKu.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dAg();
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
        return (e) super.bc(ImageRequestBuilder.ac(uri).y(map).dHf());
    }
}
