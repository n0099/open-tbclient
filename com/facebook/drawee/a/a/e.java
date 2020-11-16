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
/* loaded from: classes10.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> oOf;
    private final g oOg;
    @Nullable
    private com.facebook.drawee.a.a.a.b oOt;
    private final com.facebook.imagepipeline.d.g oOu;
    @Nullable
    private com.facebook.drawee.a.a.a.f oOv;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.oOu = gVar2;
        this.oOg = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: S */
    public e T(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bo(null);
        }
        return (e) super.bo(ImageRequestBuilder.ae(uri).a(com.facebook.imagepipeline.common.e.enV()).erW());
    }

    public e XP(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bo(ImageRequest.Yc(str)) : T(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: ela */
    public d elc() {
        d ele;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a elC = elC();
            String elF = elF();
            if (elC instanceof d) {
                ele = (d) elC;
            } else {
                ele = this.oOg.ele();
            }
            ele.a(a(ele, elF), elF, elb(), elx(), this.oOf, this.oOt);
            ele.a(this.oOv);
            return ele;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b elb() {
        ImageRequest ely = ely();
        com.facebook.imagepipeline.c.f eoi = this.oOu.eoi();
        if (eoi == null || ely == null) {
            return null;
        }
        if (ely.erT() != null) {
            return eoi.b(ely, elx());
        }
        return eoi.a(ely, elx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.oOu.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).ekW();
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
        return (e) super.bo(ImageRequestBuilder.ae(uri).I(map).erW());
    }
}
