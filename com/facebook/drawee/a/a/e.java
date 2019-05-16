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
    private final g jTC;
    private final com.facebook.imagepipeline.d.g jTN;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.jTN = gVar2;
        this.jTC = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: H */
    public e I(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aO(null);
        }
        return (e) super.aO(ImageRequestBuilder.U(uri).a(com.facebook.imagepipeline.common.d.cEP()).cIx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cCy */
    public d cCC() {
        com.facebook.drawee.d.a cCX = cCX();
        if (cCX instanceof d) {
            d dVar = (d) cCX;
            dVar.a(cDb(), cDa(), cCz(), cCS());
            return dVar;
        }
        return this.jTC.b(cDb(), cDa(), cCz(), cCS());
    }

    private com.facebook.cache.common.b cCz() {
        ImageRequest cCT = cCT();
        com.facebook.imagepipeline.c.f cFb = this.jTN.cFb();
        if (cFb == null || cCT == null) {
            return null;
        }
        if (cCT.cIt() != null) {
            return cFb.b(cCT, cCS());
        }
        return cFb.a(cCT, cCS());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.jTN.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: cCA */
    public e cCB() {
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
