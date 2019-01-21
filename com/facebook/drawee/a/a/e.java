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
    private final g ilG;
    private final com.facebook.imagepipeline.d.g ilR;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.ilR = gVar2;
        this.ilG = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: t */
    public e u(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aA(null);
        }
        return (e) super.aA(ImageRequestBuilder.G(uri).a(com.facebook.imagepipeline.common.d.bXM()).cbq());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bVz */
    public d bVD() {
        com.facebook.drawee.d.a bVX = bVX();
        if (bVX instanceof d) {
            d dVar = (d) bVX;
            dVar.a(bWb(), bWa(), bVA(), bVS());
            return dVar;
        }
        return this.ilG.b(bWb(), bWa(), bVA(), bVS());
    }

    private com.facebook.cache.common.b bVA() {
        ImageRequest bVT = bVT();
        com.facebook.imagepipeline.c.f bXY = this.ilR.bXY();
        if (bXY == null || bVT == null) {
            return null;
        }
        if (bVT.cbm() != null) {
            return bXY.b(bVT, bVS());
        }
        return bXY.a(bVT, bVS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.ilR.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bVB */
    public e bVC() {
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
