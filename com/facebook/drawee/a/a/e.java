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
        return (e) super.aA(ImageRequestBuilder.G(uri).a(com.facebook.imagepipeline.common.d.bWn()).bZR());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bUa */
    public d bUe() {
        com.facebook.drawee.d.a bUy = bUy();
        if (bUy instanceof d) {
            d dVar = (d) bUy;
            dVar.a(bUC(), bUB(), bUb(), bUt());
            return dVar;
        }
        return this.iho.b(bUC(), bUB(), bUb(), bUt());
    }

    private com.facebook.cache.common.b bUb() {
        ImageRequest bUu = bUu();
        com.facebook.imagepipeline.c.f bWz = this.ihz.bWz();
        if (bWz == null || bUu == null) {
            return null;
        }
        if (bUu.bZN() != null) {
            return bWz.b(bUu, bUt());
        }
        return bWz.a(bUu, bUt());
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
    /* renamed from: bUc */
    public e bUd() {
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
