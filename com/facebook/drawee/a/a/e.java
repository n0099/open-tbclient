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
    private ImmutableList<com.facebook.imagepipeline.f.a> mmS;
    private final g mmT;
    @Nullable
    private com.facebook.drawee.a.a.a.b mng;
    private final com.facebook.imagepipeline.d.g mnh;
    @Nullable
    private com.facebook.drawee.a.a.a.f mni;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mnh = gVar2;
        this.mmT = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bb(null);
        }
        return (e) super.bb(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dyl()).dCl());
    }

    public e PU(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bb(ImageRequest.Qh(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dvp */
    public d dvr() {
        d dvt;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dvR = dvR();
            String dvU = dvU();
            if (dvR instanceof d) {
                dvt = (d) dvR;
            } else {
                dvt = this.mmT.dvt();
            }
            dvt.a(a(dvt, dvU), dvU, dvq(), dvM(), this.mmS, this.mng);
            dvt.a(this.mni);
            return dvt;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dvq() {
        ImageRequest dvN = dvN();
        com.facebook.imagepipeline.c.f dyx = this.mnh.dyx();
        if (dyx == null || dvN == null) {
            return null;
        }
        if (dvN.dCi() != null) {
            return dyx.b(dvN, dvM());
        }
        return dyx.a(dvN, dvM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mnh.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dvl();
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
        return (e) super.bb(ImageRequestBuilder.ab(uri).x(map).dCl());
    }
}
