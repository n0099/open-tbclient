package com.facebook.drawee.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.b>, com.facebook.imagepipeline.f.e> {
    private final g jBh;
    private final com.facebook.imagepipeline.d.g jBs;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.jBs = gVar2;
        this.jBh = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: B */
    public e C(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aP(null);
        }
        return (e) super.aP(ImageRequestBuilder.O(uri).a(com.facebook.imagepipeline.common.d.cwN()).cAv());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cuw */
    public d cuA() {
        com.facebook.drawee.d.a cuV = cuV();
        if (cuV instanceof d) {
            d dVar = (d) cuV;
            dVar.a(cuZ(), cuY(), cux(), cuQ());
            return dVar;
        }
        return this.jBh.b(cuZ(), cuY(), cux(), cuQ());
    }

    private com.facebook.cache.common.b cux() {
        ImageRequest cuR = cuR();
        com.facebook.imagepipeline.c.f cwZ = this.jBs.cwZ();
        if (cwZ == null || cuR == null) {
            return null;
        }
        if (cuR.cAr() != null) {
            return cwZ.b(cuR, cuQ());
        }
        return cwZ.a(cuR, cuQ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.jBs.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cuy */
    public e cuz() {
        return this;
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
}
