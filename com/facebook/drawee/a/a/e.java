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
    private final g jTD;
    private final com.facebook.imagepipeline.d.g jTO;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.jTO = gVar2;
        this.jTD = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: H */
    public e I(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aO(null);
        }
        return (e) super.aO(ImageRequestBuilder.U(uri).a(com.facebook.imagepipeline.common.d.cER()).cIz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cCA */
    public d cCE() {
        com.facebook.drawee.d.a cCZ = cCZ();
        if (cCZ instanceof d) {
            d dVar = (d) cCZ;
            dVar.a(cDd(), cDc(), cCB(), cCU());
            return dVar;
        }
        return this.jTD.b(cDd(), cDc(), cCB(), cCU());
    }

    private com.facebook.cache.common.b cCB() {
        ImageRequest cCV = cCV();
        com.facebook.imagepipeline.c.f cFd = this.jTO.cFd();
        if (cFd == null || cCV == null) {
            return null;
        }
        if (cCV.cIv() != null) {
            return cFd.b(cCV, cCU());
        }
        return cFd.a(cCV, cCU());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.jTO.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cCC */
    public e cCD() {
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
