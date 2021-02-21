package com.facebook.drawee.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.internal.ImmutableList;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pAK;
    private final g pAL;
    @Nullable
    private com.facebook.drawee.a.a.a.b pAX;
    private final com.facebook.imagepipeline.c.g pAY;
    @Nullable
    private com.facebook.drawee.a.a.a.f pAZ;

    public e(Context context, g gVar, com.facebook.imagepipeline.c.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.pAY = gVar2;
        this.pAL = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: U */
    public e V(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bo(null);
        }
        return (e) super.bo(ImageRequestBuilder.ag(uri).a(com.facebook.imagepipeline.common.e.ewv()).eAq());
    }

    public e ZA(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bo(ImageRequest.ZL(str)) : V(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: etG */
    public d etI() {
        d etK;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a eui = eui();
            String eul = eul();
            if (eui instanceof d) {
                etK = (d) eui;
            } else {
                etK = this.pAL.etK();
            }
            etK.a(a(etK, eul), eul, etH(), eud(), this.pAK, this.pAX);
            etK.a(this.pAZ);
            return etK;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b etH() {
        ImageRequest eue = eue();
        com.facebook.imagepipeline.b.f ewI = this.pAY.ewI();
        if (ewI == null || eue == null) {
            return null;
        }
        if (eue.eAn() != null) {
            return ewI.b(eue, eud());
        }
        return ewI.a(eue, eud());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.pAY.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.g.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).etC();
        }
        return null;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: b */
    public e c(Uri uri, Map<String, String> map) {
        return (e) super.bo(ImageRequestBuilder.ag(uri).P(map).eAq());
    }
}
