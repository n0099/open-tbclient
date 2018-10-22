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
    private final com.facebook.imagepipeline.d.g hYC;
    private final g hYr;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.hYC = gVar2;
        this.hYr = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: s */
    public e t(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aA(null);
        }
        return (e) super.aA(ImageRequestBuilder.F(uri).a(com.facebook.imagepipeline.common.d.bUN()).bYr());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bSA */
    public d bSE() {
        com.facebook.drawee.d.a bSY = bSY();
        if (bSY instanceof d) {
            d dVar = (d) bSY;
            dVar.a(bTc(), bTb(), bSB(), bST());
            return dVar;
        }
        return this.hYr.b(bTc(), bTb(), bSB(), bST());
    }

    private com.facebook.cache.common.b bSB() {
        ImageRequest bSU = bSU();
        com.facebook.imagepipeline.c.f bUZ = this.hYC.bUZ();
        if (bUZ == null || bSU == null) {
            return null;
        }
        if (bSU.bYn() != null) {
            return bUZ.b(bSU, bST());
        }
        return bUZ.a(bSU, bST());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.hYC.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bSC */
    public e bSD() {
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
