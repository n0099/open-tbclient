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
    private i<Boolean> kbG;
    private com.facebook.imagepipeline.a.a.a kbJ;
    @Nullable
    private ImmutableList<a> kbK;
    private t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> kbL;
    private com.facebook.drawee.components.a kbT;
    private Executor kbU;
    private Resources mResources;

    public void a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, @Nullable i<Boolean> iVar) {
        this.mResources = resources;
        this.kbT = aVar;
        this.kbJ = aVar2;
        this.kbU = executor;
        this.kbL = tVar;
        this.kbK = immutableList;
        this.kbG = iVar;
    }

    public d b(i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        com.facebook.common.internal.g.d(this.mResources != null, "init() not called");
        d a = a(this.mResources, this.kbT, this.kbJ, this.kbU, this.kbL, this.kbK, iVar, str, bVar, obj);
        if (this.kbG != null) {
            a.sd(this.kbG.get().booleanValue());
        }
        return a;
    }

    protected d a(Resources resources, com.facebook.drawee.components.a aVar, com.facebook.imagepipeline.a.a.a aVar2, Executor executor, t<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> tVar, @Nullable ImmutableList<a> immutableList, i<com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>>> iVar, String str, com.facebook.cache.common.b bVar, Object obj) {
        return new d(resources, aVar, aVar2, executor, tVar, iVar, str, bVar, obj, immutableList);
    }
}
