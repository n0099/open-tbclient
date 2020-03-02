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
    private ImmutableList<com.facebook.imagepipeline.f.a> lJK;
    private final g lJL;
    @Nullable
    private com.facebook.drawee.a.a.a.b lJZ;
    private final com.facebook.imagepipeline.d.g lKa;
    @Nullable
    private com.facebook.drawee.a.a.a.f lKb;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lKa = gVar2;
        this.lJL = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: J */
    public e K(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bg(null);
        }
        return (e) super.bg(ImageRequestBuilder.Y(uri).a(com.facebook.imagepipeline.common.e.doy()).dsC());
    }

    public e OV(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bg(ImageRequest.Ph(str)) : K(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dlI */
    public d dlK() {
        d dlM;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a dmk = dmk();
            String dmn = dmn();
            if (dmk instanceof d) {
                dlM = (d) dmk;
            } else {
                dlM = this.lJL.dlM();
            }
            dlM.a(a(dlM, dmn), dmn, dlJ(), dmf(), this.lJK, this.lJZ);
            dlM.a(this.lKb);
            return dlM;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dlJ() {
        ImageRequest dmg = dmg();
        com.facebook.imagepipeline.c.f doL = this.lKa.doL();
        if (doL == null || dmg == null) {
            return null;
        }
        if (dmg.dsz() != null) {
            return doL.b(dmg, dmf());
        }
        return doL.a(dmg, dmf());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lKa.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dlE();
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
        return (e) super.bg(ImageRequestBuilder.Y(uri).z(map).dsC());
    }
}
