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
    private final g iab;
    private final com.facebook.imagepipeline.d.g iam;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.iam = gVar2;
        this.iab = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: s */
    public e t(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.az(null);
        }
        return (e) super.az(ImageRequestBuilder.F(uri).a(com.facebook.imagepipeline.common.d.bUi()).bXM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bRV */
    public d bRZ() {
        com.facebook.drawee.d.a bSt = bSt();
        if (bSt instanceof d) {
            d dVar = (d) bSt;
            dVar.a(bSx(), bSw(), bRW(), bSo());
            return dVar;
        }
        return this.iab.b(bSx(), bSw(), bRW(), bSo());
    }

    private com.facebook.cache.common.b bRW() {
        ImageRequest bSp = bSp();
        com.facebook.imagepipeline.c.f bUu = this.iam.bUu();
        if (bUu == null || bSp == null) {
            return null;
        }
        if (bSp.bXI() != null) {
            return bUu.b(bSp, bSo());
        }
        return bUu.a(bSp, bSo());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> a(ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.iam.a(imageRequest, obj, a(cacheLevel));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: bRX */
    public e bRY() {
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
