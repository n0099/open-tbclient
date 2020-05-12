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
    private ImmutableList<com.facebook.imagepipeline.f.a> lTa;
    private final g lTb;
    @Nullable
    private com.facebook.drawee.a.a.a.b lTo;
    private final com.facebook.imagepipeline.d.g lTp;
    @Nullable
    private com.facebook.drawee.a.a.a.f lTq;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.lTp = gVar2;
        this.lTb = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: N */
    public e O(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.aX(null);
        }
        return (e) super.aX(ImageRequestBuilder.Z(uri).a(com.facebook.imagepipeline.common.e.dqT()).duU());
    }

    public e Og(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.aX(ImageRequest.Ot(str)) : O(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: dnX */
    public d dnZ() {
        d dob;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a doz = doz();
            String doC = doC();
            if (doz instanceof d) {
                dob = (d) doz;
            } else {
                dob = this.lTb.dob();
            }
            dob.a(a(dob, doC), doC, dnY(), dou(), this.lTa, this.lTo);
            dob.a(this.lTq);
            return dob;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b dnY() {
        ImageRequest dov = dov();
        com.facebook.imagepipeline.c.f drf = this.lTp.drf();
        if (drf == null || dov == null) {
            return null;
        }
        if (dov.duR() != null) {
            return drf.b(dov, dou());
        }
        return drf.a(dov, dou());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.lTp.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).dnT();
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
        return (e) super.aX(ImageRequestBuilder.Z(uri).x(map).duU());
    }
}
