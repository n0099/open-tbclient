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
    private final g kbF;
    private final com.facebook.imagepipeline.d.g kbQ;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.kbQ = gVar2;
        this.kbF = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: E */
    public e F(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aJ(null);
        }
        return (e) super.aJ(ImageRequestBuilder.R(uri).a(com.facebook.imagepipeline.common.d.cFX()).cJG());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cDF */
    public d cDJ() {
        com.facebook.drawee.d.a cEe = cEe();
        if (cEe instanceof d) {
            d dVar = (d) cEe;
            dVar.a(cEi(), cEh(), cDG(), cDZ());
            return dVar;
        }
        return this.kbF.b(cEi(), cEh(), cDG(), cDZ());
    }

    private com.facebook.cache.common.b cDG() {
        ImageRequest cEa = cEa();
        com.facebook.imagepipeline.c.f cGj = this.kbQ.cGj();
        if (cGj == null || cEa == null) {
            return null;
        }
        if (cEa.cJC() != null) {
            return cGj.b(cEa, cDZ());
        }
        return cGj.a(cEa, cDZ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.kbQ.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cDH */
    public e cDI() {
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
