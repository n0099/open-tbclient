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
/* loaded from: classes4.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mSi;
    private final g mSj;
    @Nullable
    private com.facebook.drawee.a.a.a.b mSx;
    private final com.facebook.imagepipeline.d.g mSy;
    @Nullable
    private com.facebook.drawee.a.a.a.f mSz;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mSy = gVar2;
        this.mSj = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bc(null);
        }
        return (e) super.bc(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dGr()).dKr());
    }

    public e Rt(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bc(ImageRequest.RG(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dDw */
    public d dDy() {
        d dDA;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dDY = dDY();
            String dEb = dEb();
            if (dDY instanceof d) {
                dDA = (d) dDY;
            } else {
                dDA = this.mSj.dDA();
            }
            dDA.a(a(dDA, dEb), dEb, dDx(), dDT(), this.mSi, this.mSx);
            dDA.a(this.mSz);
            return dDA;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dDx() {
        ImageRequest dDU = dDU();
        com.facebook.imagepipeline.c.f dGD = this.mSy.dGD();
        if (dGD == null || dDU == null) {
            return null;
        }
        if (dDU.dKo() != null) {
            return dGD.b(dDU, dDT());
        }
        return dGD.a(dDU, dDT());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mSy.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dDs();
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
        return (e) super.bc(ImageRequestBuilder.ab(uri).y(map).dKr());
    }
}
