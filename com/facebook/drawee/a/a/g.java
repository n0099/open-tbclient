package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.c.t;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class g {
    @Nullable
    private i<Boolean> ilG;
    private com.facebook.imagepipeline.a.a.a ilJ;
    @Nullable
    private ImmutableList<a> ilK;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> ilL;
    private com.facebook.drawee.components.a ilT;
    private Executor ilU;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, @Nullable i<Boolean> iVar) {
        this.mResources = resources;
        this.ilT = aVar;
        this.ilJ = aVar2;
        this.ilU = executor;
        this.ilL = tVar;
        this.ilK = immutableList;
        this.ilG = iVar;
    }

    public d b(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        com.facebook.common.internal.g.c(this.mResources != null, "init() not called");
        d a = a(this.mResources, this.ilT, this.ilJ, this.ilU, this.ilL, this.ilK, iVar, str, bVar, obj);
        if (this.ilG != null) {
            a.oU(this.ilG.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        return new d(resources, aVar, aVar2, executor, tVar, iVar, str, bVar, obj, immutableList);
    }
}
