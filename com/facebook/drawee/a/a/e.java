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
/* loaded from: classes13.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> moc;
    private final g mod;
    @Nullable
    private com.facebook.drawee.a.a.a.b mor;
    private final com.facebook.imagepipeline.d.g mos;
    @Nullable
    private com.facebook.drawee.a.a.a.f mot;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mos = gVar2;
        this.mod = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bb(null);
        }
        return (e) super.bb(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dyz()).dCz());
    }

    public e PV(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bb(ImageRequest.Qi(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dvD */
    public d dvF() {
        d dvH;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dwf = dwf();
            String dwi = dwi();
            if (dwf instanceof d) {
                dvH = (d) dwf;
            } else {
                dvH = this.mod.dvH();
            }
            dvH.a(a(dvH, dwi), dwi, dvE(), dwa(), this.moc, this.mor);
            dvH.a(this.mot);
            return dvH;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dvE() {
        ImageRequest dwb = dwb();
        com.facebook.imagepipeline.c.f dyL = this.mos.dyL();
        if (dyL == null || dwb == null) {
            return null;
        }
        if (dwb.dCw() != null) {
            return dyL.b(dwb, dwa());
        }
        return dyL.a(dwb, dwa());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mos.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dvz();
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
        return (e) super.bb(ImageRequestBuilder.ab(uri).x(map).dCz());
    }
}
