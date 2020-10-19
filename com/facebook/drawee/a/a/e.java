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
/* loaded from: classes18.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nLP;
    private final g nLQ;
    @Nullable
    private com.facebook.drawee.a.a.a.b nMd;
    private final com.facebook.imagepipeline.d.g nMe;
    @Nullable
    private com.facebook.drawee.a.a.a.f nMf;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.nMe = gVar2;
        this.nLQ = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: R */
    public e S(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bj(null);
        }
        return (e) super.bj(ImageRequestBuilder.ad(uri).a(com.facebook.imagepipeline.common.e.eaj()).eej());
    }

    public e VN(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bj(ImageRequest.Wa(str)) : S(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dXp */
    public d dXr() {
        d dXt;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dXR = dXR();
            String dXU = dXU();
            if (dXR instanceof d) {
                dXt = (d) dXR;
            } else {
                dXt = this.nLQ.dXt();
            }
            dXt.a(a(dXt, dXU), dXU, dXq(), dXM(), this.nLP, this.nMd);
            dXt.a(this.nMf);
            return dXt;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dXq() {
        ImageRequest dXN = dXN();
        com.facebook.imagepipeline.c.f eav = this.nMe.eav();
        if (eav == null || dXN == null) {
            return null;
        }
        if (dXN.eeg() != null) {
            return eav.b(dXN, dXM());
        }
        return eav.a(dXN, dXM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.nMe.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dXl();
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
        return (e) super.bj(ImageRequestBuilder.ad(uri).I(map).eej());
    }
}
