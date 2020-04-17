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
    private ImmutableList<com.facebook.imagepipeline.f.a> lSW;
    private final g lSX;
    @Nullable
    private com.facebook.drawee.a.a.a.b lTk;
    private final com.facebook.imagepipeline.d.g lTl;
    @Nullable
    private com.facebook.drawee.a.a.a.f lTm;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lTl = gVar2;
        this.lSX = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: N */
    public e O(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aW(null);
        }
        return (e) super.aW(ImageRequestBuilder.Z(uri).a(com.facebook.imagepipeline.common.e.dqV()).duW());
    }

    public e Od(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.aW(ImageRequest.Oq(str)) : O(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dnZ */
    public d dob() {
        d dod;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a doB = doB();
            String doE = doE();
            if (doB instanceof d) {
                dod = (d) doB;
            } else {
                dod = this.lSX.dod();
            }
            dod.a(a(dod, doE), doE, doa(), dow(), this.lSW, this.lTk);
            dod.a(this.lTm);
            return dod;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b doa() {
        ImageRequest dox = dox();
        com.facebook.imagepipeline.c.f drh = this.lTl.drh();
        if (drh == null || dox == null) {
            return null;
        }
        if (dox.duT() != null) {
            return drh.b(dox, dow());
        }
        return drh.a(dox, dow());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lTl.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dnV();
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
        return (e) super.aW(ImageRequestBuilder.Z(uri).x(map).duW());
    }
}
