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
    private ImmutableList<com.facebook.imagepipeline.f.a> nme;
    private final g nmf;
    @Nullable
    private com.facebook.drawee.a.a.a.b nms;
    private final com.facebook.imagepipeline.d.g nmt;
    @Nullable
    private com.facebook.drawee.a.a.a.f nmu;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.nmt = gVar2;
        this.nmf = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.be(null);
        }
        return (e) super.be(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dSr()).dWr());
    }

    public e Ux(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.be(ImageRequest.UK(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dPx */
    public d dPz() {
        d dPB;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dPZ = dPZ();
            String dQc = dQc();
            if (dPZ instanceof d) {
                dPB = (d) dPZ;
            } else {
                dPB = this.nmf.dPB();
            }
            dPB.a(a(dPB, dQc), dQc, dPy(), dPU(), this.nme, this.nms);
            dPB.a(this.nmu);
            return dPB;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dPy() {
        ImageRequest dPV = dPV();
        com.facebook.imagepipeline.c.f dSD = this.nmt.dSD();
        if (dSD == null || dPV == null) {
            return null;
        }
        if (dPV.dWo() != null) {
            return dSD.b(dPV, dPU());
        }
        return dSD.a(dPV, dPU());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.nmt.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dPt();
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
        return (e) super.be(ImageRequestBuilder.ab(uri).y(map).dWr());
    }
}
