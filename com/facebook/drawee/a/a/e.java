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
/* loaded from: classes11.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private com.facebook.drawee.a.a.a.b lFN;
    private final com.facebook.imagepipeline.d.g lFO;
    @Nullable
    private com.facebook.drawee.a.a.a.f lFP;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> lFy;
    private final g lFz;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lFO = gVar2;
        this.lFz = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: I */
    public e J(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.be(null);
        }
        return (e) super.be(ImageRequestBuilder.X(uri).a(com.facebook.imagepipeline.common.e.dmb()).dpZ());
    }

    public e Oy(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.be(ImageRequest.OJ(str)) : J(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: djq */
    public d djs() {
        d dju;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a djS = djS();
            String djV = djV();
            if (djS instanceof d) {
                dju = (d) djS;
            } else {
                dju = this.lFz.dju();
            }
            dju.a(a(dju, djV), djV, djr(), djN(), this.lFy, this.lFN);
            dju.a(this.lFP);
            return dju;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b djr() {
        ImageRequest djO = djO();
        com.facebook.imagepipeline.c.f dmo = this.lFO.dmo();
        if (dmo == null || djO == null) {
            return null;
        }
        if (djO.dpW() != null) {
            return dmo.b(djO, djN());
        }
        return dmo.a(djO, djN());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lFO.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).djm();
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
        return (e) super.be(ImageRequestBuilder.X(uri).z(map).dpZ());
    }
}
