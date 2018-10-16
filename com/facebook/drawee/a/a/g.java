package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.c.t;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class g {
    private com.facebook.drawee.components.a hYE;
    private Executor hYF;
    @Nullable
    private i<Boolean> hYr;
    private com.facebook.imagepipeline.a.a.a hYu;
    @Nullable
    private ImmutableList<a> hYv;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> hYw;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, @Nullable i<Boolean> iVar) {
        this.mResources = resources;
        this.hYE = aVar;
        this.hYu = aVar2;
        this.hYF = executor;
        this.hYw = tVar;
        this.hYv = immutableList;
        this.hYr = iVar;
    }

    public d b(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        com.facebook.common.internal.g.c(this.mResources != null, "init() not called");
        d a = a(this.mResources, this.hYE, this.hYu, this.hYF, this.hYw, this.hYv, iVar, str, bVar, obj);
        if (this.hYr != null) {
            a.oA(this.hYr.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        return new d(resources, aVar, aVar2, executor, tVar, iVar, str, bVar, obj, immutableList);
    }
}
