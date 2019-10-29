package com.facebook.drawee.a.a;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.i;
import com.facebook.imagepipeline.c.t;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class g {
    private com.facebook.imagepipeline.a.a.a kcA;
    @Nullable
    private ImmutableList<a> kcB;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kcC;
    private com.facebook.drawee.components.a kcK;
    private Executor kcL;
    @Nullable
    private i<Boolean> kcx;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, @Nullable i<Boolean> iVar) {
        this.mResources = resources;
        this.kcK = aVar;
        this.kcA = aVar2;
        this.kcL = executor;
        this.kcC = tVar;
        this.kcB = immutableList;
        this.kcx = iVar;
    }

    public d b(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        com.facebook.common.internal.g.d(this.mResources != null, "init() not called");
        d a = a(this.mResources, this.kcK, this.kcA, this.kcL, this.kcC, this.kcB, iVar, str, bVar, obj);
        if (this.kcx != null) {
            a.sd(this.kcx.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        return new d(resources, aVar, aVar2, executor, tVar, iVar, str, bVar, obj, immutableList);
    }
}
