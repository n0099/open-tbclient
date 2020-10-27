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
    private ImmutableList<com.facebook.imagepipeline.f.a> oDi;
    private final g oDj;
    @Nullable
    private com.facebook.drawee.a.a.a.b oDw;
    private final com.facebook.imagepipeline.d.g oDx;
    @Nullable
    private com.facebook.drawee.a.a.a.f oDy;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.oDx = gVar2;
        this.oDj = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: R */
    public e S(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bn(null);
        }
        return (e) super.bn(ImageRequestBuilder.ad(uri).a(com.facebook.imagepipeline.common.e.ekh()).eoj());
    }

    public e XA(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bn(ImageRequest.XN(str)) : S(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: ehn */
    public d ehp() {
        d ehr;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a ehP = ehP();
            String ehS = ehS();
            if (ehP instanceof d) {
                ehr = (d) ehP;
            } else {
                ehr = this.oDj.ehr();
            }
            ehr.a(a(ehr, ehS), ehS, eho(), ehK(), this.oDi, this.oDw);
            ehr.a(this.oDy);
            return ehr;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b eho() {
        ImageRequest ehL = ehL();
        com.facebook.imagepipeline.c.f ekt = this.oDx.ekt();
        if (ekt == null || ehL == null) {
            return null;
        }
        if (ehL.eog() != null) {
            return ekt.b(ehL, ehK());
        }
        return ekt.a(ehL, ehK());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.oDx.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).ehj();
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
        return (e) super.bn(ImageRequestBuilder.ad(uri).I(map).eoj());
    }
}
