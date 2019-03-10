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
    private final g jBA;
    private final com.facebook.imagepipeline.d.g jBL;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.jBL = gVar2;
        this.jBA = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: B */
    public e C(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aQ(null);
        }
        return (e) super.aQ(ImageRequestBuilder.O(uri).a(com.facebook.imagepipeline.common.d.cwX()).cAF());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cuG */
    public d cuK() {
        com.facebook.drawee.d.a cvf = cvf();
        if (cvf instanceof d) {
            d dVar = (d) cvf;
            dVar.a(cvj(), cvi(), cuH(), cva());
            return dVar;
        }
        return this.jBA.b(cvj(), cvi(), cuH(), cva());
    }

    private com.facebook.cache.common.b cuH() {
        ImageRequest cvb = cvb();
        com.facebook.imagepipeline.c.f cxj = this.jBL.cxj();
        if (cxj == null || cvb == null) {
            return null;
        }
        if (cvb.cAB() != null) {
            return cxj.b(cvb, cva());
        }
        return cxj.a(cvb, cva());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.jBL.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cuI */
    public e cuJ() {
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
