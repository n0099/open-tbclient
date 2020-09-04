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
/* loaded from: classes9.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private com.facebook.drawee.a.a.a.b nmK;
    private final com.facebook.imagepipeline.d.g nmL;
    @Nullable
    private com.facebook.drawee.a.a.a.f nmM;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nmw;
    private final g nmx;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.nmL = gVar2;
        this.nmx = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.be(null);
        }
        return (e) super.be(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dSA()).dWA());
    }

    public e Ux(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.be(ImageRequest.UK(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dPG */
    public d dPI() {
        d dPK;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dQi = dQi();
            String dQl = dQl();
            if (dQi instanceof d) {
                dPK = (d) dQi;
            } else {
                dPK = this.nmx.dPK();
            }
            dPK.a(a(dPK, dQl), dQl, dPH(), dQd(), this.nmw, this.nmK);
            dPK.a(this.nmM);
            return dPK;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dPH() {
        ImageRequest dQe = dQe();
        com.facebook.imagepipeline.c.f dSM = this.nmL.dSM();
        if (dSM == null || dQe == null) {
            return null;
        }
        if (dQe.dWx() != null) {
            return dSM.b(dQe, dQd());
        }
        return dSM.a(dQe, dQd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.nmL.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dPC();
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
        return (e) super.be(ImageRequestBuilder.ab(uri).y(map).dWA());
    }
}
