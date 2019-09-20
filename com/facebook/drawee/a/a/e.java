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
    private final g ken;
    private final com.facebook.imagepipeline.d.g kez;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.kez = gVar2;
        this.ken = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: H */
    public e I(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aO(null);
        }
        return (e) super.aO(ImageRequestBuilder.U(uri).a(com.facebook.imagepipeline.common.d.cJc()).cML());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cGJ */
    public d cGN() {
        com.facebook.drawee.d.a cHi = cHi();
        if (cHi instanceof d) {
            d dVar = (d) cHi;
            dVar.a(cHm(), cHl(), cGK(), cHd());
            return dVar;
        }
        return this.ken.b(cHm(), cHl(), cGK(), cHd());
    }

    private com.facebook.cache.common.b cGK() {
        ImageRequest cHe = cHe();
        com.facebook.imagepipeline.c.f cJo = this.kez.cJo();
        if (cJo == null || cHe == null) {
            return null;
        }
        if (cHe.cMH() != null) {
            return cJo.b(cHe, cHd());
        }
        return cJo.a(cHe, cHd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.kez.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cGL */
    public e cGM() {
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
