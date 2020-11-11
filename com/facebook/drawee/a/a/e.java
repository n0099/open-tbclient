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
/* loaded from: classes18.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.g.c>, com.facebook.imagepipeline.g.f> {
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.f.a> oMB;
    private final g oMC;
    @Nullable
    private com.facebook.drawee.a.a.a.b oMP;
    private final com.facebook.imagepipeline.d.g oMQ;
    @Nullable
    private com.facebook.drawee.a.a.a.f oMR;

    public e(Context context, g gVar, com.facebook.imagepipeline.d.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.oMQ = gVar2;
        this.oMC = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: R */
    public e S(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bn(null);
        }
        return (e) super.bn(ImageRequestBuilder.ad(uri).a(com.facebook.imagepipeline.common.e.enX()).erY());
    }

    public e Ye(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bn(ImageRequest.Yr(str)) : S(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: elc */
    public d ele() {
        d elg;
        com.facebook.imagepipeline.k.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a elE = elE();
            String elH = elH();
            if (elE instanceof d) {
                elg = (d) elE;
            } else {
                elg = this.oMC.elg();
            }
            elg.a(a(elg, elH), elH, eld(), elz(), this.oMB, this.oMP);
            elg.a(this.oMR);
            return elg;
        } finally {
            com.facebook.imagepipeline.k.b.endSection();
        }
    }

    private com.facebook.cache.common.b eld() {
        ImageRequest elA = elA();
        com.facebook.imagepipeline.c.f eok = this.oMQ.eok();
        if (eok == null || elA == null) {
            return null;
        }
        if (elA.erV() != null) {
            return eok.b(elA, elz());
        }
        return eok.a(elA, elz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.oMQ.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.h.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).ekY();
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
        return (e) super.bn(ImageRequestBuilder.ad(uri).I(map).erY());
    }
}
