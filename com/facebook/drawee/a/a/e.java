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
/* loaded from: classes12.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lJb;
    private final g lJc;
    @Nullable
    private com.facebook.drawee.a.a.a.b lJq;
    private final com.facebook.imagepipeline.d.g lJr;
    @Nullable
    private com.facebook.drawee.a.a.a.f lJs;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lJr = gVar2;
        this.lJc = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: I */
    public e J(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.be(null);
        }
        return (e) super.be(ImageRequestBuilder.X(uri).a(com.facebook.imagepipeline.common.e.dnj()).dro());
    }

    public e OI(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.be(ImageRequest.OU(str)) : J(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dkt */
    public d dkv() {
        d dkx;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dkV = dkV();
            String dkY = dkY();
            if (dkV instanceof d) {
                dkx = (d) dkV;
            } else {
                dkx = this.lJc.dkx();
            }
            dkx.a(a(dkx, dkY), dkY, dku(), dkQ(), this.lJb, this.lJq);
            dkx.a(this.lJs);
            return dkx;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dku() {
        ImageRequest dkR = dkR();
        com.facebook.imagepipeline.c.f dnx = this.lJr.dnx();
        if (dnx == null || dkR == null) {
            return null;
        }
        if (dkR.drl() != null) {
            return dnx.b(dkR, dkQ());
        }
        return dnx.a(dkR, dkQ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lJr.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dkp();
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
        return (e) super.be(ImageRequestBuilder.X(uri).z(map).dro());
    }
}
