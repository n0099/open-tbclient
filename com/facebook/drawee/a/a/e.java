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
    private ImmutableList<com.facebook.imagepipeline.f.a> lJV;
    private final g lJW;
    @Nullable
    private com.facebook.drawee.a.a.a.b lKk;
    private final com.facebook.imagepipeline.d.g lKl;
    @Nullable
    private com.facebook.drawee.a.a.a.f lKm;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lKl = gVar2;
        this.lJW = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: J */
    public e K(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bg(null);
        }
        return (e) super.bg(ImageRequestBuilder.Y(uri).a(com.facebook.imagepipeline.common.e.doz()).dsD());
    }

    public e OW(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bg(ImageRequest.Pi(str)) : K(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dlJ */
    public d dlL() {
        d dlN;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dml = dml();
            String dmo = dmo();
            if (dml instanceof d) {
                dlN = (d) dml;
            } else {
                dlN = this.lJW.dlN();
            }
            dlN.a(a(dlN, dmo), dmo, dlK(), dmg(), this.lJV, this.lKk);
            dlN.a(this.lKm);
            return dlN;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dlK() {
        ImageRequest dmh = dmh();
        com.facebook.imagepipeline.c.f doM = this.lKl.doM();
        if (doM == null || dmh == null) {
            return null;
        }
        if (dmh.dsA() != null) {
            return doM.b(dmh, dmg());
        }
        return doM.a(dmh, dmg());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lKl.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dlF();
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
        return (e) super.bg(ImageRequestBuilder.Y(uri).z(map).dsD());
    }
}
