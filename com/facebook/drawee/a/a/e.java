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
/* loaded from: classes14.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pCP;
    private final g pCQ;
    @Nullable
    private com.facebook.drawee.a.a.a.b pDc;
    private final com.facebook.imagepipeline.c.g pDd;
    @Nullable
    private com.facebook.drawee.a.a.a.f pDe;

    public e(Context context, g gVar, com.facebook.imagepipeline.c.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.pDd = gVar2;
        this.pCQ = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: U */
    public e V(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bq(null);
        }
        return (e) super.bq(ImageRequestBuilder.ag(uri).a(com.facebook.imagepipeline.common.e.ewE()).eAz());
    }

    public e ZG(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bq(ImageRequest.ZR(str)) : V(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: etP */
    public d etR() {
        d etT;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a eur = eur();
            String euu = euu();
            if (eur instanceof d) {
                etT = (d) eur;
            } else {
                etT = this.pCQ.etT();
            }
            etT.a(a(etT, euu), euu, etQ(), eum(), this.pCP, this.pDc);
            etT.a(this.pDe);
            return etT;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b etQ() {
        ImageRequest eun = eun();
        com.facebook.imagepipeline.b.f ewR = this.pDd.ewR();
        if (ewR == null || eun == null) {
            return null;
        }
        if (eun.eAw() != null) {
            return ewR.b(eun, eum());
        }
        return ewR.a(eun, eum());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.pDd.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.g.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).etL();
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
        return (e) super.bq(ImageRequestBuilder.ag(uri).P(map).eAz());
    }
}
