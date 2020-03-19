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
    private ImmutableList<com.facebook.imagepipeline.f.a> lLB;
    private final g lLC;
    @Nullable
    private com.facebook.drawee.a.a.a.b lLQ;
    private final com.facebook.imagepipeline.d.g lLR;
    @Nullable
    private com.facebook.drawee.a.a.a.f lLS;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lLR = gVar2;
        this.lLC = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: J */
    public e K(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bg(null);
        }
        return (e) super.bg(ImageRequestBuilder.Y(uri).a(com.facebook.imagepipeline.common.e.doW()).dta());
    }

    public e OW(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bg(ImageRequest.Pi(str)) : K(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dmg */
    public d dmi() {
        d dmk;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dmI = dmI();
            String dmL = dmL();
            if (dmI instanceof d) {
                dmk = (d) dmI;
            } else {
                dmk = this.lLC.dmk();
            }
            dmk.a(a(dmk, dmL), dmL, dmh(), dmD(), this.lLB, this.lLQ);
            dmk.a(this.lLS);
            return dmk;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dmh() {
        ImageRequest dmE = dmE();
        com.facebook.imagepipeline.c.f dpj = this.lLR.dpj();
        if (dpj == null || dmE == null) {
            return null;
        }
        if (dmE.dsX() != null) {
            return dpj.b(dmE, dmD());
        }
        return dpj.a(dmE, dmD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lLR.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dmc();
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
        return (e) super.bg(ImageRequestBuilder.Y(uri).z(map).dta());
    }
}
