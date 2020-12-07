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
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.f.c>, com.facebook.imagepipeline.f.f> {
    @Nullable
    private com.facebook.drawee.a.a.a.b pdA;
    private final com.facebook.imagepipeline.c.g pdB;
    @Nullable
    private com.facebook.drawee.a.a.a.f pdC;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.e.a> pdn;
    private final g pdo;

    public e(Context context, g gVar, com.facebook.imagepipeline.c.g gVar2, Set<com.facebook.drawee.controller.c> set) {
        super(context, set);
        this.pdB = gVar2;
        this.pdo = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.drawee.d.d
    /* renamed from: T */
    public e U(@Nullable Uri uri) {
        if (uri == null) {
            return (e) super.bo(null);
        }
        return (e) super.bo(ImageRequestBuilder.af(uri).a(com.facebook.imagepipeline.common.e.etB()).exw());
    }

    public e Zk(@Nullable String str) {
        return (str == null || str.isEmpty()) ? (e) super.bo(ImageRequest.Zv(str)) : U(Uri.parse(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: eqP */
    public d eqR() {
        d eqT;
        com.facebook.imagepipeline.j.b.beginSection("obtainController");
        try {
            com.facebook.drawee.d.a err = err();
            String eru = eru();
            if (err instanceof d) {
                eqT = (d) err;
            } else {
                eqT = this.pdo.eqT();
            }
            eqT.a(a(eqT, eru), eru, eqQ(), erm(), this.pdn, this.pdA);
            eqT.a(this.pdC);
            return eqT;
        } finally {
            com.facebook.imagepipeline.j.b.endSection();
        }
    }

    private com.facebook.cache.common.b eqQ() {
        ImageRequest ern = ern();
        com.facebook.imagepipeline.b.f etN = this.pdB.etN();
        if (etN == null || ern == null) {
            return null;
        }
        if (ern.ext() != null) {
            return etN.b(ern, erm());
        }
        return etN.a(ern, erm());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> a(com.facebook.drawee.d.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.pdB.a(imageRequest, obj, a(cacheLevel), a(aVar));
    }

    @Nullable
    protected com.facebook.imagepipeline.g.c a(com.facebook.drawee.d.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).eqL();
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
        return (e) super.bo(ImageRequestBuilder.af(uri).I(map).exw());
    }
}
