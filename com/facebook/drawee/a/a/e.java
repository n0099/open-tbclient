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
/* loaded from: classes4.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    private final com.facebook.imagepipeline.d.g mSA;
    @Nullable
    private com.facebook.drawee.a.a.a.f mSB;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> mSk;
    private final g mSl;
    @Nullable
    private com.facebook.drawee.a.a.a.b mSz;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.mSA = gVar2;
        this.mSl = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: P */
    public e Q(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bc(null);
        }
        return (e) super.bc(ImageRequestBuilder.ab(uri).a(com.facebook.imagepipeline.common.e.dGs()).dKs());
    }

    public e Rt(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bc(ImageRequest.RG(str)) : Q(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dDx */
    public d dDz() {
        d dDB;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dDZ = dDZ();
            String dEc = dEc();
            if (dDZ instanceof d) {
                dDB = (d) dDZ;
            } else {
                dDB = this.mSl.dDB();
            }
            dDB.a(a(dDB, dEc), dEc, dDy(), dDU(), this.mSk, this.mSz);
            dDB.a(this.mSB);
            return dDB;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dDy() {
        ImageRequest dDV = dDV();
        com.facebook.imagepipeline.c.f dGE = this.mSA.dGE();
        if (dGE == null || dDV == null) {
            return null;
        }
        if (dDV.dKp() != null) {
            return dGE.b(dDV, dDU());
        }
        return dGE.a(dDV, dDU());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.mSA.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dDt();
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
        return (e) super.bc(ImageRequestBuilder.ab(uri).y(map).dKs());
    }
}
