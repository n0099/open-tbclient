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
    private ImmutableList<com.facebook.imagepipeline.f.a> lJI;
    private final g lJJ;
    @Nullable
    private com.facebook.drawee.a.a.a.b lJX;
    private final com.facebook.imagepipeline.d.g lJY;
    @Nullable
    private com.facebook.drawee.a.a.a.f lJZ;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lJY = gVar2;
        this.lJJ = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: J */
    public e K(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bg(null);
        }
        return (e) super.bg(ImageRequestBuilder.Y(uri).a(com.facebook.imagepipeline.common.e.dow()).dsA());
    }

    public e OV(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bg(ImageRequest.Ph(str)) : K(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dlG */
    public d dlI() {
        d dlK;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dmi = dmi();
            String dml = dml();
            if (dmi instanceof d) {
                dlK = (d) dmi;
            } else {
                dlK = this.lJJ.dlK();
            }
            dlK.a(a(dlK, dml), dml, dlH(), dmd(), this.lJI, this.lJX);
            dlK.a(this.lJZ);
            return dlK;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dlH() {
        ImageRequest dme = dme();
        com.facebook.imagepipeline.c.f doJ = this.lJY.doJ();
        if (doJ == null || dme == null) {
            return null;
        }
        if (dme.dsx() != null) {
            return doJ.b(dme, dmd());
        }
        return doJ.a(dme, dmd());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lJY.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dlC();
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
        return (e) super.bg(ImageRequestBuilder.Y(uri).z(map).dsA());
    }
}
