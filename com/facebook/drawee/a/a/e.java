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
    private final g iho;
    private final com.facebook.imagepipeline.d.g ihz;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.ihz = gVar2;
        this.iho = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: t */
    public e u(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aA(null);
        }
        return (e) super.aA(ImageRequestBuilder.G(uri).a(com.facebook.imagepipeline.common.d.bWo()).bZS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bUb */
    public d bUf() {
        com.facebook.drawee.d.a bUz = bUz();
        if (bUz instanceof d) {
            d dVar = (d) bUz;
            dVar.a(bUD(), bUC(), bUc(), bUu());
            return dVar;
        }
        return this.iho.b(bUD(), bUC(), bUc(), bUu());
    }

    private com.facebook.cache.common.b bUc() {
        ImageRequest bUv = bUv();
        com.facebook.imagepipeline.c.f bWA = this.ihz.bWA();
        if (bWA == null || bUv == null) {
            return null;
        }
        if (bUv.bZO() != null) {
            return bWA.b(bUv, bUu());
        }
        return bWA.a(bUv, bUu());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.ihz.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bUd */
    public e bUe() {
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
