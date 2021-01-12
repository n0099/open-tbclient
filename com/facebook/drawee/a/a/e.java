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
/* loaded from: classes6.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pqa;
    private final g pqb;
    @Nullable
    private com.facebook.drawee.a.a.a.b pqn;
    private final com.facebook.imagepipeline.c.g pqo;
    @Nullable
    private com.facebook.drawee.a.a.a.f pqp;

    public e(Context context, g gVar, com.facebook.imagepipeline.c.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.pqo = gVar2;
        this.pqb = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: U */
    public e V(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bo(null);
        }
        return (e) super.bo(ImageRequestBuilder.ag(uri).a(com.facebook.imagepipeline.common.e.etV()).exQ());
    }

    public e Ym(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bo(ImageRequest.Yx(str)) : V(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: erf */
    public d erh() {
        d erj;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a erI = erI();
            String erL = erL();
            if (erI instanceof d) {
                erj = (d) erI;
            } else {
                erj = this.pqb.erj();
            }
            erj.a(a(erj, erL), erL, erg(), erD(), this.pqa, this.pqn);
            erj.a(this.pqp);
            return erj;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b erg() {
        ImageRequest erE = erE();
        com.facebook.imagepipeline.b.f euh = this.pqo.euh();
        if (euh == null || erE == null) {
            return null;
        }
        if (erE.exN() != null) {
            return euh.b(erE, erD());
        }
        return euh.a(erE, erD());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.pqo.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.g.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).erb();
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
        return (e) super.bo(ImageRequestBuilder.ag(uri).N(map).exQ());
    }
}
