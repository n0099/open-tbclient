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
    private final com.facebook.imagepipeline.d.g kcH;
    private final g kcw;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.kcH = gVar2;
        this.kcw = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: E */
    public e F(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aJ(null);
        }
        return (e) super.aJ(ImageRequestBuilder.R(uri).a(com.facebook.imagepipeline.common.d.cFZ()).cJI());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cDH */
    public d cDL() {
        com.facebook.drawee.d.a cEg = cEg();
        if (cEg instanceof d) {
            d dVar = (d) cEg;
            dVar.a(cEk(), cEj(), cDI(), cEb());
            return dVar;
        }
        return this.kcw.b(cEk(), cEj(), cDI(), cEb());
    }

    private com.facebook.cache.common.b cDI() {
        ImageRequest cEc = cEc();
        com.facebook.imagepipeline.c.f cGl = this.kcH.cGl();
        if (cGl == null || cEc == null) {
            return null;
        }
        if (cEc.cJE() != null) {
            return cGl.b(cEc, cEb());
        }
        return cGl.a(cEc, cEb());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.kcH.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cDJ */
    public e cDK() {
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
