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
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private com.facebook.drawee.a.a.a.b nwK;
    private final com.facebook.imagepipeline.d.g nwL;
    @Nullable
    private com.facebook.drawee.a.a.a.f nwM;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> nww;
    private final g nwx;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.nwL = gVar2;
        this.nwx = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: R */
    public e S(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bg(null);
        }
        return (e) super.bg(ImageRequestBuilder.ad(uri).a(com.facebook.imagepipeline.common.e.dWy()).eay());
    }

    public e UZ(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bg(ImageRequest.Vm(str)) : S(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dTE */
    public d dTG() {
        d dTI;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dUg = dUg();
            String dUj = dUj();
            if (dUg instanceof d) {
                dTI = (d) dUg;
            } else {
                dTI = this.nwx.dTI();
            }
            dTI.a(a(dTI, dUj), dUj, dTF(), dUb(), this.nww, this.nwK);
            dTI.a(this.nwM);
            return dTI;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dTF() {
        ImageRequest dUc = dUc();
        com.facebook.imagepipeline.c.f dWK = this.nwL.dWK();
        if (dWK == null || dUc == null) {
            return null;
        }
        if (dUc.eav() != null) {
            return dWK.b(dUc, dUb());
        }
        return dWK.a(dUc, dUb());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.nwL.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dTA();
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
        return (e) super.bg(ImageRequestBuilder.ad(uri).y(map).eay());
    }
}
