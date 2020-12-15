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
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    @Nullable
    private com.facebook.drawee.a.a.a.b pdC;
    private final com.facebook.imagepipeline.c.g pdD;
    @Nullable
    private com.facebook.drawee.a.a.a.f pdE;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pdp;
    private final g pdq;

    public e(Context context, g gVar, com.facebook.imagepipeline.c.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.pdD = gVar2;
        this.pdq = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: T */
    public e U(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bo(null);
        }
        return (e) super.bo(ImageRequestBuilder.af(uri).a(com.facebook.imagepipeline.common.e.etC()).exx());
    }

    public e Zk(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bo(ImageRequest.Zv(str)) : U(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: eqQ */
    public d eqS() {
        d eqU;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a ers = ers();
            String erv = erv();
            if (ers instanceof d) {
                eqU = (d) ers;
            } else {
                eqU = this.pdq.eqU();
            }
            eqU.a(a(eqU, erv), erv, eqR(), ern(), this.pdp, this.pdC);
            eqU.a(this.pdE);
            return eqU;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b eqR() {
        ImageRequest ero = ero();
        com.facebook.imagepipeline.b.f etO = this.pdD.etO();
        if (etO == null || ero == null) {
            return null;
        }
        if (ero.exu() != null) {
            return etO.b(ero, ern());
        }
        return etO.a(ero, ern());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.pdD.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.g.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).eqM();
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
        return (e) super.bo(ImageRequestBuilder.af(uri).I(map).exx());
    }
}
